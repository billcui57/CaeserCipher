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
            
                System.out.println(breakCode(message));
            

        }
    }

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

    public static String breakCode(String encryptedMessage) {
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
        String decrypted = "";
        for (int i = 0; i < 26; i++) {
            results[i] = decode(encryptedMessage, i);
            String[] compare = results[i].split(" ");
            for (int j = 0; j < compare.length; j++) {
                for (int l = 0; l < commonPhrases.length; l++) {
                    if (compare[j].equalsIgnoreCase(commonPhrases[l])) {
                        for (int k = 0; k < compare.length; k++) {
                            decrypted += compare[k] + " ";
                        }

                    }
                }
            }
        }

        return decrypted;
    }
}
