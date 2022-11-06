package kr.co.myphotoshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    MyView displayView;
    float scaleX = 1.0f,scaleY = 1.0f,rotateAngle;

    public class MyView extends View {
        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Paint paint = new Paint();
            int centerX = getWidth() /2;
            int centerY = getHeight()/2;

            // 캔버스 스케일 변경
            canvas.scale(scaleX,scaleY,centerX,centerY);
            //캔버스를 회전시킴
            canvas.rotate(rotateAngle,centerX,centerY);

            Bitmap map = BitmapFactory.decodeResource(getResources(),R.drawable.lena);
            canvas.drawBitmap(map,0,0,paint);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.imageDispPlay);
        displayView = new MyView(this);
        linearLayout.addView(displayView);
    }

    public void expand(View view) {
        scaleX += 0.1f;
        scaleY += 0.1f;

        displayView.invalidate();

    }

    public void shrink(View view) {
        scaleX -= 0.1f;
        scaleY -= 0.1f;

        displayView.invalidate();
    }

    public void rotateLeft(View view) {
        rotateAngle -= 30;
        displayView.invalidate();
    }

    public void rotateRight(View view) {
        rotateAngle += 30;
        displayView.invalidate();
    }
}