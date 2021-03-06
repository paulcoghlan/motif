/*
 * Copyright (C) 2015 John Leacox
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.leacox.motif.matching;

import com.leacox.motif.extract.Extractor2;
import com.leacox.motif.function.Consumer2;
import com.leacox.motif.function.Function2;

/**
 * Fluent API for specifying an action to take on a match with 2 parameters.
 *
 * @author John Leacox
 */
public final class InitialMatching2<T, U extends T, A, B> extends Matching2<T, U, A, B> {
  private final T value;

  InitialMatching2(Extractor2<U, A, B> extractor, T value) {
    super(extractor);

    this.value = value;
  }

  /**
   * Sets a {@link Function2} to execute if this matches.
   */
  public <R> FluentMatchingR<T, R> get(Function2<A, B, R> function) {
    return get(new FluentMatchingR<>(value), function);
  }

  /**
   * Sets a {@link Consumer2} to execute if this matches.
   */
  public FluentMatchingC<T> then(Consumer2<A, B> consumer) {
    return then(new FluentMatchingC<>(value), consumer);
  }
}
