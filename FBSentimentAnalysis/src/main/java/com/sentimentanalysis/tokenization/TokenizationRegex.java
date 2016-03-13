package com.sentimentanalysis.tokenization;

public interface TokenizationRegex {
    /*
    * RegexReplacerMap mapped a regex to its replacer
    * contains Regex, Replacer pairs
    */    
    String[][] RegexReplacerMap = {
        {"((www\\.[^\\s]+)|(https?://[^\\s]+))", "URL"}, //URL Regex, and its replacer       
        {"[\\s]+", " "},                                 //Whitespace Regex, and its replacer
        {"@[^\\s]+", "AT_USER"},                         //@User Regex, and its replacer
        {"#", ""}                                        //HashTags Regex, and its replacer        
    };

}
