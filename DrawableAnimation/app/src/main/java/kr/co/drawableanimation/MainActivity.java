package kr.co.drawableanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    AnimationDrawable rocketAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView rocketImage = findViewById(R.id.rocket_image);
        // 애니메이션 리소스를 이미지 뷰의 배경으로 설정
        rocketImage.setBackgroundResource(R.drawable.rocket);
        //애니메이션 객체 얻음
        rocketAnimation = (AnimationDrawable) rocketImage.getBackground();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            rocketAnimation.start();
            return true;
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            rocketAnimation.stop();
            return true;
        }

        return super.onTouchEvent(event);
    }
}