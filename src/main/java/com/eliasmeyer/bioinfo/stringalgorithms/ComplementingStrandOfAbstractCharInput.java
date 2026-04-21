package com.eliasmeyer.bioinfo.stringalgorithms;

import com.eliasmeyer.bioinfo.commons.AbstractCharInputProcessor;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

/*
	https://rosalind.info/problems/revc/
	Complementing a Strand of DNA
	In DNA strings, symbols 'A' and 'T' are complements of each other, as are 'C' and 'G'.
	The reverse complement of a DNA string s is the string sc formed by reversing the symbols of s, then taking the complement of each symbol (e.g., the reverse complement of "GTCA" is "TGAC").

	Given: A DNA string s of length at most 1000 bp.
	Return: The reverse complement sc of s.
 */
public class ComplementingStrandOfAbstractCharInput extends AbstractCharInputProcessor {

	Deque<Character> rna = new ArrayDeque<>();

	static void main() throws IOException {
		ComplementingStrandOfAbstractCharInput processor = new ComplementingStrandOfAbstractCharInput();
		processor.readAndProcessInput();
		processor.printResult();
	}

	@Override
	protected void processChar(char c) {
		rna.push(getComplement(c));
	}

	@Override
	protected void printResult() {
		rna.forEach(IO::print);
	}


	private char getComplement(char c) {
		return switch (c) {
			case 'A' -> 'T';
			case 'G' -> 'C';
			case 'T' -> 'A';
			case 'C' -> 'G';
			default -> c;
		};
	}
}
