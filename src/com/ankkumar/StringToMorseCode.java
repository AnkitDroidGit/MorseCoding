package com.ankkumar;

import java.util.Scanner;

public class StringToMorseCode {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        char[] letters = { ' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
        String[] morseLetters = { "    ", ". ___", "___ . . .", "___ . ___ .", "___ . .", ".", ". . ___ .", "___ ___ .", ". . . .", ". .", ". ___ ___ ___", "___ . ___", ". ___ . .",  "___ ___", "___ .", "___ ___ ___", ". ___ ___ .", "___ ___ . ___", ". ___ .", ". . .", "_", ". . ___", ". . . ___", ". ___ ___", "___ . . ___", "___ . ___ ___", "___ ___ . .", ". ___ ___ ___ ___", ". . ___ ___ ___", ". . . ___ ___", ". . . . ___", ". . . . .", "___ . . . .", "___ ___ . . .", "___ ___ ___ . .", "___ ___ ___ ___ .", "___ ___ ___ ___ ___"};

        String textToChange = "";
        StringBuilder newText = new StringBuilder();
        System.out.println("Enter text you want to change to Morse code");
        textToChange = input.nextLine();

        textToChange = textToChange.toLowerCase();

        for (int i = 0; i < textToChange.length(); i++) {
            for (short j = 0; j < 37; j++) {
                if (textToChange.charAt(i) == letters[j]) {
                    newText.append(morseLetters[j]);
                    newText.append("   ");
                    break;
                }
            }
        }

        System.out.println("Text in Morse Code");
        System.out.println(newText);
    }
}