package kr.co.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton Rbutton1,Rbutton2;
    private EditText text;
    Button btn;

    String deg,result;
    Integer show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        text = findViewById(R.id.editText);

    }

    public void click(View v) {
        switch (v.getId()) {
            case R.id.button:
                RadioButton celsiusBtn = findViewById(R.id.radioButton1);
                RadioButton fahrenheitBtn = findViewById(R.id.radioButton2);

                if(text.getText().length() == 0) {
                    Toast.makeText(this, "값을입력하세요", Toast.LENGTH_SHORT).show();
                    return;
                }

                float inputValue = Float.parseFloat(text.getText().toString());
                if(celsiusBtn.isChecked()){
                    text.setText(String.valueOf(convertFahrenheitToCelsius(inputValue)));
                    celsiusBtn.setChecked(false);
                    fahrenheitBtn.setChecked(true);
                } else {
                    text.setText(String.valueOf(convertCelsiusToFahrenheit(inputValue)));
                    celsiusBtn.setChecked(true);
                    fahrenheitBtn.setChecked(false);
                }
                break;

        }
    }

    public float convertCelsiusToFahrenheit(float celsius) {
        return (celsius*9/5+32);
    }

    public float convertFahrenheitToCelsius(float Fahrenheit) {
        return ((Fahrenheit-32)*5/9);
    }
}