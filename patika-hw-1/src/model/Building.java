package model;

import java.math.BigDecimal;

public class Building {

    private BigDecimal price;
    private Double squareMeter;
    // for usage purpose of "3+1", meaning 3 rooms and 1 living room
    private String roomNumber;

    public Building(BigDecimal price, Double squareMeter, String roomNumber) {
        this.price = price;
        this.squareMeter = squareMeter;
        this.roomNumber = roomNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getSquareMeter() {
        return squareMeter;
    }

    public void setSquareMeter(Double squareMeter) {
        this.squareMeter = squareMeter;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Building{" +
                "price=" + price +
                ", squareMeter=" + squareMeter +
                ", roomNumber='" + roomNumber + '\'' +
                '}';
    }
}
