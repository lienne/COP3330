/*
Liana Severo
COP 3330 - Object Oriented Programming
*/

package core;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Liana Severo
 */
public class Die implements IDie {
    
    // Member variable declarations
    // stores dice data for the sides of the die
    private final ArrayList<String> sides = new ArrayList<>();
    
    
    // Populate sides array with letters from BoggleData.txt text file
    @Override
    public void addLetter(String letter)
    {
        // add the passed-in argument to the ArrayList "sides"
        sides.add(letter);
    }
    
    @Override
    public void displayLetters()
    {
        // Enhanced for loop to output the letter on each of the six sides of the die
        for(String value : sides)
        {
            // prints out a letter followed by a space
            //System.out.print(value + " ");
        }
    }
    
    @Override
    public String rollDie()
    {
        // create new random object
        Random rand = new Random();
        // "side" is int because we're grabbing a random INDEX from sides array (nth side)
        int side = rand.nextInt(sides.size());
        // return that random nth side
        return sides.get(side);
    }
}
