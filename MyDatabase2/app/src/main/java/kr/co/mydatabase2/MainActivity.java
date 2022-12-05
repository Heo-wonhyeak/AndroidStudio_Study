package kr.co.mydatabase2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mycontacts.db";
    private static final int DATABASE_VERSION = 2;

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
        for(int i=0; i<100; i++) {
            if(i<10){
                sqLiteDatabase.execSQL("INSERT INTO contacts VALUES (null,'이순신"+i+"','010-1234-100"+i+"')");
            } else {
                sqLiteDatabase.execSQL("INSERT INTO contacts VALUES (null,'이순신" + i + "','010-1234-10" + i + "')");
            }
        }
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DBHelper 객체 생성
        helper = new DBHelper(this);

        try {
            // DB 필요할때 사용(데이터베이스 연산 기능 메서드 제공)
            db = helper.getWritableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM contacts",null);

            String[] from = {"name","tel"};
            int[] to = {android.R.id.text1, android.R.id.text2};

            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2 , cursor,from,to);

            ListView list = findViewById(R.id.list);
            list.setAdapter(adapter);

        } catch (SQLiteException e) {
            db = helper.getReadableDatabase();
        }
    }
}