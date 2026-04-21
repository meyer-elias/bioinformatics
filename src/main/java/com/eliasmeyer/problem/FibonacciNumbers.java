package com.eliasmeyer.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class FibonacciNumbers {

	static void main() throws IOException {
		FibonacciNumbers f = new FibonacciNumbers();
		f.processInput();
	}

	public void processInput() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line;

		while (Objects.nonNull(line = reader.readLine()) && !line.isEmpty()) {
			int n = Integer.parseInt(line);

			long result = fibonacci(n);
			IO.println(result);
		}
		reader.close();
	}

	private long fibonacci(int n) {
		long current = 1;
		long antecessor = 1;

		if (n <= 1) {
			return antecessor;
		}

		long temp;
		for (int i = 3; i <= n; i++) {
			temp = antecessor;
			antecessor = current;
			current = temp + antecessor;
		}

		return current;
	}
}
