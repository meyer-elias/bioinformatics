package com.eliasmeyer.algorithms.alignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
	https://rosalind.info/problems/hamm/

	Given two strings s and t of equal length, the Hamming distance between s and t, denoted dH(s,t),
 	is the number of corresponding symbols that differ in s and t

	Given: Two DNA strings s and t of equal length (not exceeding 1 kbp).
	Return: The Hamming distance dH(s,t)
 */
public class CountingPointMutations {

	private final StringBuilder s = new StringBuilder();
	private final StringBuilder t = new StringBuilder();

	static void main() throws IOException {
		CountingPointMutations processor = new CountingPointMutations();
		processor.readAndProcessInput();
	}

	public void readAndProcessInput() throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			s.append(reader.readLine().trim());
			t.append(reader.readLine().trim());
		}

		IO.println(hammingDistance());
	}

	private long hammingDistance() {
		long distance = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != t.charAt(i)) {
				distance++;
			}
		}
		return distance;
	}
}
