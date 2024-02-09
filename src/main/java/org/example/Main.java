package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello world...");

        String url = "https://www.ekstrabladet.dk/";
//        String url = "https://example.com/";
        List<String> words = Arrays.asList("</h2>", "</h4>", "</form>", "fodbold", "krig", "nyheder", "</svg>");
//        List<String> words = Arrays.asList("h1", "this", "header", "example");

        UrlReader urlReader = new UrlReader();
        Map<String, Integer> mappedWordsFound = urlReader.readUrl(url, words);
        mappedWordsFound.forEach((key, value) -> System.out.println("Ordet: \"" + key + "\" forekommer " + value + " antal gange."));

    }
}