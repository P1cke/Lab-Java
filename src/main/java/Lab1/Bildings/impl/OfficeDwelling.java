package Lab1.Bildings.impl;

import Lab1.Bildings.impl.Flat;
import Lab1.Bildings.impl.DwellingFloor;
import Lab1.Interfaces.Buildings;
import Lab1.Interfaces.Floor;
import Lab1.Interfaces.Space;

public class OfficeDwelling implements Buildings {
    private Floor[] floors;

    public OfficeDwelling(int floorCount, int[] flatCounts) {
        floors = new Floor[floorCount];
        for (int i = 0; i < floorCount; i++) {
            floors[i] = new DwellingFloor(flatCounts[i]);
        }
    }

    public int getFloorsQuantity() {
        return floors.length;
    }

    public int getTotalFlats() {
        int totalFlats = 0;
        for (Floor floor : floors) {
            totalFlats += floor.getTotalFlats();
        }
        return totalFlats;
    }

    public int getFlatsSquare() {
        int totalSquare = 0;
        for (Floor floor : floors) {
            totalSquare += floor.getFlatsSquare();
        }
        return totalSquare;
    }

    public int getFlatsQuantity() {
        int totalQuantity = 0;
        for (Floor floor : floors) {
            totalQuantity += floor.getFlatsQuantity();
        }
        return totalQuantity;
    }

    public Floor[] getFloors() {
        return floors;
    }

    public Floor getFloor(int index) {
        if (index >= 0 && index < floors.length) {
            return floors[index];
        }
        return null;
    }

    public void setFloor(int index, Floor newFloor) {
        if (index >= 0 && index < floors.length) {
            floors[index] = newFloor;
        }
    }

    public Space getFlat(int index) {
        for (Floor floor : floors) {
            if (index >= 0 && index < floor.getTotalFlats()) {
                return floor.getFlat(index);
            } else {
                index -= floor.getTotalFlats();
            }
        }
        return null;
    }

    @Override
    public void setFlat(int index, Space newSpace) {

    }

    @Override
    public void addFlat(int index, Space newSpace) {

    }

    public void setFlat(int index, Flat newFlat) {
        for (Floor floor : floors) {
            if (index >= 0 && index < floor.getTotalFlats()) {
                floor.setFlat(index, (Space) newFlat);
                return;
            } else {
                index -= floor.getTotalFlats();
            }
        }
    }

    public void addFlat(int index, Flat newFlat) {
        for (Floor floor : floors) {
            if (index >= 0 && index <= floor.getTotalFlats()) {
                floor.addFlat(index, (Space) newFlat);
                return;
            } else {
                index -= floor.getTotalFlats();
            }
        }
    }

    public void deleteFlat(int index) {
        for (Floor floor : floors) {
            if (index >= 0 && index < floor.getTotalFlats()) {
                floor.deleteFlat(index);
                return;
            } else {
                index -= floor.getTotalFlats();
            }
        }
    }

    public Space getBestSpaceBySquare() {
        Flat bestFlat = null;
        double maxSquare = 0;
        for (Floor floor : floors) {
            Flat flat = (Flat) floor.getBestSquare();
            if (flat != null && flat.getSquare() > maxSquare) {
                bestFlat = flat;
                maxSquare = flat.getSquare();
            }
        }
        return (Space) bestFlat;
    }

    @Override
    public Space[] getSortSpacesBySquare(int order) {
        return new Space[0];
    }

    public Flat[] getSortFlatsBySquare(int order) {
        Flat[] allFlats = new Flat[getTotalFlats()];
        int flatIndex = 0;
        for (Floor floor : floors) {
            for (int i = 0; i < floor.getTotalFlats(); i++) {
                allFlats[flatIndex++] = (Flat) floor.getFlat(i);
            }
        }

        for (int i = 0; i < allFlats.length - 1; i++) {
            for (int j = 0; j < allFlats.length - i - 1; j++) {
                if (order * allFlats[j].getSquare() > order * allFlats[j + 1].getSquare()) {
                    Flat temp = allFlats[j];
                    allFlats[j] = allFlats[j + 1];
                    allFlats[j + 1] = temp;
                }
            }
        }
        return allFlats;
    }
}
