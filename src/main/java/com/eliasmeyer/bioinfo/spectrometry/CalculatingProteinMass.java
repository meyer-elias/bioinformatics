package com.eliasmeyer.bioinfo.spectrometry;

import com.eliasmeyer.bioinfo.commons.AbstractCharInputProcessor;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

/*
	https://rosalind.info/problems/prtm/
	Calculating Protein Mass

	In a weighted alphabet, every symbol is assigned a positive real number called a weight. A string formed from a weighted alphabet is called a weighted string, and its weight is equal to the sum of the weights of its symbols.
	The standard weight assigned to each member of the 20-symbol amino acid alphabet is the monoisotopic mass of the corresponding amino acid.

	Given: A protein string P of length at most 1000 aa.
	Return: The total weight of P. Consult the monoisotopic mass table.

 */
public class CalculatingProteinMass extends AbstractCharInputProcessor {

	private final Map<Character, BigDecimal> monoisotopic;
	private BigDecimal total = BigDecimal.ZERO;

	public CalculatingProteinMass() {
		monoisotopic = Map.ofEntries(
			Map.entry('A', new BigDecimal("71.03711")),
			Map.entry('C', new BigDecimal("103.00919")),
			Map.entry('D', new BigDecimal("115.02694")),
			Map.entry('E', new BigDecimal("129.04259")),
			Map.entry('F', new BigDecimal("147.06841")),
			Map.entry('G', new BigDecimal("57.02146")),
			Map.entry('H', new BigDecimal("137.05891")),
			Map.entry('I', new BigDecimal("113.08406")),
			Map.entry('K', new BigDecimal("128.09496")),
			Map.entry('L', new BigDecimal("113.08406")),
			Map.entry('M', new BigDecimal("131.04049")),
			Map.entry('N', new BigDecimal("114.04293")),
			Map.entry('P', new BigDecimal("97.05276")),
			Map.entry('Q', new BigDecimal("128.05858")),
			Map.entry('R', new BigDecimal("156.10111")),
			Map.entry('S', new BigDecimal("87.03203")),
			Map.entry('T', new BigDecimal("101.04768")),
			Map.entry('V', new BigDecimal("99.06841")),
			Map.entry('W', new BigDecimal("186.07931")),
			Map.entry('Y', new BigDecimal("163.06333")));
	}

	static void main(String[] args) throws IOException {
		CalculatingProteinMass processor = new CalculatingProteinMass();
		processor.readAndProcessInput();
	}

	@Override
	protected void processChar(char c) {
		total = total.add(monoisotopic.get(c));
	}

	@Override
	protected void printResult() {
		IO.println(total);
	}
}
