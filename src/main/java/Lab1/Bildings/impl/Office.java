package Lab1.Bildings.impl;

import Lab1.Bildings.AbstractSpace;
import Lab1.Interfaces.Space;

class Office extends AbstractSpace implements Space {

    public Office() {
        super();
    }

    public Office(int square) {
        super(square);
    }

    public Office(int square, int quantity) {
        super(square, quantity);
    }
}
