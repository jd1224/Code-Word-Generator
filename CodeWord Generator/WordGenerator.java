import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import java.Math.Random;

public class WordGenerator{

	private static final String COMMA_DELIMITER = ",";
	private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public String getWord(){
		return codeWord();
	}
	
	/*
	*Method to return a random word from a set of csv files 
	*saved in the same folder as this program
	*/
	private String codeWord(){
		//grab a random letter from the alphabet constant and append the rest of the file name
		String letter1 = randomLetter()+"word.csv";
		//initialize the word1 String
		String word1="";
		//instantiate the br
		BufferedReader br = null;
		try{
			//instantiate the br with the file locate at letter1
			br = new BufferedReader(new FileReader(letter1));
			
			//create an arraylist to hold the words in the csv file
			List<String> words = new ArrayList<String>();
			//instantiate line
			String line = "";
			//read a line from the csv (all are on their own line in the attached files)
			br.readLine();
			//fill the words arraylist
			while ((line = br.readLine())!= null){
				words.add(line);
			}
			//grab a random word from the list and make word1 that word1
			word1 = (words.get((int)(Math.random()*words.size()-1)+1));
			
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		//return the random word
		return word1.toUpperCase();
		
	}
	
	//return a random letter from the alphabet constant as a string
	private String randomLetter(){
		int num = (int)(Math.random()*alphabet.length())+1;
		if (num<alphabet.length()){
			return alphabet.substring(num,num+1);
		}else{
			return alphabet.substring(num-1);
		}
		
	}


}