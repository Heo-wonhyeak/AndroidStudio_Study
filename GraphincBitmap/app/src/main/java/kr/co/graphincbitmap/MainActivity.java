package kr.co.graphincbitmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
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
        super.onDraw(canvas);
        Paint paint = new Paint();

        //상하반전을 위한 행렬
        Matrix matrix = new Matrix();
        matrix.preScale(1,-1);

        Bitmap map = BitmapFactory.decodeResource(getResources(),R.drawable.house);
        Bitmap bMap = Bitmap.createBitmap(map,0,0,map.getWidth(),map.getHeight(),matrix,false);
        Bitmap bMap2 = Bitmap.createScaledBitmap(map,600,600,false);

        canvas.drawBitmap(bMap,0,0,paint);
        canvas.drawBitmap(map,100,100,paint);
        canvas.drawBitmap(bMap2,200,200,paint);


    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }
}