package cipher;

import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Math;


public class Calculations {
	/**
	 * For each partial string input create a map for each letter frequency
	 * 
	 * @param partialCiphertext
	 * @return
	 */
	public static HashMap<Character,Double> indexOfCoincidenceMap (String partialCiphertext){
		HashMap<Character,Double> map = new HashMap<Character,Double>();
		Character letter=null;
		for(int i=0;i<partialCiphertext.length();i++){
			letter=partialCiphertext.charAt(i);
			if(map.containsKey(letter)) {
				map.put(letter,  map.get(letter)+1);
			} else {
				map.put(letter, 1.0);
			}
		}

		return map;
	}

	/**
	 * Given a string calculate the index of coincidence.
	 * 
	 * @param ciphertext
	 * @return
	 */
	public static double getIndexOfCoincidence(String ciphertext) {
		double indexCoincidence=0;
		HashMap<Character,Double> countMap = new HashMap<Character,Double>();
		double total = ciphertext.length();
		double i=0;
		countMap= indexOfCoincidenceMap(ciphertext);//change this 		int n = ciphertext.length();
		for(HashMap.Entry<Character,Double> entry: countMap.entrySet()){
			i+= (entry.getValue() * (entry.getValue()-1));
		}
		indexCoincidence=i/(total*(total-1));
		return indexCoincidence;
	}

	/**
	 * Displays the Index of Coincidence based on the number keys that there could
	 * be 
	 * 
	 * @param ciphertext
	 * @param m
	 */
	public static void printIndexOfCoincidence(String ciphertext, int m){
		Character letter=null;
		int count=0;
		int key =0;
		String word =null;
		double index =0;
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		for(int i=0;i<ciphertext.length();i++){
			letter = ciphertext.charAt(i);
			key = Math.floorMod(count,m);
			if(map.containsKey(key)) {
				word=map.get(key);
				word = word + letter.toString();
				map.put(key, word );
			} else {
				map.put(key, letter.toString());
			}
			count++;
		}
		for(HashMap.Entry<Integer,String> entry: map.entrySet()){
			index=getIndexOfCoincidence(entry.getValue());
			System.out.println(index+",");
			
		}
	}

	public static Double getShiftedIndexOfCoincidence(String ciphertext, double shiftValue){
		double shiftedIndexOfCoincidence=0;
		double n = ciphertext.length();
		double total = 0;
		double f=0;
		HashMap<Character,Double> englishMap = new HashMap<Character,Double>();
		HashMap<Character,Integer> valueMap = new HashMap<Character,Integer>();
		HashMap<Character,Integer> countMap = new HashMap<Character,Integer>();
		englishMap=	cipherFrequency.getEnglishFrequency();
		valueMap= cipherFrequency.getLetterValue();
		countMap = cipherFrequency.getMonogram(ciphertext);
		

		for(double shift=0;shift<=25;shift++){
			for(HashMap.Entry<Character,Double> entry: englishMap.entrySet()){
				//(entry.getValue() * (shiftedValue+......))/n;

				f = valueMap.get(entry.getKey())+ shift;
				total += ( ( entry.getValue() * (double) countMap.get( Math.floorMod((int) f ,26)) )/2);
				
			}
			shiftedIndexOfCoincidence +=total;
			total=0;
		}
		return shiftedIndexOfCoincidence;
	}

	/**
	 * determine if a value is a prime number
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isPrime(int number){
		boolean prime = true;
		if(number<=1){
			prime = false;
		} 
		for(int i=2; i<= Math.sqrt(number);i++){
			if( (number % i) == 0 ){
				prime =false;
			}
		}
		return prime;
	}

	/*
	 * 
	 */
	public static void getMultiplicativeInverse(){

	}
	
	/**
	 * Using Euclid's Algorithm to determine the greatest common denominator between two variables
	 * 
	 * @bpeterso25
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getGCD(double start, double end) {
		double r =0;
		double q=0;
		q = Math.floor(end/start);
		r = end - (start *q);
		return (int)r;
	}

	/**
	 * Returns the mulitiplicative value of a Hill cipher based on the letters that the user
	 * @param cipherLetter1
	 * @param plaintextLetter1
	 * @param cipherLetter2
	 * @param plaintextLetter2
	 * @return
	 */
	public static Integer calculateAffineMulitiplicative(Character cipherLetter1, Character plaintextLetter1, Character cipherLetter2, Character plaintextLetter2){
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		map = cipherFrequency.getLetterValue();
		int difference=0;
		int differenceMult =0;
		int a =0;
		difference = map.get(cipherLetter2)-map.get(cipherLetter1);
		differenceMult = map.get(plaintextLetter2)-map.get(plaintextLetter1);
		//now equation is difference = difference (mult*a) Mod 26
		
		return a;
	}

	public static Integer calculateAffineAdditive (Character cipherLetter, Character plaintextLetter){
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		map = cipherFrequency.getLetterValue();
		int b=0;


		return b;
	}

	/**
	 * Using the index of coincidence calculate the keyLength based off
	 * the probability of the that matches the english language of 
	 * about .065 or determine if it's random text of .038
	 * 
	 * @bpeterso25
	 * @para ciphertext
	 */
	 
	public static int getKeyLength(String ciphertext){
		int keyLength=0;
		
		

		return keyLength;
	}

}
