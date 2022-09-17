package kr.co.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    MyPageAdapter myPageAdapter;

    int[] images = {R.drawable.image1,R.drawable.image2,R.drawable.image3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.ViewPager);
        myPageAdapter = new MyPageAdapter(MainActivity.this,images);

        viewPager.setAdapter(myPageAdapter);
    }
}