package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String filePath = "/Users/darksho/Desktop/LaunchCode/Projects/Java/Java Practice/CountingCharacters/src/com/company/file.txt";
        String text = getStringFromFile(filePath);
        countChars(text);

    }

    public static String getStringFromUser() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string");
        String userString = input.nextLine().toLowerCase();
        // make the input string all lowercase
        //userString = userString.toLowerCase();
        input.close();
        return userString;

    }

    public static String getStringFromFile(String filePath) {
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            String data = "";
            while (myReader.hasNextLine()) {
                data += myReader.nextLine();

            }
            myReader.close();
            return data;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }
    public static void countChars(String text) {
        // Create a hash map where key is the char and count is the value for that key
        HashMap<Character, Integer> charToCount = new HashMap<>();
        // In for loop, check if 'c' is in hash map
        for(char c : text.toCharArray()){
            if (!Character.isLetter(c)) {
                continue;
            }
            //System.out.println(c);
            // if not enter in to hash map w/ value of 1
            if (!charToCount.containsKey(c)) {
                charToCount.put(c,1);
                // if it is increment by 1
            } else {
                int count = charToCount.get(c) + 1;
                charToCount.put(c, count);
            }
            // loop through the data structure to print results
        }
        // For loop for printing hash map key/values
        for (Map.Entry <Character, Integer> charCount : charToCount.entrySet()) {
            System.out.println(charCount.getKey() + " : " + charCount.getValue());
        }

    }
}

