package kz.altenic.task3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private EditText inputName;
    private RadioGroup radioLang;
    private Spinner spinnerOs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputName =   findViewById(R.id.inputName);
        radioLang =   findViewById(R.id.radioLang);
        spinnerOs = findViewById(R.id.spinnerOs);
    }

    // МЕТОД ДЛЯ КНОПКИ "ИТОГО"
    public void onInfo(View v) {
        // Создание второго окна
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);

        RadioButton selectRadioButton = findViewById(radioLang.getCheckedRadioButtonId());

        // Подготовка параметров для второго окна
        intent.putExtra("name", inputName.getText().toString());
        intent.putExtra("lang", selectRadioButton.getText());
        intent.putExtra("os", spinnerOs.getSelectedItem().toString());

        // Запуск второго окна
        startActivity(intent);
    }
}