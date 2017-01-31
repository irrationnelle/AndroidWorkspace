package net.azurewebsites.irrationnelle.test18broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by irrationnelle on 1/31/17.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Test18의 방송수신자 응답한다!!", Toast.LENGTH_SHORT).show();
    }
}
