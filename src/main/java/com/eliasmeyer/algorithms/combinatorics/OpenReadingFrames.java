package com.eliasmeyer.algorithms.combinatorics;


import com.eliasmeyer.algorithms.commons.AbstractStreamingFastaInputProcessor;
import com.eliasmeyer.bio.molecule.nucleicacid.dna.DNA;
import com.eliasmeyer.bio.molecule.nucleicacid.dna.DNABase;
import com.eliasmeyer.bio.molecule.protein.Protein;
import com.eliasmeyer.bio.molecule.translation.StandardGeneticCodeDNA;
import com.eliasmeyer.bio.molecule.translation.Translation;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

public class OpenReadingFrames extends AbstractStreamingFastaInputProcessor {

	private final Set<Protein> proteins = new LinkedHashSet<>();

	static void main(String[] args) throws IOException {
		new OpenReadingFrames().readAndProcessInput();
	}

	@Override
	protected void onRecord(String header, String sequence) {
		DNA dna = new DNA(sequence);
		Translation<DNABase> translation = new Translation<>(new StandardGeneticCodeDNA());

		// Forward strand ORFs
		proteins.addAll(translation.allOrfs(
			dna.sequence(),
			c -> c.first() == DNABase.A && c.second() == DNABase.T && c.third() == DNABase.G
		));

		// Reverse-complement strand ORFs
		DNA reverseComplement = new DNA(dna.complementary().reverse());
		proteins.addAll(translation.allOrfs(
			reverseComplement.sequence(),
			c -> c.first() == DNABase.A && c.second() == DNABase.T && c.third() == DNABase.G
		));
	}

	@Override
	protected void printResult() {
		for (Protein protein : proteins) {
			IO.println(protein.sequence());
		}
	}
}
