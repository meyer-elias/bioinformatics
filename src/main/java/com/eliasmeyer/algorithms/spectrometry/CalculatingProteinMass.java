package com.eliasmeyer.algorithms.spectrometry;

import com.eliasmeyer.algorithms.commons.AbstractCharInputProcessor;
import com.eliasmeyer.bio.molecule.protein.AminoAcid;
import java.io.IOException;
import java.math.BigDecimal;

/*
	https://rosalind.info/problems/prtm/
	Calculating Protein Mass

	In a weighted alphabet, every symbol is assigned a positive real number called a weight. A string formed from a weighted alphabet is called a weighted string, and its weight is equal to the sum of the weights of its symbols.
	The standard weight assigned to each member of the 20-symbol amino acid alphabet is the monoisotopic mass of the corresponding amino acid.

	Given: A protein string P of length at most 1000 aa.
	Return: The total weight of P. Consult the monoisotopic mass table.

 */
public class CalculatingProteinMass extends AbstractCharInputProcessor {

	private BigDecimal total = BigDecimal.ZERO;

	static void main(String[] args) throws IOException {
		CalculatingProteinMass processor = new CalculatingProteinMass();
		processor.readAndProcessInput();
	}

	@Override
	protected void processChar(char c) {
		total = total.add(AminoAcid.valueOf(String.valueOf(c)).molecularWeight());
	}

	@Override
	protected void printResult() {
		IO.println(total);
	}
}
