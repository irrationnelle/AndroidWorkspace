package net.azurewebsites.irrationnelle.test10;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

/**
 * Created by irrationnelle on 1/13/17.
 */

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBasic = (Button) findViewById(R.id.btn_basic);
    }
}
