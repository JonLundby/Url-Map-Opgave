package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

//        String url = "https://www.ekstrabladet.dk/";
//        List<String> words = Arrays.asList("</h2>", "</h4>", "</form>", "fodbold", "krig", "nyheder", "</svg>");
//        String url = "https://example.com/";
//        List<String> words = Arrays.asList("h1", "this", "header", "example");

        List<String> urls = Arrays.asList("https://www.ekstrabladet.dk/", "https://example.com/");
        List<String> words = Arrays.asList("</h2>", "</h4>", "</form>", "h1", "this", "example", "nyheder", "</svg>");

        UrlReader urlReader = new UrlReader();
//        Map<String, Integer> mappedWordsFound = urlReader.readUrl(url, words);
        // Timer start
        long startTime = System.currentTimeMillis();
        Map<String, Map<String, Integer>> urlsMap = urlReader.readUrls(urls, words);
        urlsMap.forEach((key, mapWordsInner) -> {
            System.out.print("På \"" + key + "\" forekommer ordet \n");
            mapWordsInner.forEach((word, count) -> System.out.println("\"" + word + "\" " + count + " antal gange."));
        });

        // Timer end and print to console
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Operation complete in: " + elapsedTime + "ms");

    }
}
