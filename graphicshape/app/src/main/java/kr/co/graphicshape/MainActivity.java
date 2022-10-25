package kr.co.graphicshape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    static class MyView extends View {

        public MyView(Context context) {
            super(context);
            setBackgroundColor(Color.LTGRAY);
        }

        Paint paint = new Paint();
        //사각형 객체
        RectF rectF = new RectF(30,50,330,500);

        @Override
        protected void onDraw(Canvas canvas) {
            //super.onDraw(canvas);
            paint.setColor(Color.GREEN);
            canvas.drawColor(Color.YELLOW);
            //둥근 사각형 그리는 메서드 rx,ry는 모서리 반지름
            canvas.drawRoundRect(rectF,30,30,paint);

            rectF = new RectF(450,50,750,550);
            //타원을 그리는 메서드 (사각형 안에 타원을 그림)
            canvas.drawOval(rectF,paint);

            rectF = new RectF(30,600,330,1100);
            paint.setColor(Color.RED);
            //원호를 그리는 메서드 (사각형 안에 그려지는 원호임 startAngle에서 시작해서 sweepAngle만큼 원호를 그림)
            canvas.drawArc(rectF,0,30,true,paint);

            paint.setColor(Color.BLUE);
            paint.setStrokeWidth(10);
            float[] pts = {30,1250,300,1350 ,300,1350,60,1450 ,60,1450,360,1500};
            canvas.drawLines(pts,paint);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView myView = new MyView(this);
        setContentView(myView);

    }
}