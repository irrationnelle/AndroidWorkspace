package net.azurewebsites.irrationnelle.ex03;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by irrationnelle on 1/10/17.
 */

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        LinearLayout totalLayout = (LinearLayout) findViewById(R.id.total_layout);
        ArrayList<LinearLayout> layoutList = new ArrayList<>();
        for (int i = 0; i < totalLayout.getChildCount(); i++) {
            LinearLayout layout = (LinearLayout) totalLayout.getChildAt(i);
            for (int j = 0; j < layout.getChildCount(); j++) {
                Button btn = (Button) layout.getChildAt(j);
                System.out.println(btn.getText());
            }
        }
    }
}
