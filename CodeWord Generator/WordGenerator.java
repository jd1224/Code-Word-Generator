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
	private static String[] wordMaker(){
		
		//Choose a random letter to pull for our codewords
		String letter1 = randomLetter()+"word.csv";
		String letter2 = randomLetter()+"word.csv";
		String word1="";
		String word2="";
		String[] codeWord = new String[2];
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(letter1));
			
			List<String> words = new ArrayList<String>();
			
			String line = "";
			
			br.readLine();
			
			while ((line = br.readLine())!= null){
				words.add(line);
			}
			
			word1 = (words.get((int)(Math.random()*words.size()-1)+1));
			
			
			br = new BufferedReader(new FileReader(letter2));
			
			List<String> words2 = new ArrayList<String>();
			
			String line2 = "";
			
			br.readLine();
			
			while ((line2 = br.readLine())!= null){
				words2.add(line2);
			}
			
			word2 = (words2.get((int)(Math.random()*words2.size()-1)+1));
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		codeWord[0] = word1.toUpperCase();
		codeWord[1] = word2.toUpperCase();
		return codeWord;
		
	}
	
	private static String codeWord(){
		String letter1 = randomLetter()+"word.csv";
		String word1="";
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(letter1));
			
			List<String> words = new ArrayList<String>();
			
			String line = "";
			
			br.readLine();
			
			while ((line = br.readLine())!= null){
				words.add(line);
			}
			
			word1 = (words.get((int)(Math.random()*words.size()-1)+1));
			
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return word1.toUpperCase();
		
	}
	
	//return a random letter in the english alphabet as a string
	private static String randomLetter(){
		int num = (int)(Math.random()*alphabet.length())+1;
		if (num<alphabet.length()){
			return alphabet.substring(num,num+1);
		}else{
			return alphabet.substring(num-1);
		}
		
	}


}