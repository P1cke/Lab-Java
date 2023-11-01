package Lab1.Bildings.impl;

import Lab1.Interfaces.Floor;
import Lab1.Interfaces.Space;
import Lab1.Interfaces.Buildings;

public class Dwelling implements Buildings {
    private Floor[] floors;

    public Dwelling(int floorCount, int[] flatCounts) {
        floors = new Floor[floorCount];
        for (int i = 0; i < floorCount; i++) {
            floors[i] = new DwellingFloor(flatCounts[i]);
        }
    }

    public Dwelling(Floor[] floors) {
        this.floors = floors;
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

    public void setFloor(int index, Floor newDwellingFloor) {
        if (index >= 0 && index < floors.length) {
            floors[index] = newDwellingFloor;
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

    public void setFlat(int index, Space newSpace) {
        for (Floor floor : floors) {
            if (index >= 0 && index < floor.getTotalFlats()) {
                floor.setFlat(index, newSpace);
                return;
            } else {
                index -= floor.getTotalFlats();
            }
        }
    }

    public void addFlat(int index, Space newSpace) {
        for (Floor floor : floors) {
            if (index >= 0 && index <= floor.getTotalFlats()) {
                floor.addFlat(index, newSpace);
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
        Space bestFlat = null;
        int maxSquare = 0;
        for (Floor floor : floors) {
            Space flat = floor.getBestSquare();
            if (flat != null && flat.getSquare() > maxSquare) {
                bestFlat = flat;
                maxSquare = flat.getSquare();
            }
        }
        return bestFlat;
    }

    public Space[] getSortSpacesBySquare(int order) {
        Space[] allFlats = new Flat[getTotalFlats()];
        int flatIndex = 0;
        for (Floor floor : floors) {
            for (int i = 0; i < floor.getTotalFlats(); i++) {
                allFlats[flatIndex++] = floor.getFlat(i);
            }
        }

        for (int i = 0; i < allFlats.length - 1; i++) {
            for (int j = 0; j < allFlats.length - i - 1; j++) {
                if (order * allFlats[j].getSquare() > order * allFlats[j + 1].getSquare()) {
                    Flat temp = (Flat) allFlats[j];
                    allFlats[j] = allFlats[j + 1];
                    allFlats[j + 1] = temp;
                }
            }
        }
        return allFlats;
    }
}
