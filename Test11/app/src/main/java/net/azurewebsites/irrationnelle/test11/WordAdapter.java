package net.azurewebsites.irrationnelle.test11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by irrationnelle on 1/16/17.
 */

public class WordAdapter extends BaseAdapter {
    private Context context;
    private int itemLayout;
    private String[] values;

    public WordAdapter (Context context, int itemLayout, String[] values) {
        this.context = context;
        this.itemLayout = itemLayout;
        this.values = values;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int position) {
        return values[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /*
     * The most important method in this class. It's core method.
     * getView( ) method is called for item's count
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // !! To inflate my_item.xml
        View myItem = inflater.inflate(itemLayout, parent, false);
        ImageView imageItem = (ImageView) myItem.findViewById(R.id.android);
        TextView textItem = (TextView) myItem.findViewById(R.id.text_item);

        textItem.setText(values[position]);
        return myItem;
    }
}