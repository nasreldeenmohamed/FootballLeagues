package com.bip.interview.task;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;

import static androidx.navigation.Navigation.findNavController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavController navController = findNavController(this, R.id.navigationHostFragment);
        navController.setGraph(R.navigation.navigation_graph);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return findNavController(this, R.id.navigationHostFragment).navigateUp();
    }
}
