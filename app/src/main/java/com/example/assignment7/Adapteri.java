package com.example.assignment7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Adapteri extends ArrayAdapter {
    private Context context;
    ArrayList<Data> dataset;

    public Adapteri(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.timestamp_layout, parent, false);
        LinearLayout linearLayout = (LinearLayout) v;

        TextView aika = v.findViewById(R.id.aika);
        TextView tapahtuma = v.findViewById(R.id.tapahtuma);

        aika.setText(dataset.get(position).getAika());
        tapahtuma.setText(dataset.get(position).getTapahtuma());

        return v;
    }
}
