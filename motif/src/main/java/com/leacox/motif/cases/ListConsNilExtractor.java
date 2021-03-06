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

import com.leacox.motif.extract.Extractor0;

import java.util.List;

/**
 * An extractor for extracting an empty list.
 *
 * @author John Leacox
 */
public class ListConsNilExtractor<A> implements Extractor0<List<A>> {
  private ListConsNilExtractor() {
  }

  /**
   * Creates a new instance of {@link ListConsNilExtractor}.
   */
  public static <A> ListConsNilExtractor<A> create() {
    return new ListConsNilExtractor<>();
  }

  @Override
  public boolean unapply(List<A> list) {
    return list.isEmpty();
  }

  @Override
  public Class<List> getExtractorClass() {
    return List.class;
  }
}
