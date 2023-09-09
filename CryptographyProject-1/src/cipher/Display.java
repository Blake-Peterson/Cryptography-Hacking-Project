package cipher;

import java.util.HashMap;
import java.util.Map;


public class Display {
	
	/**
	 * print out the whole cipherText
	 * @bpeterso25
	 * @param cipherText
	 */
	public static void displayCipher(String cipherText) {
		System.out.println(cipherText);
	}
	
	/**
	 * 
	 * 
	 * @param ciphertext
	 * @param letterMappings
	 */
	public static void displayCipherGuessing(String ciphertext, HashMap<Character,Character> letterMappings) {
		int n = ciphertext.length();
		int count=0;
		int total = n*2;
		boolean flag=false;
		//display with about 150 characters then switch to display the lines below and alternate until gone through the cipher.
		//in a while loop
		while(count !=total){
			if(flag==false){
				for(int i=0;i<n;i++) {
					char cipherLetter = ciphertext.charAt(i);
					char mappedLetter=letterMappings.get(cipherLetter);
					if(letterMappings.containsKey(mappedLetter)) {
						System.out.print(mappedLetter+" ");
					} else {
						System.out.print("_ ");
					}
					if(count % 100 ==0){
						flag=true;
					}
					count++;
				}
			} else {
				System.out.println();
				for(int j=0;j<n;j++) {
					System.out.print(ciphertext.charAt(j)+" ");
					if(count % 100 ==0){
						flag=false;
					}
					count++;
				}
			}
		}
	}	

	public static void displayLetterCount(String cipherText) {
		int highest=0;
		HashMap<Character,Integer> cipherMap = cipherFrequency.getMonogram(cipherText);
		for(Map.Entry<Character,Integer> entry: cipherMap.entrySet()) {
			System.out.println("Letter = "+ entry.getKey() +"\tFrequency = "+entry.getValue());
			if(entry.getValue() > highest) {
				highest = entry.getValue();
			}
		}
		System.out.println("Your highest value is "+highest);
	}

	
}
