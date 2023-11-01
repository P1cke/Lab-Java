package Lab1.Bildings.impl;

import Lab1.Interfaces.Space;
import Lab1.Interfaces.Floor;

public class OfficeFloor implements Floor {
    private Space[] flats;

    public OfficeFloor(int number_Flats) {
        flats = (Space[]) new Flat[number_Flats];
        for (int i = 0; i < number_Flats; i++) {
            flats[i] = (Space) new Flat();
        }
    }

    public OfficeFloor(Flat[] flats) {
        this.flats = (Space[]) flats;
    }

    public int getTotalFlats() {
        return flats.length;
    }

    public int getFlatsSquare() {
        int squares = 0;
        for (Space flat : flats) {
            squares += flat.getSquare();
        }
        return squares;
    }

    public int getFlatsQuantity() {
        int totalQuantity = 0;
        for (Space flat : flats) {
            totalQuantity += flat.getQuantity();
        }
        return totalQuantity;
    }

    public Space[] getFlats() {
        return flats;
    }

    public Space getFlat(int index) {
        return flats[index];
    }

    @Override
    public void setFlat(int index, Space newFlat) {

    }

    @Override
    public void addFlat(int index, Space newFlat) {

    }

    public void setFlat(int index, Flat newFlat) {
        flats[index] = (Space) newFlat;
    }

    public void addFlat(int index, Flat newFlat) {
        Flat[] newFlats = new Flat[flats.length + 1];
        for (int i = 0; i < index; i++) {
            newFlats[i] = (Flat) flats[i];
        }
        newFlats[index] = newFlat;
        for (int i = index; i < flats.length; i++) {
            newFlats[i + 1] = (Flat) flats[i];
        }
        flats = (Space[]) newFlats;
    }

    public void deleteFlat(int index) {
        Flat[] newFlats = new Flat[flats.length - 1];
        for (int i = 0, j = 0; i < flats.length; i++) {
            if (i != index) {
                newFlats[j] = (Flat) flats[i];
                j++;
            }
        }
        flats = (Space[]) newFlats;
    }

    public Space getBestSquare() {
        if (flats.length == 0) {
            return null;
        }
        Flat bigFlat = (Flat) flats[0];
        for (Space flat : flats) {
            if (flat.getSquare() > bigFlat.getSquare()) {
                bigFlat = (Flat) flat;
            }
        }
        return (Space) bigFlat;
    }
}
