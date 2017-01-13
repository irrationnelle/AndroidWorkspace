package net.azurewebsites.irrationnelle.ex04;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by irrationnelle on 1/11/17.
 */

public class MainActivity extends Activity {
    private MyView myView;

    private Button btnRed;
    private Button btnGreen;
    private Button btnBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = (MyView) findViewById(R.id.my_view);

        btnRed = (Button) findViewById(R.id.btn_red);
        btnGreen = (Button) findViewById(R.id.btn_green);
        btnBlue = (Button) findViewById(R.id.btn_blue);

        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paint paint = new Paint();
                paint.setColor(Color.RED);
                myView.setPaint(paint);

                Path path = new Path();
                myView.setPath(path);
            }
        });

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paint paint = new Paint();
                paint.setColor(Color.BLUE);
                myView.setPaint(paint);

                Path path = new Path();
                myView.setPath(path);
            }
        });

        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paint paint = new Paint();
                paint.setColor(Color.GREEN);
                myView.setPaint(paint);

                Path path = new Path();
                myView.setPath(path);
            }
        });
    }
}
