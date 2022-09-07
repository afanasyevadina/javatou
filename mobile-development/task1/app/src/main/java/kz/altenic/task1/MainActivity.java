package kz.altenic.task1;

import android.app.Activity;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import kz.altenic.task1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    EditText inputA; // Переменная для доступа к компоненту со значением "a"
    EditText inputB; // Переменная для доступа к компоненту со значением "b"
    EditText inputC; // Переменная для доступа к компоненту со значением "b"
    EditText inputD; // Переменная для доступа к компоненту со значением "b"
    EditText inputX; // Переменная для доступа к компоненту со значением "x"
    TextView textResult; // Переменная для доступа к компоненту со значением результата
    Button buttonCalculate; // Переменная для доступа к компоненту кнопки

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Доступ к компонентам окна
        inputA = findViewById(R.id.input_a);
        inputB = findViewById(R.id.input_b);
        inputC = findViewById(R.id.input_c);
        inputD = findViewById(R.id.input_d);
        inputX = findViewById(R.id.input_x);
        textResult = findViewById(R.id.text_result);
        buttonCalculate = findViewById(R.id.button_calculate);
    }

    // МЕТОД КНОПКИ РАСЧЕТА
    public void onClick(View v) {
        // Объявление локальных переменных
        double a, b, c, d, x, y;

        try { // НАЧАЛО ЗАЩИЩЕННОГО БЛОКА

            // Чтение данных из компонент
            a = Double.parseDouble(inputA.getText().toString().trim());
            b = Double.parseDouble(inputB.getText().toString().trim());
            c = Double.parseDouble(inputC.getText().toString().trim());
            d = Double.parseDouble(inputD.getText().toString().trim());
            x = Double.parseDouble(inputX.getText().toString().trim());

            // Основной алгоритм
            y = x <= 5 ? (Math.pow(a, 2) * c + Math.pow(b, 2) - d) / x : Math.pow(x, 2) + 5;

            // Вывод полученного значения в компонент
            textResult.setText(getResources().getString(R.string.result_text).concat(" ").concat(String.valueOf(y)));

        } catch (Exception e) { // ЧТО ДЕЛАТЬ ЕСЛИ ВОЗНИКНЕТ ОШИБКА В БЛОКЕ МЕЖДУ "TRY" И "CATCH":

            // Вывод сообщения об ошибке
            textResult.setText("Неверные входные данные для расчета!");
            Toast.makeText(getApplicationContext(), "Вы ж чего!", Toast.LENGTH_LONG).show();

        }  // КОНЕЦ ЗАЩИЩЕННОГО БЛОКА
        InputMethodManager imm = (InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

    }
}