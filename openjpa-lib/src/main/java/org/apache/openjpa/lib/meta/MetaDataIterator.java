/*
 * Copyright 2006 The Apache Software Foundation.
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
package org.apache.openjpa.lib.meta;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.openjpa.lib.util.Closeable; // also in java.io(in 1.5)

/**
 * Iterator over metadata resources.
 *
 * @author Abe White
 */
public interface MetaDataIterator extends Closeable {

    /**
     * Return whether there is another resource to iterate over.
     */
    public boolean hasNext() throws IOException;

    /**
     * Return the next metadata resource.
     */
    public Object next() throws IOException;

    /**
     * Return the last-iterated metadata resource content as a stream.
     */
    public InputStream getInputStream() throws IOException;

    /**
     * Return the last-iterated metadata resource content as a file, or null
     * if not an extant file.
     */
    public File getFile() throws IOException;

    /**
     * Close the resources used by this iterator.
     */
    public void close();
}

