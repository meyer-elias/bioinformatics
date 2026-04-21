package com.eliasmeyer.bioinfo.stringalgorithms;

import com.eliasmeyer.bioinfo.commons.AbstractCharInputProcessor;
import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/*
	https://rosalind.info/problems/dna/

	A string is simply an ordered collection of symbols selected from some alphabet and formed into a word; the length of a string is the number of symbols that it contains.
	An example of a length 21 DNA string (whose alphabet contains the symbols 'A', 'C', 'G', and 'T') is "ATGCTTCAGAAAGGTCTTACG."

	Given: A DNA string s of length at most 1000 nt.
	Return: Four integers (separated by spaces) counting the respective number of times that the symbols 'A', 'C', 'G', and 'T' occur in s
*/
public class CountingAbstractCharInputNucleotides extends AbstractCharInputProcessor {

	private static final Map<String, Integer> frequence = new TreeMap<>(Comparator.naturalOrder());

	static void main() throws IOException {
		CountingAbstractCharInputNucleotides processor = new CountingAbstractCharInputNucleotides();
		processor.readAndProcessInput();
		processor.printResult();
	}

	@Override
	protected void processChar(char c) {
		frequence.compute(String.valueOf(c), (k, v) -> v == null ? 1 : v + 1);
	}

	@Override
	protected void printResult() {
		frequence.forEach((s, n) -> IO.print(n + " "));
		IO.println();
	}
}
