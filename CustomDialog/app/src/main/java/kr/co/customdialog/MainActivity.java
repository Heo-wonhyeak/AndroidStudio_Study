package kr.co.customdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText userName,password;
    Button login,cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void onClick(View view) {
        final Dialog loginDialog = new Dialog(this);
        loginDialog.setContentView(R.layout.customer_dialog);

        login = loginDialog.findViewById(R.id.login);
        cancel = loginDialog.findViewById(R.id.cancel);

        userName = loginDialog.findViewById(R.id.userName);
        password = loginDialog.findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userName.getText().toString().trim().length() >0 && password.getText().toString().trim().length() > 0) {
                    Toast.makeText(getApplicationContext(),"로그인성공", Toast.LENGTH_SHORT).show();
                    loginDialog.dismiss();
                } else {
                    Toast.makeText(getApplicationContext(),"다시 입력하십시오.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"취소되었습니다.",Toast.LENGTH_SHORT).show();
                loginDialog.dismiss();
            }
        });

        loginDialog.show();
    }
}