package com.example.Web_API;

import java.util.ArrayList;

/**
 * Created by idriss on 08/05/2016.
 */
public class Offer {

    public String id_requêtes;
    public Itenerary itinéraire;
    public String chauffeurId;
    public String véhiculeId;
    public String places_libres_iniales;
    public String places_libres_actuelles;
    public String état;

    public String getId_requêtes() {
        return id_requêtes;
    }

    public void setId_requêtes(String id_requêtes) {
        this.id_requêtes = id_requêtes;
    }

    public Itenerary getItinéraire() {
        return itinéraire;
    }

    public void setItinéraire(Itenerary itinéraire) {
        this.itinéraire = itinéraire;
    }

    public String getChauffeurId() {
        return chauffeurId;
    }

    public void setChauffeurId(String chauffeurId) {
        this.chauffeurId = chauffeurId;
    }

    public String getVéhiculeId() {
        return véhiculeId;
    }

    public void setVéhiculeId(String véhiculeId) {
        this.véhiculeId = véhiculeId;
    }

    public String getPlaces_libres_iniales() {
        return places_libres_iniales;
    }

    public void setPlaces_libres_iniales(String places_libres_iniales) {
        this.places_libres_iniales = places_libres_iniales;
    }

    public String getPlaces_libres_actuelles() {
        return places_libres_actuelles;
    }

    public void setPlaces_libres_actuelles(String places_libres_actuelles) {
        this.places_libres_actuelles = places_libres_actuelles;
    }

    public String getÉtat() {
        return état;
    }

    public void setÉtat(String état) {
        this.état = état;
    }

    public Offer(String id_requêtes, Itenerary itinéraire, String chauffeurId, String véhiculeId, String places_libres_iniales, String places_libres_actuelles, String état) {
        this.id_requêtes = id_requêtes;
        this.itinéraire = itinéraire;
        this.chauffeurId = chauffeurId;
        this.véhiculeId = véhiculeId;
        this.places_libres_iniales = places_libres_iniales;
        this.places_libres_actuelles = places_libres_actuelles;
        this.état = état;
    }

}
