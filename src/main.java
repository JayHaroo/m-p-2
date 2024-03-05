package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class main{
    public static void main(String[] args)throws Exception{
        partInventory inventory = new partInventory();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String choice;

        while(true){
            System.out.println("Choose action:");
            System.out.println("A. Add part");
            System.out.println("B. Change part ");
            System.out.println("C. Delete a part");
            System.out.println("D. Print Transactions");
            System.out.println("E. Access Parts");
            System.out.println("X. Exit");
            System.out.print("Enter choice: ");
            choice = reader.readLine();

            if(choice.length() > 1){
                inventory.inputError();
            }else if(choice.charAt(0) == 'A' || choice.charAt(0) == 'a'){
                inventory.addPart();
                inventory.printLog();
            }else if(choice.charAt(0) == 'B' || choice.charAt(0) == 'b'){
                inventory.updateParts();
                System.out.println();
            }else if(choice.charAt(0) == 'C' || choice.charAt(0) == 'c'){
                inventory.deletePart();
                System.out.println();
            }else if(choice.charAt(0) == 'D' || choice.charAt(0) == 'd'){
                inventory.printLog();
            }else if(choice.charAt(0) == 'E' || choice.charAt(0) == 'e'){
                inventory.accessParts();
                System.out.println();
            }else if(choice.charAt(0) == 'X' || choice.charAt(0) == 'x'){
                break;
            }
        }
    }
}
