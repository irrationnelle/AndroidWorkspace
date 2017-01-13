package net.azurewebsites.irrationnelle.ex02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnCount;
    private Button btnReset;
    private TextView textNumber;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCount = (Button) findViewById(R.id.btn_count);
        btnReset = (Button) findViewById(R.id.btn_reset);
        textNumber = (TextView) findViewById(R.id.number);

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                textNumber.setText(count+"");
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                textNumber.setText(count+"");
            }
        });

    }


}
