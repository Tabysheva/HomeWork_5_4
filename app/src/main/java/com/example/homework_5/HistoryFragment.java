package com.example.homework_5;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {
    RecyclerView recyclerView;
    MainAdapter adapter;
    ButtonsFragment buttonsFragment;
    Button back, show;

    ArrayList<String> list = new ArrayList<>();

    public HistoryFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        buttonsFragment = new ButtonsFragment();
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler_view);
        adapter = new MainAdapter();
        recyclerView.setAdapter(adapter);
        back=view.findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ForRecycler forRecycler = (ForRecycler)getActivity();
                forRecycler.back();
            }
        });
        show = view.findViewById(R.id.save);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAll();
            }
        });

    }

    public void showAll() {
        list = getArguments().getStringArrayList("key");
        for (int i = 0; i < list.size(); i++) {
            adapter.addText(list.get(i));
            Log.d("get", "onClick: " + list);
        }
    }
}