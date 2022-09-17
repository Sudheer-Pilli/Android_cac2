package com.example.lab5_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity3 extends AppCompatActivity {
    ImageButton share, copy, call, sms;
    TextView chairname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        share = (ImageButton) findViewById(R.id.share);
        copy = (ImageButton) findViewById(R.id.copy);
        call = (ImageButton) findViewById(R.id.call);
        sms = (ImageButton) findViewById(R.id.sms);
        chairname = (TextView) findViewById(R.id.decorname1);
        String ch = chairname.getText().toString();

        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentsms = new Intent(MainActivity3.this, MainActivity4.class);
                startActivity(intentsms);
            }
        });

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentcopy= new Intent(Intent.ACTION_SEND);
                intentcopy.putExtra(Intent.EXTRA_TEXT, ch);
                intentcopy.setType("text/plain");
                startActivity(intentcopy);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentshare = new Intent(Intent.ACTION_SEND);
                intentshare.putExtra(Intent.EXTRA_TEXT, ch);
                intentshare.setType("text/plain");
                startActivity(intentshare);
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = "+34666777888";
                Intent intentcall = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intentcall);
            }
        });

        final RatingBar rate1 = (RatingBar) findViewById(R.id.ratingbar);
        Button subrate = (Button) findViewById(R.id.subrate);
        TextView textrate = (TextView) findViewById(R.id.textrate);

        subrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               textrate.setText("Your rating is: "+rate1.getRating());
            }
        });



    }
}