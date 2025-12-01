package com.example.myapplication;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimalListActivity extends AppCompatActivity {
    
    private ListView listView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_list);
        
        listView = findViewById(R.id.animal_listview);
        
        List<Map<String, Object>> data = new ArrayList<>();
        String[] animals = {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};
        int[] images = {R.drawable.lion, R.drawable.tiger, R.drawable.monkey, 
                        R.drawable.dog, R.drawable.cat, R.drawable.elephant};
        
        for (int i = 0; i < animals.length; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("name", animals[i]);
            item.put("image", images[i]);
            data.add(item);
        }
        
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                data,
                R.layout.list_item_animal,
                new String[]{"name", "image"},
                new int[]{R.id.animal_name, R.id.animal_image}
        );
        
        listView.setAdapter(adapter);
        
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String animalName = animals[position];
            Toast.makeText(this, "You clicked: " + animalName, Toast.LENGTH_SHORT).show();
        });
    }
}
