package com.ankkumar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ArrayMorseCode {
    public static Scanner sc;

    public static void main(String[] args) throws IOException  //Input Output Exception is added to cover the BufferedReader
    {
        int option = 0;
        String sentence = "", answer = "", answer1 = "";
        char[] english = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
                'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
                ',', '.', '?'};   //Defining a Character Array of the English Letters numbers and Symbols so that we can compare and convert later

        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                "-----", "--..--", ".-.-.-", "..--.."};  //Defining an Array of String to hold the Morse Code value of Every English Letter,Number and Symbol in the same order as that of the character Array
        sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(">>>>Welcome to MorseCode Software<<<<");
        System.out.println("");
        do {
            System.out.println("-->Enter the Option Corresponding to the Task you want to Perform ");
            System.out.println("1.Generate Morse Code.\n2.Generate English Language\n3.Exit ");
            System.out.print("->");
            while (!sc.hasNextInt())  //Repeat Until the next Item is an Integer i.e Until the Next Item is an Integer Keep on Repeating it
            {//NOTE- The hasnext() function is also used when we are using the Iterator where the next input is always checked and then if it is valid it is allowed to be entered
                System.out.println("");
                System.err.println("-->ERROR<-->Enter Digits Only<--");
                System.out.print("->");
                sc.next();   //Repeat and Discard the previous Inputs which are not valid
            }
            option = sc.nextInt();
            switch (option) {
                case 1 -> {
                    System.out.println("");
                    System.out.println("-->Enter the Sentence that you want to Transmit Using the Morse Code ");
                    System.out.print("->");
                    sentence = br.readLine();
                    System.out.println("");
                    sentence = sentence.toLowerCase(); //Because morse code is defined only for the lower case letters and the numbers and the Symbols will remain the Same
                    char[] morsec = sentence.toCharArray();
                    //The loop will run till i is less than the number of characters in the Sentence because Every Character needs to Be Converted into the Respective Morse Code
                    for (char c : morsec) {//For Every Letter in the User Input Sentence
                        for (int j = 0; j < english.length; j++)   //For Every Character in the morsec array we will have to traverse the entire English Array and find the match so that it can be represented
                        {
                            if (english[j] == c)  //If the Character Present in English array is equal to the character present in the Morsec array then Only Execute
                            {//Always remember that the condition in the Inner loop will be the first to be Equated in the If Statement because that will change until the characters match
                                answer = answer + morse[j] + " ";  //After Every Letter is generated in the Morse Code we will give a Space
                            }  //Since the Letters in the English char and the symbols present in the morse array are at the Same Index
                        }
                    }
                    System.out.println("-->The Morse Code Translation is:- ");
                    System.out.print(">> ");
                    System.out.println(answer);
                    System.out.println("");
                }
                case 2 -> {
                    System.out.println("");
                    System.out.println("-->Enter the Morse Code and After Every Letter add Space in Between ");
                    System.out.print("-> ");
                    sentence = br.readLine();
                    System.out.println("");
                    String[] morsec = sentence.split(" ");   //To use the split function to Convert Every Morse Code String as a Separate Entry in the STring array
                    for (String s : morsec) {//For Every morse code Letter Entered
                        //Remember - We are Splitting on the Basis of the space
                        for (int j = 0; j < morse.length; j++) {
                            if (morse[j].equals(s))  //When you are comparing the String you have to Do this and not ==
                            {
                                answer1 = answer1 + english[j];  //Since the characters in the Morse array and the English Array are in the Same Index
                            }
                        }
                    }
                    System.out.println("-->The English Language Translation is:- ");
                    System.out.print(">> ");
                    System.out.println(answer1);
                    System.out.println("");
                }
                case 3 -> {
                    System.out.println("");
                    System.out.println(">>Thank you For Using this Service<<");
                    System.out.println("");
                }
                default -> {
                    System.err.println("-->ERROR<-->Invalid Option Entered<--");
                    System.out.println("");
                }
            }
        }
        while (option != 3);
    }
}
