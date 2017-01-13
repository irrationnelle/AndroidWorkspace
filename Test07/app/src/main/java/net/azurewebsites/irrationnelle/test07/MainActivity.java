package net.azurewebsites.irrationnelle.test07;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by irrationnelle on 1/11/17.
 */

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView myView = new MyView(this);
        setContentView(myView);
    }
}
