package com.example.Web_API;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Created by HASSINE on 08/05/2016. Cette classe s'occupe par la création des
 * listes offers & demands & orgs
 */
public class GenerateAllLists {

    private final static Logger LOGGER = Logger.getLogger(GenerateAllLists.class.getName());

    /*fonction qui s'occupe de la lecture du mémoire des offres à partir du requetesoffres.txt et créé la liste
* des offres */
    public ArrayList<Offer> listOfOffers(File offers) {
        ArrayList<Offer> listofOffers = new ArrayList<>();
        try {
            InputStream ips = new FileInputStream(offers);
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String ligne;
            int numline = 1;
            int index;
            String id_requêtes, itinéraire, chauffeurId, véhiculeId, places_libres_iniales,
                    places_libres_actuelles, état;
            while ((ligne = br.readLine()) != null) {
                if (numline > 1) {
                    //id_requêtes
                    index = ligne.indexOf(",");
                    id_requêtes = ligne.substring(0, index);
                    ligne = ligne.substring(index + 1, ligne.length());
                    //itinéraire
                    index = ligne.indexOf(",");
                    itinéraire = ligne.substring(0, index);
                    ligne = ligne.substring(index + 1, ligne.length());
                    //chauffeurId
                    index = ligne.indexOf(",");
                    chauffeurId = ligne.substring(0, index);
                    ligne = ligne.substring(index + 1, ligne.length());
                    //véhiculeId
                    index = ligne.indexOf(",");
                    véhiculeId = ligne.substring(0, index);
                    ligne = ligne.substring(index + 1, ligne.length());
                    //places_libres_iniales
                    index = ligne.indexOf(",");
                    places_libres_iniales = ligne.substring(0, index);
                    ligne = ligne.substring(index + 1, ligne.length());
                    //places_libres_actuelles
                    index = ligne.indexOf(",");
                    places_libres_actuelles = ligne.substring(0, index);
                    ligne = ligne.substring(index + 1, ligne.length());
                    //état
                    état = ligne;

                    //Création de Itenarary
                    ArrayList<Position> arrayListPostions = new ArrayList<>();
                    int index_ = 0;
                    // récupératin position
                    while (!itinéraire.equals("")) {
                        index_ = itinéraire.indexOf("_");
                        if (index_ == -1) {
                            String position = itinéraire;
                            int indexSlach = position.indexOf("/");
                            String postionNom = position.substring(0, indexSlach);
                            position = position.substring(indexSlach + 1, position.length());
                            indexSlach = position.indexOf("/");
                            String heurePlusTot = position.substring(0, indexSlach);
                            position = position.substring(indexSlach + 1, position.length());
                            indexSlach = position.indexOf("/");
                            String minutePlusTot = position.substring(0, indexSlach);
                            position = position.substring(indexSlach + 1, position.length());
                            indexSlach = position.indexOf("/");
                            String heurePlusTard = position.substring(0, indexSlach);
                            position = position.substring(indexSlach + 1, position.length());
                            indexSlach = position.indexOf("/");
                            String minutePlusTard = position.substring(0, indexSlach);
                            position = position.substring(indexSlach + 1, position.length());
                            indexSlach = position.indexOf("/");
                            String pickUp = position.substring(0, indexSlach);
                            position = position.substring(indexSlach + 1, position.length());
                            String delivery = position;

                            Horaire horairePlusTot = new Horaire(Integer.parseInt(heurePlusTot),
                                    Integer.parseInt(minutePlusTot));
                            Horaire horairePlusTard = new Horaire(Integer.parseInt(heurePlusTard),
                                    Integer.parseInt(minutePlusTard));
                            if (postionNom.equals("bizerte")) {
                                int indexPosition = 0;
                                Position position1 = new Position(indexPosition, postionNom, horairePlusTot, horairePlusTard, pickUp, delivery);
                                arrayListPostions.add(position1);
                            }

                            if (postionNom.equals("elalia")) {
                                int indexPosition = 1;
                                Position position1 = new Position(indexPosition, postionNom, horairePlusTot, horairePlusTard, pickUp, delivery);
                                arrayListPostions.add(position1);
                            }

                            if (postionNom.equals("rassjbel")) {
                                int indexPosition = 2;
                                Position position1 = new Position(indexPosition, postionNom, horairePlusTot, horairePlusTard, pickUp, delivery);
                                arrayListPostions.add(position1);
                            }

                            if (postionNom.equals("tunis")) {
                                int indexPosition = 3;
                                Position position1 = new Position(indexPosition, postionNom, horairePlusTot, horairePlusTard, pickUp, delivery);
                                arrayListPostions.add(position1);
                            }

                            if (postionNom.equals("sousse")) {
                                int indexPosition = 4;
                                Position position1 = new Position(indexPosition, postionNom, horairePlusTot, horairePlusTard, pickUp, delivery);
                                arrayListPostions.add(position1);
                            }

                            if (postionNom.equals("nabeul")) {
                                int indexPosition = 5;
                                Position position1 = new Position(indexPosition, postionNom, horairePlusTot, horairePlusTard, pickUp, delivery);
                                arrayListPostions.add(position1);
                            }

                            if (postionNom.equals("sfax")) {
                                int indexPosition = 6;
                                Position position1 = new Position(indexPosition, postionNom, horairePlusTot, horairePlusTard, pickUp, delivery);
                                arrayListPostions.add(position1);
                            }

                            itinéraire = "";
                        } else {
                            String position = itinéraire.substring(0, index_);
                            int indexSlach = position.indexOf("/");
                            String postionNom = position.substring(0, indexSlach);
                            position = position.substring(indexSlach + 1, position.length());
                            indexSlach = position.indexOf("/");
                            String heurePlusTot = position.substring(0, indexSlach);
                            position = position.substring(indexSlach + 1, position.length());
                            indexSlach = position.indexOf("/");
                            String minutePlusTot = position.substring(0, indexSlach);
                            position = position.substring(indexSlach + 1, position.length());
                            indexSlach = position.indexOf("/");
                            String heurePlusTard = position.substring(0, indexSlach);
                            position = position.substring(indexSlach + 1, position.length());
                            indexSlach = position.indexOf("/");
                            String minutePlusTard = position.substring(0, indexSlach);
                            position = position.substring(indexSlach + 1, position.length());
                            indexSlach = position.indexOf("/");
                            String pickUp = position.substring(0, indexSlach);
                            position = position.substring(indexSlach + 1, position.length());
                            String delivery = position;

                            Horaire horairePlusTot = new Horaire(Integer.parseInt(heurePlusTot),
                                    Integer.parseInt(minutePlusTot));
                            Horaire horairePlusTard = new Horaire(Integer.parseInt(heurePlusTard),
                                    Integer.parseInt(minutePlusTard));
                            if (postionNom.equals("bizerte")) {
                                int indexPosition = 0;
                                Position position1 = new Position(indexPosition, postionNom, horairePlusTot, horairePlusTard, pickUp, delivery);
                                arrayListPostions.add(position1);
                            }

                            if (postionNom.equals("elalia")) {
                                int indexPosition = 1;
                                Position position1 = new Position(indexPosition, postionNom, horairePlusTot, horairePlusTard, pickUp, delivery);
                                arrayListPostions.add(position1);
                            }

                            if (postionNom.equals("rassjbel")) {
                                int indexPosition = 2;
                                Position position1 = new Position(indexPosition, postionNom, horairePlusTot, horairePlusTard, pickUp, delivery);
                                arrayListPostions.add(position1);
                            }

                            if (postionNom.equals("tunis")) {
                                int indexPosition = 3;
                                Position position1 = new Position(indexPosition, postionNom, horairePlusTot, horairePlusTard, pickUp, delivery);
                                arrayListPostions.add(position1);
                            }

                            if (postionNom.equals("sousse")) {
                                int indexPosition = 4;
                                Position position1 = new Position(indexPosition, postionNom, horairePlusTot, horairePlusTard, pickUp, delivery);
                                arrayListPostions.add(position1);
                            }

                            if (postionNom.equals("nabeul")) {
                                int indexPosition = 5;
                                Position position1 = new Position(indexPosition, postionNom, horairePlusTot, horairePlusTard, pickUp, delivery);
                                arrayListPostions.add(position1);
                            }

                            if (postionNom.equals("sfax")) {
                                int indexPosition = 6;
                                Position position1 = new Position(indexPosition, postionNom, horairePlusTot, horairePlusTard, pickUp, delivery);
                                arrayListPostions.add(position1);
                            }

                            itinéraire = itinéraire.substring(index_ + 1, itinéraire.length());
                        }

                    }

                    Itenerary itenerary = new Itenerary(arrayListPostions);

                    Offer offer = new Offer(id_requêtes, itenerary, chauffeurId, véhiculeId, places_libres_iniales,
                            places_libres_actuelles, état);
                    listofOffers.add(offer);
                }
                numline++;
            }

        } catch (Exception e) {
            LOGGER.info("Error Exception");
        }
        return listofOffers;

    }


    /*fonction qui s'occupe de la lecture du mémoire des demandes à partir du requête_demandes.txt et créé la liste
* des demandes */
    public ArrayList<Demand> listOfDemands(File demands) {
        ArrayList<Demand> listOfDemands = new ArrayList<>();
        try {
            InputStream ips = new FileInputStream(demands);
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String ligne;
            int numline = 1;
            int index;
            String idrequêtedemande, itinéraire, nombredeplaces, montant, état;
            while ((ligne = br.readLine()) != null) {
                if (numline > 1) {

                    //idrequêtedemande
                    index = ligne.indexOf(",");
                    idrequêtedemande = ligne.substring(0, index);
                    ligne = ligne.substring(index + 1, ligne.length());
                    //itinéraire
                    index = ligne.indexOf(",");
                    itinéraire = ligne.substring(0, index);
                    ligne = ligne.substring(index + 1, ligne.length());
                    //nombredeplaces
                    index = ligne.indexOf(",");
                    nombredeplaces = ligne.substring(0, index);
                    ligne = ligne.substring(index + 1, ligne.length());
                    //montant
                    index = ligne.indexOf(",");
                    montant = ligne.substring(0, index);
                    ligne = ligne.substring(index + 1, ligne.length());
                    //état
                    état = ligne;

                    //Création de Itenarary
                    ArrayList<Position> arrayListPostions = new ArrayList<>();
                    int index_ = 0;
                    // récupératin position
                    while (!itinéraire.equals("")) {
                        index_ = itinéraire.indexOf("_");
                        if (index_ == -1) {
                            String position = itinéraire;
                            int indexSlach = position.indexOf("/");
                            String postionNom = position.substring(0, indexSlach);
                            position = position.substring(indexSlach + 1, position.length());
                            indexSlach = position.indexOf("/");
                            String heurePlusTot = position.substring(0, indexSlach);
                            position = position.substring(indexSlach + 1, position.length());
                            indexSlach = position.indexOf("/");
                            String minutePlusTot = position.substring(0, indexSlach);
                            position = position.substring(indexSlach + 1, position.length());
                            indexSlach = position.indexOf("/");
                            String heurePlusTard = position.substring(0, indexSlach);
                            position = position.substring(indexSlach + 1, position.length());
                            indexSlach = position.indexOf("/");
                            String minutePlusTard = position.substring(0, indexSlach);
                            position = position.substring(indexSlach + 1, position.length());
                            indexSlach = position.indexOf("/");
                            String pickUp = position.substring(0, indexSlach);
                            position = position.substring(indexSlach + 1, position.length());
                            String delivery = position;

                            Horaire horairePlusTot = new Horaire(Integer.parseInt(heurePlusTot),
                                    Integer.parseInt(minutePlusTot));
                            Horaire horairePlusTard = new Horaire(Integer.parseInt(heurePlusTard),
                                    Integer.parseInt(minutePlusTard));

                            if (postionNom.equals("bizerte")) {
                                int indexPosition = 0;
                                Position position1 = new Position(indexPosition, postionNom, horairePlusTot, horairePlusTard, pickUp, delivery);
                                arrayListPostions.add(position1);
                            }

                            if (postionNom.equals("elalia")) {
                                int indexPosition = 1;
                                Position position1 = new Position(indexPosition, postionNom, horairePlusTot, horairePlusTard, pickUp, delivery);
                                arrayListPostions.add(position1);
                            }

                            if (postionNom.equals("rassjbel")) {
                                int indexPosition = 2;
                                Position position1 = new Position(indexPosition, postionNom, horairePlusTot, horairePlusTard, pickUp, delivery);
                                arrayListPostions.add(position1);
                            }

                            if (postionNom.equals("tunis")) {
                                int indexPosition = 3;
                                Position position1 = new Position(indexPosition, postionNom, horairePlusTot, horairePlusTard, pickUp, delivery);
                                arrayListPostions.add(position1);
                            }

                            if (postionNom.equals("sousse")) {
                                int indexPosition = 4;
                                Position position1 = new Position(indexPosition, postionNom, horairePlusTot, horairePlusTard, pickUp, delivery);
                                arrayListPostions.add(position1);
                            }

                            if (postionNom.equals("nabeul")) {
                                int indexPosition = 5;
                                Position position1 = new Position(indexPosition, postionNom, horairePlusTot, horairePlusTard, pickUp, delivery);
                                arrayListPostions.add(position1);
                            }

                            if (postionNom.equals("sfax")) {
                                int indexPosition = 6;
                                Position position1 = new Position(indexPosition, postionNom, horairePlusTot, horairePlusTard, pickUp, delivery);
                                arrayListPostions.add(position1);
                            }

                            itinéraire = "";
                        } else {
                            String position = itinéraire.substring(0, index_);
                            int indexSlach = position.indexOf("/");
                            String postionNom = position.substring(0, indexSlach);
                            position = position.substring(indexSlach + 1, position.length());
                            indexSlach = position.indexOf("/");
                            String heurePlusTot = position.substring(0, indexSlach);
                            position = position.substring(indexSlach + 1, position.length());
                            indexSlach = position.indexOf("/");
                            String minutePlusTot = position.substring(0, indexSlach);
                            position = position.substring(indexSlach + 1, position.length());
                            indexSlach = position.indexOf("/");
                            String heurePlusTard = position.substring(0, indexSlach);
                            position = position.substring(indexSlach + 1, position.length());
                            indexSlach = position.indexOf("/");
                            String minutePlusTard = position.substring(0, indexSlach);
                            position = position.substring(indexSlach + 1, position.length());
                            indexSlach = position.indexOf("/");
                            String pickUp = position.substring(0, indexSlach);
                            position = position.substring(indexSlach + 1, position.length());
                            String delivery = position;

                            Horaire horairePlusTot = new Horaire(Integer.parseInt(heurePlusTot),
                                    Integer.parseInt(minutePlusTot));
                            Horaire horairePlusTard = new Horaire(Integer.parseInt(heurePlusTard),
                                    Integer.parseInt(minutePlusTard));

                            if (postionNom.equals("bizerte")) {
                                int indexPosition = 0;
                                Position position1 = new Position(indexPosition, postionNom, horairePlusTot, horairePlusTard, pickUp, delivery);
                                arrayListPostions.add(position1);
                            }

                            if (postionNom.equals("elalia")) {
                                int indexPosition = 1;
                                Position position1 = new Position(indexPosition, postionNom, horairePlusTot, horairePlusTard, pickUp, delivery);
                                arrayListPostions.add(position1);
                            }

                            if (postionNom.equals("rassjbel")) {
                                int indexPosition = 2;
                                Position position1 = new Position(indexPosition, postionNom, horairePlusTot, horairePlusTard, pickUp, delivery);
                                arrayListPostions.add(position1);
                            }

                            if (postionNom.equals("tunis")) {
                                int indexPosition = 3;
                                Position position1 = new Position(indexPosition, postionNom, horairePlusTot, horairePlusTard, pickUp, delivery);
                                arrayListPostions.add(position1);
                            }

                            if (postionNom.equals("sousse")) {
                                int indexPosition = 4;
                                Position position1 = new Position(indexPosition, postionNom, horairePlusTot, horairePlusTard, pickUp, delivery);
                                arrayListPostions.add(position1);
                            }

                            if (postionNom.equals("nabeul")) {
                                int indexPosition = 5;
                                Position position1 = new Position(indexPosition, postionNom, horairePlusTot, horairePlusTard, pickUp, delivery);
                                arrayListPostions.add(position1);
                            }

                            if (postionNom.equals("sfax")) {
                                int indexPosition = 6;
                                Position position1 = new Position(indexPosition, postionNom, horairePlusTot, horairePlusTard, pickUp, delivery);
                                arrayListPostions.add(position1);
                            }

                            itinéraire = itinéraire.substring(index_ + 1, itinéraire.length());
                        }

                    }

                    Itenerary itenerary = new Itenerary(arrayListPostions);

                    Demand demand = new Demand(idrequêtedemande, itenerary, nombredeplaces, montant, état);
                    listOfDemands.add(demand);
                }
                numline++;
            }
        } catch (Exception e) {
            LOGGER.info("Error Exception");
        }
        return listOfDemands;

    }


    /*fonction qui s'occupe de la lecture du mémoire des organisations à partir du organizations.txt et créé la liste
* des organizations */
}
