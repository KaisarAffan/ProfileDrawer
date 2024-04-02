package com.example.navdrawerexample.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navdrawerexample.R;

public class GuruFragment extends Fragment {

    private ListView listViewGuru;

    public GuruFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_guru, container, false);

        // Initialize ListView
        listViewGuru = rootView.findViewById(R.id.listViewGuru);

        // Create an array of student names
        String[] guruNames = {"Aji Suryawan", "Agus", "Dwi Janto", "Fahmi", "Jefri Nikoll"};

        // Create an ArrayAdapter to populate the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, guruNames);

        // Set the adapter to the ListView
        listViewGuru.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Set the title of the Fragment
        requireActivity().setTitle("Guru Fragment");
    }
}
