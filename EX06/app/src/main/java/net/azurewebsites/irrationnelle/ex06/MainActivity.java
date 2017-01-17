package net.azurewebsites.irrationnelle.ex06;

import android.app.Dialog;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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
    private ImageButton addBtn;

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

        // TODO check that lambda expression needs final like anonymous class.
        final ContactAdapter adapter = new ContactAdapter(this, contactLayout, contactVOList);

        listView.setAdapter(adapter);

        // lambda expression
        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Delete Verify Dialog").setMessage("Do you want really this contact info?")
                    .setPositiveButton("Yes", ((dialog, which) -> {
                        contactVOList.remove(position);
                        adapter.notifyDataSetChanged();
                        dialog.cancel();
            }))
                    .setNegativeButton("No", ((dialog, which) -> {
                        dialog.cancel();
            })).
                    create().show();

            return true;
        });

        addBtn = (ImageButton) findViewById(R.id.add_button);
        addBtn.setOnClickListener(v -> {
            final Dialog dialog = new Dialog(v.getContext());
            dialog.setContentView(R.layout.add_dialog);

            final EditText inputName = (EditText) dialog.findViewById(R.id.edit_name);
            final EditText inputPhone = (EditText) dialog.findViewById(R.id.edit_phone);

            Button submitConfirm = (Button) dialog.findViewById(R.id.btn_confirm);
            Button submitCancel = (Button) dialog.findViewById(R.id.btn_cancel);

            submitConfirm.setOnClickListener(v1 -> {
                ContactVO contact = new ContactVO();
                contact.setName(inputName.getText()+"");
                contact.setMessage(inputPhone.getText()+"");

                contactVOList.add(contact);

                adapter.notifyDataSetChanged();
                listView.refreshDrawableState();
                dialog.cancel();
            });

            submitCancel.setOnClickListener(v1 -> {
                dialog.cancel();
            });

            dialog.show();
        });
    }
}
