/*
 * Copyright 2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradle.api.internal.file.copy;

import org.gradle.api.file.CopySpec;
import org.gradle.api.internal.file.FileResolver;
import org.gradle.internal.reflect.Instantiator;

import java.io.File;

public class FileCopyActionImpl extends CopyActionImpl implements FileCopyAction {
    private Object destDir;

    public FileCopyActionImpl(Instantiator instantiator, FileResolver resolver, CopySpecVisitor visitor) {
        super(instantiator, resolver, visitor, true);
    }

    @Override
    public CopySpec into(Object destDir) {
        this.destDir = destDir;
        return this;
    }

    public File getDestinationDir() {
        return destDir == null ? null : getResolver().resolve(destDir);
    }
}
