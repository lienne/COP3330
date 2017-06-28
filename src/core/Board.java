/*
Liana Severo
COP 3330 - Object Oriented Programming
*/

package core;

import static core.IDie.NUMBER_OF_SIDES;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Liana Severo
 */

public class Board implements IBoard {

    // Member variable declarations:
    // Stores dice data
    public static ArrayList<String> diceData;
    // Stores dictionary data
    public static ArrayList<String> dictData;
    // Stores 16 game dice
    public static ArrayList<Die> gameDice;
    // Stores game data
    private static final ArrayList<String> gameData = new ArrayList();

    // Methods (Getters and Setters) for member variables:
    // Getter for diceData
    public ArrayList<String> getDiceData(){
        return diceData;
    }
    // Setter for diceData
    public void setDiceData(ArrayList<String> diceData) {
        Board.diceData = diceData;
    }
    // Getter for dictData
    public ArrayList<String> getDictData() {
        return dictData;
    }
    // Setter for dictData
    public void setDictData(ArrayList<String> dictData) {
        Board.dictData = dictData;
    }
    // Getter for gameDice
    public ArrayList<Die> getGameDice() {
        return gameDice;
    }
    // Setter for gameDice
    public void setGameDice(ArrayList<Die> gameDice) {
        Board.gameDice = gameDice;
    }
    // Getter for gameData
    public static ArrayList<String> getGameData() {
        return gameData;
    }
    
    
    
    
    // Constructor for Board
    public Board(ArrayList<String> boggleData, ArrayList<String> dictionaryData) {
        
        // Set member variable diceData equal to boggleData parameter/argument passed in
        diceData = boggleData;
        
        // Set member variable dictData equal to dictionaryData parameter/argument passed in
        dictData = dictionaryData;
        
        // Instantiate an ArrayList of class Die
        gameDice = new ArrayList<>();
    }
    
    // Methods implemented from IBoard interface
    @Override
    public void populateDice()
    {    
        // Variable called 'die' of type Die
        Die die;
        int counter = 0;
        int i, j;
        
        // Loop through the 16 dice
        for(i = 0; i < NUMBER_OF_DICE; i++)
        {
            // create an instance of class Die, store in variable die, using the default no-arg constructor
            // This will create a new instance for every loop - 16 instances
            die = new Die();
            
            // loop through each instance of the class Die created above
            // each die has six sides
            for(j = 0; j < NUMBER_OF_SIDES; j++)
            {
                die.addLetter(getDiceData().get(counter));
                counter++;
            }
            
            //System.out.print("Die " + i + " :");
            die.displayLetters();
            getGameDice().add(die);
            //System.out.println();
            
        }
    
    }
    
    
    @Override
    public ArrayList shakeDice() {
        //int i;
        // Create new random object from Java class java.util.Random, called rand
        //Random rand = new Random();
        // Create index array to modify
        /*ArrayList<Integer> indexes = new ArrayList<>();
        // Populate indexes array so that value is SAME as index
        // Should have 16 cells
        for(i = 0; i < gameDice.size(); i++)
        {
            indexes.add(i);
        }
        
        */
        
        // Loop through all 16 game dice
        /*for(i = 0; i < gameDice.size(); i++)
        {
            // Grab random index from indexes array
            int randIndex = rand.nextInt(indexes.size());
            //System.out.println(indexes.size());
            // Grab value of randIndex, store it in value variable
            int value = indexes.get(randIndex);
            // Roll the die and add result to gameData array
            gameData.add(gameDice.get(value).rollDie());
            // Remove index that's already been used
            indexes.remove(randIndex);
        }*/
        
        Collections.shuffle(gameDice);
        
        for(Die d : gameDice){
            gameData.add(d.rollDie());
        }
        displayGameData();
        return gameData;
    }
    
    
    public void displayGameData()
    {
        System.out.print("Boggle Board");
        
        int i = 0;
        
        for(String s : gameData)
        {
            if(i%4==0)
            {
                System.out.print("\n");
            }
            System.out.print(s + " ");
            i++;
        }
        System.out.print("\n");
    }
    
    
}
