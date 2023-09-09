package cipher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {

	public static void displayChoices(){
		System.out.println("\nPlease select what you would like to do");
		System.out.println("----------------------------------------------");
		System.out.println("1: Show the letter Frequencies of the cipher");
		System.out.println("2: Determine Key Size");
		System.out.println("3: Attempt to crack the cipher");
		System.out.println("5: Exit the program");
	}

	public static void displayCrackingChoices(){
		System.out.println("\nWhich method would you like to use to crack the cipher?");
		System.out.println("-------------------------------------------------------");
		System.out.println("1: Shift");
		System.out.println("2: Substitution ");
		System.out.println("3: Affine");
		System.out.println("4: Vignere");
		System.out.println("5: Permutation");
		System.out.println("6: Hill");
		System.out.println("7: One-time Pad");
		System.out.println("0: Leave Cipher Cracking");
	}
	
	public static void displayMenu(String ciphertext) {
		HashMap<String,Integer> trigramMap = new HashMap<String, Integer>();
		HashMap<String,Integer> positionMap = new HashMap<String, Integer>();
		ArrayList<String> trigramList = new ArrayList<String>();
		
		String response = null;
		String line = null;
		Scanner s = new Scanner(System.in);
		int choice = 0;
		int method =0;
		while(choice !=5) {
			displayChoices();
			response = s.nextLine();
			choice = Integer.parseInt(response);
			if(choice == 1 ) {
				cipherFrequency.printFrequencyAnalysis(ciphertext);
			}else if( choice == 2 ) {
				//get the key size
				System.out.println("------------------");
				trigramList =cipherFrequency.getFrequentTrigrams(ciphertext);
				trigramMap = cipherFrequency.getTrigrams(ciphertext);
				
				for(HashMap.Entry<String,Integer> entry: trigramMap.entrySet()) {
					if(entry.getValue()>20){
					System.out.println("Letter = "+ entry.getKey() +"\tFrequency = "+entry.getValue());
					}
				}
				
				System.out.println("------------------");
				for(int i=0;i<5;i++){
					System.out.println(trigramMap.get(trigramList.get(i)));
				}
				
			}else if( choice == 3 ) {
				displayCrackingChoices();
				line =s.nextLine();
				method= Integer.parseInt(line);
				crackOptions(ciphertext,method);
			}else if( choice == 4 ) {
				

			} 
			/*else {
				System.out.println("\nError incorrect input. Try again silly.\n\n");
			}*/
			
		}
		s.close();	
	}

	public static void crackOptions(String ciphertext,int crackMethod){
		int method = 0;
		String line = "";
		String choice= "";
		int key=0;
		String cipherLetter=null;
		String plaintextLetter=null;
		Scanner sc = new Scanner(System.in);
		while(crackMethod!=0){
			if(crackMethod==1){
				System.out.println("What would like to use for your key");
				key= Integer.parseInt(sc.nextLine());
				Decryption.decryptShiftCipher(ciphertext, key);
				crackMethod=0;
				sc.close();
				System.out.println("================================================================================");
			}else if(crackMethod==2){ //substitution
				HashMap<Character,Character>keyMap = new HashMap<Character,Character>();
				System.out.println("Assign Ciphertext to Plaintext ");
				while(choice.compareTo("done")!= 0){  //loops continuously need to break it when done
					System.out.println("Ciphertext letter:");
					cipherLetter=sc.nextLine();
					System.out.println("Plaintext letter");
					plaintextLetter = sc.nextLine();
					keyMap=Substitution.putKeyMap(cipherLetter.charAt(0), plaintextLetter.charAt(0));
				}
				Display.displayCipherGuessing(ciphertext, keyMap);
				

			}else if(method==3){//affine

				

			}else if(method==4){//vignere



			}else if(method==5){//permuation


			} else if(method ==6){//Hill
	
			} else if(method ==7){//one-time pad

			}

		}
		sc.close();

	}

	public static String leaveMethod(){
		String leave =null;
		System.out.println("Would you like to leave the cracking method? Type 'exit'");
		Scanner s = new Scanner(System.in);
		leave = s.nextLine();
		leave.toLowerCase();
		s.close();
		return leave;
		
	}
}
