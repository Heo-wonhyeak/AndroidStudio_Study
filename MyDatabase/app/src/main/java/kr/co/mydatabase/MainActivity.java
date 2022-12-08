package kr.co.mydatabase;

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
import android.widget.TextView;
import android.widget.Toast;

class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mycontacts.db";
    private static final int DATABASE_VERSION = 1;

    // 생성자
    // factory : 커서를 지정하는 매개변수
    //             Null 로 전달하면 표준 커서가 사용됨.
    public DBHelper(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    //데이터베이스가 처음 생성될때 호출됨
    // 테이블 생성, 초기화
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE contacts (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, tel TEXT);");
    }

    //데이터베이스가 업그레이드 될 필요가 있을때 호출됨
    // 기존 테이블 삭제하고 새로 만들어주면 됨
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(sqLiteDatabase);
    }
}

public class MainActivity extends AppCompatActivity {

    DBHelper helper;
    SQLiteDatabase db;
    EditText edit_name, edit_tel;
    TextView edit_result;
    Button btnAdd,btnSearch,btnAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DBHelper 객체 생성
        helper = new DBHelper(this);

        try {
            // DB 필요할때 사용(데이터베이스 연산 기능 메서드 제공)
            db = helper.getWritableDatabase();
        } catch (SQLiteException e) {
            db = helper.getReadableDatabase();
        }

        edit_name= findViewById(R.id.name);
        edit_tel = findViewById(R.id.callNum);
        edit_result= findViewById(R.id.TextViewResult);

        btnAdd = findViewById(R.id.btnAdd);
        btnSearch = findViewById(R.id.btnSearch);
        btnAll = findViewById(R.id.btnAll);

        //추가
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edit_name.getText().toString();
                String tel = edit_tel.getText().toString();

                db.execSQL("INSERT INTO contacts VALUES (null,'"+name+"','"+tel+"')");
                Toast.makeText(getApplicationContext(), "성공적으로 추가되었음", Toast.LENGTH_SHORT).show();
                edit_name.setText("");
                edit_tel.setText("");
            }
        });

        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = db.rawQuery("SELECT * FROM contacts",null);
                String str = "ID        Name        Tel \r\n";

                if(cursor != null) {
                    // cursor.moveToNext() == 다음이 있다면 true
                    while (cursor.moveToNext()) {
                        str += cursor.getString(0)+"        ";
                        str += cursor.getString(1)+"        ";
                        str += cursor.getString(2)+"\r\n";
                    }
                }

                edit_result.setText(str);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edit_name.getText().toString();
                Cursor cursor = db.rawQuery("SELECT name, tel FROM contacts WHERE name='"+name+"';",null);


                Toast.makeText(getApplicationContext(), ""+cursor.getCount()+"개 입니다", Toast.LENGTH_SHORT).show();

            }
        });


    }
}