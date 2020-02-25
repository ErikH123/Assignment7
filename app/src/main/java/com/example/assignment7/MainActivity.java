package com.example.assignment7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Kuuntelija kuuntelija;

    ListView listView;
    ArrayList<Data> lista;
    Adapteri adapteri;
    final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kuuntelija = new Kuuntelija();

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        registerReceiver(kuuntelija, filter);

        lista = new ArrayList<>();
        adapteri = new Adapteri(this, R.layout.timestamp_layout, lista);
        listView = findViewById(R.id.listView);
        listView.setAdapter(adapteri);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(kuuntelija);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume kutsuttu");
        adapteri.notifyDataSetChanged();
    }


}
