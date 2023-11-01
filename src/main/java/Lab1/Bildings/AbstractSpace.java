package Lab1.Bildings;

import lombok.Data;

@Data
public class AbstractSpace {

    private static int QUANTITY = 2;
    private static int SQUARE = 50;

    private int square;
    private int quantity;

    public AbstractSpace() {
        quantity = QUANTITY;
        square = SQUARE;
    }

    public AbstractSpace(int square) {
        this.quantity = QUANTITY;
        this.square = square;
    }

    public AbstractSpace(int square, int quantity) {
        this.quantity = quantity;
        this.square = square;
    }
}