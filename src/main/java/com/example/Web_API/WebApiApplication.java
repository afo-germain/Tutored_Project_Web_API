package com.example.Web_API;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author oyoki
 */
@SpringBootApplication
@RestController
public class WebApiApplication {

    public int convertHoraireToMinutes(Horaire horaire) {
        return horaire.getHeure() * 60 + horaire.getMinute();
    }

    public Horaire convertMinutesToHoraire(int minutes) {
        int heure = minutes / 60;
        int minute = minutes % 60;
        return new Horaire(heure, minute);

    }

    public ArrayList<Offer> validateListOffer(ArrayList<Offer> arrayListOffer, Matrice_O_D matrice_o_d) {
        CelluleMatrice[][] matriceCellule = matrice_o_d.generatematrice();
        for (int i = 0; i < arrayListOffer.size(); i++) {
            Offer offer = arrayListOffer.get(i);
            Itenerary itineraire = offer.getItinéraire();
            ArrayList<Position> arrayListPosition = itineraire.getArrayListPositions();
            for (int j = 0; j < arrayListPosition.size() - 1; j++) {
                Horaire horairePlustotPos0 = arrayListPosition.get(j).datePlusTot;
                Horaire horairePlustotPos1 = arrayListPosition.get(j + 1).datePlusTot;
                Horaire horairePlustardPos0 = arrayListPosition.get(j).datePlusTard;
                Horaire horairePlustardPos1 = arrayListPosition.get(j + 1).datePlusTard;
                CelluleMatrice celluleMatrice0_1 = matriceCellule[arrayListPosition.get(j).getIndexPosition()][arrayListPosition.get(j + 1).getIndexPosition()];

                // vérification de validation de temps plus tot
                int horairePlustotPos0Minutes = convertHoraireToMinutes(horairePlustotPos0);
                int horairePlustotPos1Minutes = convertHoraireToMinutes(horairePlustotPos1);
                int horaire0_1Minutes = Integer.parseInt(celluleMatrice0_1.tempsaupluscourt);
                if (horairePlustotPos0Minutes + horaire0_1Minutes > horairePlustotPos1Minutes) {
                    horairePlustotPos1Minutes = horairePlustotPos0Minutes + horaire0_1Minutes;
                    horairePlustotPos1 = convertMinutesToHoraire(horairePlustotPos1Minutes);
                    arrayListPosition.get(j + 1).setDatePlusTot(horairePlustotPos1);

                }

                // vérification de validation de temps plus tard
                int horairePlustardPos0Minutes = convertHoraireToMinutes(horairePlustardPos0);
                int horairePlustardPos1Minutes = convertHoraireToMinutes(horairePlustardPos1);
                if (horairePlustardPos0Minutes + horaire0_1Minutes > horairePlustardPos1Minutes) {
                    horairePlustardPos1Minutes = horairePlustardPos0Minutes + horaire0_1Minutes;
                    horairePlustardPos1 = convertMinutesToHoraire(horairePlustardPos1Minutes);
                    arrayListPosition.get(j + 1).setDatePlusTard(horairePlustardPos1);

                }

            }
        }
        return arrayListOffer;
    }

    public ArrayList<Demand> validateListDemand(ArrayList<Demand> arrayListDemand, Matrice_O_D matrice_o_d) {
        CelluleMatrice[][] matriceCellule = matrice_o_d.generatematrice();
        for (int i = 0; i < arrayListDemand.size(); i++) {
            Demand demand = arrayListDemand.get(i);
            Itenerary itineraire = demand.getItinéraire();
            ArrayList<Position> arrayListPosition = itineraire.getArrayListPositions();
            for (int j = 0; j < arrayListPosition.size() - 1; j++) {
                Horaire horairePlustotPos0 = arrayListPosition.get(j).datePlusTot;
                Horaire horairePlustotPos1 = arrayListPosition.get(j + 1).datePlusTot;
                Horaire horairePlustardPos0 = arrayListPosition.get(j).datePlusTard;
                Horaire horairePlustardPos1 = arrayListPosition.get(j + 1).datePlusTard;
                CelluleMatrice celluleMatrice0_1 = matriceCellule[arrayListPosition.get(j).getIndexPosition()][arrayListPosition.get(j + 1).getIndexPosition()];

                // vérification de validation de temps plus tot
                int horairePlustotPos0Minutes = convertHoraireToMinutes(horairePlustotPos0);
                int horairePlustotPos1Minutes = convertHoraireToMinutes(horairePlustotPos1);
                int horaire0_1Minutes = Integer.parseInt(celluleMatrice0_1.tempsaupluscourt);
                if (horairePlustotPos0Minutes + horaire0_1Minutes > horairePlustotPos1Minutes) {
                    horairePlustotPos1Minutes = horairePlustotPos0Minutes + horaire0_1Minutes;
                    horairePlustotPos1 = convertMinutesToHoraire(horairePlustotPos1Minutes);
                    arrayListPosition.get(j + 1).setDatePlusTot(horairePlustotPos1);

                }

                // vérification de validation de temps plus tard
                int horairePlustardPos0Minutes = convertHoraireToMinutes(horairePlustardPos0);
                int horairePlustardPos1Minutes = convertHoraireToMinutes(horairePlustardPos1);
                if (horairePlustardPos0Minutes + horaire0_1Minutes > horairePlustardPos1Minutes) {
                    horairePlustardPos1Minutes = horairePlustardPos0Minutes + horaire0_1Minutes;
                    horairePlustardPos1 = convertMinutesToHoraire(horairePlustardPos1Minutes);
                    arrayListPosition.get(j + 1).setDatePlusTard(horairePlustardPos1);

                }

            }
        }
        return arrayListDemand;
    }

    
    public static void main(String[] args) throws URISyntaxException {

    /*    Main main1 = new Main();

        URL resource_offers = main1.getClass().getClassLoader().getResource("input/requêtes_offres.txt");
        if (resource_offers == null) {
            throw new IllegalArgumentException("file not found!");
        }

        URL resource_demands = main1.getClass().getClassLoader().getResource("input/requêtes_demandes.txt");
        if (resource_demands == null) {
            throw new IllegalArgumentException("file not found!");
        }

        URL resource_organization = main1.getClass().getClassLoader().getResource("output/organisation.txt");
        if (resource_organization == null) {
            throw new IllegalArgumentException("file not found!");
        }

        File file_offers = new File(resource_offers.toURI());
        File file_demands = new File(resource_demands.toURI());
        File file_organization = new File(resource_organization.toURI());


        GenerateAllLists generateAllLists = new GenerateAllLists();
        ArrayList<Offer> listIntializedOffer = generateAllLists.listOfOffers(file_offers);
        ArrayList<Demand> listIntializedDemand = generateAllLists.listOfDemands(file_demands);

        Matrice_O_D matrice_o_d = new Matrice_O_D();

        ArrayList<Offer> listValidatedOffer = main1.validateListOffer(listIntializedOffer, matrice_o_d);

        ArrayList<Demand> listValidatesDemand = main1.validateListDemand(listIntializedDemand, matrice_o_d);

        ArrayList<Organization> arrayListOrganisation = new ArrayList<>();

        GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm(listValidatedOffer, listValidatesDemand, arrayListOrganisation);
        long debut = System.currentTimeMillis();
        arrayListOrganisation = greedyAlgorithm.generateListOrganization(listValidatedOffer, listValidatesDemand, matrice_o_d);

        for (Organization e : arrayListOrganisation) {
            System.out.println(e.toString());
        }

        System.out.println(System.currentTimeMillis() - debut);*/

        SpringApplication.run(WebApiApplication.class, args);

    }

    @GetMapping("/")
    public @ResponseBody
    String helloWorld() {
        return "<h2 style=\" text-align: center; position: absolute; top: 40%; left: 50%; transform: translate(-50%, -50%) \"> Welcome to the Web API that organises mobility of student in case of Portes du Jura !<h2>";
    }

    @GetMapping(value = "/compute", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String compute() throws URISyntaxException {

        Main main1 = new Main();

        URL resource_offers = main1.getClass().getClassLoader().getResource("input/requêtes_offres.txt");
        if (resource_offers == null) {
            throw new IllegalArgumentException("file not found!");
        }

        URL resource_demands = main1.getClass().getClassLoader().getResource("input/requêtes_demandes.txt");
        if (resource_demands == null) {
            throw new IllegalArgumentException("file not found!");
        }

        /*URL resource_organization = main1.getClass().getClassLoader().getResource("output/organisation.txt");
        if (resource_organization == null) {
            throw new IllegalArgumentException("file not found!");
        }*/

        File file_offers = new File(resource_offers.toURI());
        File file_demands = new File(resource_demands.toURI());
        //File file_organization = new File(resource_organization.toURI());


        /*File file_offers = new File("C:\\Files_Requêtes\\requêtes_offres.txt");
        File file_demands = new File("C:\\Files_Requêtes\\requête_demandes.txt");
        File file_organization = new File("C:\\Files_Requêtes\\organisation.txt");*/
        GenerateAllLists generateAllLists = new GenerateAllLists();
        ArrayList<Offer> listIntializedOffer = generateAllLists.listOfOffers(file_offers);
        ArrayList<Demand> listIntializedDemand = generateAllLists.listOfDemands(file_demands);

        Matrice_O_D matrice_o_d = new Matrice_O_D();

        ArrayList<Offer> listValidatedOffer = main1.validateListOffer(listIntializedOffer, matrice_o_d);

        ArrayList<Demand> listValidatesDemand = main1.validateListDemand(listIntializedDemand, matrice_o_d);

        ArrayList<Organization> arrayListOrganisation = new ArrayList<>();

        GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm(listValidatedOffer, listValidatesDemand, arrayListOrganisation);
        long debut = System.currentTimeMillis();
        arrayListOrganisation = greedyAlgorithm.generateListOrganization(listValidatedOffer, listValidatesDemand, matrice_o_d);

        String result = "";

        result += new Gson().toJson(arrayListOrganisation);
                
        System.out.println(System.currentTimeMillis() - debut);
        return result;
    }
}
