package net.azurewebsites.irrationnelle.testandroidstudio;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.azurewebsites.irrationnelle.testandroidstudio.vo.MainItem;

import java.util.List;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainViewHolder> {
    private List<MainItem> items;

    public MainRecyclerViewAdapter(List<MainItem> items) {
        this.items = items;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View statusContainer = inflater.inflate(R.layout.main_recycler_items, parent, false);
        return new MainViewHolder(statusContainer);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        MainItem status = items.get(position);
        holder.bind(status);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
