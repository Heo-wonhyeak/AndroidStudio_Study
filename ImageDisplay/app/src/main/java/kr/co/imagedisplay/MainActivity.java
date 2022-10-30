package kr.co.imagedisplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

class MyView extends View {
    public MyView(Context context) {
        super(context);
        setBackgroundColor(Color.CYAN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        //(앱리소스 객체,이미지 리소스 식별자)
        Bitmap map = BitmapFactory.decodeResource(getResources(),R.drawable.cat1);

        //(화면에 그려지는 비트맵,이미지그려징 좌표 , 페인트)
        canvas.drawBitmap(map,0,0,paint);

    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }
}