package com.crisspian.fragment_guide_01;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.crisspian.fragment_guide_01.databinding.FragmentBlankBinding;


public class BlankFragment extends Fragment {
    public FragmentBlankBinding binding;
    public static final int YES = 0;
    public static final int NO = 1;

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        initBinding(inflater,container);
        setupListener();

        return (binding.getRoot());
    }

    private void setupListener() {
        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

            }
        });
    }

    private void initBinding(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentBlankBinding.inflate(inflater, container, false);
    }
}