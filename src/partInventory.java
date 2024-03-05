package src;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class partInventory{
    // declare the fields for storing parts inventory and prices 
    private HashMap<Integer, String> numbersAndDescs = new HashMap<Integer, String>();
    private HashMap<Integer, Float> prices = new HashMap<Integer, Float>();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private transactionHistory history = new transactionHistory();

    // method to add a part to the part inventory
    public void addPart()throws Exception{
        // ask the user for the part number and the part description
        System.out.print("Enter the Part Number: ");
        int partNumber = 0;
        
        try{
            partNumber = Integer.parseInt(reader.readLine());
        }catch(Exception e){
            System.out.println("Transaction with error recorded and ceased.");
            history.addHistory(0, "Adding part number", 0, "Invalid input for part number");
            return;
        }

        System.out.print("Enter the Part Description: ");
        String desc = reader.readLine();
        this.numbersAndDescs.put(partNumber, desc);
        
        // ask the user for the part price
        System.out.print("Enter the Part Price: ");
        float partPrice = 0.0f;
        try{
            partPrice = Float.parseFloat(reader.readLine());
        }catch(Exception e){
            System.out.println("Transaction with error recorded and ceased.");
            history.addHistory(partNumber, "Adding part price", 0, "Invalid input for part price");
            return;
        }
        this.prices.put(partNumber, partPrice);
        

         //this sequence of printing is used to print the overview of adding a part number        
        System.out.println();
        System.out.println("Added to the Parts Inventory: ");
        System.out.println("Part Number: " + partNumber);
        System.out.println("Part Description: " + numbersAndDescs.get(partNumber));
        System.out.println("Part Price: " + prices.get(partNumber));
        System.out.println("Transaction without error recorded.");
        history.addHistory(partNumber, numbersAndDescs.get(partNumber), prices.get(partNumber), "No Error");
        
    }

    // method that prints information of a part that is selected by the user
    public void accessParts()throws Exception{
        System.out.print("Enter the Part Number of the part that you wanted to see: ");
        int partNumber = Integer.parseInt(reader.readLine());

        System.out.println("The part that has the Part Number: "+partNumber);
        System.out.println("Part Description: "+numbersAndDescs.get(partNumber));
        System.out.println("Part Price: "+prices.get(partNumber));
        System.out.println();
    }


    public void updateParts()throws Exception{
        System.out.print("Enter the part number of the part you want to update: ");
        int partNumber = 0;
        try{
            partNumber = Integer.parseInt(reader.readLine());
        }catch(Exception e){
            System.out.println("Transaction with error recorded and ceased.");
            history.addHistory(0, "Picking a part number to update", 0, "Invalid input for part number");
            return;
        }

        System.out.print("Enter the updated Description for the part: ");
        String newDescription = reader.readLine();

        System.out.print("Enter updated price for the part: ");
        float newPrice = 0.0f;
        try{
            newPrice = Float.parseFloat(reader.readLine());
        }catch(Exception e){
            System.out.println("Transaction with error recorded and ceased.");
            history.addHistory(partNumber, "Picking a part price to update", 0, "Invalid input for part price");
            return;
        }

        //this sequence of printing is used to print the overview of updating a part
        System.out.println("Here's the updated Description and Price for part number " + partNumber);
        System.out.println("Old Description: " + numbersAndDescs.get(partNumber));
        System.out.println("Part Number " + partNumber);
        numbersAndDescs.remove(partNumber);
        numbersAndDescs.put(partNumber, newDescription);
        System.out.println("New Description: " + numbersAndDescs.get(partNumber));
        System.out.println();
        System.out.println("Old Price " + prices.get(partNumber));
        System.out.println("Part Number " + partNumber);
        prices.remove(partNumber);
        prices.put(partNumber, newPrice);
        System.out.println("New Price: " + prices.get(partNumber));
        System.out.println("Transaction without error recorded.");
        history.addHistory(partNumber, numbersAndDescs.get(partNumber), prices.get(partNumber), "No Error");
        System.out.println();
        
    }

    //this method will delete the part from the list
    public void deletePart()throws Exception{
        System.out.print("Enter the part number you want to delete: ");
        int partNumber = Integer.parseInt(reader.readLine());
        if(numbersAndDescs.containsKey(partNumber) && prices.containsKey(partNumber)){
            numbersAndDescs.remove(partNumber);
            prices.remove(partNumber);
            System.out.println("Deleted part from the inventory " + partNumber);
            history.addHistory(partNumber, "Picking a part number to delete", 0, "No Error");
        }else{
            System.out.println("Transaction with error recorded and ceased.");
            history.addHistory(0, "Picking a part number to delete", 0, "Invalid input for part number");
            
        }
    }

    //this will print all the history transactions
    public void printLog(){
        history.printHistory();
    }

    public void inputError(){
        System.out.println("Transaction with error recorded.");
        history.addHistory(0, "Wrong input for transaction", 0, "Wrong input for transaction");
    }
}