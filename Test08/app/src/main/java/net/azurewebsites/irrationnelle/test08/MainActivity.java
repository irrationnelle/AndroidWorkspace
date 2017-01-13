package net.azurewebsites.irrationnelle.test08;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by irrationnelle on 1/11/17.
 */

public class MainActivity extends Activity {
    private MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myView = new MyView(this);
        setContentView(myView);
    }
}
