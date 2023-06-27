package com.example.Web_API;

import java.util.ArrayList;

/**
 * Created by idriss on 08/05/2016.
 */
public class Itenerary {

    public ArrayList<Position> arrayListPositions;

    public ArrayList<Position> getArrayListPositions() {
        return arrayListPositions;
    }

    public void setArrayListPositions(ArrayList<Position> arrayListPositions) {
        this.arrayListPositions = arrayListPositions;
    }

    public Itenerary(ArrayList<Position> arrayListPositions) {
        this.arrayListPositions = arrayListPositions;
    }

    @Override
    public String toString() {
        String result = "Itenerary{";
        for (Position position : arrayListPositions) {
            result += "[" + position + "]";
        }
        result += "}";
        return result;
    }
}
