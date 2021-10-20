package com.crisspian.fragment_guide_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.crisspian.fragment_guide_01.databinding.ActivityMainBinding;
import com.crisspian.fragment_guide_01.databinding.FragmentBlankBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding Binding;
    private boolean isFragmentDisplayed = false;
    private BlankFragment blankFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBinding();
        setContentView(Binding.getRoot());
        setupClickListener();
    }



    private void initBinding() {
        Binding = ActivityMainBinding.inflate(getLayoutInflater());
    }
    private void setupClickListener() {
        Binding.btnFragment.setOnClickListener(v->{
            if (isFragmentDisplayed) {
                closeFragment();

            } else{
                showFragment();
            }

        });
    }

    private void showFragment(){

        if(blankFragment == null){
            blankFragment = BlankFragment.newInstance();
        }
       // BlankFragment blankFragment = BlankFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.content,blankFragment)
           .addToBackStack(null)
           .commit();
        Binding.btnFragment.setText(R.string.close);
        isFragmentDisplayed = true;
    }

    private void closeFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        BlankFragment blankFragment = (BlankFragment) fragmentManager.findFragmentById(R.id.content);
        if (blankFragment !=null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(blankFragment).commit();
            Binding.btnFragment.setText(R.string.open);
            isFragmentDisplayed = false;

        }

    }
}