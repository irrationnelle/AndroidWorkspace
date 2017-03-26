package net.azurewebsites.irrationnelle.testandroidstudio;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import net.azurewebsites.irrationnelle.testandroidstudio.databinding.MainRecyclerItemsBinding;
import net.azurewebsites.irrationnelle.testandroidstudio.vo.MainItem;

public class MainViewHolder extends RecyclerView.ViewHolder {
    private MainRecyclerItemsBinding binding;

    public MainViewHolder(View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
    }

    public void bind(MainItem item) {
        binding.setItem(item);
    }
}
