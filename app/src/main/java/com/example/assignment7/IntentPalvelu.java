package com.example.assignment7;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.room.Room;

import java.util.ArrayList;


public class IntentPalvelu extends IntentService {
    ArrayList<Data> list = new ArrayList<>();

    final String TAG = "IntentPalvelu";

    public IntentPalvelu() {
        super("intentPalvelu");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        final Tietokanta tietokanta = Room.databaseBuilder(
                getApplicationContext(),
                Tietokanta.class,
                Tietokanta.NIMI
        ).allowMainThreadQueries()
                .build();

        try {
            Data tieto = null;
            if (intent != null) {
                tieto = (Data) intent.getSerializableExtra("data");
            }
            if (tieto != null) {
                Log.d(TAG, "onHandleIntent: AIKA = " + tieto.getAika() + " ja TAPAHTUMA = " + tieto.getTapahtuma());
            }
            tietokanta.myDao().insert(tieto);
            list.addAll(tietokanta.myDao().getAll());


            for (Data d : list) {
                Log.d(TAG, "Listan sisältö:" + d.getAika() + " " + d.getTapahtuma());
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            tietokanta.close();
        }

    }

}
