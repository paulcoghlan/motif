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

package com.leacox.motif.generate;

import static com.google.common.base.Preconditions.checkNotNull;

import com.leacox.motif.extract.FieldExtractor;
import com.leacox.motif.tuple.Tuple2;

import com.google.common.collect.Lists;
import com.squareup.javapoet.TypeName;

import java.util.List;

/**
 * Specification of a match method with 0-arity.
 *
 * @author John Leacox
 */
public final class Match0MethodSpec {
  final String name;
  final List<MethodParam> nonMatchParams;
  final Tuple2<Class<? extends FieldExtractor>, Object[]> fieldExtractorWithArgs;
  final String summaryJavadoc;

  private Match0MethodSpec(Builder builder) {
    this.name = builder.name;
    this.nonMatchParams = builder.nonMatchParams;
    this.fieldExtractorWithArgs = builder.fieldExtractorWithArgs;
    this.summaryJavadoc = builder.summaryJavadoc;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private String name;
    private final List<MethodParam> nonMatchParams = Lists.newArrayList();
    private Tuple2<Class<? extends FieldExtractor>, Object[]> fieldExtractorWithArgs;
    private String summaryJavadoc;

    public Builder withName(String methodName) {
      this.name = methodName;
      return this;
    }

    public Builder addNonMatchParam(TypeName type, String name) {
      nonMatchParams.add(MethodParam.create(type, name));
      return this;
    }

    public Builder withMatchExtractor(
        Class<? extends FieldExtractor> matchExtractor, Object... args) {
      fieldExtractorWithArgs = Tuple2.of(matchExtractor, args);
      return this;
    }

    public Builder withSummaryJavadoc(String summaryJavadoc) {
      this.summaryJavadoc = summaryJavadoc;
      return this;
    }

    /**
     * Creates a new instances of {@link Match0MethodSpec} with the builder parameters.
     */
    public Match0MethodSpec build() {
      checkNotNull(name, "name == null");
      checkNotNull(fieldExtractorWithArgs, "matchExtractor == null");

      return new Match0MethodSpec(this);
    }
  }
}
