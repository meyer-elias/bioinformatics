package com.eliasmeyer.bioinfo.stringalgorithms;

import com.eliasmeyer.bioinfo.commons.AbstractCharInputProcessor;
import java.io.IOException;

/*
	https://rosalind.info/problems/rna/

	An RNA string is a string formed from the alphabet containing 'A', 'C', 'G', and 'U'.
	Given a DNA string t corresponding to a coding strand, its transcribed RNA string u is formed by replacing all occurrences of 'T' in t with 'U' in u.

	Given: A DNA string t having length at most 1000 nt.
	Return: The transcribed RNA string of t.
 */
public class TranscribingDNAintoRNA extends AbstractCharInputProcessor {

	StringBuffer rna = new StringBuffer();

	static void main() throws IOException {
		TranscribingDNAintoRNA processor = new TranscribingDNAintoRNA();
		processor.readAndProcessInput();
		processor.printResult();
	}

	@Override
	protected void printResult() {
		IO.println(rna.toString());
	}

	@Override
	protected void processChar(char c) {
		rna.append(c == 'T' ? 'U' : c);
	}
}
