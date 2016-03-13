package com.fahad.example.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fahad.example.model.AnalysisResult;
import com.fahad.example.model.Comment;
import com.sentimentanalysis.classification.ClassifyFeatures;
import com.sentimentanalysis.maxentmodel.MaxentModel;
import com.sentimentanalysis.tokenization.Tokenizer;

@Controller
public class SentimentAnalysisController {
	
	private static final String[] SENTIMENTS = {"positive", "negative", "neutral"};
    private static final String TRAINING_DATA_FILES_SUBSCRIPT = "_data";
    private static final String[] TrainingFileNames = {"positive_data", "negative_data", "neutral_data"};
    private static final String FILE_EXTENSION = ".txt";
    
    
	
	
	@RequestMapping(value="/performSentimentAnalysis", method=RequestMethod.POST)
	public @ResponseBody AnalysisResult performSentimentAnalysis (@RequestBody ArrayList<Comment> comments) {
		AnalysisResult analysisResult = null;
		if (comments != null && !comments.isEmpty()) {
			analysisResult = new AnalysisResult(0, 0, 0);
			for (Comment comment : comments) {
				MaxentModel maxentModel = new MaxentModel(SENTIMENTS,
						FILE_EXTENSION);
				maxentModel.eval(ClassifyFeatures.getFeatureVector(Tokenizer
						.tokenize(comment.getMessage())));
				String outcome = maxentModel.getBestOutcome();
				if (outcome != null) {
					analysisResult.incrementSentimentCount(outcome); 
					System.out.println(comment + " is " + outcome);
				} else {
					System.out.println(comment + " is: model can't decide");
				}
			}

		}
		return analysisResult;
	}
	
}
