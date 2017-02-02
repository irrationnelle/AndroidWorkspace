package net.azurewebsites.irrationnelle.test24xmlparsing;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private EditText editKeyword;
    private Button btnSearch;
    private ListView listViewBook;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editKeyword = (EditText) findViewById(R.id.edit_keyword);
        btnSearch = (Button) findViewById(R.id.btn_search);
        listViewBook = (ListView) findViewById(R.id.listview_book);

        btnSearch.setOnClickListener(v -> {
            String keyword = editKeyword.getText() + "";
            NaverBookThread t = new NaverBookThread(null, keyword);
            t.start();
        });
    }
}
