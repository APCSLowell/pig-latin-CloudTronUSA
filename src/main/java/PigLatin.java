import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.util.Arrays;

public class PigLatin {
    
    public void tester() {
        // String[] lines = loadStrings("words.txt");
        String[] lines = new String[8]; 
        try{
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
	    System.out.println("there are " + lines.length + " lines");
	    for (int i = 0 ; i < lines.length; i++) {
	        System.out.println(pigLatin(lines[i]));
	    }
    }
	
    public int findFirstVowel(String sWord) {
        //precondition: sWord is a valid String of length greater than 0.
        //postcondition: returns the position of the first vowel in sWord.  If there are no vowels, returns -1
    	ArrayList<String> t = new ArrayList<String>(Arrays.asList("a", "e", "i", "o", "u"));
    	for (int i=0;i<sWord.length();i++) {
            if (t.stream().anyMatch(sWord.substring(i,i+1)::equals)) {return i;}
        }
        return -1;
    }

    public String pigLatin(String sWord) {
        //precondition: sWord is a valid String of length greater than 0
        //postcondition: returns the pig latin equivalent of sWord
	    if(findFirstVowel(sWord) == -1)    // all consonants
		    return sWord + "ay";
        if(sWord.length()>1 && sWord.substring(0,2).equals("qu"))    // starts with qu
		    return sWord.substring(2) + "quay";
        if(findFirstVowel(sWord) == 0)    // starts with vowel
		    return sWord + "way";
        else {    // starts with consonats
            int v = findFirstVowel(sWord);
            return sWord.substring(v) + sWord.substring(0, v) + "ay";
        }
    }
} //end PigLatin class
