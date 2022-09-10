import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Inputter {
    //the method is used to input a positive integer number
    //integer number
    public static int inputInteger(String message, int min, int max){
        String str="";
        boolean check=true;
        int result=0;
        do{
            try{
                Scanner sc=new Scanner(System.in);
                System.out.println(message);
                str=sc.nextLine();
                if(str.matches("[0-9]+$")){
                int i = Integer.parseInt(str);
                    if(i<min || i>max) throw new Exception();
                    else
                        result=i;
                        check=false;
        }
        else;
            }catch(Exception e){
                System.out.println("Invalid input");
            }
        }while(check);
        return result;
    }
    //the method is used to input a String 
    //matches a pattern string
    public static String inputString(String message, String pattern){
        String s="";
        boolean check=true;
        do{
            try{
                Scanner sc=new Scanner(System.in);
                System.out.println(message);
                s=sc.nextLine();
                if(!s.matches(pattern)) throw new Exception();
                check=false;
            }catch(Exception e){
                System.out.println("Invalid");
            }
        }while(check);
        return s;
    }
    //the method is used to input real number
    public static double inputRealNum(String message, double min, double max){
        String str="";
        double result=0;
        boolean check=true;
        do{
            try{
                Scanner sc=new Scanner(System.in);
        System.out.println(message);
        str=sc.nextLine();
        if(str.matches("[0-9]+[.]?[0-9]+$")){
            double i = Double.parseDouble(str);
            if(i<min || i>max) throw new Exception();
            else
                result=i;
                check=false;
        }
        else throw new Exception();
            }catch(Exception e){
                System.out.println("Invalid input");
            }
        }while(check);
        return result;
        
    }
    static boolean confirmYesNo(String check) {
        boolean result = false;
        String confirm = Inputter.inputString(check,"^[Y|N|y|n]$");
        if ("Y".equalsIgnoreCase(confirm)) {
            result = true;
        }
        return result;
    }
}

