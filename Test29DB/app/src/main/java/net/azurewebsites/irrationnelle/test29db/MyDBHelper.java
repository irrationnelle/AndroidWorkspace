package net.azurewebsites.irrationnelle.test29db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "my_word.db";
    private static final int DB_VERSION = 1;

    private SQLiteDatabase db;

    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

        db = getReadableDatabase();
//        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE word_table(word_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "word TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS word_table");
        onCreate(db);
    }

    public void insert(String inputWord) {
        db.execSQL("INSERT INTO word_table(word) VALUES ('"+inputWord+"');");
    }

    public List<String> selectWords() {
        List<String> list = new ArrayList<>();
        return list;
    }
}
