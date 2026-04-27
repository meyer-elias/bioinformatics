package com.eliasmeyer.algorithms.stringalgorithms;

import com.eliasmeyer.algorithms.commons.AbstractLineInputProcessor;
import com.eliasmeyer.bio.molecule.nucleicacid.dna.DNA;
import java.io.IOException;

/*
	https://rosalind.info/problems/revc/
	Complementing a Strand of DNA
	In DNA strings, symbols 'A' and 'T' are complements of each other, as are 'C' and 'G'.
	The reverse complement of a DNA string s is the string sc formed by reversing the symbols of s, then taking the complement of each symbol (e.g., the reverse complement of "GTCA" is "TGAC").

	Given: A DNA string s of length at most 1000 bp.
	Return: The reverse complement sc of s.
 */
public class ComplementingStrandOfAbstractCharInput extends AbstractLineInputProcessor {

	DNA dna;

	static void main() throws IOException {
		ComplementingStrandOfAbstractCharInput processor = new ComplementingStrandOfAbstractCharInput();
		processor.readAndProcessInput();
	}

	@Override
	protected void processLine(String line) {
		dna = new DNA(line);
	}

	@Override
	protected void printResult() {
		dna.complementary().reverse().forEach(IO::print);
		IO.println();
	}
}
