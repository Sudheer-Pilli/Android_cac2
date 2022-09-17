package com.example.lab5_intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity2 extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private TextView name;
    CardView samp1, samp2, samp3, samp4;
    ImageButton img1;
    FloatingActionButton fab1;
    TextView app_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = findViewById(R.id.textView2);

        String username=getIntent().getStringExtra("keyname");

        name.setText(username);

        fab1 = findViewById(R.id.add_fab);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent prof = new Intent(MainActivity2.this, MainActivity5.class);
                startActivity(prof);
            }
        });

        samp1 = findViewById(R.id.chair1);
        samp2 = findViewById(R.id.chair2);
        samp3 = findViewById(R.id.chair3);
        samp4 = findViewById(R.id.chair4);
        img1 = findViewById(R.id.chairimg1);
        app_name = findViewById(R.id.app_name);

        samp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(int1);
            }
        });

        registerForContextMenu(app_name);
    }

    public void showpopup(View v){
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popupmenu);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_share:;
                Toast.makeText(this, "Message shared.", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.nav_flag:;
                Toast.makeText(this, "Message shared.", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.settings:
                Toast.makeText(this, "Settings clicked",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.contact_us:
                Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.context_main, menu);
    }



    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.aboutus:
                Intent intent = new Intent(MainActivity2.this, MainActivity6.class);
                startActivity(intent);
                return true;


            case R.id.oursponsors:
                Toast.makeText(this, "Our Sponsors Selected", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onContextItemSelected(item);
        }

    }
}