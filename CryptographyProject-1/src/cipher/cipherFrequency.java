package cipher;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class cipherFrequency {

	/**
	 * display the frequency of each letter in the cipher program as an integer.
	 * 
	 * @param cipherText
	 * @return
	 */
	public static HashMap<Character,Integer> getMonogram(String cipherText) {
		HashMap<Character, Integer> map = new HashMap<Character,Integer>();
		int n= cipherText.length();
		for(int i=0;i<n;i++){
			char c = cipherText.charAt(i);			
			if(map.containsKey(c)) {
				map.put(c,  map.get(c)+1);
			} else {
				map.put(c, 1);
			}
		}
		return map;
	}

	/**
	 * Calculate the frequency of each digram in the cipher
	 * 
	 * @param ciphertext
	 * @return
	 */
	public static HashMap<String,Integer> getDigram(String ciphertext){
		HashMap<String,Integer> map = new HashMap<String, Integer>();
		int n = ciphertext.length();
		Character firstLetter, secondLetter = null;
		String digram = null;
		
		for(int i=0;i<n-1;i++){
			firstLetter =ciphertext.charAt(i);
			secondLetter = ciphertext.charAt(i+1);
			digram = firstLetter.toString() +secondLetter.toString();
			if(map.containsKey(digram)) {
				map.put(digram,  map.get(digram)+1);
			} else {
				map.put(digram, 1);
			}
		}

		return map;
	}

	/**
	 * Map the frequencies of the trigrams in the ciphertext
	 * 
	 * @param ciphertext
	 * @return
	 */
	public static HashMap<String,Integer> getTrigrams(String ciphertext){
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		int n = ciphertext.length();
		Character firstLetter,secondLetter,thirdLetter = null;
		String trigram = null;
		for(int i=0;i<n-2;i++){
			firstLetter =ciphertext.charAt(i);
			secondLetter = ciphertext.charAt(i+1);
			thirdLetter = ciphertext.charAt(i+2);
			trigram = firstLetter.toString() +secondLetter.toString()+ thirdLetter.toString();
			if(map.containsKey(trigram)) {
				map.put(trigram,  map.get(trigram)+1);
			} else {
				map.put(trigram, 1);
			}
		}
		return map;
	}

	/**
	 * Show the five most frequent trigrams in the ciphertext with their respective locations into a list.
	 * 
	 * @return
	 */
	public static ArrayList<String> getFrequentTrigrams(String ciphertext){
		
		ArrayList<String> frequencyList = new ArrayList<String>(5);
		HashMap<String,Integer> trigramsMap = new HashMap<String,Integer>();
		trigramsMap = getTrigrams(ciphertext);
		String lowest ="";
		int min=0;
		boolean flag=false;
		for(HashMap.Entry<String,Integer> entry: trigramsMap.entrySet()){
			if(frequencyList.size()<5){
				frequencyList.add(entry.getKey());
			} else {
				for(int i=0;i<5;i++){
					if(entry.getValue()>20){
						System.out.println(trigramsMap.get(frequencyList.get(i))+ " :vs: "+ entry.getValue());
					}
						
					if( (trigramsMap.get(frequencyList.get(i)) <= entry.getValue()) && (entry.getValue() >= trigramsMap.get(frequencyList.get(min))) ){ //checks for the lowest and replace only that value
						//System.out.println(min);
						
						System.out.println("min is: "+trigramsMap.get(frequencyList.get(i)));
						System.out.println("============");
						flag=true;
					}
				}
				if(flag==true){
					int j=0;
					frequencyList.remove(frequencyList.get(min));
					frequencyList.add(entry.getKey());
					
					flag =false;
				}
			}

		}

		return frequencyList;
	}

	/**
	 * 
	 * @param ciphertext
	 * @param trigramsList
	 * @return
	 */
	public static HashMap<String,Integer> getTrigramPositions(String ciphertext, HashMap<String,Integer>frequentTrigramsMap){
		HashMap<String,Integer>positionMap = new HashMap<String,Integer>();
		int n= ciphertext.length();
		String trigram,position,locations =null;
		Character letter1,letter2,letter3 =null;
		/*for(int i=0;i<trigramsList.size();i++){
			for(int k=0;k<n-2;k++){
				letter1=ciphertext.charAt(i);
				letter2=ciphertext.charAt(i+1);
				letter3=ciphertext.charAt(i+2);
				trigram = letter1.toString()+letter2.toString()+letter3.toString();
				if(trigramsList.get(i).equals(trigram)){
					position= Integer.toString(k);
					if(positionMap.containsKey(trigram)) {
						locations = positionMap.get(k)+","+position;
						//positionMap.put(trigramsList.get(index), locations);
					} else {
						//positionMap.put(trigram, );
					}
				}
			}
		}
		*/
		return positionMap;
	}

	/**
	 * given a ciphertext string outputs the frequencies of the monograms and digrams
	 * of the ciphertext for the user
	 * 
	 * @bpeterso25
	 */
	public static void printFrequencyAnalysis(String ciphertext){
		HashMap<Character,Integer> monoMap = new HashMap<Character,Integer>();
		HashMap<String, Integer> digramMap = new HashMap<String,Integer>();
		monoMap = getMonogram(ciphertext);
		digramMap = getDigram(ciphertext);
		System.out.println("Monogram Frequencies");
		System.out.println("--------------------");
		for(HashMap.Entry<Character,Integer> entry: monoMap.entrySet()){
			System.out.println(entry.getKey()+"\t"+entry.getValue());
		}
		System.out.println("===================================================");
		System.out.println("Digram Frequencies");
		System.out.println("--------------------");
		for(HashMap.Entry<String,Integer> entry: digramMap.entrySet()){
			System.out.println(entry.getKey()+"\t"+entry.getValue());
		}
	}

	/**
	 * 
	 * @param ciphertext
	 * @return
	 */
	public static ArrayList<String> KasiskiTest(String ciphertext, Map<String, Integer>trigramMap){
		ArrayList<String> trigrams = new ArrayList<String>();
		HashMap<String,Integer> positionMap = new HashMap<String,Integer>();
		//positionMap = getTrigramPositions(ciphertext, trigramMap);
		int n = ciphertext.length();
		
		
	
				//iterate find most frequent trigrams
				//locations in the ciphertext
				//GCDs of the distance between consecutive trigrams
				
		return trigrams;
	}

	public static HashMap<Character,Integer> getVigenereKey(String ciphertext){
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();

		
		return map;
	}

	/**
	 * Get the total amount of letter in a cilpher
	 * 
	 * @param integerMap
	 * @return
	 */
	public static int getTotalLetters(HashMap <Character,Integer> integerMap){
		int total=0;
		for(HashMap.Entry<Character,Integer> entry : integerMap.entrySet()){
			total += entry.getValue();
		}
		return total;
	}

	/*
	 * * Display the percentages that each letter shows up in the entire ciphertext
	 */	 
	public static HashMap<Character,Double> getPercentMap(HashMap <Character,Integer> integerMap){
		HashMap <Character, Double> percentMap = new HashMap<Character, Double>();
		double total=0;
		double percent=0;
		total = (double) getTotalLetters(integerMap);
		
		for(HashMap.Entry<Character,Integer> entry: integerMap.entrySet()){
			percent = (double) entry.getValue(); 
			percent = percent/total;
			percentMap.put(entry.getKey(),percent);
		}
		return percentMap;
	}
	
	/*
	 * assign values to each letter of the alphabet from zero to 25.
	 */
	public static HashMap<Character,Integer> getLetterValue(){
		HashMap<Character,Integer> valueMap = new HashMap<Character,Integer>();
		valueMap.put('A',0);
		valueMap.put('B',1);
		valueMap.put('C',2);
		valueMap.put('D',3);
		valueMap.put('E',4);
		valueMap.put('F',5);
		valueMap.put('G',6);
		valueMap.put('H',7);
		valueMap.put('I',8);
		valueMap.put('J',9);
		valueMap.put('K',10);
		valueMap.put('L',11);
		valueMap.put('M',12);
		valueMap.put('N',13);
		valueMap.put('O',14);
		valueMap.put('P',15);
		valueMap.put('Q',16);
		valueMap.put('R',17);
		valueMap.put('S',18);
		valueMap.put('T',19);
		valueMap.put('U',20);
		valueMap.put('V',21);
		valueMap.put('W',22);
		valueMap.put('X',23);
		valueMap.put('Y',24);
		valueMap.put('Z',25);
		return valueMap;
	}

	/*
	 * assign values to each letter of the alphabet from zero to 25.
	 */
	public static HashMap<Integer,Character> getNumberLetter(){
		HashMap<Integer,Character> valueMap = new HashMap<Integer,Character>();
		valueMap.put(0,'A');
		valueMap.put(1,'B');
		valueMap.put(2,'C');
		valueMap.put(3,'D');
		valueMap.put(4,'E');
		valueMap.put(5,'F');
		valueMap.put(6,'G');
		valueMap.put(7,'H');
		valueMap.put(8,'I');
		valueMap.put(9,'J');
		valueMap.put(10,'K');
		valueMap.put(11,'L');
		valueMap.put(12,'M');
		valueMap.put(13,'N');
		valueMap.put(14,'O');
		valueMap.put(15,'P');
		valueMap.put(16,'Q');
		valueMap.put(17,'R');
		valueMap.put(18,'S');
		valueMap.put(19,'T');
		valueMap.put(20,'U');
		valueMap.put(21,'V');
		valueMap.put(22,'W');
		valueMap.put(23,'X');
		valueMap.put(24,'Y');
		valueMap.put(25,'Z');
		return valueMap;
	}
	
	/*
	 * Displays the approximate english frequency of each letter of the alphabet
	 */
	public static HashMap<Character,Double> getEnglishFrequency(){
		HashMap<Character,Double> map = new HashMap<Character,Double>();
		map.put('E',12.702);
		map.put('T',9.056);
		map.put('A',8.167);
		map.put('O',7.507);
		map.put('I',6.996);
		map.put('N',6.749);
		map.put('S',6.327);
		map.put('R',5.987);
		map.put('H',6.194);
		map.put('D',4.253);
		map.put('L',4.025);
		map.put('U',2.758);
		map.put('C',2.782);
		map.put('M',2.406);
		map.put('F',2.228);
		map.put('Y',1.974);
		map.put('W',2.360);
		map.put('G',2.015);
		map.put('P',1.929);
		map.put('B',1.492);
		map.put('V',.978);
		map.put('K',.772);
		map.put('X',.150);
		map.put('Q',.095);
		map.put('J',.153);
		map.put('Z',.074);
		return map;
	}
}
