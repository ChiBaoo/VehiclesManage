/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Car extends Vehicle{
    String type;
    int yearMade;

    public Car() {
    }

    public Car(int vType, String id, String name, String color, double price, String brand, String type, int yearMade) {
        super(vType, id, name, color, price, brand);
        this.type = type;
        this.yearMade = yearMade;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYearMade() {
        return yearMade;
    }

    public void setYearMade(int yearMade) {
        this.yearMade = yearMade;
    }

    @Override
    public String toString() {
        return vType + "," + id + "," + name + "," + color + ","
                + price + "," + brand + "," + type + "," + yearMade;
    }
    
}
