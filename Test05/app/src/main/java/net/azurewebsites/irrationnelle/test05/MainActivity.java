package net.azurewebsites.irrationnelle.test05;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;

/**
 * Created by irrationnelle on 1/11/17.
 */

public class MainActivity extends Activity {
    private CheckBox checkMeat;
    private CheckBox checkCheese;
    private CheckBox checkHam;

    private RadioButton radioRed;
    private RadioButton radioBlue;
    private RadioButton radioGreen;

    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyCheckEvent checkListener = new MyCheckEvent();

        checkMeat = (CheckBox) findViewById(R.id.check_meat);
        checkCheese = (CheckBox) findViewById(R.id.check_cheese);
        checkHam = (CheckBox) findViewById(R.id.check_ham);

        // 체크박스 객체에 이벤트 등록하기
        checkMeat.setOnClickListener(checkListener);
        checkCheese.setOnClickListener(checkListener);
        checkHam.setOnClickListener(checkListener);

        radioRed = (RadioButton) findViewById(R.id.radio_red);
        radioBlue = (RadioButton) findViewById(R.id.radio_blue);
        radioGreen = (RadioButton) findViewById(R.id.radio_green);


        radioRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "You click Red Button", Toast.LENGTH_SHORT).show();
            }
        });

        ratingBar = (RatingBar) findViewById(R.id.rating);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.d("rase", "Rating:" + rating + ", From User: "+fromUser);
            }
        });
        ratingBar.setRating(2.5f);

    }

    // 이벤트 처리를 위한 내부 클래스
    class MyCheckEvent implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if(((CheckBox)v).isChecked()) {
                switch (v.getId()) {
                    case R.id.check_meat:
                        Toast.makeText(getApplicationContext(), "You choose Meat", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.check_cheese:
                        Toast.makeText(getApplicationContext(), "You choose Cheese", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.check_ham:
                        Toast.makeText(getApplicationContext(), "You choose Ham", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
