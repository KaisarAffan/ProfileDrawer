package com.example.navdrawerexample.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navdrawerexample.Item;
import com.example.navdrawerexample.MyAdapter;
import com.example.navdrawerexample.R;

import java.util.ArrayList;
import java.util.List;

public class Warung extends Fragment {

    List<Item> resep = new ArrayList<>();
    MyAdapter adapter;

    String[] image ={"https://media.licdn.com/dms/image/C4E03AQF-MU1gjy2gbw/profile-displayphoto-shrink_800_800/0/1639546331557?e=1717632000&v=beta&t=qfxYrszT2ZralmPM6wn5eJ43jbpmfooCRR3uwRRGyMw",
                     "",
                     "",
                     "",
                     "",
                     "",
                     "",
                     "",
                     "",
                     "",
                     ""};

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_warung, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.RvWarung);
        // Set the title of the Fragment
        requireActivity().setTitle("Resep");

        menu();

        adapter = new MyAdapter(getContext(),resep);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void menu() {
        String[] title =getResources().getStringArray(R.array.makananTitle);
        String[] desc =getResources().getStringArray(R.array.makananDesc);

        for (int i=0; i<title.length;i++){
            resep.add(new Item(image[i],title[i],desc[i]));
        }

    }
}
