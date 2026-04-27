package com.eliasmeyer.algorithms.commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class AbstractStreamingFastaInputProcessor {

	public final void readAndProcessInput() throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			streamFasta(reader);
			printResult();
		}
	}

	private void streamFasta(BufferedReader reader) throws IOException {
		String currentHeader = null;
		StringBuilder currentSequence = new StringBuilder();

		String line;
		while ((line = reader.readLine()) != null) {
			line = line.trim();
			if (line.isEmpty()) {
				continue;
			}

			if (line.startsWith(">")) {
				if (currentHeader != null) {
					onRecord(currentHeader, currentSequence.toString());
				}
				currentHeader = line.substring(1).trim();
				currentSequence.setLength(0);
			} else {
				currentSequence.append(line);
			}
		}

		if (currentHeader != null) {
			onRecord(currentHeader, currentSequence.toString());
		}
	}

	protected abstract void onRecord(String header, String sequence);

	protected abstract void printResult();
}
