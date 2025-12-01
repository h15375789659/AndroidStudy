package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MenuTestActivity extends AppCompatActivity {
    
    private TextView testTextView;
    private Button showMenuBtn;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_test);
        
        testTextView = findViewById(R.id.test_text);
        showMenuBtn = findViewById(R.id.btn_show_menu);
        
        showMenuBtn.setOnClickListener(v -> showPopupMenu());
    }
    
    private void showPopupMenu() {
        PopupMenu popupMenu = new PopupMenu(this, showMenuBtn);
        popupMenu.getMenuInflater().inflate(R.menu.main_menu, popupMenu.getMenu());
        
        popupMenu.setOnMenuItemClickListener(item -> {
            return handleMenuSelection(item);
        });
        
        popupMenu.show();
    }
    
    private boolean handleMenuSelection(MenuItem item) {
        int id = item.getItemId();
        
        if (id == R.id.menu_font_small) {
            testTextView.setTextSize(10);
            return true;
        } else if (id == R.id.menu_font_medium) {
            testTextView.setTextSize(16);
            return true;
        } else if (id == R.id.menu_font_large) {
            testTextView.setTextSize(20);
            return true;
        } else if (id == R.id.menu_normal_item) {
            Toast.makeText(this, "普通菜单项被点击", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_color_red) {
            testTextView.setTextColor(Color.RED);
            return true;
        } else if (id == R.id.menu_color_black) {
            testTextView.setTextColor(Color.BLACK);
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        
        if (id == R.id.menu_font_small) {
            testTextView.setTextSize(10);
            return true;
        } else if (id == R.id.menu_font_medium) {
            testTextView.setTextSize(16);
            return true;
        } else if (id == R.id.menu_font_large) {
            testTextView.setTextSize(20);
            return true;
        } else if (id == R.id.menu_normal_item) {
            Toast.makeText(this, "普通菜单项被点击", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_color_red) {
            testTextView.setTextColor(Color.RED);
            return true;
        } else if (id == R.id.menu_color_black) {
            testTextView.setTextColor(Color.BLACK);
            return true;
        }
        
        return super.onOptionsItemSelected(item);
    }
}
