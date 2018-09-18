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
            for(int i=0;i<26;i++){
                 String printOut=breakCode(message)[i];
                 if(printOut!=null)
                     System.out.println(printOut);
                 
            }
               
            

        }
    }
    
    /**
     * 
     * @param message un-encrypted message that you want to encrypt
     * @param key key for encryption (how many letters to shift by)
     * @return encrypted message
     */
    public static String encode(String message, int key) {
        String encryptedMessage = "";
        int shift = key % 26;
        for (int i = 0; i < message.length(); i++) {
            if ((message.charAt(i) <= 'z') && (message.charAt(i) >= 'a')) {
                if ((message.charAt(i)) + shift > 'z') {
                    encryptedMessage += (char) (message.charAt(i) + shift - 'z' + 'a' - 1);
                } else {
                    encryptedMessage += (char) (message.charAt(i) + shift);
                }
            } else if ((message.charAt(i) <= 'Z') && (message.charAt(i) >= 'A')) {
                if ((message.charAt(i)) + shift > 'Z') {
                    encryptedMessage += (char) (message.charAt(i) + shift - 'Z' + 'A' - 1);
                } else {
                    encryptedMessage += (char) (message.charAt(i) + shift);
                }
            } else {
                encryptedMessage += message.charAt(i);
            }
        }
        return encryptedMessage;
    }

    /**
     * 
     * @param encryptedMessage message that needs to be decrypted
     * @param key key to shift encrypted message by to decrypt it
     * @return decrypted message
     */
    public static String decode(String encryptedMessage, int key) {
        String decryptedMessage = "";
        int shift = key % 26;
        for (int i = 0; i < encryptedMessage.length(); i++) {
            if ((encryptedMessage.charAt(i) <= 'z') && (encryptedMessage.charAt(i) >= 'a')) {
                if (encryptedMessage.charAt(i) - shift < 'a') {
                    decryptedMessage += (char) ('z' - ('a' - (encryptedMessage.charAt(i) - shift) - 1));
                } else {
                    decryptedMessage += (char) (encryptedMessage.charAt(i) - shift);
                }
            } else if ((encryptedMessage.charAt(i) <= 'Z') && (encryptedMessage.charAt(i) >= 'A')) {
                if (encryptedMessage.charAt(i) - shift < 'A') {
                    decryptedMessage += (char) ('Z' - ('A' - (encryptedMessage.charAt(i) - shift) - 1));
                } else {
                    decryptedMessage += (char) (encryptedMessage.charAt(i) - shift);
                }
            } else {
                decryptedMessage += encryptedMessage.charAt(i);
            }

        }
        return decryptedMessage;
    }

    /**
     * 
     * @param encryptedMessage message that needs to be decrypted, key is not needed as decryption is done with brute force
     * @return decrypted message
     */
    public static String[] breakCode(String encryptedMessage) {
        String[] results = new String[26];
        String[] commonPhrases = {"time", "person ", "year ", "way ", "day ", "thing", "man",
            "world", "life", "hand", "part", "child", "eye", "woman", "place", "work", "week", "case",
            "point", "government", "company", "number", "group", "problem", "fact", "be", "have", "do",
            "say", "get", "make", "go", "know", "take", "see", "come", "think", "look", "want", "give", "use",
            "find", "tell", "ask", "work", "seem", "feel", "try", "leave", "call", "good", "new", "first",
            "last", "long", "great", "little", "own", "other", "old", "right", "big", "high", "different",
            "small", "large", "next", "early", "young", "important", "few", "public", "bad", "same", "able",
            "to", "of", "in", "for", "on", "with", "at", "by", "from", "up", "about", "into", "over", "after",
            "the", "and", "a", "that", "I", "it", "not", "he", "as", "you", "this", "but", "his", "they", "her",
            "she", "or", "an", "will", "my", "one", "all", "would", "there", "their"
        };
        String[] decrypted = new String [26];
        for (int i = 0; i < 26; i++) {
            results[i] = decode(encryptedMessage, i);
            String[] compare = results[i].split(" ");
            for (int j = 0; j < compare.length; j++) {
                for (int l = 0; l < commonPhrases.length; l++) {
                    if (compare[j].equalsIgnoreCase(commonPhrases[l])) {
                        for (int k = 0; k < compare.length; k++) {
                            decrypted[i] += compare[k] + " ";
                        }

                    }
                }
            }
            if(decrypted[i]!=null)
                     decrypted[i]=decrypted[i].substring(4,encryptedMessage.length()+4);
        }

        return decrypted;
    }
}
