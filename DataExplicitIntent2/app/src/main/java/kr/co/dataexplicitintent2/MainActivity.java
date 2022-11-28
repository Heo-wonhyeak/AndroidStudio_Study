package kr.co.dataexplicitintent2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1,edit2;
    RadioGroup rdoGroup;
    RadioButton rdoPlus,rdoMinus,rdoMulti,rdoDivision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSend = findViewById(R.id.btnSend);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);

        rdoGroup = findViewById(R.id.rdoGroup);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ResultActivity.class);

                switch (rdoGroup.getCheckedRadioButtonId()) {
                    case R.id.rdoPlus:
                        intent.putExtra("Calc","+");
                        break;
                    case R.id.rdoMinus:
                        intent.putExtra("Calc","-");
                        break;
                    case R.id.rdoMulti:
                        intent.putExtra("Calc","*");
                        break;
                    case R.id.rdoDivision:
                        intent.putExtra("Calc","/");
                        break;
                    default:
                        break;
                }

                intent.putExtra("num1",Integer.parseInt(edit1.getText().toString()));
                intent.putExtra("num2",Integer.parseInt(edit2.getText().toString()));

                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
if(resultCode == RESULT_OK) {
    Double result = data.getDoubleExtra("returnValue", 0);
    Toast.makeText(this, "결과 : " + result, Toast.LENGTH_SHORT).show();
}
    }
}