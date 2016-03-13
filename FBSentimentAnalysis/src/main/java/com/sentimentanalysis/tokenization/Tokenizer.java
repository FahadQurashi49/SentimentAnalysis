package com.sentimentanalysis.tokenization;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer implements TokenizationRegex{
    
    private static String tokenizedComment;
   
    public static String tokenize(String comment) {        
        tokenizedComment = comment;
        // lower case and trims the string
        tokenizedComment = tokenizedComment.toLowerCase().trim();
        addSpacesAfterPunctuations();
        //replace URLs,whitespaces,Hashtags,@, with their corresponding replacers
        //See RegexReplacerMap declaration
        for (String[] regex: RegexReplacerMap) {
            replaceAllMatch(regex[0], regex[1]);
        }
        
        return tokenizedComment;
    }
    
    private static void replaceAllMatch(String regex, String replace) {
       Pattern pattern = Pattern.compile(regex);
       Matcher matcher = pattern.matcher(tokenizedComment);
       
       tokenizedComment = matcher.replaceAll(replace);
    }
    private static void addSpacesAfterPunctuations() {
        ArrayList<Integer> positions = new ArrayList<Integer>();
        Pattern p = Pattern.compile("[,.!?;:]");  
        Matcher m = p.matcher(tokenizedComment);
        while (m.find()) {
            positions.add(m.start());
        }
        for(Integer position: positions) {
            if(position + 1 < tokenizedComment.length()) {
                if(Character.isLetterOrDigit(tokenizedComment.charAt(position + 1))) {
                    tokenizedComment =  tokenizedComment.substring(0, position+1) + " " +
                            tokenizedComment.substring(position+1, tokenizedComment.length());
                }
            }
                
        }
    }
}
