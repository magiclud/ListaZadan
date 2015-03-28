package com.example.aga.listatodo;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {


    private ArrayList<String> taskList;
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.listView);
        listview.setBackgroundColor(Color.LTGRAY);
        taskList = new ArrayList<>();

        setAdapterAndListView();
    }

    private void setAdapterAndListView() {
        StableArrayAdapter adapter = new StableArrayAdapter(this, R.layout.row_in_list, taskList);
        adapter.notifyDataSetChanged();
        listview.setAdapter(adapter);
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                taskList.remove(taskList.get(position));
                listview.invalidateViews();
                return true;
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        return id == R.id.action_settings || super.onOptionsItemSelected(item);

    }

  public void addTaskToList(View view){
      EditText editText = (EditText) findViewById(R.id.editText);
      String text = editText.getText().toString();
      editText.getText().clear();
      taskList.add(text);
      listview.invalidateViews();

  }
}
