package net.azurewebsites.irrationnelle.test24xmlparsing;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import net.azurewebsites.irrationnelle.test24xmlparsing.vo.BookVO;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText editKeyword;
    private Button btnSearch;
    private ListView listViewBook;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
//            bookVOList = (List) msg.obj;
            bookVOList.clear();
            bookVOList.addAll((List<BookVO>)msg.obj);
            adapter.notifyDataSetChanged();
        }
    };


    private BookListAdapter adapter;
    private List<BookVO> bookVOList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editKeyword = (EditText) findViewById(R.id.edit_keyword);
        btnSearch = (Button) findViewById(R.id.btn_search);
        listViewBook = (ListView) findViewById(R.id.listview_book);

        adapter = new BookListAdapter(this, R.layout.item_book, bookVOList);

        listViewBook.setAdapter(adapter);

        btnSearch.setOnClickListener(v -> {
            String keyword = editKeyword.getText() + "";
            NaverBookThread t = new NaverBookThread(handler, keyword);
            t.start();
        });
    }
}
