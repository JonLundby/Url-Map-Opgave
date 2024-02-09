package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UrlReader {

    // Method for reading how many times a word, from a list of words, appear
    public static Map<String, Integer> readUrl(String urlString, List<String> words) {

        // Creating new HashMap/hash table to store key:value pairs
        Map<String, Integer> mapWords = new HashMap<>();

        // Populating the mapWords Map with words from passed list of words and setting count(value) as default 0
        for (String s: words) {
            mapWords.put(s, 0);
        }

        try {
            // Creating a new URL with the URL string passed from readUrl method
            URL url = new URL(urlString);
            try {
                // Opening URL connection, getting input stream and reading it with bufferedReader
                URLConnection urlConnection = url.openConnection();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                // declaring an empty string
                String line = "";
                // while loop that loops until string "line" is null which is when "line = bufferedReader.readLine()" has no more to read.
                while (line != null) {
                    // Making sure characters in line is set to lowercase (and printing the lines)
                    String lineToLower = " " + line.toLowerCase() + " ";
                    System.out.println(lineToLower);

                    // For every word to search, split line into array and update/put new value of arr.length + 1
                    // to mapped key/word
                    for (String word: words) {
                        String[] arr = lineToLower.split(word);
                        if (arr.length > 1) {
                            int count = 0;
                            count = mapWords.get(word) + (arr.length - 1);
                            mapWords.put(word, count);
                        }
                    }
                    // Reading next line
                    line = bufferedReader.readLine();
                }
            // Exceptions and error messages
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } catch (MalformedURLException e) {
            System.out.println("Not able to read URL: " + e.getMessage());
        }

        return mapWords;
    }

    public Map<String, Map<String, Integer>> readUrls(List<String> urls, List<String> words) {
        Map<String, Map<String, Integer>> mapUrlWords = new HashMap<>();
        for (String url: urls) {
            Map<String, Integer> mapWordsInner = new HashMap<>();
            mapWordsInner = this.readUrl(url, words);
            mapUrlWords.put(url, mapWordsInner);
        }

        return mapUrlWords;
    }

}
