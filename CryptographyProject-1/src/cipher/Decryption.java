package cipher;

import java.util.HashMap;

public class Decryption {

	/**
	 * Takes the ciphertext as input along with the supposed key outputs the 
	 * supposed it plaintext
	 * @bpeterso25
	 */
	public static void decryptShiftCipher(String ciphertext, int key) {
		String plaintext="";
		int n= ciphertext.length();
		char substitute=0;
		int value=0;
		String letter =null;
		HashMap <Character, Integer> letterMap = new HashMap<Character,Integer>();
		HashMap <Integer,Character> numberMap = new HashMap<Integer,Character>();
		letterMap = cipherFrequency.getLetterValue();
		numberMap = cipherFrequency.getNumberLetter();
		for(int i=0;i< n;i++){
			substitute = ciphertext.charAt(i);
			value=letterMap.get(substitute);
			value += key;
			value = Math.floorMod(value, 26);
			letter= numberMap.get(value).toString().toLowerCase();
			plaintext = plaintext + letter;
		}
		System.out.println(plaintext);
	}

	/**
	 * Decrypts the cipher based on the (a^-1)*(y -b) mod 26 = x, where x is the plaintext letter.
	 * 
	 * @param ciphertext
	 * @param multiplicative
	 * @param addative
	 */
	public static void decryptAffineCipher(String ciphertext, int multiplicative, int additive){
		HashMap<Character,Integer>map = new HashMap<Character,Integer>();
		HashMap<Integer,Character>plaintextMap = new HashMap<Integer,Character>();
		map = cipherFrequency.getLetterValue();
		plaintextMap = cipherFrequency.getNumberLetter();
		Character letter=null;
		int multiplicativeInverse =0;
		int innerValue =0;
		Character plaintextLetter = null;
		int plaintextValue = 0;
		String phrase = null;

		for(int i=0;i<ciphertext.length();i++){
			letter=ciphertext.charAt(i);
			//map value - additive then math
			innerValue = Math.floorMod(map.get(letter)-additive,26);
			multiplicativeInverse = 1/multiplicative; //multiplicative method to get

			plaintextValue=innerValue*multiplicativeInverse;
			plaintextLetter = plaintextMap.get(plaintextValue);

			phrase +=plaintextLetter.toString();
		}
		System.out.println(phrase);
	}

	/**
	 * Display the plaintext of a substitution cipher with a given key. Alphabet corresponds with
	 * different starting point
	 * 
	 * @bpeterso25
	 * @param cipherText
	 * @param key
	 */
	public static void decryptSubstitution(String ciphertext, int key) {
		String plaintext = null;
		
		//pick letters most frequency based off probability
		//e with most frequent and t with 2nd make equation
		
	}

	/**
	 * Display the plaintext from the cipherText and the supposed key.
	 * 
	 * @bpeterso25
	 * @param cipherText
	 * @param keyString
	 */
	public static void decryptVignere(String ciphertext, String keyString){
		

	}
	
	/**
	 * 
	 * @param cipehrtext
	 */
	public static void decryptPermutation(String cipehrtext){

	}


	public static void decryptOneTimePad(String ciphertext, HashMap<Character,Character> keyMap){

	}
	
}
