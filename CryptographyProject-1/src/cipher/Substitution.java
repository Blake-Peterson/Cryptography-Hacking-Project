
package cipher;

import java.util.HashMap;

public class Substitution {
    
    /**
	 * Store potential plaintext letters to associate the ciphertext letters to form a mapKey to 
	 * decrypt the ciphertext.
	 * 
	 * @bpeterso25
	 * @param a
	 * @param b
	 * @return
	 */
	public static HashMap<Character,Character> putKeyMap(Character a, Character b) {
		HashMap<Character, Character>map = new HashMap<Character,Character>();
		a = Character.toUpperCase(a);
		b = Character.toUpperCase(b);
		map.put(a, b);
		return map;
	}
}
