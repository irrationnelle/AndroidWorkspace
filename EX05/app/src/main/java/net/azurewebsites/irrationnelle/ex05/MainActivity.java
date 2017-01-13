package net.azurewebsites.irrationnelle.ex05;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by irrationnelle on 1/13/17.
 */

public class MainActivity extends AppCompatActivity {
    private Button btnSignUp;

    private Button btnConfirm;
    private Button btnCancel;

    private EditText nameEdit;
    private EditText groupEdit;

    private TextView name;
    private TextView group;

    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignUp = (Button) findViewById(R.id.btn_sign_up);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    public void showDialog() {
        final Dialog popup = new Dialog(this);
        popup.setContentView(R.layout.popup);

        name = (TextView) findViewById(R.id.edit_name);
        group = (TextView) findViewById(R.id.edit_group);

        nameEdit = (EditText) popup.findViewById(R.id.popup_edit_name);
        groupEdit = (EditText) popup.findViewById(R.id.popup_edit_group);

        imageView = (ImageView) findViewById(R.id.image_view);

        btnConfirm = (Button) popup.findViewById(R.id.popup_btn_confirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nameEdit.getText().length()>0 && groupEdit.getText().length()>0) {
                    name.setText(nameEdit.getText());
                    group.setText(groupEdit.getText());
                    popup.cancel();
                    imageView.setImageResource(R.drawable.androidblack);
                } else {
                    Toast.makeText(getApplicationContext(), "You must input name and group!", Toast.LENGTH_LONG).show();
                }

            }
        });

        btnCancel = (Button) popup.findViewById(R.id.popup_btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.cancel();
            }
        });

        popup.show();
    }
}
