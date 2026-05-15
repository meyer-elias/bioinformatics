package com.eliasmeyer.bio.molecule.nucleicacid.dna;

import com.eliasmeyer.bio.molecule.commons.Complementary;
import com.eliasmeyer.bio.molecule.nucleicacid.rna.RNABase;

public enum DNABase implements Complementary<DNABase> {

	A(0), C(1), G(2), T(3);

	private final int idx;

	DNABase(int idx) {
		this.idx = idx;
	}

	public int idx() {
		return idx;
	}

	@Override
	public DNABase complement() {
		return switch (this) {
			case A -> T;
			case T -> A;
			case C -> G;
			case G -> C;
		};
	}

	public RNABase toRNA() {
		return switch (this) {
			case A -> RNABase.A;
			case T -> RNABase.U; // T vira U no RNA
			case C -> RNABase.C;
			case G -> RNABase.G;
		};
	}

	public static DNABase parseBase(char symbol) {
		try {
			return DNABase.valueOf(String.valueOf(symbol));
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException(
				"Invalid DNA base: '" + symbol + "'. Allowed: A, C, G, T", ex
			);
		}
	}

}

