/*
Liana Severo
COP 3330 - Object Oriented Programming
*/

package core;

import java.util.ArrayList;

/**
 *
 * @author Liana Severo
 */
public interface IBoard {
    
    // Constant (static) variable declarations & initializations
    static final int NUMBER_OF_DICE = 16;
    static final int GRID = 4;
    
    // Method signatures
    public void populateDice();
    public ArrayList shakeDice();
    
}
