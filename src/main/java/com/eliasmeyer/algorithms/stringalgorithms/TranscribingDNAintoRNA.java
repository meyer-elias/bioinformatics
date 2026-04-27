package com.eliasmeyer.algorithms.stringalgorithms;

import com.eliasmeyer.algorithms.commons.AbstractLineInputProcessor;
import com.eliasmeyer.bio.molecule.nucleicacid.dna.DNA;
import com.eliasmeyer.bio.molecule.nucleicacid.rna.RNA;
import java.io.IOException;

/*
	https://rosalind.info/problems/rna/

	An RNA string is a string formed from the alphabet containing 'A', 'C', 'G', and 'U'.
	Given a DNA string t corresponding to a coding strand, its transcribed RNA string u is formed by replacing all occurrences of 'T' in t with 'U' in u.

	Given: A DNA string t having length at most 1000 nt.
	Return: The transcribed RNA string of t.
 */
public class TranscribingDNAintoRNA extends AbstractLineInputProcessor {

	private RNA rna;

	static void main() throws IOException {
		TranscribingDNAintoRNA processor = new TranscribingDNAintoRNA();
		processor.readAndProcessInput();
	}

	@Override
	protected void processLine(String line) {
		DNA dna = new DNA(line);
		rna = dna.transcribe();
	}

	@Override
	protected void printResult() {
		rna.sequence().forEach(System.out::print);
		IO.println();
	}
}
