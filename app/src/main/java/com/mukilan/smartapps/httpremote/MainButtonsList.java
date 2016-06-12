package com.mukilan.smartapps.httpremote;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.Exchanger;

public class MainButtonsList extends AppCompatActivity {

    private RecyclerView buttons_recycler_view;
    private ButtonsAdapter buttons_adapter;
    private ArrayList<JSONObject> button_data_set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_buttons_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttons_recycler_view = (RecyclerView)findViewById(R.id.buttons_recycleriew);
        buttons_recycler_view.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        set_buttons();
        buttons_adapter = new ButtonsAdapter(button_data_set);
        buttons_adapter.notifyDataSetChanged();
        buttons_recycler_view.setAdapter(buttons_adapter);
    }

    // Basically this method should read button details from a table
    void set_buttons(){

        int button_count = 5;

        button_data_set = new ArrayList(button_count);

        try {

            JSONObject btn1 = new JSONObject();
            btn1.put("title", "Button1");
            button_data_set.add(btn1);

            JSONObject btn2 = new JSONObject();
            btn1.put("title", "Button2");
            button_data_set.add(btn2);

            JSONObject btn3 = new JSONObject();
            btn1.put("title", "Button3");
            button_data_set.add(btn3);

            JSONObject btn4 = new JSONObject();
            btn1.put("title", "Button4");
            button_data_set.add(btn4);

            JSONObject btn5 = new JSONObject();
            btn1.put("title", "Button5");
            button_data_set.add(btn5);

        }catch(Exception e){
            e.printStackTrace();
        }

        Common.ButtonsCount = button_count;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_buttons_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
