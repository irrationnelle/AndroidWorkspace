package net.azurewebsites.irrationnelle.test15intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

/**
 * Created by irrationnelle on 1/24/17.
 */

public class MainActivity extends AppCompatActivity {
    private Button btnGoogleMap;
    private Button btnOther;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGoogleMap = (Button) findViewById(R.id.btn_google_map);
        btnGoogleMap.setOnClickListener(v -> {
            Log.i("rase", Intent.ACTION_VIEW);
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.google.co.kr/maps/place/Petit+Pont/@48.852416,2.3441413,17z/data=!3m1!4b1!4m5!3m4!1s0x47e671e0e7f573d3:0x2e702f369ecd62ff!8m2!3d48.852416!4d2.34633"));

            startActivity(intent);
        });

        btnOther = (Button) findViewById(R.id.other_activity);
        btnOther.setOnClickListener(v -> {
            Log.i("rase", "com.test.intent.RASE");
            Intent otherIntent = new Intent();
            otherIntent.setAction("com.test.intent.RASE");

            startActivity(otherIntent);
        });

    }
}
