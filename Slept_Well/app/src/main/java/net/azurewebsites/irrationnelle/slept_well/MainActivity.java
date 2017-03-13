package net.azurewebsites.irrationnelle.slept_well;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;

import net.azurewebsites.irrationnelle.slept_well.databinding.ActivityMainBinding;
import net.azurewebsites.irrationnelle.slept_well.databinding.ContentMainBinding;
import net.azurewebsites.irrationnelle.slept_well.databinding.FabTestBinding;
import net.azurewebsites.irrationnelle.slept_well.vo.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        FabTestBinding fabTestBinding = DataBindingUtil.setContentView(this, R.layout.fab_test);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        User user = new User("rase", "tyr");
        binding.setUser(user);

        binding.fab.setOnClickListener(v -> {
            Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        });

        final View actionB = fabTestBinding.actionB;

        FloatingActionButton actionC = new FloatingActionButton(getBaseContext());
        actionC.setTitle("Hide/Show Action above");
        actionC.setOnClickListener(v -> {
            actionB.setVisibility(actionB.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
        });

        fabTestBinding.multipleActions.addButton(actionC);

        fabTestBinding.actionA.setOnClickListener(v -> {
            fabTestBinding.actionA.setTitle("Action A clicked");
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
