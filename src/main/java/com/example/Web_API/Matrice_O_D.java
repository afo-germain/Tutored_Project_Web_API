package com.example.Web_API;

import java.util.ArrayList;

/**
 * Created by HASSINE on 08/05/2016.
 */
public class Matrice_O_D {

    public CelluleMatrice[][] generatematrice() {

        CelluleMatrice[][] matriceCellule = new CelluleMatrice[7][7];
        // 0:bizerte
        // 1:elalia
        // 2:rassjbel
        // 3:tunis
        // 4:nabeul
        // 5:sousse
        // 6:sfax

        //initialiser tous les cases du matrice
        ArrayList<Position> arrayListposition = new ArrayList<>();

        Itenerary itineraire = new Itenerary(arrayListposition);
        CelluleMatrice celluleMatrice = new CelluleMatrice("100000", "100000", "100000", itineraire);

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                matriceCellule[i][j] = celluleMatrice;
            }
        }

        // remplir 0_1 : bizerte------>elalia
        ArrayList<Position> arrayListposition0_1 = new ArrayList<>();
        Position position1 = new Position(0, "bizerte", new Horaire(0, 0), new Horaire(0, 0), "", "");
        Position position2 = new Position(1, "elalia", new Horaire(0, 0), new Horaire(0, 0), "", "");
        arrayListposition0_1.add(position1);
        arrayListposition0_1.add(position2);
        Itenerary itineraire0_1 = new Itenerary(arrayListposition0_1);
        CelluleMatrice celluleMatrice0_1 = new CelluleMatrice("1.4", "21", "20", itineraire0_1);
        matriceCellule[0][1] = celluleMatrice0_1;

        // remplir 0_2 : bizerte------>rassjbel
        ArrayList<Position> arrayListposition0_2 = new ArrayList<>();
        Position position3 = new Position(0, "bizerte", new Horaire(0, 0), new Horaire(0, 0), "", "");
        Position position4 = new Position(1, "elalia", new Horaire(0, 0), new Horaire(0, 0), "", "");
        Position position5 = new Position(2, "rassjbel", new Horaire(0, 0), new Horaire(0, 0), "", "");
        arrayListposition0_2.add(position3);
        arrayListposition0_2.add(position4);
        arrayListposition0_2.add(position5);

        Itenerary itineraire0_2 = new Itenerary(arrayListposition0_1);
        CelluleMatrice celluleMatrice0_2 = new CelluleMatrice("2.5", "36", "30", itineraire0_2);
        matriceCellule[0][2] = celluleMatrice0_2;

        // remplir 0_3 : bizerte------>tunis
        ArrayList<Position> arrayListposition0_3 = new ArrayList<>();
        Position position6 = new Position(0, "bizerte", new Horaire(0, 0), new Horaire(0, 0), "", "");
        Position position7 = new Position(3, "tunis", new Horaire(0, 0), new Horaire(0, 0), "", "");
        arrayListposition0_3.add(position6);
        arrayListposition0_3.add(position7);

        Itenerary itineraire0_3 = new Itenerary(arrayListposition0_1);
        CelluleMatrice celluleMatrice0_3 = new CelluleMatrice("4.75", "65", "60", itineraire0_3);
        matriceCellule[0][3] = celluleMatrice0_3;

        // remplir 3_4 : tunis------>sousse
        ArrayList<Position> arrayListposition3_4 = new ArrayList<>();
        Position position8 = new Position(3, "tunis", new Horaire(0, 0), new Horaire(0, 0), "", "");
        Position position9 = new Position(4, "sousse", new Horaire(0, 0), new Horaire(0, 0), "", "");
        arrayListposition3_4.add(position8);
        arrayListposition3_4.add(position9);

        // remplir 1_2 : elalia------>rassjbel
        ArrayList<Position> arrayListposition1_2 = new ArrayList<>();
        Position position10 = new Position(1, "elalia", new Horaire(0, 0), new Horaire(0, 0), "", "");
        Position position11 = new Position(2, "rassjbel", new Horaire(0, 0), new Horaire(0, 0), "", "");
        arrayListposition1_2.add(position10);
        arrayListposition1_2.add(position11);
        Itenerary itineraire1_2 = new Itenerary(arrayListposition1_2);
        CelluleMatrice celluleMatrice1_2 = new CelluleMatrice("0.7", "10", "10", itineraire1_2);
        matriceCellule[1][2] = celluleMatrice1_2;

        Itenerary itineraire3_4 = new Itenerary(arrayListposition3_4);
        CelluleMatrice celluleMatrice3_4 = new CelluleMatrice("7.5", "150", "120", itineraire3_4);
        matriceCellule[3][4] = celluleMatrice3_4;
        return matriceCellule;

    }
}
