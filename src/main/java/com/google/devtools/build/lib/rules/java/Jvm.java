// Copyright 2014 The Bazel Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.devtools.build.lib.rules.java;

import com.google.common.base.Preconditions;
import com.google.devtools.build.lib.analysis.config.BuildConfiguration;
import com.google.devtools.build.lib.cmdline.Label;
import com.google.devtools.build.lib.concurrent.ThreadSafety.Immutable;
import com.google.devtools.build.lib.skyframe.serialization.ObjectCodec;
import com.google.devtools.build.lib.skyframe.serialization.autocodec.AutoCodec;

/**
 * This class represents a Java virtual machine with a path.
 */
@AutoCodec
@Immutable
public final class Jvm extends BuildConfiguration.Fragment {
  public static final ObjectCodec<Jvm> CODEC = new Jvm_AutoCodec();

  private final Label jvmLabel;

  /**
   * Creates a {@link  Jvm} instance. {@code jvmLabel} must be non-null.
   */
  @AutoCodec.Constructor
  public Jvm(Label jvmLabel) {
    this.jvmLabel = Preconditions.checkNotNull(jvmLabel);
  }

  /**
   * Returns a label that points to the current {@code java_runtime_suite} or
   * {@code java_runtime} rule in use.
   */
  public Label getJvmLabel() {
    return jvmLabel;
  }
}
