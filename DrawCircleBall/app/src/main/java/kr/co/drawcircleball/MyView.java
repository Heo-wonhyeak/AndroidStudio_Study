package kr.co.drawcircleball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.Random;

public class MyView extends View {

    private Paint[] mForegrounds = {makePaint(Color.BLACK),makePaint(Color.RED),makePaint(Color.CYAN),makePaint(Color.GREEN)};
    private static Random random = new Random();

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private Paint makePaint(int color) {
        Paint paint = new Paint();
        paint.setColor(color);

        return paint;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.YELLOW);

        int width = getWidth();
        int height = getHeight();

        for(int i=0; i<20; i++) {
            float x = random.nextInt(width);
            float y = random.nextInt(height);
            float radius = random.nextInt(100);
            Paint circlePaint = mForegrounds[random.nextInt(mForegrounds.length)];
            canvas.drawCircle(x,y,radius,circlePaint);
        }
    }
}
