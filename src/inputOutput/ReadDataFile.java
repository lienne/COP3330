/*
Liana Severo
COP 3330 - Object Oriented Programming
*/

package inputOutput;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Liana Severo
 */
public class ReadDataFile implements IReadDataFile {
    
    // Member variable declarations
    private Scanner inputFile;
    private final String dataFileName;
    private final ArrayList<String> fileData;

    // Constructor for ReadDataFile class, accepting only Strings as parameters
    public ReadDataFile(String fileName) {
        dataFileName = fileName;
        fileData = new ArrayList<>();
    }

    /**
     * @return the fileData
     */
    public ArrayList<String> getData() {
        return fileData;
    }
    
    // Method to populate data
    @Override
    public void populateData() {
        try
        {
            // Instantiate an instance of Java API class URL
            URL url = getClass().getResource("/data/" + dataFileName);
            // Instantiate an instance of class File using the URL created above
            File file = new File(url.toURI());
            // Initialize Scanner-type variable "inputFile"
            inputFile = new Scanner(file);
            
            // Loop through data file until the end
            while(inputFile.hasNext())
            {
                // Add each value read from the file to ArrayList "fileData"
                fileData.add(inputFile.next());
            }
        }
        catch(IOException | URISyntaxException ex)
        {
            System.out.println(ex.toString());
            //ex.printStackTrace();
        }
        finally
        {
            if(inputFile != null)
            {
                inputFile.close();
            }
        }
        
    }
}
