
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class ProgramMng {
    public static void main(String[] args) {
        String fName = "vehicles.txt";
        VehicleList VehList=new VehicleList();
        Scanner sc=new Scanner(System.in);
        String[] options={  "Add new Vehicle",
                            "Update Vehicle",
                            "Delete Vehicle",
                            "Search Vehicle (2 options)",
                            "Print the list (2 options)",
                            "Save data",
                            "Quit"
                          };
       
        String[] options3={ "Search by name (Descending price)",
                            "Search by id",
                            "Quit"
                            };
        String[] options4={"Show all",
                            "Show all (Descending by price)",
                            "Quit"
                            };
        int userChoice=0;
        VehList.AddFromFile(fName);
        boolean changed =false;
       do{
            try{
            System.out.println("\n CAR MANAGER");
            userChoice=Menu.inputOptionInMenu(options);
            switch(userChoice){
                case 1: VehList.Addtolist();
                        changed=true;
                        break;
                case 2: VehList.updateVehicle(); 
                        changed=true;
                        break;
                    
                case 3: VehList.removeId();
                        changed=true;
                        break;
                    
                case 4: int Choice2 = 0;
                        do{
                        System.out.println("\n Search Options:");
                        Choice2=Menu.inputOptionInMenu(options3);                        
                        Vehicle veh=null;
                        switch(Choice2){
                            case 1: 
                                    String nameSearch=Inputter.inputString("Input name for search:", "^[a-zA-Z]+$");
                                    VehList.searchByName(nameSearch);
                                    break;
                            case 2: String id=Inputter.inputString("Enter vehicle id(I000):", "^I\\d{3}$");
                                    Vehicle temp=VehList.searchID(id);
                                    System.out.println(temp);
                                    break;
                        }
                        }while(Choice2 >=0 && Choice2<3);
                        break;
                case 5: int Choice3=0;
                        do{
                        System.out.println("\n Print Options");
                        Choice3=Menu.inputOptionInMenu(options4);
                        Vehicle veh=null;
                        switch(Choice3){
                            case 1:VehList.printAll();
                                    break;
                            case 2: VehList.printAllDescending();
                                    break;
                        }
                        }while(Choice3 >0 && Choice3<3);
                        break;
                    
                case 6: VehList.saveToFile(fName);
                        changed=false;

                default:if(changed){
                    System.out.println("Save changes Y/N ?");
                    String response=sc.nextLine().toUpperCase();
                    if(response.startsWith("Y"))
                        VehList.saveToFile(fName);
                }
            }
            }catch(Exception e){
             //e.printStackTrace();
               System.out.println("Invalid input");
            }
        }while(userChoice>0 && userChoice<7);
    }
}
