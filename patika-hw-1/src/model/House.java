package model;

import java.math.BigDecimal;

public class House extends Building{
    public House(BigDecimal price, Double squareMeter, String roomNumber) {
        super(price, squareMeter, roomNumber);
    }
}
