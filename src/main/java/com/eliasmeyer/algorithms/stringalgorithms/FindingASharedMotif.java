package com.eliasmeyer.algorithms.stringalgorithms;

import com.eliasmeyer.algorithms.commons.AbstractStreamingFastaInputProcessor;
import com.eliasmeyer.bio.molecule.commons.Sequence;
import com.eliasmeyer.bio.molecule.nucleicacid.dna.DNA;
import com.eliasmeyer.bio.molecule.nucleicacid.dna.DNABase;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

/*
 *	https://rosalind.info/problems/lcsm/
 *
 *	Given: A collection of k  (k≤100) DNA strings of length at most 1 kbp each in FASTA format.
 *	Return: A longest common substring of the collection. (If multiple solutions exist, you may return any single solution.)
 */
public class FindingASharedMotif extends AbstractStreamingFastaInputProcessor {

	Set<DNA> motifLocations = new HashSet<>();

	@Override
	protected void onRecord(String header, String sequence) {
		motifLocations.add(new DNA(sequence.trim()));
	}

	@Override
	protected void printResult() {
		Sequence<DNABase> sharedMotif = findSharedMotif();
		System.out.println(sharedMotif);
	}

	Sequence<DNABase> findSharedMotif() {
		Sequence<DNABase> reference = motifLocations.stream()
			.findAny()
			.map(DNA::sequence)
			.orElseThrow(() -> new IllegalStateException("No motif found"));

		Sequence<DNABase> longest = new Sequence<>();

		// Não vale a pena começar em posições onde o que resta não supera o maior motivo já encontrado.
		for (int start = 0; reference.size() - start > longest.size(); start++) {
			Sequence<DNABase> motif = longestSharedMotifFrom(reference, start);
			if (motif.size() > longest.size()) {
				longest = motif;
			}
		}

		return longest;
	}

	/*
	 *	Vai juntando um elemento por vez a partir de start (A, AT, ATA, ...)
	 *	enquanto o motivo continuar presente em todas as sequências, e fica com o último.
	 */
	private Sequence<DNABase> longestSharedMotifFrom(Sequence<DNABase> reference, int start) {
		return IntStream.rangeClosed(start + 1, reference.size())
			.mapToObj(end -> reference.subSequence(start, end))
			.takeWhile(this::isShared)
			.reduce((shorter, longer) -> longer)
			.orElseGet(Sequence::new);
	}

	private boolean isShared(Sequence<DNABase> motif) {
		DNABase[] elements = StreamSupport.stream(motif.spliterator(), false)
			.toArray(DNABase[]::new);

		return motifLocations.stream()
			.allMatch(dna -> dna.sequence().hasSubsequence(elements));
	}
}
