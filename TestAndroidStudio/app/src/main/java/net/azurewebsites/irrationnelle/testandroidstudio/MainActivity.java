package net.azurewebsites.irrationnelle.testandroidstudio;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionButton;

import net.azurewebsites.irrationnelle.testandroidstudio.databinding.ActivityMainBinding;
import net.azurewebsites.irrationnelle.testandroidstudio.databinding.FabTestBinding;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainFragment";

    private ActivityMainBinding activityMainBinding;

    private TextView mTextMessage;

    private MainFragments mainFragments;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

//        mainFragments = new MainFragments();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
//        fragmentTransaction.replace(R.id.main_fragment, mainFragments);
        fragmentTransaction.commit();

        Log.d(TAG, "fragmentTransaction is completed");


        BottomNavigationView navigation = activityMainBinding.navigation;
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        final View actionB = activityMainBinding.actionB;

        FloatingActionButton actionC = new FloatingActionButton(getBaseContext());
        actionC.setTitle("Hide/Show Action above");
        actionC.setOnClickListener(v -> {
            actionB.setVisibility(actionB.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
        });

        activityMainBinding.multipleActions.addButton(actionC);

        activityMainBinding.actionA.setOnClickListener(v -> {
            activityMainBinding.actionA.setTitle("Action A clicked");
        });
    }

}
