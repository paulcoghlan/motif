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

import com.leacox.motif.extract.Extractor2;
import com.leacox.motif.tuple.Tuple2;

import java.util.List;
import java.util.Optional;

/**
 * An extractor for extracting a {@link List} into a head element and a tail of remaining
 * elements.
 *
 * @author John Leacox
 */
public class ListConsHeadTailExtractor<A> implements Extractor2<List<A>, A, List<A>> {
  private ListConsHeadTailExtractor() {
  }

  /**
   * Creates a new instance of {@link ListConsHeadTailExtractor}.
   */
  public static <A> ListConsHeadTailExtractor<A> create() {
    return new ListConsHeadTailExtractor<>();
  }

  @Override
  public Optional<Tuple2<A, List<A>>> unapply(List<A> list) {
    if (list.isEmpty()) {
      return Optional.empty();
    }

    return Optional.of(Tuple2.of(list.get(0), list.subList(1, list.size())));
  }

  @Override
  public Class<List> getExtractorClass() {
    return List.class;
  }
}
