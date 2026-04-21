package com.eliasmeyer.bioinfo.stringalgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindingAMotifInDNA {

	private String s;
	private String t;

	static void main(String[] args) throws IOException {
		FindingAMotifInDNA processor = new FindingAMotifInDNA();
		processor.readAndProcessInput();
	}

	public void readAndProcessInput() throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			s = reader.readLine().trim();
			t = reader.readLine().trim();
		}
		System.out.println(findMotifPositions(s, t));
	}

	private String findMotifPositions(String s, String t) {
		StringBuilder out = new StringBuilder();
		int from = 0;
		int idx;

		while ((idx = s.indexOf(t, from)) >= 0) {
			if (out.length() > 0) {
				out.append(' ');
			}
			out.append(idx + 1); // Rosalind usa índice 1-based
			from = idx + 1;      // permite sobreposição
		}

		return out.toString();
	}

}
