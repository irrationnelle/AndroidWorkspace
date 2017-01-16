package net.azurewebsites.irrationnelle.ex06;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import net.azurewebsites.irrationnelle.ex06.vo.ContactVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by irrationnelle on 1/16/17.
 */

public class MainActivity extends AppCompatActivity {
    private List<ContactVO> contactVOList;
    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.contact_list);

        int contactLayout = R.layout.contact_list;

        ContactVO vo1 = new ContactVO();
        vo1.setName("Rase");
        vo1.setMessage("Test01");

        ContactVO vo2 = new ContactVO();
        vo2.setName("Tyr");
        vo2.setMessage("Test02");

        ContactVO vo3 = new ContactVO();
        vo3.setName("verenis");
        vo3.setMessage("Why so serious?");

        contactVOList = new ArrayList<>();

        contactVOList.add(vo1);
        contactVOList.add(vo2);
        contactVOList.add(vo3);

        ContactAdapter adapter = new ContactAdapter(this, contactLayout, contactVOList);

        listView.setAdapter(adapter);

    }
}
