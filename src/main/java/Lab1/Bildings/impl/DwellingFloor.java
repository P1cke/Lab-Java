package Lab1.Bildings.impl;

import Lab1.Interfaces.Floor;
import Lab1.Interfaces.Space;

public class DwellingFloor implements Floor {
    private Space[] flats;

    public DwellingFloor(int number_Flats) {
        flats = new Space[number_Flats];
        for (int i = 0; i < number_Flats; i++) {
            flats[i] = new Flat();
        }
    }

    public DwellingFloor(Flat[] flats) {
        this.flats = flats;
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
        if (index < flats.length) {
            return flats[index];
        }
        return null;
    }

    public void deleteFlat(int index) {
        Space[] newFlats = new Flat[flats.length - 1];
        for (int i = 0, j = 0; i < flats.length; i++) {
            if (i != index) {
                newFlats[j] = flats[i];
                j++;
            }
        }
        flats = newFlats;
    }

    public Space getBestSquare() {
        if (flats.length == 0) {
            return null;
        }
        Space bigFlat = flats[0];
        for (Space flat : flats) {
            if (flat.getSquare() > bigFlat.getSquare()) {
                bigFlat = flat;
            }
        }
        return bigFlat;
    }

    public void setFlat(int index, Space newFlat) {
        if (index < flats.length) {
            flats[index] = newFlat;
        }
    }

    public void addFlat(int index, Space newFlat) {
        Space[] newFlats = new Flat[flats.length + 1];
        for (int i = 0; i < index; i++) {
            newFlats[i] = flats[i];
        }
        newFlats[index] = newFlat;
        for (int i = index; i < flats.length; i++) {
            newFlats[i + 1] = flats[i];
        }
        flats = newFlats;
    }
}


