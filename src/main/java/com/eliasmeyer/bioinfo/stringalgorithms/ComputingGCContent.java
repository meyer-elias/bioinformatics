package com.eliasmeyer.bioinfo.stringalgorithms;

import com.eliasmeyer.bioinfo.stringalgorithms.gc.Calculus;
import com.eliasmeyer.bioinfo.stringalgorithms.gc.GCContent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
	https://rosalind.info/problems/gc/

	The GC-content of a DNA string is given by the percentage of symbols in the string that are 'C' or 'G'. For example, the GC-content of "AGCTATAG" is 37.5%.
	Note that the reverse complement of any DNA string has the same GC-content.
	DNA strings must be labeled when they are consolidated into a database. A commonly used method of string labeling is called FASTA format.
	In this format, the string is introduced by a line that begins with '>', followed by some labeling information. Subsequent lines contain the string itself; the first line to begin with '>' indicates the label of the next string.
	In Rosalind's implementation, a string in FASTA format will be labeled by the ID "Rosalind_xxxx", where "xxxx" denotes a four-digit code between 0000 and 9999.

	Given: At most 10 DNA strings in FASTA format (of length at most 1 kbp each).
	Return: The ID of the string having the highest GC-content, followed by the GC-content of that string.
			Rosalind allows for a default error of 0.001 in all decimal answers unless otherwise stated; please see the note on absolute error below.
*/
public class ComputingGCContent {

	static void main(String[] args) throws IOException {
		new ComputingGCContent().processInput();
	}

	public void processInput() throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			Map<String, String> sequences = parseFasta(reader);

			if (sequences.isEmpty()) {
				return;
			}

			GCContent best = findHighestGCContent(sequences);
			printResult(best);
		}
	}

	private Map<String, String> parseFasta(BufferedReader reader) throws IOException {
		Map<String, String> sequences = new LinkedHashMap<>();
		String currentHeader = null;
		StringBuilder currentSequence = new StringBuilder();

		String line;
		while ((line = reader.readLine()) != null) {
			line = line.trim();
			if (line.isEmpty()) {
				continue;
			}

			if (line.startsWith(">")) {
				if (currentHeader != null) {
					sequences.put(currentHeader, currentSequence.toString());
				}
				currentHeader = line.substring(1).trim();
				currentSequence.setLength(0);
			} else {
				currentSequence.append(line);
			}
		}

		if (currentHeader != null) {
			sequences.put(currentHeader, currentSequence.toString());
		}

		return sequences;
	}

	private GCContent findHighestGCContent(Map<String, String> sequences) {
		int poolSize = Math.clamp(1, 10, sequences.size());

		try (ExecutorService executor = Executors.newFixedThreadPool(poolSize)) {
			try {
				List<CompletableFuture<GCContent>> futures = new ArrayList<>();

				for (Map.Entry<String, String> entry : sequences.entrySet()) {
					String id = entry.getKey();
					String dna = entry.getValue();

					CompletableFuture<GCContent> future = CompletableFuture.supplyAsync(() -> {
						try {
							return new Calculus(id, dna).call();
						} catch (Exception e) {
							throw new CompletionException(e);
						}
					}, executor);

					futures.add(future);
				}

				CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

				return futures.stream()
					.map(CompletableFuture::join)
					.max(Comparator.comparing(GCContent::percent))
					.orElseThrow();
			} finally {
				executor.shutdown();
			}
		}
	}

	private void printResult(GCContent best) {
		System.out.println(best.id());
		// mantém saída decimal consistente
		BigDecimal normalized = best.percent().stripTrailingZeros();
		System.out.println(normalized.toPlainString());
	}
}
