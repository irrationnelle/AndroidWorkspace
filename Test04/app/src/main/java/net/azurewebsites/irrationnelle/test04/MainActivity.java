package net.azurewebsites.irrationnelle.test04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText firstNumber;
    private EditText secondNumber;

    private Button plus;
    private Button minus;
    private Button multiple;
    private Button divide;
    private Button equal;

    private TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumber = (EditText) findViewById(R.id.first_number);
        secondNumber = (EditText) findViewById(R.id.second_number);

        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        multiple = (Button) findViewById(R.id.multiple);
        divide = (Button) findViewById(R.id.divide);
        equal = (Button) findViewById(R.id.equal);

        answer = (TextView) findViewById(R.id.answer);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int first = Integer.parseInt(firstNumber.getText().toString());
                int second = Integer.parseInt(secondNumber.getText().toString());

                answer.setText(first + second+"");
            }
        });
    }


}
