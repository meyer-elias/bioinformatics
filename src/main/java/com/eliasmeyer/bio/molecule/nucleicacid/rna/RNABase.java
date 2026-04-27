package com.eliasmeyer.bio.molecule.nucleicacid.rna;

import com.eliasmeyer.bio.molecule.nucleicacid.dna.DNABase;

public enum RNABase {
	A(0), U(1), C(2), G(3);

	private final int idx;

	RNABase(int idx) {
		this.idx = idx;
	}

	public DNABase toDNA() {
		return switch (this) {
			case A -> DNABase.A;
			case U -> DNABase.T;
			case C -> DNABase.C;
			case G -> DNABase.G;
		};
	}

	public int getIdx() {
		return idx;
	}
}
