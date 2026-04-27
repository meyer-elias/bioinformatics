package com.eliasmeyer.bio.molecule.nucleicacid.dna;

import com.eliasmeyer.bio.molecule.commons.Sequence;
import com.eliasmeyer.bio.molecule.commons.codon.Codon;

public class DNACodon extends Codon<DNABase> {

	public DNACodon(Sequence<DNABase> sequence, int offset) {
		super(sequence, offset);
	}
}
