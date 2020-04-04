package com.preisinger.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class FileStore {

	public static final String DEFAULT_DIR = "./output/";

	public void write(final String fileName, String dir, final String content) {
		if(fileName == null || content == null){
			throw new IllegalArgumentException("fileName and content must not be null");
		}

		if(dir != null){
			new File(dir).mkdirs();
		} else {
			new File(DEFAULT_DIR).mkdirs();
			dir = DEFAULT_DIR;
		}
		String path = dir + fileName;

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(new File(path)));
		    out.write(content);
		    out.close();
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
}