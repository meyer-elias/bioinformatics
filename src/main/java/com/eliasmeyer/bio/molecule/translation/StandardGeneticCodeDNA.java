package com.eliasmeyer.bio.molecule.translation;

import com.eliasmeyer.bio.molecule.commons.codon.Amino;
import com.eliasmeyer.bio.molecule.commons.codon.Codon;
import com.eliasmeyer.bio.molecule.commons.codon.CodonTranslation;
import com.eliasmeyer.bio.molecule.commons.codon.Stop;
import com.eliasmeyer.bio.molecule.nucleicacid.dna.DNABase;
import com.eliasmeyer.bio.molecule.protein.AminoAcid;

/**
 * The standard genetic code.
 */
public class StandardGeneticCodeDNA implements GeneticCode<DNABase> {

	private final CodonTranslation[] table = new CodonTranslation[64];

	public StandardGeneticCodeDNA() {
		init();
	}

	private void init() {
		set(DNABase.T, DNABase.T, DNABase.T, new Amino(AminoAcid.F));
		set(DNABase.T, DNABase.T, DNABase.C, new Amino(AminoAcid.F));
		set(DNABase.T, DNABase.T, DNABase.A, new Amino(AminoAcid.L));
		set(DNABase.T, DNABase.T, DNABase.G, new Amino(AminoAcid.L));
		set(DNABase.T, DNABase.C, DNABase.T, new Amino(AminoAcid.S));
		set(DNABase.T, DNABase.C, DNABase.C, new Amino(AminoAcid.S));
		set(DNABase.T, DNABase.C, DNABase.A, new Amino(AminoAcid.S));
		set(DNABase.T, DNABase.C, DNABase.G, new Amino(AminoAcid.S));
		set(DNABase.T, DNABase.A, DNABase.T, new Amino(AminoAcid.Y));
		set(DNABase.T, DNABase.A, DNABase.C, new Amino(AminoAcid.Y));
		set(DNABase.T, DNABase.A, DNABase.A, Stop.getInstance());
		set(DNABase.T, DNABase.A, DNABase.G, Stop.getInstance());
		set(DNABase.T, DNABase.G, DNABase.T, new Amino(AminoAcid.C));
		set(DNABase.T, DNABase.G, DNABase.C, new Amino(AminoAcid.C));
		set(DNABase.T, DNABase.G, DNABase.A, Stop.getInstance());
		set(DNABase.T, DNABase.G, DNABase.G, new Amino(AminoAcid.W));

		set(DNABase.C, DNABase.T, DNABase.T, new Amino(AminoAcid.L));
		set(DNABase.C, DNABase.T, DNABase.C, new Amino(AminoAcid.L));
		set(DNABase.C, DNABase.T, DNABase.A, new Amino(AminoAcid.L));
		set(DNABase.C, DNABase.T, DNABase.G, new Amino(AminoAcid.L));
		set(DNABase.C, DNABase.C, DNABase.T, new Amino(AminoAcid.P));
		set(DNABase.C, DNABase.C, DNABase.C, new Amino(AminoAcid.P));
		set(DNABase.C, DNABase.C, DNABase.A, new Amino(AminoAcid.P));
		set(DNABase.C, DNABase.C, DNABase.G, new Amino(AminoAcid.P));
		set(DNABase.C, DNABase.A, DNABase.T, new Amino(AminoAcid.H));
		set(DNABase.C, DNABase.A, DNABase.C, new Amino(AminoAcid.H));
		set(DNABase.C, DNABase.A, DNABase.A, new Amino(AminoAcid.Q));
		set(DNABase.C, DNABase.A, DNABase.G, new Amino(AminoAcid.Q));
		set(DNABase.C, DNABase.G, DNABase.T, new Amino(AminoAcid.R));
		set(DNABase.C, DNABase.G, DNABase.C, new Amino(AminoAcid.R));
		set(DNABase.C, DNABase.G, DNABase.A, new Amino(AminoAcid.R));
		set(DNABase.C, DNABase.G, DNABase.G, new Amino(AminoAcid.R));

		set(DNABase.A, DNABase.T, DNABase.T, new Amino(AminoAcid.I));
		set(DNABase.A, DNABase.T, DNABase.C, new Amino(AminoAcid.I));
		set(DNABase.A, DNABase.T, DNABase.A, new Amino(AminoAcid.I));
		set(DNABase.A, DNABase.T, DNABase.G, new Amino(AminoAcid.M));
		set(DNABase.A, DNABase.C, DNABase.T, new Amino(AminoAcid.T));
		set(DNABase.A, DNABase.C, DNABase.C, new Amino(AminoAcid.T));
		set(DNABase.A, DNABase.C, DNABase.A, new Amino(AminoAcid.T));
		set(DNABase.A, DNABase.C, DNABase.G, new Amino(AminoAcid.T));
		set(DNABase.A, DNABase.A, DNABase.T, new Amino(AminoAcid.N));
		set(DNABase.A, DNABase.A, DNABase.C, new Amino(AminoAcid.N));
		set(DNABase.A, DNABase.A, DNABase.A, new Amino(AminoAcid.K));
		set(DNABase.A, DNABase.A, DNABase.G, new Amino(AminoAcid.K));
		set(DNABase.A, DNABase.G, DNABase.T, new Amino(AminoAcid.S));
		set(DNABase.A, DNABase.G, DNABase.C, new Amino(AminoAcid.S));
		set(DNABase.A, DNABase.G, DNABase.A, new Amino(AminoAcid.R));
		set(DNABase.A, DNABase.G, DNABase.G, new Amino(AminoAcid.R));

		set(DNABase.G, DNABase.T, DNABase.T, new Amino(AminoAcid.V));
		set(DNABase.G, DNABase.T, DNABase.C, new Amino(AminoAcid.V));
		set(DNABase.G, DNABase.T, DNABase.A, new Amino(AminoAcid.V));
		set(DNABase.G, DNABase.T, DNABase.G, new Amino(AminoAcid.V));
		set(DNABase.G, DNABase.C, DNABase.T, new Amino(AminoAcid.A));
		set(DNABase.G, DNABase.C, DNABase.C, new Amino(AminoAcid.A));
		set(DNABase.G, DNABase.C, DNABase.A, new Amino(AminoAcid.A));
		set(DNABase.G, DNABase.C, DNABase.G, new Amino(AminoAcid.A));
		set(DNABase.G, DNABase.A, DNABase.T, new Amino(AminoAcid.D));
		set(DNABase.G, DNABase.A, DNABase.C, new Amino(AminoAcid.D));
		set(DNABase.G, DNABase.A, DNABase.A, new Amino(AminoAcid.E));
		set(DNABase.G, DNABase.A, DNABase.G, new Amino(AminoAcid.E));
		set(DNABase.G, DNABase.G, DNABase.T, new Amino(AminoAcid.G));
		set(DNABase.G, DNABase.G, DNABase.C, new Amino(AminoAcid.G));
		set(DNABase.G, DNABase.G, DNABase.A, new Amino(AminoAcid.G));
		set(DNABase.G, DNABase.G, DNABase.G, new Amino(AminoAcid.G));
	}

	private void set(DNABase a, DNABase b, DNABase c, CodonTranslation t) {
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
	private int index(DNABase a, DNABase b, DNABase c) {
		return a.idx() * 16 + b.idx() * 4 + c.idx();
	}

	@Override
	public CodonTranslation translate(Codon<DNABase> codon) {
		return table[index(codon.first(), codon.second(), codon.third())];
	}
}
