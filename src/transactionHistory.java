package src;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class transactionHistory{
    //class fields
    private ArrayList<Integer> partNumbers;
    private ArrayList<String> partDescs;
    private ArrayList<Float> partPrices;
    private ArrayList<String> partError;
    
    //constructor
    transactionHistory(){
        partNumbers = new ArrayList<Integer>();
        partDescs = new ArrayList<String>();
        partPrices = new ArrayList<Float>();
        partError = new ArrayList<String>();
        
    }

    //this will add the transactions to the history
    public void addHistory(int partNumber, String desc, float price, String err){
        partNumbers.add(partNumber);
        partDescs.add(desc);
        partPrices.add(price);
        partError.add(err);
        
    }

    //this will print the history
    public void printHistory(){
        for(int i = 0; i < partNumbers.size(); i++){
            System.out.println();
            System.out.println("Transaction Number: "+ (i+1));
            System.out.println("Part Number: "+partNumbers.get(i));
            System.out.println("Part Desc: "+partDescs.get(i));
            System.out.println("Part Prices: "+partPrices.get(i));
            System.out.println("Part Error: "+partError.get(i));
            System.out.println();
        }
    }
}
