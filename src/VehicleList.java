
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class VehicleList extends ArrayList<Vehicle>{
    Scanner sc= new Scanner(System.in); 
    public VehicleList(){
        super();
    }
    //add vehicles from a text file
   public void AddFromFile (String fName){
        try{
            File f=new File(fName); // checking the file
            if (!f.exists()) return;
            FileReader fr=new FileReader(f); // read đọc các ký tự từ file
            BufferedReader bf=new BufferedReader(fr); // readline
            String details;
            while((details= bf.readLine())!=null){ // đọc các dữ liệu theo dòng
                 StringTokenizer stk=new StringTokenizer(details,", ");
                 int vType=Integer.parseInt(stk.nextToken());
                 String id=stk.nextToken();
                 String name=stk.nextToken();
                 String color=stk.nextToken();
                 double price=Double.parseDouble(stk.nextToken());
                 String brand=stk.nextToken();
                 if(vType==1){
                     String type=stk.nextToken();
                     int yearMade=Integer.parseInt(stk.nextToken());
                     Vehicle veh=new Car(vType, id, name, color, price, brand, type, yearMade);
                     this.add(veh);
                 }
                 else if(vType==2){
                     int maxSpeed=Integer.parseInt(stk.nextToken());
                     String license=stk.nextToken();
                     Vehicle veh;
                     if(license.compareToIgnoreCase("true")==0)
                         veh=new Motorbike(vType, id, name, color, price, brand, maxSpeed, true);
                     else
                         veh=new Motorbike(vType, id, name, color, price, brand, maxSpeed, false);
                     this.add(veh);
                 }
            }
            bf.close(); fr.close();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Invalid");
        }
    }
    //save to file
    public void saveToFile(String fName){
        if(this.size()==0){
            System.out.println("Empty List");
            return;
        }
        try{
            File f=new File(fName);
            FileWriter fw=new FileWriter(f); //write
            PrintWriter pw=new PrintWriter(fw); //print
            for (Vehicle x : this) {
                if(x.getvType()==1){
                    Car y=(Car)x;
                    pw.println(x.getvType() + ", " + x.getId() + ", "
                            + x.getName() + ", " + x.getColor() + ", " + x.getPrice()
                            + ", " + x.getBrand() + ", " + y.getType() + ", " + y.getYearMade());
                }
                else{
                    Motorbike y=(Motorbike)x;
                    pw.println(x.getvType() + ", " + x.getId() + ", "
                            + x.getName() + ", " + x.getColor() + ", " + x.getPrice()
                            + ", " + x.getBrand() + ", " + y.getMaxSpeed() + ", " + y.isLicense());
                }
            }
            pw.close();
            fw.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    //search by id
    Vehicle searchID (String id){
        System.out.println("Id searching result:");
        for (Vehicle x : this) {
            if(x.getId().equalsIgnoreCase(id))
                return x;
        }
        return null;
    }
    //find a vehicle id
    private int find (String id){
        for (int i = 0; i < this.size(); i++) 
            if(this.get(i).getId().equals(id)) return i;
            return -1;
    }
    //print by name
    void searchByName(String name){
        try{
            for (Vehicle x : this) {
            if(x.getName().equalsIgnoreCase(name))
                System.out.println(x);
        }
        }catch(Exception e){
            System.out.println("khum tim thay");
        }
    }
    //add a vehicle
    public Vehicle addVehicle() {
        String newId, newName, newColor, newBrand, newType;
        int vType, pos, newYearMade, newMaxSpeed;
        double newPrice;
        boolean isLicense, flag=false;
        System.out.println("Enter New Vehicle Details:");
            vType=Inputter.inputInteger("1 for Car, 2 for Motorbike:", 1 , 2);
            do{
                newId=Inputter.inputString("Enter vehicle id(I000):", "I[0-9]{3}");
                pos=find(newId);
                if(pos>=0) System.out.println("ID is duplicated");
            }while(pos>=0);
            newName=Inputter.inputString("Input new name:", "^[a-zA-Z]+$");
            newColor=Inputter.inputString("Input new color:", "^[a-zA-Z]+$");
            newPrice=Inputter.inputRealNum("Input new price:", 0, 999999999);
            newBrand=Inputter.inputString("Input new brand:", "^[a-zA-Z]+$");
            if(vType==1){
                newType=Inputter.inputString("Input new type:", "^[a-zA-Z]+$");
                newYearMade=Inputter.inputInteger("Input new year made", 1886, 2022);
                Vehicle newVeh = new Car(vType, newId, newName, newColor, newPrice, newBrand, newType, newYearMade);
                return newVeh;
            }
            else{
                newMaxSpeed=Inputter.inputInteger("Input new max speed", 0, 400);
                isLicense=Inputter.confirmYesNo("Require license (Y or N):");
                Vehicle newVeh = new Motorbike(vType, newId, newName, newColor, newPrice, newBrand, newMaxSpeed, isLicense);
                return newVeh;
            }
    }
    // add vehicle to the list
    public Vehicle Addtolist(){
        Vehicle Vh= addVehicle();
        this.add(Vh);
        return Vh;
    }
    Vehicle removeId(){
        String id=Inputter.inputString("Input id", "^I[0-9]{3}$");
        Vehicle x = new Vehicle();
        x=searchID(id);
        if(x!=null){
            boolean confirm=Inputter.confirmYesNo("Remove the ID ?(Y/N):");
            if(confirm==false){ 
                System.out.println("Remove cancel");
                return null;
            }
            else{
            this.remove(x);
            System.out.println("The Vehicle: " + id + " has been removed");
            return x;
            }
        }
        else
            System.out.println("This code does not exist!");
            return null;
    }
    /// Update vihecles
    public Vehicle updateVehicle(){
        String idTmp = Inputter.inputString("Enter ID you want to modify: ", "^I[0-9]{3}$");
        int pos = find(idTmp);
        System.out.println("Old ID: "+this.get(pos).getId());
        Vehicle veh = null;
        if(pos < 0) System.out.println("This ID does not exist.");
        else{
            this.get(pos).setId("\0"); // RESET VEHICLE ID BACK TO NULL
           // System.out.println("ID = " + this.get(pos).getId());
            veh = this.set(pos, addVehicle());
        } 
        return veh;
    }
    //print all vehicles
    void printAll(){
        if(this.isEmpty()) System.out.println("Empty list");
        else{
            for (Vehicle x : this) {
                System.out.println(x);
            }
        }
    }
    //print by descending
    void printAllDescending(){
        if(this.isEmpty()) System.out.println("Empty list");
        else{
            Collections.sort(this);
            for (Vehicle x : this) {
                System.out.println(x);
            }
        }
    }
}
