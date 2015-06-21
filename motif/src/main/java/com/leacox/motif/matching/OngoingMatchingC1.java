package com.leacox.motif.matching;

import com.leacox.motif.extraction.Extractor1;

import java.util.function.Consumer;

/**
 * @author John Leacox
 */
public final class OngoingMatchingC1<T, U extends T, A> extends Matching1<T, U, A> {
  private final FluentMatchingC<T> fluentMatchingC;

  OngoingMatchingC1(FluentMatchingC<T> fluentMatchingC, Extractor1<U, A> extractor) {
    super(extractor);

    this.fluentMatchingC = fluentMatchingC;
  }

  public FluentMatchingC<T> then(Consumer<A> consumer) {
    return then(fluentMatchingC, consumer);
  }
}
