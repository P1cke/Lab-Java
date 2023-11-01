package Lab1.Bildings.impl;

import Lab1.Bildings.AbstractSpace;
import Lab1.Interfaces.Space;

public class Flat extends AbstractSpace implements Space {

    public Flat() {
        super();
    }

    public Flat(int square) {
        super(square);
    }

    public Flat(int square, int quantity) {
        super(square, quantity);
    }
}

