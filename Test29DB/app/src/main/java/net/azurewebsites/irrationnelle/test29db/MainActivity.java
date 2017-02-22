package net.azurewebsites.irrationnelle.test29db;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText editWord;
    private Button btnAdd, btnSelectList;
    private ListView listViewWord;

    private List<String> wordList;

    private MyDBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editWord = (EditText) findViewById(R.id.edit_word);
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnSelectList = (Button) findViewById(R.id.btn_list);
        listViewWord = (ListView) findViewById(R.id.listview);

        wordList = new ArrayList<>();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, wordList);

        helper = new MyDBHelper(this);



        btnAdd.setOnClickListener(v -> {
            String input = editWord.getText()+"";
            if(input != null && input.length()>0) {
                helper.insert(input);
            }
        });

        btnSelectList.setOnClickListener(v -> {
            List<String> selectList = helper.selectWords();

            wordList.clear();
            wordList.addAll(selectList);
            adapter.notifyDataSetChanged();
        });
    }
}
