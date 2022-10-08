package kr.co.singletouch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class SingleTouchView extends View {

    private Paint paint = new Paint();
    private Path path = new Path();

    public SingleTouchView(Context context, AttributeSet attributeSet) {
        super(context,attributeSet);

        //선을 매끄럽게 그리기 위하여 antiAlias 설정을 함
        paint.setAntiAlias(true);
        //선 두께 설정
        paint.setStrokeWidth(10f);
        //색상 설정
        paint.setColor(Color.CYAN);
        //선 스타일 설정
        paint.setStyle(Paint.Style.STROKE);
        //선 모양
        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 경로대로 그려짐
        canvas.drawPath(path,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //마우스가 터치된 위치를 얻음
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                //터치가 눌러지면 경로에 위치를 저장함
                path.moveTo(x,y);
                return true;
            case MotionEvent.ACTION_MOVE:
                //터치가 떼어지면 경로에 직선그리기를 저장함
                path.lineTo(x,y);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                return false;
        }

        invalidate();

        return true;
    }
}
