package com.eliasmeyer.algorithms.stringalgorithms;

import com.eliasmeyer.algorithms.commons.AbstractLineInputProcessor;
import com.eliasmeyer.bio.molecule.nucleicacid.rna.RNA;
import com.eliasmeyer.bio.molecule.protein.Protein;
import com.eliasmeyer.bio.molecule.translation.StandardGeneticCodeRNA;
import com.eliasmeyer.bio.molecule.translation.Translation;
import java.io.IOException;

/*
	https://rosalind.info/problems/prot/

	The 20 commonly occurring amino acids are abbreviated by using 20 letters from the English alphabet (all letters except for B, J, O, U, X, and Z).
	Protein strings are constructed from these 20 symbols. Henceforth, the term genetic string will incorporate protein strings along with DNA strings and RNA strings.

	The RNA codon table dictates the details regarding the encoding of specific codons into the amino acid alphabet.

	Given: An RNA string s corresponding to a strand of mRNA (of length at most 10 kbp).
	Return: The protein string encoded by s.
 */
public class TranslatingRNAIntoProtein extends AbstractLineInputProcessor {

	Protein protein;

	static void main() throws IOException {
		TranslatingRNAIntoProtein processor = new TranslatingRNAIntoProtein();
		processor.readAndProcessInput();
	}


	@Override
	protected void processLine(String line) {
		RNA rna = new RNA(line);

		Translation translation = new Translation(new StandardGeneticCodeRNA());
		protein = new Protein(translation.from(rna.sequence()).sequence());
	}

	@Override
	protected void printResult() {
		protein.sequence().forEach(IO::print);
		IO.println();
	}
}

