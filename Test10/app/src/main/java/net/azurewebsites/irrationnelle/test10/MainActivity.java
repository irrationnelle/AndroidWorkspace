package net.azurewebsites.irrationnelle.test10;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
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
}
