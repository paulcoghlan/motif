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

package com.leacox.motif.extract;

import com.leacox.motif.extract.matchers.Matcher;

import java.util.List;
import java.util.Optional;

/**
 * A decomposable matcher that extracts 0 values.
 *
 * @author John Leacox
 */
final class DecomposableMatch0<T> implements Extractor0<T> {
  final List<Matcher<Object>> fieldMatchers;
  final FieldExtractor<T> fieldExtractor;

  DecomposableMatch0(
      List<Matcher<Object>> fieldMatchers, FieldExtractor<T> fieldExtractor) {
    this.fieldMatchers = fieldMatchers;
    this.fieldExtractor = fieldExtractor;
  }

  @Override
  public boolean unapply(T t) {
    Optional<List<Object>> fieldsOpt = fieldExtractor.unapply(t);
    if (!fieldsOpt.isPresent()) {
      return false;
    }

    List<Object> fields = fieldsOpt.get();
    if (fieldMatchers.size() != fields.size()) {
      return false;
    }

    for (int i = 0; i < fieldMatchers.size(); i++) {
      if (!fieldMatchers.get(i).matches(fields.get(i))) {
        return false;
      }
    }

    return true;
  }

  @Override
  public Class getExtractorClass() {
    return fieldExtractor.getExtractorClass();
  }
}
