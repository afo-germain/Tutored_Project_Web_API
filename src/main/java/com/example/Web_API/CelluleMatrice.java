package com.example.Web_API;

/**
 * Created by HASSINE on 08/05/2016.
 */
public class CelluleMatrice {

    public String montant;
    public String distanceaupluscourt;
    public String tempsaupluscourt;
    public Itenerary itinéraire;

    public CelluleMatrice(String montant, String distanceaupluscourt, String tempsaupluscourt, Itenerary itinéraire) {
        this.montant = montant;
        this.distanceaupluscourt = distanceaupluscourt;
        this.tempsaupluscourt = tempsaupluscourt;
        this.itinéraire = itinéraire;
    }

    public String getMontant() {

        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public String getDistanceaupluscourt() {
        return distanceaupluscourt;
    }

    public void setDistanceaupluscourt(String distanceaupluscourt) {
        this.distanceaupluscourt = distanceaupluscourt;
    }

    public String getTempsaupluscourt() {
        return tempsaupluscourt;
    }

    public void setTempsaupluscourt(String tempsaupluscourt) {
        this.tempsaupluscourt = tempsaupluscourt;
    }

    public Itenerary getItinéraire() {
        return itinéraire;
    }

    public void setItinéraire(Itenerary itinéraire) {
        this.itinéraire = itinéraire;
    }
}
