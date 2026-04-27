package com.eliasmeyer.algorithms.stringalgorithms;

import com.eliasmeyer.algorithms.commons.AbstractStreamingFastaInputProcessor;
import com.eliasmeyer.algorithms.stringalgorithms.gc.Calculus;
import com.eliasmeyer.algorithms.stringalgorithms.gc.GCContent;
import java.io.IOException;
import java.math.BigDecimal;

/*
	https://rosalind.info/problems/gc/

	The GC-content of a DNA string is given by the percentage of symbols in the string that are 'C' or 'G'. For example, the GC-content of "AGCTATAG" is 37.5%.
	Note that the reverse complement of any DNA string has the same GC-content.
	DNA strings must be labeled when they are consolidated into a database. A commonly used method of string labeling is called FASTA format.
	In this format, the string is introduced by a line that begins with '>', followed by some labeling information. Subsequent lines contain the string itself; the first line to begin with '>' indicates the label of the next string.
	In Rosalind's implementation, a string in FASTA format will be labeled by the ID "Rosalind_xxxx", where "xxxx" denotes a four-digit code between 0000 and 9999.

	Given: At most 10 DNA strings in FASTA format (of length at most 1 kbp each).
	Return: The ID of the string having the highest GC-content, followed by the GC-content of that string.
			Rosalind allows for a default error of 0.001 in all decimal answers unless otherwise stated; please see the note on absolute error below.
*/
public class ComputingGCContent extends AbstractStreamingFastaInputProcessor {

	private GCContent best;

	static void main(String[] args) throws IOException {
		new ComputingGCContent().readAndProcessInput();
	}

	@Override
	protected void onRecord(String header, String sequence) {
		try {
			GCContent current = new Calculus(header, sequence).call();
			if (best == null || current.percent().compareTo(best.percent()) > 0) {
				best = current;
			}
		} catch (Exception e) {
			throw new RuntimeException("Failed to compute GC content for: " + header, e);
		}
	}

	@Override
	protected void printResult() {
		if (best == null) {
			return;
		}
		System.out.println(best.id());
		BigDecimal normalized = best.percent().stripTrailingZeros();
		System.out.println(normalized.toPlainString());
	}
}
