package com.client.hospitalregist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<RumahSakit> hospitals= new ArrayList<RumahSakit>() ;
    private RecyclerView recviewRS;
    Button btnDoc, btnNotif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadRes(); //load hospitals
        recviewRS = findViewById(R.id.recViewRS);
        btnDoc = findViewById(R.id.btnSeeDoc);
        btnNotif = findViewById(R.id.btnNotif);

        LinearLayoutManager lm = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recviewRS.setLayoutManager(lm);
        ListHospitalAdapter adp = new ListHospitalAdapter();
        recviewRS.setAdapter(adp);

        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getBaseContext(), ListDoctorsActivity.class);
                startActivity(i);
            }
        });


        btnNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int NOTIFICATION_ID = 234;
                NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    String CHANNEL_ID = "my_channel_01";
                    CharSequence name = "my_channel";
                    String Description = "This is my channel";
                    int importance = NotificationManager.IMPORTANCE_HIGH;
                    NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
                    mChannel.setDescription(Description);
                    mChannel.enableLights(true);
                    mChannel.setLightColor(Color.RED);
                    mChannel.enableVibration(true);
                    mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                    mChannel.setShowBadge(false);
                    notificationManager.createNotificationChannel(mChannel);
                }
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "my_channel_01")
                        .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                        .setContentTitle("RS Delta Surya is full")
                        .setContentText("RS Delta Surya Sidoarjo is overloaded, please find another hospital");

                Intent resultIntent = new Intent(getApplicationContext(), MainActivity.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext());
                stackBuilder.addParentStack(MainActivity.class);
                stackBuilder.addNextIntent(resultIntent);
                PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(resultPendingIntent);
                notificationManager.notify(NOTIFICATION_ID, builder.build());
            }
        });

    }

    //loading resource
    private void LoadRes(){

        hospitals.add(new RumahSakit(1, "RS Delta Surya", "Jl. Pahlawan No.9, Jati, Kec. Sidoarjo", "-7.4471138", "112.7015698"));
        hospitals.add(new RumahSakit(2, "RSU Siloam Surabaya", "Jl. Raya Gubeng No.70, Gubeng", "-7.2734396566770805", "112.7463870082012"));
        hospitals.add(new RumahSakit(3, "RS Royal Surabaya", "Jl. Rungkut Industri I No.1, Kendangsari", "-7.328654788595059", "112.75084402554349"));
    }
}