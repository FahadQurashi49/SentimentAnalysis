package com.sentimentanalysis.classification;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.sentimentanalysis.GetFile;

public class ClassifyFeatures {
    
    public static ArrayList<String> getFeatureVector (String comment) {
        
        if(comment == null || comment.isEmpty())
            return null;
        
        ArrayList<String> featureVector = new ArrayList<>();
        String[] words = comment.split(" ");
        File file = GetFile.instance.getFile("/stop_words.txt");
        Set<String> stopWordList = GetStopWordList(file);
        
        for(String word : words) {
            //1 removes repeating letters like hungryyyyyyyyyy to hungry
            word = word.replaceAll("([a-zA-Z])(\\1{2,})", "$1");           
            //2 remove punctuation
            word = word.replaceAll("\\p{Punct}+", "");
            //3,4 remove stop words and words that starts with number
            if(word != null && !word.isEmpty() && !stopWordList.contains(word) && !Character.isDigit(word.charAt(0))) {
                featureVector.add(word);
            }
                
        }        
        
        return featureVector;
    }
    
    private static Set<String> GetStopWordList(File theFile) {
        Set<String> stopWordsList = null;        
        try {
            stopWordsList = new HashSet<>(Arrays.asList(new Scanner(theFile).useDelimiter("\\Z").next().split("\r\n")));
        } catch (FileNotFoundException e) {
            System.out.println("exception: " + e.getMessage());
        }
        return stopWordsList;
    }

}
