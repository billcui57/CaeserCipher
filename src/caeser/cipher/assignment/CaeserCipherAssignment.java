/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caeser.cipher.assignment;

import java.util.Scanner;

/**
 *
 * @author 348848128
 */
public class CaeserCipherAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        while (true) {
            String message = input.nextLine();
            String[] printOut = breakCode(message);
            for (int i = 0; i < printOut.length; i++) {
                System.out.println(printOut[i]);
            }
        }
        

    }

    /**
     *
     * @param message un-encrypted message that you want to encrypt
     * @param key key for encryption (how many letters to shift by)
     * @return encrypted message as string
     * 
     * Takes in a string and moves each char's value by an integer amount. If the char's value is shifted outside of the alphabet spectrum,
     * then it is wrapped around back to the other end of the alphabet
     * 
     * encode method acts more as a char shifting engine than just for encoding
     */
    public static String encode(String message, int key) {
        String encryptedMessage = "";
        int shift;
        
        //if user inputs a key of 0, then no shift
        if((key>0)||(key<0)){
            shift = key % 26;
        }else{
            return message;
        }
        
        
        //loops through the string char by char
        for (int i = 0; i < message.length(); i++) {
           
            //sets the boundries custom to uppercase or lowercase
            char endIndex=' ';
            char firstIndex=' ';
            if(Character.isUpperCase(message.charAt(i))){
                firstIndex='A';
                endIndex='Z';
            }else if(Character.isLowerCase(message.charAt(i))){
                firstIndex='a';
                endIndex='z';
            }
            
            //ensures that the character is a letter, if not then it is not shfited
            if (Character.isLetter(message.charAt(i))) {
                //if char is shifted outside of alphabet, then it is wrapped back to the other end
                if ((message.charAt(i)) + shift > endIndex) {
                    encryptedMessage += (char) (message.charAt(i) + shift - endIndex + firstIndex - 1);
                } else if (message.charAt(i) + shift < firstIndex) {
                    encryptedMessage += (char) (endIndex - (firstIndex - (message.charAt(i) + shift) - 1));
                } else {
                    //simple shift no wrapping
                    encryptedMessage += (char) (message.charAt(i) + shift);
                }
            } else{
                //character is not a letter, not shifted
                encryptedMessage += message.charAt(i);
            }
            
        }
        return encryptedMessage;
    }

    /**
     *
     * @param encryptedMessage message that needs to be decrypted
     * @param key key to shift encrypted message by to decrypt it
     * @return decrypted message as string
     * uses the encode engine in reverse
     */
    public static String decode(String encryptedMessage, int key) {
        String decryptedMessage = "";
        //inputs the inverse key into the encode engine
        decryptedMessage = encode(encryptedMessage,-key);
        return decryptedMessage;
    }

    /**
     *
     * @param encryptedMessage message that needs to be decrypted, key is not
     * needed as decryption is done with brute force
     * @return decrypted message in an array of strings
     * utilizes a common word dictionary to guess from several decoded instances which one is the most likely to be a proper sentence
     */
    public static String[] breakCode(String encryptedMessage) {
        String[] results = new String[26];
        //common word dictionary - for future improvement, should place into .JSON file
        String[] commonPhrases = {"time", "person ", "year ", "way ", "day ", "thing", "man",
            "world", "life", "hand", "part", "child", "eye", "woman", "place", "work", "week", "case",
            "point", "government", "company", "number", "group", "problem", "fact", "be", "have", "do",
            "say", "get", "make", "go", "know", "take", "see", "come", "think", "look", "want", "give", "use",
            "find", "tell", "ask", "work", "seem", "feel", "try", "leave", "call", "good", "new", "first",
            "last", "long", "great", "little", "own", "other", "old", "right", "big", "high", "different",
            "small", "large", "next", "early", "young", "important", "few", "public", "bad", "same", "able",
            "to", "of", "in", "for", "on", "with", "at", "by", "from", "up", "about", "into", "over", "after",
            "the", "and", "a", "that", "I", "it", "not", "he", "as", "you", "this", "but", "his", "they", "her",
            "she", "or", "an", "will", "my", "one", "all", "would", "there", "their"};
        String[] decrypted = new String[26];
        int arraySize = 0;
        for (int i = 0; i < 26; i++) {
            //decodes sentence with 26 different possible keys
            results[i] = decode(encryptedMessage, i);
            String[] compare = results[i].split(" ");
            //checks if each word in the decoded sentence is an english word
            for (int j = 0; j < compare.length; j++) {
                for (int l = 0; l < commonPhrases.length; l++) {
                    if (compare[j].equalsIgnoreCase(commonPhrases[l])) {
                        //if it is, then appends that string into output string (I have not learned dynamic arrays yet so this is my solution)
                        for (int k = 0; k < compare.length; k++) {
                            decrypted[i] += compare[k] + " ";
                        }

                    }
                }
            }
            
            //removes the "null" before the string
            if (decrypted[i] != null) {
                decrypted[i] = decrypted[i].substring(4, encryptedMessage.length() + 4);

            }
        }

        //counts number of possible sentences to create a set sized array
        for (int i = 0; i < decrypted.length; i++) {
            if (decrypted[i] != null) {
                arraySize++;
            }
        }

        //stores all possible sentences into that array and outputs it
        String[] list = new String[arraySize];
        int i = 0;
        for (int j = 0; j < decrypted.length; j++) {
            if (decrypted[j] != null) {
                list[i] = decrypted[j];
                i++;
            }
        }

        return list;
    }
}
