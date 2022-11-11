package kr.co.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void open(View view){
        //빌더 객체 생성
        AlertDialog.Builder alertDBuilder = new AlertDialog.Builder(this);
        //대화상자의 메시지 세팅
        alertDBuilder.setMessage("결제하시겠습니까?");
        alertDBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "결제가 완료되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        alertDBuilder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"결제취소",Toast.LENGTH_SHORT).show();
            }
        });

        alertDBuilder.show();
    }
}