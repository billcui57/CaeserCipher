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
        while(true){
            String message = input.nextLine().toLowerCase();
            System.out.println(encode(message,2));
            
        }
    }
    
    public static String encode(String message,int key){
        String encryptedMessage="";
        int shift = key%26;
        for(int i=0;i<message.length();i++){
            if((message.charAt(i))+key>='z'){
                encryptedMessage+=(char)((message.charAt(i)-'z')%26+key+'a');
            }else{
                encryptedMessage+=(char)(message.charAt(i)+key);
            }
        }
        return encryptedMessage;
    }
    
    
    

    public static String decode(String encryptedMessage,int key){
        String decryptedMessage="";
        int shift = key%26;
        for(int i=0;i<encryptedmessage.length();i++){
            if((message.charAt(i))+key>='z'){
                encryptedMessage+=(char)((message.charAt(i)-'z')%26+key+'a');
            }else{
                encryptedMessage+=(char)(message.charAt(i)+key);
            }
        }
        return encryptedMessage;
    }
    
}
