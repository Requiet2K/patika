package model;

import java.math.BigDecimal;

public class Villa extends Building{
    public Villa(BigDecimal price, Double squareMeter, String roomNumber) {
        super(price, squareMeter, roomNumber);
    }
}
