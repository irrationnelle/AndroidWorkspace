package net.azurewebsites.irrationnelle.test19sendbroadcast2;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by irrationnelle on 1/31/17.
 */

public class MainActivity extends AppCompatActivity {
    private Button btnSend;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main2);
//
//        btnSend = (Button) findViewById(R.id.btn_send_broadcast);
//
//        btnSend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent("com.example.RASE");
//                sendBroadcast(intent);
//            }
//        });
    }
}
