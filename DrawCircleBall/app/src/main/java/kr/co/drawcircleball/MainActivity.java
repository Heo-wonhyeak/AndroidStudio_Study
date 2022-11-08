package kr.co.drawcircleball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView = findViewById(R.id.myView);
    }

    public void reset(View view) {
        myView.invalidate();
    }
}