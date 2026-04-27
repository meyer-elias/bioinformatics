package com.eliasmeyer.bio.molecule.translation;

import com.eliasmeyer.bio.molecule.commons.codon.Amino;
import com.eliasmeyer.bio.molecule.commons.codon.Codon;
import com.eliasmeyer.bio.molecule.commons.codon.CodonTranslation;
import com.eliasmeyer.bio.molecule.commons.codon.Stop;
import com.eliasmeyer.bio.molecule.nucleicacid.rna.RNABase;
import com.eliasmeyer.bio.molecule.protein.AminoAcid;

/**
 * The standard genetic code.
 */
public class StandardGeneticCodeRNA implements GeneticCode<RNABase> {

	private final CodonTranslation[] table = new CodonTranslation[64];

	public StandardGeneticCodeRNA() {
		init();
	}

	private void init() {
		set(RNABase.U, RNABase.U, RNABase.U, new Amino(AminoAcid.F));
		set(RNABase.U, RNABase.U, RNABase.C, new Amino(AminoAcid.F));
		set(RNABase.U, RNABase.U, RNABase.A, new Amino(AminoAcid.L));
		set(RNABase.U, RNABase.U, RNABase.G, new Amino(AminoAcid.L));
		set(RNABase.U, RNABase.C, RNABase.U, new Amino(AminoAcid.S));
		set(RNABase.U, RNABase.C, RNABase.C, new Amino(AminoAcid.S));
		set(RNABase.U, RNABase.C, RNABase.A, new Amino(AminoAcid.S));
		set(RNABase.U, RNABase.C, RNABase.G, new Amino(AminoAcid.S));
		set(RNABase.U, RNABase.A, RNABase.U, new Amino(AminoAcid.Y));
		set(RNABase.U, RNABase.A, RNABase.C, new Amino(AminoAcid.Y));
		set(RNABase.U, RNABase.A, RNABase.A, Stop.getInstance());
		set(RNABase.U, RNABase.A, RNABase.G, Stop.getInstance());
		set(RNABase.U, RNABase.G, RNABase.U, new Amino(AminoAcid.C));
		set(RNABase.U, RNABase.G, RNABase.C, new Amino(AminoAcid.C));
		set(RNABase.U, RNABase.G, RNABase.A, Stop.getInstance());
		set(RNABase.U, RNABase.G, RNABase.G, new Amino(AminoAcid.W));

		set(RNABase.C, RNABase.U, RNABase.U, new Amino(AminoAcid.L));
		set(RNABase.C, RNABase.U, RNABase.C, new Amino(AminoAcid.L));
		set(RNABase.C, RNABase.U, RNABase.A, new Amino(AminoAcid.L));
		set(RNABase.C, RNABase.U, RNABase.G, new Amino(AminoAcid.L));
		set(RNABase.C, RNABase.C, RNABase.U, new Amino(AminoAcid.P));
		set(RNABase.C, RNABase.C, RNABase.C, new Amino(AminoAcid.P));
		set(RNABase.C, RNABase.C, RNABase.G, new Amino(AminoAcid.P));
		set(RNABase.C, RNABase.C, RNABase.A, new Amino(AminoAcid.P));
		set(RNABase.C, RNABase.A, RNABase.U, new Amino(AminoAcid.H));
		set(RNABase.C, RNABase.A, RNABase.C, new Amino(AminoAcid.H));
		set(RNABase.C, RNABase.A, RNABase.A, new Amino(AminoAcid.Q));
		set(RNABase.C, RNABase.A, RNABase.G, new Amino(AminoAcid.Q));
		set(RNABase.C, RNABase.G, RNABase.U, new Amino(AminoAcid.R));
		set(RNABase.C, RNABase.G, RNABase.C, new Amino(AminoAcid.R));
		set(RNABase.C, RNABase.G, RNABase.A, new Amino(AminoAcid.R));
		set(RNABase.C, RNABase.G, RNABase.G, new Amino(AminoAcid.R));

		set(RNABase.A, RNABase.U, RNABase.U, new Amino(AminoAcid.I));
		set(RNABase.A, RNABase.U, RNABase.C, new Amino(AminoAcid.I));
		set(RNABase.A, RNABase.U, RNABase.A, new Amino(AminoAcid.I));
		set(RNABase.A, RNABase.U, RNABase.G, new Amino(AminoAcid.M));
		set(RNABase.A, RNABase.C, RNABase.U, new Amino(AminoAcid.T));
		set(RNABase.A, RNABase.C, RNABase.C, new Amino(AminoAcid.T));
		set(RNABase.A, RNABase.C, RNABase.A, new Amino(AminoAcid.T));
		set(RNABase.A, RNABase.C, RNABase.G, new Amino(AminoAcid.T));
		set(RNABase.A, RNABase.A, RNABase.U, new Amino(AminoAcid.N));
		set(RNABase.A, RNABase.A, RNABase.C, new Amino(AminoAcid.N));
		set(RNABase.A, RNABase.A, RNABase.A, new Amino(AminoAcid.K));
		set(RNABase.A, RNABase.A, RNABase.G, new Amino(AminoAcid.K));
		set(RNABase.A, RNABase.G, RNABase.U, new Amino(AminoAcid.S));
		set(RNABase.A, RNABase.G, RNABase.C, new Amino(AminoAcid.S));
		set(RNABase.A, RNABase.G, RNABase.A, new Amino(AminoAcid.R));
		set(RNABase.A, RNABase.G, RNABase.G, new Amino(AminoAcid.R));

		set(RNABase.G, RNABase.U, RNABase.U, new Amino(AminoAcid.V));
		set(RNABase.G, RNABase.U, RNABase.C, new Amino(AminoAcid.V));
		set(RNABase.G, RNABase.U, RNABase.A, new Amino(AminoAcid.V));
		set(RNABase.G, RNABase.U, RNABase.G, new Amino(AminoAcid.V));
		set(RNABase.G, RNABase.C, RNABase.U, new Amino(AminoAcid.A));
		set(RNABase.G, RNABase.C, RNABase.C, new Amino(AminoAcid.A));
		set(RNABase.G, RNABase.C, RNABase.A, new Amino(AminoAcid.A));
		set(RNABase.G, RNABase.C, RNABase.G, new Amino(AminoAcid.A));
		set(RNABase.G, RNABase.A, RNABase.U, new Amino(AminoAcid.D));
		set(RNABase.G, RNABase.A, RNABase.C, new Amino(AminoAcid.D));
		set(RNABase.G, RNABase.A, RNABase.A, new Amino(AminoAcid.E));
		set(RNABase.G, RNABase.A, RNABase.G, new Amino(AminoAcid.E));
		set(RNABase.G, RNABase.G, RNABase.U, new Amino(AminoAcid.G));
		set(RNABase.G, RNABase.G, RNABase.C, new Amino(AminoAcid.G));
		set(RNABase.G, RNABase.G, RNABase.A, new Amino(AminoAcid.G));
		set(RNABase.G, RNABase.G, RNABase.G, new Amino(AminoAcid.G));
	}

	private void set(RNABase a, RNABase b, RNABase c, CodonTranslation t) {
		table[index(a, b, c)] = t;
	}

	/**
	 * Returns the index of the codon in the table.
	 *
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	private int index(RNABase a, RNABase b, RNABase c) {
		return a.getIdx() * 16 + b.getIdx() * 4 + c.getIdx();
	}

	@Override
	public CodonTranslation translate(Codon<RNABase> codon) {
		return table[index(codon.first(), codon.second(), codon.third())];
	}
}
