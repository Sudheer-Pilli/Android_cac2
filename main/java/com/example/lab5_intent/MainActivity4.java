package com.example.lab5_intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {
    EditText etPhone, etMessage;
    Button btSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        etPhone = (EditText) findViewById(R.id.et_phone);
        etMessage = (EditText) findViewById(R.id.et_message);
        btSend = findViewById(R.id.bt_send);

        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission( MainActivity4.this,
                        Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED){
                    String sPhone = etPhone.getText().toString().trim();
                    String sMessage = etMessage.getText().toString().trim();
                    if(!sPhone.equals("")&& !sMessage.equals("")){
                        SmsManager smsManager=SmsManager.getDefault();
                        smsManager.sendTextMessage(sPhone, null,sMessage,null,null);
                        Toast.makeText(getApplicationContext(),"SMS sent successfully!", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Enter values",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    ActivityCompat.requestPermissions(MainActivity4.this, new String[]{Manifest.permission.SEND_SMS},100);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==100 && grantResults.length > 0 && grantResults[0]
                == PackageManager.PERMISSION_GRANTED){

            String sPhone = etPhone.getText().toString().trim();
            String sMessage = etMessage.getText().toString().trim();
            if(!sPhone.equals("")&& !sMessage.equals("")){
                SmsManager smsManager=SmsManager.getDefault();
                smsManager.sendTextMessage(sPhone, null,sMessage,null,null);
                Toast.makeText(getApplicationContext(),"SMS sent successfully!", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Enter values",Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
        }
    }
}