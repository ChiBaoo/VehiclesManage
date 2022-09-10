import java.util.ArrayList;
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
public class Menu {
     public static int inputOptionInMenu(String[] options) {
        for(int i=0;i<=options.length-1;i++){
            System.out.println((i+1)+"-"+options[i]);
        }
        int choice=0;
        boolean flag=true;
        do{
            try{
            Scanner sc=new Scanner(System.in);
            System.out.print("input option:");
            choice=sc.nextInt();
            if(choice<=0) throw new Exception();
            flag=false;
            }catch(Exception e){
                System.out.println("Invalid input");
            }
        } while(flag);
            return choice;
    }
}

