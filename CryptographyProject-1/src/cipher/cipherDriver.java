package cipher;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class cipherDriver {

	

	public static void main(String[] args) {	
		
		String ciphertext=cipherReader.getCipher(args[0]);
		//System.out.println("cipherText is "+ciphertext+"\n");
		//cipherFrequency.printFrequencyAnalysis(ciphertext);

		
		//Calculations.printIndexOfCoincidence(ciphertext, 3);
		System.out.println("============================================================================================");

		Menu.displayMenu(ciphertext);
		/*

		HashMap<Character,Integer> monoMap = new HashMap<Character,Integer>();
		monoMap= cipherFrequency.getMonogram(ciphertext);
		for(Map.Entry<Character,Integer> entry: monoMap.entrySet()) {
			System.out.println("Letter = "+ entry.getKey() +"\tFrequency = "+entry.getValue());
		}

		
		HashMap<String,Integer> trigramsMap = new HashMap<String,Integer>();
		trigramsMap= cipherFrequency.getFrequentTrigrams(ciphertext);
		for(Map.Entry<String,Integer> entry: trigramsMap.entrySet()) {
			System.out.println("Letter = "+ entry.getKey() +"\tFrequency = "+entry.getValue());
		}
		*/
	}
}