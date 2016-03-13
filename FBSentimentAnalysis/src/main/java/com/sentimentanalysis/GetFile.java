package com.sentimentanalysis;

import java.io.File;

public class GetFile {
	
	public static GetFile instance = new GetFile();
	
	public File getFile (String fileName) {
		//Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		return file;
	}
}
