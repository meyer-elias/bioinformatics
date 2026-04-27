package com.eliasmeyer.bio.molecule.commons.codon;

public final class Stop implements CodonTranslation {

	private static final Stop INSTANCE = new Stop();

	private Stop() {
	}

	public static Stop getInstance() {
		return INSTANCE;
	}

}
