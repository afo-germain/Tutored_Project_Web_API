package com.example.Web_API;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Created by HASSINE on 08/05/2016.
 */
public class GreedyAlgorithm {

    private final static Logger LOGGER = Logger.getLogger(GreedyAlgorithm.class.getName());
    public ArrayList<Offer> arrayListOffers;
    public ArrayList<Demand> arrayListDemands;
    public ArrayList<Organization> arrayListOrganizations;

    public GreedyAlgorithm(ArrayList<Offer> arrayListOffers, ArrayList<Demand> arrayListDemands, ArrayList<Organization> arrayListOrganizations) {
        this.arrayListOffers = arrayListOffers;
        this.arrayListDemands = arrayListDemands;
        this.arrayListOrganizations = arrayListOrganizations;
    }

    public static Logger getLOGGER() {

        return LOGGER;
    }

    // les fonctions de conversion de temps
    public int convertHoraireToMinutes(Horaire horaire) {
        return horaire.getHeure() * 60 + horaire.getMinute();
    }

    public Horaire convertMinutesToHoraire(int minutes) {
        int heure = minutes / 60;
        int minute = minutes % 60;
        return new Horaire(heure, minute);

    }

    public ArrayList<Offer> getArrayListOffers() {
        return arrayListOffers;
    }

    public void setArrayListOffers(ArrayList<Offer> arrayListOffers) {
        this.arrayListOffers = arrayListOffers;
    }

    public ArrayList<Demand> getArrayListDemands() {
        return arrayListDemands;
    }

    public void setArrayListDemands(ArrayList<Demand> arrayListDemands) {
        this.arrayListDemands = arrayListDemands;
    }

    public ArrayList<Organization> getArrayListOrganizations() {
        return arrayListOrganizations;
    }

    public void setArrayListOrganizations(ArrayList<Organization> arrayListOrganizations) {
        this.arrayListOrganizations = arrayListOrganizations;
    }

    public boolean isInsertedDemand(ArrayList<Position> arrayListPositionDemand, ArrayList<Position> arrayListPositionOrganization, Matrice_O_D matrice_o_d) {
        boolean isInsertedPosition = false;
        CelluleMatrice[][] matriceCellule = matrice_o_d.generatematrice();
        Horaire tempsplustotpos0Demand;
        Horaire tempsplustotpos0Org;
        Horaire tempsplustardpos0Demand;
        Horaire tempsplustardpos0Org;
        Horaire tempsplustotpos1Demand;
        Horaire tempsplustotpos1Org;
        Horaire tempsplustardpos1Demand;
        Horaire tempsplustardpos1Org;

        //cas1 : même origine et même destination et pas de vias pour les deux
        if ((arrayListPositionDemand.get(0).getIndexPosition() == arrayListPositionOrganization.get(0).getIndexPosition())
                && (arrayListPositionDemand.get(arrayListPositionDemand.size() - 1).getIndexPosition() == arrayListPositionOrganization.get(arrayListPositionOrganization.size() - 1).getIndexPosition())
                && (arrayListPositionDemand.size() == arrayListPositionOrganization.size())
                && (arrayListPositionDemand.size() == 2)) {
            //vérification des fenêtres de temps
            //vérification si il y a intersection entre la fenêtre de temps de l'organisation et la fenêtre de temps de la demande
            if ((convertHoraireToMinutes(arrayListPositionOrganization.get(0).getDatePlusTot())
                    >= convertHoraireToMinutes(arrayListPositionDemand.get(0).getDatePlusTot())
                    && convertHoraireToMinutes(arrayListPositionOrganization.get(0).getDatePlusTot())
                    < convertHoraireToMinutes(arrayListPositionDemand.get(0).getDatePlusTard())
                    || (convertHoraireToMinutes(arrayListPositionOrganization.get(0).getDatePlusTard())
                    <= convertHoraireToMinutes(arrayListPositionDemand.get(0).getDatePlusTard())
                    && convertHoraireToMinutes(arrayListPositionOrganization.get(0).getDatePlusTard())
                    > convertHoraireToMinutes(arrayListPositionDemand.get(0).getDatePlusTot())))
                    && ((convertHoraireToMinutes(arrayListPositionOrganization.get(1).getDatePlusTot())
                    >= convertHoraireToMinutes(arrayListPositionDemand.get(1).getDatePlusTot())
                    && convertHoraireToMinutes(arrayListPositionOrganization.get(1).getDatePlusTot())
                    < convertHoraireToMinutes(arrayListPositionDemand.get(1).getDatePlusTard())
                    || (convertHoraireToMinutes(arrayListPositionOrganization.get(1).getDatePlusTard())
                    <= convertHoraireToMinutes(arrayListPositionDemand.get(1).getDatePlusTard())
                    && convertHoraireToMinutes(arrayListPositionOrganization.get(1).getDatePlusTard())
                    > convertHoraireToMinutes(arrayListPositionDemand.get(1).getDatePlusTot()))))) {
                isInsertedPosition = true;

            }

        }
        //cas2 : même origine et destination différente: la destination appartient au vias de l'offre : offre avec vias et demande sans via
        if ((arrayListPositionDemand.get(0).getIndexPosition() == arrayListPositionOrganization.get(0).getIndexPosition())
                && (arrayListPositionDemand.get(arrayListPositionDemand.size() - 1).getIndexPosition()
                != arrayListPositionOrganization.get(arrayListPositionOrganization.size() - 1).getIndexPosition())) {
            for (int i = 0; i < arrayListPositionOrganization.size(); i++) {
                if (arrayListPositionOrganization.get(i).getIndexPosition() == arrayListPositionDemand.get(arrayListPositionDemand.size() - 1).getIndexPosition()) {
                    //vérification fenêtres de temps
                    if ((convertHoraireToMinutes(arrayListPositionOrganization.get(0).getDatePlusTot())
                            >= convertHoraireToMinutes(arrayListPositionDemand.get(0).getDatePlusTot())
                            && convertHoraireToMinutes(arrayListPositionOrganization.get(0).getDatePlusTot())
                            < convertHoraireToMinutes(arrayListPositionDemand.get(0).getDatePlusTard())
                            || (convertHoraireToMinutes(arrayListPositionOrganization.get(0).getDatePlusTard())
                            <= convertHoraireToMinutes(arrayListPositionDemand.get(0).getDatePlusTard())
                            && convertHoraireToMinutes(arrayListPositionOrganization.get(0).getDatePlusTard())
                            > convertHoraireToMinutes(arrayListPositionDemand.get(0).getDatePlusTot())))
                            && ((convertHoraireToMinutes(arrayListPositionOrganization.get(i).getDatePlusTot())
                            >= convertHoraireToMinutes(arrayListPositionDemand.get(arrayListPositionDemand.size() - 1).getDatePlusTot())
                            && convertHoraireToMinutes(arrayListPositionOrganization.get(i).getDatePlusTot())
                            < convertHoraireToMinutes(arrayListPositionDemand.get(arrayListPositionDemand.size() - 1).getDatePlusTard())
                            || (convertHoraireToMinutes(arrayListPositionOrganization.get(i).getDatePlusTard())
                            <= convertHoraireToMinutes(arrayListPositionDemand.get(arrayListPositionDemand.size() - 1).getDatePlusTard())
                            && convertHoraireToMinutes(arrayListPositionOrganization.get(i).getDatePlusTard())
                            > convertHoraireToMinutes(arrayListPositionDemand.get(arrayListPositionDemand.size() - 1).getDatePlusTot()))))) {
                        isInsertedPosition = true;

                    }

                }
            }

        }
        // 3éme cas: même destination et origine différent: l'origine appartient aux via de l'offre : offre avec via et demande sans via
        if ((arrayListPositionDemand.get(0).getIndexPosition() != arrayListPositionOrganization.get(0).getIndexPosition())
                && (arrayListPositionDemand.get(arrayListPositionDemand.size() - 1).getIndexPosition()
                == arrayListPositionOrganization.get(arrayListPositionOrganization.size() - 1).getIndexPosition())) {
            for (int i = 0; i < arrayListPositionOrganization.size(); i++) {
                if (arrayListPositionOrganization.get(i).getIndexPosition() == arrayListPositionDemand.get(0).getIndexPosition()) {
                    //vérification fenêtres de temps
                    if ((convertHoraireToMinutes(arrayListPositionOrganization.get(arrayListPositionOrganization.size() - 1).getDatePlusTot())
                            >= convertHoraireToMinutes(arrayListPositionDemand.get(arrayListPositionDemand.size() - 1).getDatePlusTot())
                            && convertHoraireToMinutes(arrayListPositionOrganization.get(arrayListPositionOrganization.size() - 1).getDatePlusTot())
                            < convertHoraireToMinutes(arrayListPositionDemand.get(arrayListPositionDemand.size() - 1).getDatePlusTard())
                            || (convertHoraireToMinutes(arrayListPositionOrganization.get(arrayListPositionOrganization.size() - 1).getDatePlusTard())
                            <= convertHoraireToMinutes(arrayListPositionDemand.get(arrayListPositionDemand.size() - 1).getDatePlusTard())
                            && convertHoraireToMinutes(arrayListPositionOrganization.get(arrayListPositionOrganization.size() - 1).getDatePlusTard())
                            > convertHoraireToMinutes(arrayListPositionDemand.get(arrayListPositionDemand.size() - 1).getDatePlusTot())))
                            && ((convertHoraireToMinutes(arrayListPositionOrganization.get(i).getDatePlusTot())
                            >= convertHoraireToMinutes(arrayListPositionDemand.get(0).getDatePlusTot())
                            && convertHoraireToMinutes(arrayListPositionOrganization.get(i).getDatePlusTot())
                            < convertHoraireToMinutes(arrayListPositionDemand.get(0).getDatePlusTard())
                            || (convertHoraireToMinutes(arrayListPositionOrganization.get(i).getDatePlusTard())
                            <= convertHoraireToMinutes(arrayListPositionDemand.get(0).getDatePlusTard())
                            && convertHoraireToMinutes(arrayListPositionOrganization.get(i).getDatePlusTard())
                            > convertHoraireToMinutes(arrayListPositionDemand.get(0).getDatePlusTot()))))) {
                        isInsertedPosition = true;

                    }

                }
            }

        }
        //4cas offre avec via et demande avec via

        /* //4.1 ont la même origine et la même destination
        if ((arrayListPositionDemand.get(0).getIndexPosition() == arrayListPositionOrganization.get(0).getIndexPosition())
                && (arrayListPositionDemand.get(arrayListPositionDemand.size() - 1).getIndexPosition() ==
                arrayListPositionOrganization.get(arrayListPositionOrganization.size() - 1).getIndexPosition())
                ) {
              for (int i=0; i<arrayListPositionOrganization.size(); i++) {
                  for ( int j=0; j<arrayListPositionDemand.size() ; j++){
                      if (arrayListPositionOrganization.get(i).getIndexPosition() == arrayListPositionDemand.get(j).getIndexPosition()){
                          if ((convertHoraireToMinutes(arrayListPositionOrganization.get(i).getDatePlusTot()) >=
                                  convertHoraireToMinutes(arrayListPositionDemand.get(j).getDatePlusTot()) &&
                                  convertHoraireToMinutes(arrayListPositionOrganization.get(i).getDatePlusTot()) <
                                          convertHoraireToMinutes(arrayListPositionDemand.get(j).getDatePlusTard())
                                  ||
                                  (convertHoraireToMinutes(arrayListPositionOrganization.get(i).getDatePlusTard()) <=
                                          convertHoraireToMinutes(arrayListPositionDemand.get(j).getDatePlusTard()) &&
                                          convertHoraireToMinutes(arrayListPositionOrganization.get(i).getDatePlusTard()) >
                                                  convertHoraireToMinutes(arrayListPositionDemand.get(j).getDatePlusTot())))){
                              isInsertedPosition=true;
                          }

                      }


                  }

              }
        }*/
        //4.2 ont la même origine et la destination de la demande appartient aux vias de l'offre
        /*if ((arrayListPositionDemand.get(0).getIndexPosition() == arrayListPositionOrganization.get(0).getIndexPosition())
                && (arrayListPositionDemand.get(arrayListPositionDemand.size() - 1).getIndexPosition() !=
                arrayListPositionOrganization.get(arrayListPositionOrganization.size() - 1).getIndexPosition())
                ){
            for (int i=0; i<arrayListPositionOrganization.size(); i++) {
                for ( int j=0; j<arrayListPositionDemand.size() ; j++){
                    if (arrayListPositionOrganization.get(i).getIndexPosition() == arrayListPositionDemand.get(j).getIndexPosition()){
                        if ((convertHoraireToMinutes(arrayListPositionOrganization.get(i).getDatePlusTot()) >=
                                convertHoraireToMinutes(arrayListPositionDemand.get(j).getDatePlusTot()) &&
                                convertHoraireToMinutes(arrayListPositionOrganization.get(i).getDatePlusTot()) <
                                        convertHoraireToMinutes(arrayListPositionDemand.get(j).getDatePlusTard())
                                ||
                                (convertHoraireToMinutes(arrayListPositionOrganization.get(i).getDatePlusTard()) <=
                                        convertHoraireToMinutes(arrayListPositionDemand.get(j).getDatePlusTard()) &&
                                        convertHoraireToMinutes(arrayListPositionOrganization.get(i).getDatePlusTard()) >
                                                convertHoraireToMinutes(arrayListPositionDemand.get(j).getDatePlusTot())))){
                            isInsertedPosition=true;
                        }

                    }


                }

            }

        }*/
        //4.3 ont la même destination et l'origine de la demande appartient aux vias de l'offre
        /* if ((arrayListPositionDemand.get(0).getIndexPosition() != arrayListPositionOrganization.get(0).getIndexPosition())
                && (arrayListPositionDemand.get(arrayListPositionDemand.size() - 1).getIndexPosition() ==
                arrayListPositionOrganization.get(arrayListPositionOrganization.size() - 1).getIndexPosition())
                ){
            for (int i=0; i<arrayListPositionOrganization.size(); i++) {
                for ( int j=0; j<arrayListPositionDemand.size() ; j++){
                    if (arrayListPositionOrganization.get(i).getIndexPosition() == arrayListPositionDemand.get(j).getIndexPosition()){
                        if ((convertHoraireToMinutes(arrayListPositionOrganization.get(i).getDatePlusTot()) >=
                                convertHoraireToMinutes(arrayListPositionDemand.get(j).getDatePlusTot()) &&
                                convertHoraireToMinutes(arrayListPositionOrganization.get(i).getDatePlusTot()) <
                                        convertHoraireToMinutes(arrayListPositionDemand.get(j).getDatePlusTard())
                                ||
                                (convertHoraireToMinutes(arrayListPositionOrganization.get(i).getDatePlusTard()) <=
                                        convertHoraireToMinutes(arrayListPositionDemand.get(j).getDatePlusTard()) &&
                                        convertHoraireToMinutes(arrayListPositionOrganization.get(i).getDatePlusTard()) >
                                                convertHoraireToMinutes(arrayListPositionDemand.get(j).getDatePlusTot())))){
                            isInsertedPosition=true;
                        }

                    }


                }

            }

        }*/
        //4.4 l'origine et la destination de la demande appartiennent aux vias de l'offre
        /* if ((arrayListPositionDemand.get(0).getIndexPosition() != arrayListPositionOrganization.get(0).getIndexPosition())
                && (arrayListPositionDemand.get(arrayListPositionDemand.size() - 1).getIndexPosition() !=
                arrayListPositionOrganization.get(arrayListPositionOrganization.size() - 1).getIndexPosition())
                ){
            for (int i=0; i<arrayListPositionOrganization.size(); i++) {
                for ( int j=0; j<arrayListPositionDemand.size() ; j++){
                    if (arrayListPositionOrganization.get(i).getIndexPosition() == arrayListPositionDemand.get(j).getIndexPosition()){
                        if ((convertHoraireToMinutes(arrayListPositionOrganization.get(i).getDatePlusTot()) >=
                                convertHoraireToMinutes(arrayListPositionDemand.get(j).getDatePlusTot()) &&
                                convertHoraireToMinutes(arrayListPositionOrganization.get(i).getDatePlusTot()) <
                                        convertHoraireToMinutes(arrayListPositionDemand.get(j).getDatePlusTard())
                                ||
                                (convertHoraireToMinutes(arrayListPositionOrganization.get(i).getDatePlusTard()) <=
                                        convertHoraireToMinutes(arrayListPositionDemand.get(j).getDatePlusTard()) &&
                                        convertHoraireToMinutes(arrayListPositionOrganization.get(i).getDatePlusTard()) >
                                                convertHoraireToMinutes(arrayListPositionDemand.get(j).getDatePlusTot())))){
                            isInsertedPosition=true;
                        }

                    }


                }

            }

        }*/
        return isInsertedPosition;
    }

    public ArrayList<Organization> generateListOrganization(ArrayList<Offer> arrayListOffers, ArrayList<Demand> arrayListDemands, Matrice_O_D matrice_o_d) {

        ArrayList<Organization> arrayList_Organization = new ArrayList<>();
        int indexOrg = 0;
        // initialisation de l'organisation à partir de la liste des offres
        for (int i = 0; i < arrayListOffers.size(); i++) {
            String idorg = String.valueOf(indexOrg);
            Itenerary itinéraire = arrayListOffers.get(i).getItinéraire();
            String idoffre = arrayListOffers.get(i).getId_requêtes();
            String iddemandes = "";
            String état = "valide";
            String placesoccupées = String.valueOf(0);
            String placeslibres = String.valueOf(arrayListOffers.get(i).getPlaces_libres_iniales());
            Organization organization = new Organization(idorg, itinéraire, idoffre, iddemandes, état, placesoccupées, placeslibres);
            arrayList_Organization.add(organization);

        }
        //remplir la liste des organisation à travers la liste des demandes disponibles
        for (int i = 0; i < arrayList_Organization.size(); i++) {

            Organization organizationCourante = arrayList_Organization.get(i);
            if (!organizationCourante.getÉtat().equals("Contractualise")) {
                Itenerary itineraryOrganization = organizationCourante.getItinéraire();
                ArrayList<Position> arrayListPositionItineraryOrganization = itineraryOrganization.getArrayListPositions();
                int indexPositionItineraryOrganization = 0;

                for (int j = 0; j < arrayListDemands.size(); j++) {
                    Position positionCourante = arrayListPositionItineraryOrganization.get(indexPositionItineraryOrganization);
                    Demand demandCourante = arrayListDemands.get(j);
                    if (demandCourante.getÉtat().equals("contractualise")) {
                        continue;
                    }
                    Itenerary itineraryDemandcourante = demandCourante.getItinéraire();
                    ArrayList<Position> arrayListPositionItineraryDemand = itineraryDemandcourante.getArrayListPositions();
                    if (Integer.parseInt(organizationCourante.getPlacesoccupées()) + Integer.parseInt(demandCourante.getNombredeplaces()) > 8) {
                        continue;
                    }

                    boolean isinsertedPosition = isInsertedDemand(arrayListPositionItineraryDemand, arrayListPositionItineraryOrganization, matrice_o_d);
                    if (isinsertedPosition == true) {
                        organizationCourante.setIddemandes(organizationCourante.getIddemandes() + ',' + demandCourante.getIdrequêtedemande());
                        int newNombrePlaceOccupe = Integer.parseInt(organizationCourante.getPlacesoccupées())
                                + Integer.parseInt(demandCourante.getNombredeplaces());
                        organizationCourante.setPlacesoccupées(String.valueOf(newNombrePlaceOccupe));
                        int newNombrePlaceLibre = Integer.parseInt(organizationCourante.getPlaceslibres()) - Integer.parseInt(demandCourante.getNombredeplaces());
                        organizationCourante.setPlaceslibres(String.valueOf(newNombrePlaceLibre));
                        demandCourante.setÉtat("contractualise");
                        organizationCourante.setÉtat("partiellementContractualise");
                        if (organizationCourante.getPlacesoccupées().equals(String.valueOf(8))) {
                            organizationCourante.setÉtat("Contractualise");
                        }
                    } else if (isinsertedPosition == false) {
                        continue;

                    }

                }

            }
            indexOrg++;

        }
        return arrayList_Organization;
    }
}
