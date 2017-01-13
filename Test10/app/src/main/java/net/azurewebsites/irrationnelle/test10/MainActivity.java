package net.azurewebsites.irrationnelle.test10;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Timer;

/**
 * Created by irrationnelle on 1/13/17.
 */

public class MainActivity extends AppCompatActivity {
    private Button btnBasic;
    private Button btnDate;
    private Button btnTime;
    private Button btnCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBasic = (Button) findViewById(R.id.btn_basic);
        btnBasic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBasicDialog();
            }
        });

        btnDate = (Button) findViewById(R.id.btn_date);
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }
        });

        btnTime = (Button) findViewById(R.id.btn_time);
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimeDialog();
            }
        });

        btnCustom = (Button) findViewById(R.id.btn_custom);
        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });


    }

    public void showBasicDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Termination Confirm Dialog")
                .setMessage("Do you want terminate this application?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .create()
                .show();
    }

    public void showDateDialog() {
        int nowYear, nowMonth, nowDay;

        Calendar now = Calendar.getInstance();
        nowYear = now.get(Calendar.YEAR);
        nowMonth = now.get(Calendar.MONTH);
        nowDay = now.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog.OnDateSetListener dateListner = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // variable month has value from 0 by array index, so that you must add +1
                String dateMsg = "Date: " + year + "-" + month+1 + "-" + dayOfMonth;
                Toast.makeText(getApplicationContext(), dateMsg, Toast.LENGTH_SHORT).show();
            }
        };

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateListner, nowYear, nowMonth, nowDay);
        datePickerDialog.show();
    }


    public void showTimeDialog() {
        int nowHour, nowMinute;

        Calendar now = Calendar.getInstance();
        nowHour = now.get(Calendar.HOUR_OF_DAY);
        nowMinute = now.get(Calendar.MINUTE);

        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String timeMsg = "Time: " + hourOfDay + ":" + minute;
                Toast.makeText(getApplicationContext(), timeMsg, Toast.LENGTH_SHORT).show();
            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, timeSetListener, nowHour, nowMinute, true);
        timePickerDialog.show();
    }

    public void showCustomDialog() {
        final Dialog customDialog = new Dialog(this);
        customDialog.setContentView(R.layout.my_dialog); // inflate

        // If you only typed findViewById without customDialog. , you call method call findViewById in MainActivity
        ImageView customImg = (ImageView) customDialog.findViewById(R.id.custom_img);
        TextView customText = (TextView) customDialog.findViewById(R.id.custom_text);
        Button customBtnYes = (Button) customDialog.findViewById(R.id.custom_btn_confirm);
        Button customBtnNo = (Button) customDialog.findViewById(R.id.custom_btn_cancel);

        customImg.setImageResource(R.drawable.android);
        customText.setText("Do you wanna android?");

        customBtnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Yeah! Thank you", Toast.LENGTH_SHORT).show();
                customDialog.cancel();
            }

        });

        customBtnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "I'm sorry to hear that", Toast.LENGTH_SHORT).show();
                customDialog.cancel();
            }
        });

        customDialog.show();
    }
}
