package com.eliasmeyer.bio.molecule.commons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Sequence<T> implements Iterable<T> {

	protected final List<T> elements;

	public Sequence(Sequence<T> sequence) {
		Objects.requireNonNull(sequence, "elements must not be null");
		this.elements = new ArrayList<>(sequence.elements);
	}

	private Sequence(List<T> elements) {
		this.elements = new ArrayList<>(elements);
	}

	public Sequence(T... elements) {
		this(List.of(elements));
	}

	public Sequence(String raw, Function<Character, T> parser) {
		if (raw == null || raw.isBlank()) {
			throw new IllegalArgumentException("Sequence must not be null or blank");
		}

		this(raw.
			toUpperCase()
			.chars()
			.mapToObj(c -> parser.apply((char) c))
			.toList());
	}

	public Sequence<T> reverse() {
		List<T> reversed = new ArrayList<>(elements);
		Collections.reverse(reversed);
		return new Sequence<>(reversed);
	}

	public <R> Sequence<R> map(Function<? super T, ? extends R> mapper) {
		Objects.requireNonNull(mapper, "mapper must not be null");
		return new Sequence(
			elements.stream()
				.map(mapper)
				.toList()
		);
	}

	public static <T> Collector<T, ?, Sequence<T>> collector() {
		return Collectors.collectingAndThen(
			Collectors.toList(),
			Sequence::new
		);
	}

	public T get(int index) {
		return elements.get(index);
	}

	public int size() {
		return elements.size();
	}

	@Override
	public Iterator<T> iterator() {
		return Collections.unmodifiableList(elements).iterator();
	}

	@Override
	public void forEach(Consumer<? super T> action) {
		Objects.requireNonNull(action);
		new ArrayList<>(elements).forEach(action);
	}

	@Override
	public Spliterator<T> spliterator() {
		return elements.spliterator();
	}

	public String toString() {
		return elements.stream().map(Object::toString).collect(Collectors.joining());
	}

	@Override
	public final boolean equals(Object o) {
		if (!(o instanceof Sequence<?> sequence)) {
			return false;
		}

		return Objects.equals(elements, sequence.elements);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(elements);
	}
}
