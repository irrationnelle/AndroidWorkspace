package net.azurewebsites.irrationnelle.test19sendbr3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by irrationnelle on 1/31/17.
 */

public class MainActivity extends AppCompatActivity {
    private Button btnSendBR3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSendBR3 = (Button) findViewById(R.id.btn_send_br3);

        btnSendBR3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.RASE");
                sendBroadcast(intent);
            }
        });
    }
}
