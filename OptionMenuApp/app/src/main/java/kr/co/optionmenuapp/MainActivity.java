package kr.co.optionmenuapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("제주도 풍경");

        editText = findViewById(R.id.edtAngle);
        imageView = findViewById(R.id.imageView);

    }

    //옵션메뉴 등록
    //메뉴 팽창

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        return true;
    }

    //옵션메뉴 클릭 이벤트 처리

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.item1:
                imageView.setImageResource(R.drawable.jeju2);
                return true;
            case R.id.item2:
                imageView.setImageResource(R.drawable.jeju4);
                return true;
            case R.id.item3:
                imageView.setImageResource(R.drawable.jeju6);
                return true;
            case R.id.itemRotate:
                imageView.setRotation(Float.parseFloat(editText.getText().toString()));
                return true;

        }
        return true;
    }
}