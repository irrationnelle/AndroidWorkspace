package net.azurewebsites.irrationnelle.test19sendbroadcast;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

/**
 * Created by irrationnelle on 1/31/17.
 */

public class MainActivity extends AppCompatActivity {
    private Button btnSendBroadcast;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);

        btnSendBroadcast = (Button) findViewById(R.id.btn_send_broadcast);

        btnSendBroadcast.setOnClickListener(v -> {
            Intent intent = new Intent("com.example.RASE");
//            intent.setAction();
            sendBroadcast(intent);
        });
    }
}
