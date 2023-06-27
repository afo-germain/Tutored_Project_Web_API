package com.example.Web_API;

/**
 * Created by idriss on 08/05/2016.
 */
public class Position {

    public int indexPosition;

    public int getIndexPosition() {
        return indexPosition;
    }

    public void setIndexPosition(int indexPosition) {
        this.indexPosition = indexPosition;
    }

    public String nomPosition;
    public Horaire datePlusTot;
    public Horaire datePlusTard;
    public String pickUp;
    public String delivery;

    public String getNomPosition() {
        return nomPosition;
    }

    public void setNomPosition(String nomPosition) {
        this.nomPosition = nomPosition;
    }

    public Horaire getDatePlusTot() {
        return datePlusTot;
    }

    public void setDatePlusTot(Horaire datePlusTot) {
        this.datePlusTot = datePlusTot;
    }

    public Horaire getDatePlusTard() {
        return datePlusTard;
    }

    public void setDatePlusTard(Horaire datePlusTard) {
        this.datePlusTard = datePlusTard;
    }

    public String getPickUp() {
        return pickUp;
    }

    public void setPickUp(String pickUp) {
        this.pickUp = pickUp;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public Position(int indexPosition, String nomPosition, Horaire datePlusTot, Horaire datePlusTard, String pickUp, String delivery) {
        this.indexPosition = indexPosition;
        this.nomPosition = nomPosition;
        this.datePlusTot = datePlusTot;
        this.datePlusTard = datePlusTard;
        this.pickUp = pickUp;
        this.delivery = delivery;
    }

    @Override
    public String toString() {
        return "Position{" + "indexPosition=" + indexPosition + ", nomPosition=" + nomPosition + ", datePlusTot=" + datePlusTot + ", datePlusTard=" + datePlusTard + ", pickUp=" + pickUp + ", delivery=" + delivery + '}';
    }
}
