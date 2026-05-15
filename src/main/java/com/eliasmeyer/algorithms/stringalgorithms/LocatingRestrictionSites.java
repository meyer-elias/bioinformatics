package com.eliasmeyer.algorithms.stringalgorithms;

import com.eliasmeyer.algorithms.commons.AbstractStreamingFastaInputProcessor;
import com.eliasmeyer.bio.molecule.nucleicacid.dna.DNA;
import com.eliasmeyer.bio.molecule.nucleicacid.dna.DNABase;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * https://rosalind.info/problems/revc/
 *
 * Given: A DNA string of length at most 1 kbp in FASTA format.
 * Return: The position and length of every reverse palindrome in the string having length between 4 and 12. You may return these pairs in any order.
 */
public class LocatingRestrictionSites extends AbstractStreamingFastaInputProcessor {

	private static final int MIN_LENGTH = 4;
	private static final int MAX_LENGTH = 12;

	private final List<int[]> palindromes = new ArrayList<>();

	static void main() throws IOException {
		new LocatingRestrictionSites().readAndProcessInput();
	}

	@Override
	protected void onRecord(String header, String sequence) {
		DNA dna = new DNA(sequence);
		findReversePalindromes(dna);
	}

	private void findReversePalindromes(DNA dna) {
		for (int i = 0; i < dna.sequence().size(); i++) {
			for (int len = MIN_LENGTH; len <= MAX_LENGTH && i + len <= dna.sequence().size();
				len++) {
				if (dna.isReversePalindrome(i, len)) {
					palindromes.add(new int[]{i + 1, len});
				}
			}
		}
	}

	private boolean isReversePalindrome(List<DNABase> sequence, int start, int length) {
		for (int i = 0; i < length; i++) {
			DNABase forward = sequence.get(start + i);
			DNABase reverse = sequence.get(start + length - 1 - i).complement();

			if (forward != reverse) {
				return false;
			}
		}
		return true;
	}


	@Override
	protected void printResult() {
		for (int[] pair : palindromes) {
			System.out.println(pair[0] + " " + pair[1]);
		}
	}
}
