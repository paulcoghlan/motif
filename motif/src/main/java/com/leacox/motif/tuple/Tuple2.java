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

package com.leacox.motif.tuple;

/**
 * A tuple with two values.
 *
 * @author John Leacox
 */
public final class Tuple2<A, B> extends Tuple {
  private final A a;
  private final B b;

  private Tuple2(A a, B b) {
    super(a, b);

    this.a = a;
    this.b = b;
  }

  /**
   * Creates a new instance of {@link Tuple2} with the specified values.
   */
  public static <A, B> Tuple2<A, B> of(A a, B b) {
    return new Tuple2<>(a, b);
  }

  /**
   * Returns the first value.
   */
  public A first() {
    return a;
  }

  /**
   * Returns the second value.
   */
  public B second() {
    return b;
  }
}
