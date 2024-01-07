import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;


    //Exercise 4.14 
    public void checkIndex(int index){
        if(0 <= index && index <= files.size()-1){
            System.out.println("The index is within the range");
        }
        else{
            System.out.println("Error! The index is not within the range 0 to " + files.size());
        }
    }

    //Exercise 4.15
    public Boolean validIndex(int index){
        if(0 <= index && index <= files.size()-1){
            return true;
        }
        else{
            return false;
        }
    }

    //Exercise 4.16 
    public void listFile(int index) {
        if(validIndex(index)) {    
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    public void removeFile(int index) {
        if(validIndex(index)) {
            files.remove(index);
        }
    }

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<>();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }


    
}
