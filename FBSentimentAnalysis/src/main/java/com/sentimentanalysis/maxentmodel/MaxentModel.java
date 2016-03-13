package com.sentimentanalysis.maxentmodel;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sentimentanalysis.GetFile;

public class MaxentModel {
    
    private Map<String, Double> SentimentProbabilitiesMap; 
    private String bestOutcome;    
    private String[] sentiments;
    private String fileFormat;

    public MaxentModel() {
    }
    
    public MaxentModel(String[] sentiments, String fileFormat) {
        this.sentiments = sentiments;
        this.fileFormat = fileFormat;
    }
    
    public void eval(List<String> featureVector) {
    	if (featureVector == null) {
    		bestOutcome = null;
        	return;
    	}
        double[] weights = getModelWeights(featureVector);
        //if weights are equal, return
        if (weights[0] == weights[1] ||
        		weights[0] == weights[2] ||
        		weights[1] == weights[2]) {
        	bestOutcome = null;
        	return;
        }
        
        SentimentProbabilitiesMap = new HashMap<>();
        double[] exponents = new double[3];
        int index = 0;
        double denominator = 0.0f;
        for(double weight: weights) {
            exponents[index] = Math.exp(weight);
            denominator += exponents[index];
            index++;
        }
        index = 0;
        double maxProbability = exponents[index] / denominator;
        bestOutcome = sentiments[index];
        double outcomeProbability;
        for(double exponent: exponents) {            
            outcomeProbability = exponent / denominator;
            SentimentProbabilitiesMap.put(sentiments[index], outcomeProbability);
            if(outcomeProbability > maxProbability) {
                maxProbability = outcomeProbability;
                bestOutcome = sentiments[index];
            }
            index++;
        }
        
    }
   
    public double[] getModelWeights(List<String> featureVector) {
        double sentimentSum;      // sum of each sentiment       
        double[] weights = new double[3];
        int weightsIndex = 0;
/*        System.out.print("\t\t");
        for (String feature : featureVector) {
            System.out.print(feature + "\t");
        }
        
        System.out.println();*/
        for (String sentiment : sentiments) {            
            sentimentSum = 0;
//            System.out.print(sentiment + "\t");
            for (String feature : featureVector) {
                double count = countStringInFile(feature, sentiment + fileFormat);
                sentimentSum += count;
//                System.out.print(getRoundOffDouble(count) + "\t");
            }
//            System.out.println("\t" + getRoundOffDouble(sentimentSum));
            weights[weightsIndex++] = getRoundOffDouble(sentimentSum);       
//            System.out.println();
        }
        
        return weights;        
    }
    
    public double countStringInFile(String stringToLookFor, String fileName) {
        int count = 0;
        double totalWordsCount = 0;
        if(stringToLookFor == null || stringToLookFor.isEmpty())
            return 0.0f;
        try {
        	File file = GetFile.instance.getFile(fileName);
            FileInputStream fstream = new FileInputStream(file);            
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            stringToLookFor = " " + stringToLookFor + " ";
            while ((strLine = br.readLine()) != null) {
                if (Character.isDigit(strLine.charAt(0))) {
                    totalWordsCount = Integer.parseInt(strLine);
                    break;
                }
                int startIndex = strLine.indexOf(stringToLookFor);
                while (startIndex != -1) {
                    count++;
                    startIndex = strLine.indexOf(stringToLookFor,
                            startIndex + stringToLookFor.length());
                }
            }
            
            in.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Error: " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        } 
        if(totalWordsCount != 0)
            return (double) count / (double) totalWordsCount;
        return 0.0f;
    }
    
    private double getRoundOffDouble(double value) {
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.HALF_EVEN);
        return Double.parseDouble(df.format(value));
    }

    public String[] getSentiments() {
        return sentiments;
    }

    public void setSentiments(String[] sentiments) {
        this.sentiments = sentiments;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public Map<String, Double> getSentimentProbabilitiesMap() {
        return SentimentProbabilitiesMap;
    }

    public String getBestOutcome() {
        return bestOutcome;
    }
    
    

}
