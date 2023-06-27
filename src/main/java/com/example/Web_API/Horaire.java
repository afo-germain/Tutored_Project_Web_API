package com.example.Web_API;

/**
 * Created by idriss on 08/05/2016. cette classe contient l'horiare en heure et
 * en minute
 */
public class Horaire {

    public int heure;
    public int minute;

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public Horaire(int heure, int minute) {
        this.heure = heure;
        this.minute = minute;
    }
}
