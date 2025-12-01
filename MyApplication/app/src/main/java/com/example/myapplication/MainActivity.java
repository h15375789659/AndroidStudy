package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setupButton(R.id.btnLinearLayout, LinearLayoutActivity.class);
        setupButton(R.id.btnTableLayout, TableLayoutActivity.class);
        setupButton(R.id.btnConstraintCalculator, ConstraintCalculatorActivity.class);
        setupButton(R.id.btnSpaceStation, SpaceStationActivity.class);
        
        // 实验三入口
        setupButton(R.id.btnAnimalList, AnimalListActivity.class);
        setupButton(R.id.btnAlertDialog, AlertDialogActivity.class);
        setupButton(R.id.btnMenuTest, MenuTestActivity.class);
        setupButton(R.id.btnActionMode, ActionModeActivity.class);
    }
    
    private void setupButton(int buttonId, final Class<?> targetActivity) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, targetActivity));
            }
        });
    }
}