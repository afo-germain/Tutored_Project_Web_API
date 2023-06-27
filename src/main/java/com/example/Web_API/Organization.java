package com.example.Web_API;

import java.util.ArrayList;

/**
 * Created by idriss on 08/05/2016.
 */
public class Organization {

    public String idorg;
    public Itenerary itinéraire;
    public String idoffre;
    public String iddemandes;
    public String état;
    public String placesoccupées;
    public String placeslibres;

    public String getIdorg() {
        return idorg;
    }

    public void setIdorg(String idorg) {
        this.idorg = idorg;
    }

    public Itenerary getItinéraire() {
        return itinéraire;
    }

    public void setItinéraire(Itenerary itinéraire) {
        this.itinéraire = itinéraire;
    }

    public String getIdoffre() {
        return idoffre;
    }

    public void setIdoffre(String idoffre) {
        this.idoffre = idoffre;
    }

    public String getIddemandes() {
        return iddemandes;
    }

    public void setIddemandes(String iddemandes) {
        this.iddemandes = iddemandes;
    }

    public String getÉtat() {
        return état;
    }

    public void setÉtat(String état) {
        this.état = état;
    }

    public String getPlacesoccupées() {
        return placesoccupées;
    }

    public void setPlacesoccupées(String placesoccupées) {
        this.placesoccupées = placesoccupées;
    }

    public String getPlaceslibres() {
        return placeslibres;
    }

    public void setPlaceslibres(String placeslibres) {
        this.placeslibres = placeslibres;
    }

    public Organization(String idorg, Itenerary itinéraire, String idoffre,
            String iddemandes, String état, String placesoccupées, String placeslibres) {
        this.idorg = idorg;
        this.itinéraire = itinéraire;
        this.idoffre = idoffre;
        this.iddemandes = iddemandes;
        this.état = état;
        this.placesoccupées = placesoccupées;
        this.placeslibres = placeslibres;
    }

    @Override
    public String toString() {
        return "Organization{" + "idorg=" + idorg + ", itin\u00e9raire=" + itinéraire.toString() + ", idoffre=" + idoffre + ", iddemandes=" + iddemandes + ", \u00e9tat=" + état + ", placesoccup\u00e9es=" + placesoccupées + ", placeslibres=" + placeslibres + '}';
    }
}
