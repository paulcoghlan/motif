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

package com.leacox.motif.cases;

import com.leacox.motif.extract.Extractor1;

import java.util.Optional;

/**
 * An extractor for extrating a primitive value.
 *
 * @author John Leacox
 */
public class PrimitiveExtractor<T> implements Extractor1<T, T> {
  private final Class<T> primitiveType;

  private PrimitiveExtractor(Class<T> primitiveType) {
    this.primitiveType = primitiveType;
  }

  /**
   * Creates a new instance of {@link PrimitiveExtractor}.
   */
  public static <T> PrimitiveExtractor<T> create(Class<T> primitiveType) {
    return new PrimitiveExtractor<>(primitiveType);
  }

  @Override
  public Optional<T> unapply(T t) {
    return Optional.ofNullable(t);
  }

  @Override
  public Class getExtractorClass() {
    return primitiveType;
  }
}
