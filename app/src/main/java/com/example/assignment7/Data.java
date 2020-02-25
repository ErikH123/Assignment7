package com.example.assignment7;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Data implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String aika;
    public String tapahtuma;

    public String getAika() {
        return aika;
    }

    public void setAika(String aika) {
        this.aika = aika;
    }

    public String getTapahtuma() {
        return tapahtuma;
    }

    public void setTapahtuma(String tapahtuma) {
        this.tapahtuma = tapahtuma;
    }
}
