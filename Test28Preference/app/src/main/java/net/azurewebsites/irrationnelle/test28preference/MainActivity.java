package net.azurewebsites.irrationnelle.test28preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editPref;
    private Button btnSave, btnLoad;

    public static final String PREF_NAME = "RasePref";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPref = (EditText) findViewById(R.id.edit_pref);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnLoad = (Button) findViewById(R.id.btn_load);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editPref.getText()+"";
                if(text != null && text.length()>0) {
                    SharedPreferences rasePref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
                    SharedPreferences.Editor editor = rasePref.edit();

                    editor.putString("savedText", text);
                    editor.commit();
                } else {
                    Toast.makeText(MainActivity.this, "No input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences rasePref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
                String savedText = rasePref.getString("savedText", "none");
                editPref.setText(savedText);
            }
        });


    }
}
