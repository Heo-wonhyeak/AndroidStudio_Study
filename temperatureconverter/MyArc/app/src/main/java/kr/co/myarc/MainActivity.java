package kr.co.myarc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    static class MyView extends View{

        private Paint mPaint, mFramePaint;
        private RectF mBigOval;
        private float start,sweep;

        private static final float SWEEP_INC = 2;
        private static final float START_INC = 15;

        public MyView(Context context) {
            super(context);
            setBackgroundColor(Color.CYAN);

            mPaint = new Paint();
            mPaint.setAntiAlias(true);
            //도형 내부 채움
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(0x88ff0000);

            mFramePaint = new Paint();
            mFramePaint.setAntiAlias(true);
            //도형 외곽선만 그림
            mFramePaint.setStrokeWidth(20);
            mFramePaint.setStyle(Paint.Style.STROKE);
            mFramePaint.setColor(Color.GREEN);

            mBigOval = new RectF(40,10,900,1000);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            //super.onDraw(canvas);
            //canvas.drawOval(mBigOval,mPaint);
            canvas.drawRect(mBigOval,mFramePaint);
            canvas.drawArc(mBigOval,start,sweep,false,mPaint);
            sweep += SWEEP_INC;
            if(sweep > 360) {
                sweep -= 360;
                start += START_INC;
                if(start >=360) {
                    start -=360;
                }
            }
            //다시 지워지고 onDraw()가 호출되도록
            invalidate();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }
}