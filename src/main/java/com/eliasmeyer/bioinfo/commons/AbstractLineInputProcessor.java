package com.eliasmeyer.bioinfo.commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public abstract class AbstractLineInputProcessor {

	public void readAndProcessInput() throws IOException {
		String line;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			while (Objects.nonNull(line = reader.readLine()) && !line.isEmpty()) {
				processLine(line);
			}
		}
		printResult();
	}

	protected abstract void processLine(String line);

	protected abstract void printResult();

}
