package net.azurewebsites.irrationnelle.ex09;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by irrationnelle on 2/1/17.
 */

public class MainActivity extends AppCompatActivity {
    private TextView threadText;
//    private ProgressBar progressBar;
    private Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        threadText = (TextView) findViewById(R.id.thread_text);
        threadText.setText(Thread.currentThread().getId() +"");
//        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 200 :
                        threadText.setText(msg.arg1);
                        break;
//                    case 400 :
//                        progressBar.setProgress(msg.arg1);
                    case 999 :
                        threadText.setText("Thread END");
                        break;
                    default:
                        break;
                }
            }
        };

        CountThread t = new CountThread();
        t.start();
    }

    class CountThread extends Thread {
        @Override
        public void run() {
            for(int i = 0; i<10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

//                if (i%2 == 0) {
//                    Message msg = new Message();
//                    msg.what = 400;
//                    msg.arg1 = i;
//                    handler.sendMessage(msg);
//                }

                Message msg = new Message();
                msg.what = 200;
                msg.arg1 = i;
                handler.sendMessage(msg);
            }

            Message msg = new Message();
            msg.what = 999;
            handler.sendMessage(msg);
        }
    }
}
