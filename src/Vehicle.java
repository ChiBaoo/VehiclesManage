/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Vehicle implements Comparable{
    int vType;
    String id, name, color;
    double price;
    String brand;

    public Vehicle() {
    }

    public int getvType() {
        return vType;
    }

    public void setvType(int vType) {
        this.vType = vType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public Vehicle(int vType, String id, String name, String color, double price, String brand) {
        this.vType = vType;
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return vType + "," + id + "," + name + "," 
                + color + "," + price + "," + brand;
    }

    @Override
    public int compareTo(Object o) {
        if(this.price<((Vehicle)o).price) 
            return 1;
        else if(((Vehicle)o).price<this.price)
            return -1;
        return 0;
    }
    
}
