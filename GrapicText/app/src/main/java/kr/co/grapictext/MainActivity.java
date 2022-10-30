package kr.co.grapictext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    class MyView extends View {
        public MyView(Context context) {
            super(context);
            setBackgroundColor(Color.MAGENTA);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setTextSize(100);

            Typeface typeface;
            typeface= Typeface.create(Typeface.SANS_SERIF,Typeface.BOLD_ITALIC);

            paint.setTypeface(typeface);

            canvas.drawText("default font",100,100,paint);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }
}