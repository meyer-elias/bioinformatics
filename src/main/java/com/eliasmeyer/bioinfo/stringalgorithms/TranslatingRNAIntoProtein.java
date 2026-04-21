package com.eliasmeyer.bioinfo.stringalgorithms;

import com.eliasmeyer.bioinfo.commons.AbstractLineInputProcessor;
import java.io.IOException;
import java.util.Map;

/*
	https://rosalind.info/problems/prot/

	The 20 commonly occurring amino acids are abbreviated by using 20 letters from the English alphabet (all letters except for B, J, O, U, X, and Z).
	Protein strings are constructed from these 20 symbols. Henceforth, the term genetic string will incorporate protein strings along with DNA strings and RNA strings.

	The RNA codon table dictates the details regarding the encoding of specific codons into the amino acid alphabet.

	Given: An RNA string s corresponding to a strand of mRNA (of length at most 10 kbp).
	Return: The protein string encoded by s.
 */
public class TranslatingRNAIntoProtein extends AbstractLineInputProcessor {


	private final StringBuilder protein = new StringBuilder();
	private final Map<String, String> codonTable;

	public TranslatingRNAIntoProtein() {
		this.codonTable = Map.<String, String>ofEntries(
			Map.entry("UUU", "F"),
			Map.entry("UUC", "F"),
			Map.entry("UUA", "L"),
			Map.entry("UUG", "L"),
			Map.entry("UCU", "S"),
			Map.entry("UCC", "S"),
			Map.entry("UCA", "S"),
			Map.entry("UCG", "S"),
			Map.entry("UAU", "Y"),
			Map.entry("UAC", "Y"),
			Map.entry("UAA", "Stop"),
			Map.entry("UAG", "Stop"),
			Map.entry("UGC", "C"),
			Map.entry("UGU", "C"),
			Map.entry("UGA", "Stop"),
			Map.entry("UGG", "W"),

			Map.entry("CUU", "L"),
			Map.entry("CUC", "L"),
			Map.entry("CUA", "L"),
			Map.entry("CUG", "L"),
			Map.entry("CCU", "P"),
			Map.entry("CCC", "P"),
			Map.entry("CCG", "P"),
			Map.entry("CCA", "P"),
			Map.entry("CAU", "H"),
			Map.entry("CAC", "H"),
			Map.entry("CAA", "Q"),
			Map.entry("CAG", "Q"),
			Map.entry("CGU", "R"),
			Map.entry("CGC", "R"),
			Map.entry("CGA", "R"),
			Map.entry("CGG", "R"),

			Map.entry("AUU", "I"),
			Map.entry("AUC", "I"),
			Map.entry("AUA", "I"),
			Map.entry("AUG", "M"),
			Map.entry("ACU", "T"),
			Map.entry("ACC", "T"),
			Map.entry("ACA", "T"),
			Map.entry("ACG", "T"),
			Map.entry("AAU", "N"),
			Map.entry("AAC", "N"),
			Map.entry("AAA", "K"),
			Map.entry("AAG", "K"),
			Map.entry("AGU", "S"),
			Map.entry("AGC", "S"), Map.entry("AGA", "R"), Map.entry("AGG", "R"),

			Map.entry("GUU", "V"), Map.entry("GUC", "V"), Map.entry("GUA", "V"),
			Map.entry("GUG", "V"), Map.entry("GCU", "A"), Map.entry("GCC", "A"),
			Map.entry("GCA", "A"), Map.entry("GCG", "A"), Map.entry("GAU", "D"),
			Map.entry("GAC", "D"), Map.entry("GAA", "E"), Map.entry("GAG", "E"),
			Map.entry("GGU", "G"), Map.entry("GGC", "G"), Map.entry("GGA", "G"),
			Map.entry("GGG", "G"));
	}

	static void main() throws IOException {
		TranslatingRNAIntoProtein processor = new TranslatingRNAIntoProtein();
		processor.readAndProcessInput();
	}

	@Override
	protected void processLine(String line) {
		for (int i = 0; i + 3 < line.length(); i += 3) {
			String codon = line.substring(i, i + 3);
			String codonProcessed = codonTable.get(codon);
			protein.append(codonProcessed);
		}
	}

	@Override
	protected void printResult() {
		IO.println(protein.toString());
	}
}
