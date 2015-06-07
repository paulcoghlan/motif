package com.leacox.motif.fluent;

import com.leacox.motif.fluent.extractor.Extractor0;
import com.leacox.motif.function.Consumer0;
import com.leacox.motif.pattern.ConsumablePattern;
import com.leacox.motif.pattern.Pattern;

import java.util.function.Supplier;

/**
 * @author John Leacox
 */
abstract class Matching0<T, U> {
  private final Extractor0<U> extractor;

  Matching0(
      Extractor0<U> extractor) {
    this.extractor = extractor;
  }

  <R> FluentMatchingR<T, R> get(
      FluentMatchingR<T, R> fluentMatchingR, Supplier<R> supplier) {
    fluentMatchingR.addPattern(
        Pattern.of(
            t -> {
              return extractor.getExtractorClass().isAssignableFrom(t.getClass()) && extractor
                  .unapply((U) t);
            }, t -> supplier.get()));

    return fluentMatchingR;
  }

  FluentMatchingC<T> then(FluentMatchingC<T> fluentMatchingC, Consumer0 consumer) {
    fluentMatchingC.addPattern(
        ConsumablePattern.of(
            t -> {
              return extractor.getExtractorClass().isAssignableFrom(t.getClass()) && extractor
                  .unapply((U) t);
            }, t -> consumer.accept()));

    return fluentMatchingC;
  }
}
