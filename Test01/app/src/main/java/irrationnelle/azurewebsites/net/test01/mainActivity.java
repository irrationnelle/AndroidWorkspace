package irrationnelle.azurewebsites.net.test01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by irrationnelle on 1/6/17.
 */

public class mainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // R이라는 객체가 activity_main.xml을 관리한다.
        setContentView(R.layout.activity_main2); // activity cover create

        Button btn02 = (Button) findViewById(R.id.btn02);
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Anonymous Class Event", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void myClick(View view) {
        Toast.makeText(this, "Pushed Button1", Toast.LENGTH_LONG).show();
    }
}
