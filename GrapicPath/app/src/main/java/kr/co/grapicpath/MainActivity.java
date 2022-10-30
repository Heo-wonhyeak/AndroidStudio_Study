package kr.co.grapicpath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;

class MyView extends View {
    public MyView(Context context) {
        super(context);
        setBackgroundColor(Color.YELLOW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        Path path = new Path();

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5);

        //패스 시작점 지정
        path.moveTo(20,400);
        //패스에 직선을 추가함
        path.lineTo(300,800);
        //패스에 곡선 추가함
        path.cubicTo(0,0,1500,1500,100,100);

        //paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path,paint);
        paint.setTextSize(200);
        canvas.drawTextOnPath("This is a ezenIT",path,0,0,paint);


    }
}

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }
}