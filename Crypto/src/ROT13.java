import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
    Character cs;
    Character cf;

    ROT13(Character cs, Character cf) {
        this.cs = cs;
        this.cf = cf;
    }

    ROT13() {
    }

    /**
     * encryption by subtracting the base character from the current character (c - base), adding 13 (which is half of 26, the number of letters in the English alphabet),
     * taking the result modulo 26 to ensure the result stays within the range of the alphabet, and then adding back the base character to get the final encrypted character.
     * This logic effectively shifts each letter by 13 positions in the alphabet, wrapping around if needed.
     * @param text
     * @return
     * @throws UnsupportedOperationException
     */
    public String crypt(String text) throws UnsupportedOperationException {
        //to store encrypted text
        StringBuilder sb = new StringBuilder();
        //iterate each character in the text
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            //For each character, it checks if it's a lowercase letter between 'a' && 'm' or'A' && 'M'.
            // If so, it adds 13 to its ASCII value to get the corresponding letter after rotating by 13 places.
            if(c >= 'a' && c <= 'm' || c >= 'A' && c <= 'M') {
                c += 13;
            }
            //If the character is between 'n' && 'z', it subtracts 13 to get the corresponding letter after rotating by 13 places.
            else if(c >= 'n' && c <= 'z' || c >= 'N' && c <= 'Z' ) {
                c -= 13;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public String encrypt(String text) {
        return crypt(text);
    }

    public String decrypt(String text) {
        return crypt(text);
    }

    public static String rotate(String s, Character c) {
        int index =0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == c){
                index = i;
                break;
            }
        }
        return s.substring(index) + s.substring(0, index);
    }
    // read the file
    public void printFile() {
        try {
            Scanner file = new Scanner("/Users/angelina/Desktop/Projects/SimpleCrypt/sonnet18.txt");
            PrintWriter printWriter = new PrintWriter("/Users/angelina/Desktop/Projects/SimpleCrypt/sonnet18.enc");

            while(file.hasNext()){
                String line = file.nextLine();
                String print = encrypt(line);
            }
            printWriter.close();
        } catch (IOException e) {
            System.out.println("Not found");;
        }
    }

}
