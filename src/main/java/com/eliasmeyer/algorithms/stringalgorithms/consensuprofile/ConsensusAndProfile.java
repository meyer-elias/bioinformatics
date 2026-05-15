package com.eliasmeyer.algorithms.stringalgorithms.consensuprofile;

import com.eliasmeyer.algorithms.commons.AbstractStreamingFastaInputProcessor;
import com.eliasmeyer.bio.molecule.nucleicacid.dna.DNABase;
import java.io.IOException;
import java.util.List;

/*
 * https://rosalind.info/problems/cons/
 *
 * Given: A collection of at most 10 DNA strings of equal length (at most 1 kbp) in FASTA format.
 * Return: A consensus string and profile matrix for the collection.
 * (If several possible consensus strings exist, then you may return any one of them.)
 */
public class ConsensusAndProfile extends AbstractStreamingFastaInputProcessor {

	private final Profile profile = new Profile();


	static void main() throws IOException {
		new ConsensusAndProfile().readAndProcessInput();
	}

	@Override
	protected void onRecord(String header, String sequence) {
		List<DNABase> row = sequence.chars()
			.mapToObj(c -> DNABase.parseBase((char) c))
			.toList();

		profile.compute(row);
	}

	@Override
	protected void printResult() {
		System.out.println(profile.consensus());
		printline(DNABase.A);
		printline(DNABase.C);
		printline(DNABase.G);
		printline(DNABase.T);
	}

	private void printline(DNABase base) {
		StringBuilder sb = new StringBuilder();
		sb.append(base.name()).append(":");

		for (Integer count : profile.countsOf(base)) {
			sb.append(' ').append(count);
		}

		System.out.println(sb);
	}
}
