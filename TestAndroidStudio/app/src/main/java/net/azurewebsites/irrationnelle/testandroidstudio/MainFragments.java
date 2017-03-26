package net.azurewebsites.irrationnelle.testandroidstudio;

import android.app.Fragment;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.azurewebsites.irrationnelle.testandroidstudio.databinding.FragmentMainBinding;
import net.azurewebsites.irrationnelle.testandroidstudio.databinding.MainRecyclerItemsBinding;
import net.azurewebsites.irrationnelle.testandroidstudio.vo.MainItem;

import java.util.ArrayList;
import java.util.List;

public class MainFragments extends Fragment {
    private FragmentMainBinding binding;

    private RecyclerView recyclerView;
    private MainRecyclerViewAdapter adapter;
    private List<MainItem> items;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        View view = binding.getRoot();

        recyclerView = binding.mainRecylcerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        items = new ArrayList<>();

        items.add(new MainItem(10, "Les Hiers"));
        items.add(new MainItem(5, "Zakuro"));

        adapter = new MainRecyclerViewAdapter(items);

        recyclerView.setAdapter(adapter);

        return view;
    }
}
