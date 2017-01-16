package net.azurewebsites.irrationnelle.ex06;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.azurewebsites.irrationnelle.ex06.vo.ContactVO;

import java.util.List;

/**
 * Created by irrationnelle on 1/16/17.
 */

public class ContactAdapter extends BaseAdapter {
    private Context context;
    private int contactListLayout;
    private List<ContactVO> contactVOList;

    public ContactAdapter(Context context, int contactListLayout, List<ContactVO> contactVOList) {
        this.context = context;
        this.contactListLayout = contactListLayout;
        this.contactVOList = contactVOList;
    }

    @Override
    public int getCount() {
        return contactVOList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactVOList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ContactHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(contactListLayout, parent, false);
            holder = new ContactHolder();
            holder.callBtn = (ImageButton) convertView.findViewById(R.id.contact_call_btn);
            holder.MsgBtn = (ImageButton) convertView.findViewById(R.id.contact_msg_btn);
            holder.defaultImage = (ImageView) convertView.findViewById(R.id.contact_image);
            holder.msgText = (TextView) convertView.findViewById(R.id.contact_msg_text);
            holder.nameText = (TextView) convertView.findViewById(R.id.contact_name_text);

            // To record result of inflating
            convertView.setTag(holder);
        } else {
            holder = (ContactHolder) convertView.getTag();
            final ContactVO contact = contactVOList.get(position);  // When executing this method in run-time, unless ContactVO is not final, we are confused.
            holder.nameText.setText(contact.getName());
            holder.msgText.setText(contact.getMessage());
            holder.callBtn.setOnClickListener(v -> Toast.makeText(context, "Call: " + contact.getName(), Toast.LENGTH_SHORT).show());
        }
//
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View myContact = inflater.inflate(contactListLayout, parent, false);
////        ImageView defaultImage = (ImageView) myContact.findViewById(R.id.contact_image);
//        TextView nameText = (TextView) myContact.findViewById(R.id.contact_name_text);
//        TextView msgText = (TextView) myContact.findViewById(R.id.contact_msg_text);
//
//        for(ContactVO contact : contactVOList) {
//            nameText.setText(contact.getName());
//            msgText.setText(contact.getMessage());
//        }
//
        return convertView;
    }

    // Holder class for more efficiency to inflate
    private class ContactHolder {
        private ImageView defaultImage;
        private TextView nameText;
        private TextView msgText;
        private ImageButton callBtn;
        private ImageButton MsgBtn;
    }
}
