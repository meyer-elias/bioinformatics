package com.eliasmeyer.algorithms.commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public abstract class AbstractCharInputProcessor {

	public void readAndProcessInput() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line;

		while (Objects.nonNull(line = reader.readLine()) && !line.isEmpty()) {
			for (int i = 0; i < line.length(); i++) {
				processChar(line.charAt(i));
			}
		}
		reader.close();
		printResult();
	}

	protected abstract void processChar(char c);

	protected abstract void printResult();

}
