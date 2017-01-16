package net.azurewebsites.irrationnelle.test11;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by irrationnelle on 1/16/17.
 */

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] words = {"Rase", "Kotlin", "Android", "iPad", "WaterMelon", "Google", "Scala", "Spring"};

        listView = (ListView) findViewById(R.id.listview);

        int itemLayout = R.layout.my_item;

        WordAdapter adapter = new WordAdapter(this, itemLayout, words);

        listView.setAdapter(adapter);
    }
}
