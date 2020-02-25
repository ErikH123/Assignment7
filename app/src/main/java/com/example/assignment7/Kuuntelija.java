package com.example.assignment7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Calendar;

public class Kuuntelija extends BroadcastReceiver {

    Intent aikaIntent;

    @Override
    public void onReceive(Context context, Intent intent) {

        aikaIntent = new Intent();
        aikaIntent.setClass(context, IntentPalvelu.class);

        final String TAG = "Kuuntelija";

        if (Intent.ACTION_SCREEN_ON.equals(intent.getAction())) {
            Log.d(TAG, "Screen ON");
            Data data = new Data();
            String aika = Calendar.getInstance().getTime().toString();
            data.setAika(aika);
            data.setTapahtuma("Screen ON");
            aikaIntent.putExtra("data", data);
            context.startService(aikaIntent);
        }

        if (Intent.ACTION_SCREEN_OFF.equals(intent.getAction())) {
            Log.d(TAG, "Screen OFF");
            Data data = new Data();
            String aika = Calendar.getInstance().getTime().toString();
            data.setAika(aika);
            data.setTapahtuma("Screen OFF");
            aikaIntent.putExtra("data", data);
            context.startService(aikaIntent);
        }
    }
}
