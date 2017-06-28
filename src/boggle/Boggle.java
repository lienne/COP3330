/*
Liana Severo
COP 3330 - Object Oriented Programming
*/

package boggle;

//import static boggle.Boggle.diceData;
import core.Board;
import inputOutput.ReadDataFile;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Liana Severo
 */

public class Boggle {

    // Member variable declarations / initialization
    // diceData is also referred to as "boggle data" in instructions
    public static ArrayList<String> diceData = new ArrayList();
    public static String dataFileName = "BoggleData.txt";
    public static ArrayList<String> dictData = new ArrayList();
    public static String dictFileName = "Dictionary.txt";
    
    
    // Constructor
    public Boggle()
    {}
    
    
    public static void main(String[] args) {
        
        // Print statement in a pop up box, saying "Welcome to Boggle!"
        System.out.println("\"Welcome to Boggle!\"");
        JOptionPane.showMessageDialog(null, "\"Let's play Boggle!\"");
        
        // Create an instace of class ReadDataFile, called data, passing
        // the file name variable for BoggleData.txt as an argument
        ReadDataFile data = new ReadDataFile(dataFileName);
        // Call method populateData on instance data
        data.populateData();
        
        // Create an instance of class ReadDataFile, called dict,
        // passing the file name variable for dictionary.txt as an argument
        ReadDataFile dict = new ReadDataFile(dictFileName);
        // Call populateData on instance dict
        dict.populateData();
        
        // Create an instance of class Board, called board
        Board board = new Board(data.getData(), dict.getData());
        // Call method populateDice on board
        board.populateDice();
        // Call method shakeDice on board
        diceData = board.shakeDice();
        
       // Output showing # of objects in ArrayList dictData
       //System.out.println("There are " + dict.getData().size() + " entries in the dictionary.");
    }
    
}
