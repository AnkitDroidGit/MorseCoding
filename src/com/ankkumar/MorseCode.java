package com.ankkumar;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class MorseCode {

    private static String[] code = new String[36];
    private static char[] alphaNum = new char[36];

    // Not to be used
    private MorseCode() {
    }

    /**
     * Translates a string to a morse string
     * @param toTranslate the string to translate
     * @return the translated string
     */
    public static String translate(String toTranslate) {

        StringBuilder result = new StringBuilder();

        // loop over all chars in the string, skipping spaces etc...
        for (char c : toTranslate.toCharArray() ) {
            if(Character.compare(c, ' ') == 0) {
                result.append('\n');
                continue;
            }

            result.append(letterToMorse(c));
            result.append(' ');
        }

        return result.toString();
    }

    /**
     * Translates a char to a morse string
     * @param c the char to translate
     * @return the equivalent morse code version
     */
    private static String letterToMorse(char c) {
        for (int i = 0; i < alphaNum.length ; i++ ) {
            if(alphaNum[i] == Character.toUpperCase(c)) {
                return code[i];
            }
        }

        return "";
    }

    // At first use, loads the translation table
    static {
        try {
            Scanner inCode = new Scanner(new File( MorseCode.class.getResource("morsecode.txt").getFile()));
            Scanner inAlphaNum = new Scanner (new File( MorseCode.class.getResource("alphanum.txt").getFile()));

            //for loop that loads values in morsecode.txt to the code string array.
            for(int k = 0; inCode.hasNextLine(); k++) {
                code[k] = inCode.nextLine();
            }

            //for loop that loads values in morsecode.txt to the alphaNum char array.
            for(int j = 0; inAlphaNum.hasNextLine(); j++) {
                alphaNum[j] = inAlphaNum.nextLine().charAt(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
            //TODO proper handling
        }
    }
}
