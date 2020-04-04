package com.preisinger.util;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class FileReader {

	private static final String DEFAULT_DIR = "C:\\Users\\johan\\Downloads\\";

	private void validateFile(final String fileName) throws IllegalArgumentException {
		if(fileName == null || fileName.length() == 0){
			throw new IllegalArgumentException("The filename is either null or empty");
		}
	}

	private String findDir(String dir){
		if(dir == null || dir.length() == 0){
			dir = DEFAULT_DIR;
		}

		return dir;
	}

	private Scanner openFile(final String fileName, final String dir) throws FileNotFoundException {
		File file = new File(dir + fileName);
		System.out.println(file.getAbsolutePath());
		return new Scanner(file);
	}

	public List<String> lineByLine(final String fileName, String dir) throws FileNotFoundException, IllegalArgumentException {
		validateFile(fileName);

		List<String> lines = new ArrayList<>();

		System.out.println("Reading a text file line by line: ");
		Scanner sc = openFile(fileName, findDir(dir));
		while (sc.hasNext()) {
			String str = sc.nextLine();
			lines.add(str);
		}
		sc.close();

		return lines;
	}

	public List<String> wordByWord(final String fileName, String dir) throws FileNotFoundException, IllegalArgumentException {
		validateFile(fileName);

		List<String> words = new ArrayList<>();

		System.out.println("Reading a text file word by word: ");
		Scanner sc = openFile(fileName, findDir(dir));
		while (sc.hasNext()) {
			String str = sc.next();
			words.add(str);
		}
		sc.close();

		return words;
	}

	public List<List<Integer>> matrix(final String fileName, String dir) throws FileNotFoundException, IllegalArgumentException {
		validateFile(fileName);

		List<List<Integer>> matrix = new ArrayList<>();

		System.out.println("Reading a text file as matrix: ");
		Scanner sc = openFile(fileName, findDir(dir));
		while (sc.hasNext()) {
			String str = sc.nextLine();
			String[] values = str.split(" ");

			List<Integer> columns = new ArrayList<>();
			for(int i = 0; i < values.length; i++){
				columns.add(Integer.parseInt(values[i]));
			}

			matrix.add(columns);
		}
		sc.close();

		return matrix;
	}
}