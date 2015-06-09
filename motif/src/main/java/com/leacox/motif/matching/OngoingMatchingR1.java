package com.leacox.motif.matching;

import com.leacox.motif.extractor.Extractor1;

import org.hamcrest.Matcher;

import java.util.function.Function;

/**
 * @author John Leacox
 */
public final class OngoingMatchingR1<T, U extends T, A, R> extends Matching1<T, U, A> {
  private final FluentMatchingR<T, R> fluentMatchingR;

  OngoingMatchingR1(
      FluentMatchingR<T, R> fluentMatchingR, Extractor1<U, A> extractor, Matcher<A> toMatchA) {
    super(extractor, toMatchA);

    this.fluentMatchingR = fluentMatchingR;
  }

  public FluentMatchingR<T, R> get(Function<A, R> function) {
    return get(fluentMatchingR, function);
  }
}