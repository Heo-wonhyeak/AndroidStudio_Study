package kr.co.singergroupmanagement;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME= "singergroup.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE singergroup (NAME TEXT,NUMBER INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(sqLiteDatabase);
    }
}

public class MainActivity extends AppCompatActivity {

    DBHelper helper;
    SQLiteDatabase db;
    EditText editName,editNumber,edtNameResult,edtNumberResult;
    Button btnReset,btnInsert,btnModify,btnDelete,btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        getSupportActionBar().setTitle("가수 그룹 관리 앱");

        helper = new DBHelper(this);

        try{
            db = helper.getWritableDatabase();
        } catch (SQLiteException e) {
            db = helper.getReadableDatabase();
        }

        editName = findViewById(R.id.editName);
        editNumber = findViewById(R.id.editNumber);

        btnInsert = findViewById(R.id.btnInsert);
        btnSearch = findViewById(R.id.btnSearch);
        btnDelete = findViewById(R.id.btnDelete);
        btnModify = findViewById(R.id.btnModify);
        btnReset = findViewById(R.id.btnReset);

        // 입력
//        btnInsert.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String name = editName.getText().toString();
//                int number = Integer.parseInt(editNumber.getText().toString());
//
//                db.execSQL("INSERT INTO singergroup VALUES ('"+name+"',"+number+")");
//                Toast.makeText(getApplicationContext(), "성공적으로 추가되었습니다.", Toast.LENGTH_SHORT).show();
//                editNumber.setText("");
//                editName.setText("");
//
//                btnSearch.callOnClick();
//            }
//        });

        edtNameResult = findViewById(R.id.edtNameResult);
        edtNumberResult = findViewById(R.id.edtNumberResult);

        //조회
//        btnSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Cursor cursor = db.rawQuery("SELECT * FROM singergroup",null);
//                String strName = "그룹이름\n-------------\n";
//                String strNumber = "인원\n-------------\n";
//
//                if(cursor != null) {
//                    while (cursor.moveToNext()) {
//                        strName += cursor.getString(0)+"\n";
//                        strNumber += cursor.getInt(1)+"\n";
//                    }
//                }
//
//                edtNameResult.setText(strName);
//                edtNumberResult.setText(strNumber);
//            }
//        });

        //삭제
//        btnDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String name = editName.getText().toString();
//
//                db.execSQL("DELETE FROM singergroup WHERE NAME LIKE '%"+name+"%'");
//                Toast.makeText(getApplicationContext(), "삭제되었습니다.", Toast.LENGTH_SHORT).show();
//
//                btnSearch.callOnClick();
//            }
//        });
        
        //초기화
//        btnReset.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                db.execSQL("DELETE FROM singergroup");
//                Toast.makeText(getApplicationContext(), "초기화 되었습니다.", Toast.LENGTH_SHORT).show();
//
//                btnSearch.callOnClick();
//            }
//        });

        //수정
//        btnModify.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String name = editName.getText().toString();
//                int number = Integer.parseInt(editNumber.getText().toString());
//                try{
//                    db.execSQL("UPDATE singergroup SET number = "+number+" WHERE name ='"+name+"'");
//                    Toast.makeText(getApplicationContext(), "업데이트 되었습니다.", Toast.LENGTH_SHORT).show();
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                btnSearch.callOnClick();
//
//            }
//        });

    }

    // 초기화
    public void Reset(View view) {
        db.execSQL("DELETE FROM singergroup");
        Toast.makeText(getApplicationContext(), "초기화 되었습니다.", Toast.LENGTH_SHORT).show();

        btnSearch.callOnClick();
    }

    // 입력
    public void Insert(View view) {
        String name = editName.getText().toString();
        int number = Integer.parseInt(editNumber.getText().toString());

        db.execSQL("INSERT INTO singergroup VALUES ('"+name+"',"+number+")");
        Toast.makeText(getApplicationContext(), "성공적으로 추가되었습니다.", Toast.LENGTH_SHORT).show();
        editNumber.setText("");
        editName.setText("");

        btnSearch.callOnClick();
    }

    // 수정
    public void Modify(View view){
        String name = editName.getText().toString();
        int number = Integer.parseInt(editNumber.getText().toString());
        try{
            db.execSQL("UPDATE singergroup SET number = "+number+" WHERE name ='"+name+"'");
            Toast.makeText(getApplicationContext(), "업데이트 되었습니다.", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }

        btnSearch.callOnClick();
    }

    // 삭제
    public void Delete(View view) {
        String name = editName.getText().toString();

        db.execSQL("DELETE FROM singergroup WHERE NAME ='"+name+"'");
        Toast.makeText(getApplicationContext(), "삭제되었습니다.", Toast.LENGTH_SHORT).show();

        btnSearch.callOnClick();
    }

    //조회
    public void Search(View view) {
        Cursor cursor = db.rawQuery("SELECT * FROM singergroup",null);
        String strName = "그룹이름\n-------------\n";
        String strNumber = "인원\n-------------\n";

        if(cursor != null) {
            while (cursor.moveToNext()) {
                strName += cursor.getString(0)+"\n";
                strNumber += cursor.getInt(1)+"\n";
            }
        }

        edtNameResult.setText(strName);
        edtNumberResult.setText(strNumber);
    }


}














