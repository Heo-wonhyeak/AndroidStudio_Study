package kr.co.imagescale;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

public class MyImageView extends View {

    private Drawable image;
    private ScaleGestureDetector gestureDetector;
    private float scale = 1.0f;

    public MyImageView(Context context) {
        super(context);
        image = context.getResources().getDrawable(R.drawable.lion);
        setFocusable(true);
        image.setBounds(0,0,image.getIntrinsicWidth(),image.getIntrinsicHeight());
        //제스처 인식기 객체 생성
        gestureDetector = new ScaleGestureDetector(context, new ScaleListener());
    }

    //줌 인아웃을 위한 그리기
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 캔버스의 현재 상태 저장함
        canvas.save();
        // 캔버스의 새로운 연산을 적용
        canvas.scale(scale,scale);
        image.draw(canvas);
        //캔버스의 상태를 복원
        canvas.restore();
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        // 새로운 연산이 감지되면 호출됨
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale *= detector.getScaleFactor();

            if(scale < 0.1f) {
                scale = 0.1f;
            }
            if(scale >10.0f) {
                scale = 10.0f;
            }

            return super.onScale(detector);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //제스처 인식기의 터치 이벤트 처리 메서드
        gestureDetector.onTouchEvent(event);
        //다시그리기 위해 호출
        invalidate();

        return true;
    }
}
