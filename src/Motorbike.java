/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Motorbike extends Vehicle implements Tools{
    int maxSpeed;
    boolean license;

    public Motorbike() {
    }

    public Motorbike(int maxSpeed, boolean license) {
        this.maxSpeed = maxSpeed;
        this.license = license;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public boolean isLicense() {
        return license;
    }

    public void setLicense(boolean license) {
        this.license = license;
    }

    public Motorbike(int vType, String id, String name, String color, double price, String brand, int maxSpeed, boolean license) {
        super(vType, id, name, color, price, brand);
        this.maxSpeed = maxSpeed;
        this.license = license;
    }

    @Override
    public String toString() {
        return vType + "," + id + "," + name + ","  + color + "," 
                + price + "," + brand + "," + maxSpeed + "," + license;
    }

    @Override
    public void makeSound() {
        System.out.println("Tin tin tin");
    }
    
}
