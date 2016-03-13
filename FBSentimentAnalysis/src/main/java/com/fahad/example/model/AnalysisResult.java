package com.fahad.example.model;

public class AnalysisResult {
	private long positiveCount;
	private long negativeCount;
	private long neutralCount;
	
	public AnalysisResult() {
		super();	
	}
	
	public AnalysisResult(long positiveCount, long negativeCount,
			long neutralCount) {
		super();
		this.positiveCount = positiveCount;
		this.negativeCount = negativeCount;
		this.neutralCount = neutralCount;
	}
	
	public void incrementSentimentCount (String sentiment) {
		switch (sentiment) {
		case "positive":
			positiveCount++;
			break;
		case "negative":
			negativeCount++;
			break;
		case "neutral":
			neutralCount++;
			break;
		}
	}

	public long getPositiveCount() {
		return positiveCount;
	}
	public void setPositiveCount(long positiveCount) {
		this.positiveCount = positiveCount;
	}
	public long getNegativeCount() {
		return negativeCount;
	}
	public void setNegativeCount(long negativeCount) {
		this.negativeCount = negativeCount;
	}
	public long getNeutralCount() {
		return neutralCount;
	}
	public void setNeutralCount(long neutralCount) {
		this.neutralCount = neutralCount;
	}
}
