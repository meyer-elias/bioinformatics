package com.eliasmeyer.algorithms.stringalgorithms;

import com.eliasmeyer.algorithms.commons.AbstractStreamingFastaInputProcessor;
import com.eliasmeyer.bio.molecule.nucleicacid.dna.DNA;
import com.eliasmeyer.bio.molecule.nucleicacid.rna.RNA;
import com.eliasmeyer.bio.molecule.protein.Protein;
import com.eliasmeyer.bio.molecule.translation.StandardGeneticCodeRNA;
import com.eliasmeyer.bio.molecule.translation.Translation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
	https://rosalind.info/problems/splc/

	Given: A DNA string s (of length at most 1 kbp) and a collection of substrings of s acting as introns. All strings are given in FASTA format.
	Return: A protein string resulting from transcribing and translating the exons of s. (Note: Only one solution will exist for the dataset provided.)
 */
class RNASplicing extends AbstractStreamingFastaInputProcessor {

	private String dnaSequence;
	private final List<String> introns;

	static void main(String[] args) throws IOException {
		new RNASplicing().readAndProcessInput();
	}

	RNASplicing() {
		introns = new ArrayList<>();
	}

	@Override
	protected void onRecord(String header, String sequence) {
		if (dnaSequence == null) {
			dnaSequence = sequence;
		} else {
			introns.add(sequence);
		}
	}

	@Override
	protected void printResult() {
		String exons = dnaSequence;
		for (String intron : introns) {
			exons = exons.replace(intron, "");
		}

		DNA dna = new DNA(exons);
		RNA rna = dna.transcribe();

		Translation translation = new Translation(new StandardGeneticCodeRNA());
		Protein protein = new Protein(translation.from(rna.sequence()).sequence());

		protein.sequence().forEach(System.out::print);
		System.out.println();
	}
}
