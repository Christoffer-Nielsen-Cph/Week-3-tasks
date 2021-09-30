import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner scan;
    private static String[] text;
    private static char[] chars;
    private static char myChar;
    private static int timesFound;
    private static int maxNum;


    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("data.txt");
        scan = new Scanner(file);

        String inputFromFile = "";

        while (scan.hasNextLine())                                // checks if theres more lines in the file
        {
            inputFromFile += scan.nextLine();                     // adds each line to the inputFromFile string.
        }

        text = inputFromFile.split(" ");
        String lowerCaseInput = inputFromFile.toLowerCase();
        chars = lowerCaseInput.toCharArray();


        // Creates and array of strings, where each element is a single word from the file.

        // System.out.println(text.length);

        // printWordsStartingWith("Ø");

        // printWordsOfLength(3);

        //test dine metoder ved at kalde dem her:

        // printLongestWord(text);
        // printFirstHalfOfEachWord(text);
        printMostFrequentLetter();
        printLessFrequentLetter();


    }

    private static void printWordsOfLength(int l) {
        boolean wordisvalid = true;

        for (String s : text) {
            if (s.length() == l) {
                if (s.contains(",") || s.contains(".")) {
                    wordisvalid = false;
                }

                if (wordisvalid) {
                    System.out.println(s);
                }
            }
        }
    }

    private static void printWordsStartingWith(String pattern) {
        for (String s : text) // for each word in text
        {
            if (s.startsWith(pattern) || s.startsWith(pattern.toLowerCase())) {
                System.out.println(s);
            }
        }
    }

    //skriv dine metoder herunder:
    private static void printLongestWord(String[] text) {

        Arrays.sort(text, Comparator.comparing(String::length));
        System.out.println(text[text.length - 1]);

    }


    private static void printFirstHalfOfEachWord(String[] text) {

        int beginIndex = 0;
        int endIndex;

        for (String s : text) {
            endIndex = s.length() / 2;
            System.out.println(s.substring(beginIndex, endIndex));
        }
    }

    private static void printMostFrequentLetter() {

        for(int i=1;i<chars.length;i++){
            timesFound = 0;
            for(int j=0;j<chars.length;j++){
                if(chars[i] == chars [j]){
                    timesFound = timesFound + 1;
                }
                if(Character.isWhitespace(chars[i])){
                    timesFound = timesFound -1;
                }
                if(timesFound>maxNum){
                    maxNum = timesFound;
                    myChar = chars[i];
                }
            }
        }
        System.out.println("The most frequent letter is: "+myChar+" and it occurs "+maxNum+" times");
        }
    private static void printLessFrequentLetter(){
        for(int i=1;i<chars.length;i++){
            timesFound = 0;
            for(int j=0;j<chars.length;j++){
                if(chars[i] == chars [j]){
                    timesFound = timesFound + 1;
                }
                if(Character.isWhitespace(chars[i])){
                    timesFound = timesFound -1;
                }
                if(timesFound<maxNum&& maxNum>=1){
                  maxNum = timesFound;
                  myChar = chars[i];
                }
            }
        }
        System.out.println(maxNum);
    }

    }






