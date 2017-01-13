package net.azurewebsites.irrationnelle.test06;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * Created by irrationnelle on 1/11/17.
 */

public class MainActivity extends Activity {
    private ToggleButton toggleSound;
    private EditText editEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleSound = (ToggleButton) findViewById(R.id.toggle_sound);
        toggleSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleSound.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Pushed: Sound On", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Pushed: Sound Off", Toast.LENGTH_SHORT).show();
                }
            }
        });

        editEnter = (EditText) findViewById(R.id.edit_enter);
        editEnter.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    Toast.makeText(getApplicationContext(), "Input Message: " + editEnter.getText()
                    , Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });
    }
}
