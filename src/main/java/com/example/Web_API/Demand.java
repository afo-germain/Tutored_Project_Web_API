package com.example.Web_API;

/**
 * Created by idriss on 08/05/2016.
 */
public class Demand {

    public String idrequêtedemande;
    public Itenerary itinéraire;
    public String nombredeplaces;
    public String montant;
    public String état;

    public String getIdrequêtedemande() {
        return idrequêtedemande;
    }

    public void setIdrequêtedemande(String idrequêtedemande) {
        this.idrequêtedemande = idrequêtedemande;
    }

    public Itenerary getItinéraire() {
        return itinéraire;
    }

    public void setItinéraire(Itenerary itinéraire) {
        this.itinéraire = itinéraire;
    }

    public String getNombredeplaces() {
        return nombredeplaces;
    }

    public void setNombredeplaces(String nombredeplaces) {
        this.nombredeplaces = nombredeplaces;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public String getÉtat() {
        return état;
    }

    public void setÉtat(String état) {
        this.état = état;
    }

    public Demand(String idrequêtedemande, Itenerary itinéraire, String nombredeplaces, String montant, String état) {
        this.idrequêtedemande = idrequêtedemande;
        this.itinéraire = itinéraire;
        this.nombredeplaces = nombredeplaces;
        this.montant = montant;
        this.état = état;
    }
}
