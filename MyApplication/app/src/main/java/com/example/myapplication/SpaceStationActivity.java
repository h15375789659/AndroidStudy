package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SpaceStationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space_station);
        
        Button btnDepart = findViewById(R.id.btnDepart);
        btnDepart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SpaceStationActivity.this, 
                        "准备出发！🚀", 
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
