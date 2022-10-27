package kr.co.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomView extends View {


    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        canvas.drawLine(100,100,700,100,paint);
    }
}
