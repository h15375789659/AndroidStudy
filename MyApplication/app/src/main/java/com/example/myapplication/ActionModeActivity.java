package com.example.myapplication;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActionModeActivity extends AppCompatActivity {
    
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> items;
    private Button addButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_mode);
        
        listView = findViewById(R.id.action_listview);
        addButton = findViewById(R.id.btn_add_item);
        
        items = new ArrayList<>(Arrays.asList("One", "Two", "Three", "Four", "Five"));
        adapter = new ArrayAdapter<>(this, R.layout.list_item_action, R.id.item_text, items);
        listView.setAdapter(adapter);
        
        addButton.setOnClickListener(v -> showAddItemDialog());
        
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position,
                                                  long id, boolean checked) {
                int checkedCount = listView.getCheckedItemCount();
                mode.setTitle(checkedCount + " selected");
            }
            
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                getMenuInflater().inflate(R.menu.context_menu, menu);
                return true;
            }
            
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }
            
            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                int id = item.getItemId();
                
                if (id == R.id.menu_delete) {
                    deleteSelectedItems();
                    mode.finish();
                    return true;
                } else if (id == R.id.menu_add) {
                    showAddItemDialog();
                    mode.finish();
                    return true;
                }
                return false;
            }
            
            @Override
            public void onDestroyActionMode(ActionMode mode) {
            }
        });
    }
    
    private void deleteSelectedItems() {
        List<String> toRemove = new ArrayList<>();
        for (int i = 0; i < listView.getCount(); i++) {
            if (listView.isItemChecked(i)) {
                toRemove.add(items.get(i));
            }
        }
        items.removeAll(toRemove);
        adapter.notifyDataSetChanged();
    }
    
    private void showAddItemDialog() {
        EditText editText = new EditText(this);
        editText.setHint("输入项目名称");
        
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("添加新项目")
                .setView(editText)
                .setPositiveButton("添加", (dialog, which) -> {
                    String newItem = editText.getText().toString().trim();
                    if (!newItem.isEmpty()) {
                        items.add(newItem);
                        adapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton("取消", null);
        
        builder.create().show();
    }
}
