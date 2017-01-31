package net.azurewebsites.irrationnelle.ex07;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by irrationnelle on 1/18/17.
 */

public class MainActivity extends AppCompatActivity {
    private TextView phoneNum;
    private TextView webURL;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNum = (TextView) findViewById(R.id.phone_num_textview);
        webURL = (TextView) findViewById(R.id.web_url_textview);

        phoneNum.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+phoneNum.getText().toString()));
            startActivity(intent);
        });

        webURL.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webURL.getText().toString()));
            startActivity(intent);
        });
    }
}
