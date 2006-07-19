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
package org.apache.openjpa.meta;

import java.util.Comparator;

/**
 * Order a field.
 *
 * @author Abe White
 */
public interface Order {

    /**
     * Token denoting to order by the element value.
     */
    public static final String ELEMENT = "#element";

    /**
     * Return the name of the orderable.
     */
    public String getName();

    /**
     * Order direction.
     */
    public boolean isAscending();

    /**
     * Return a comparator for ordering by this element, or null if
     * the ordering is done in the datastore.
     */
    public Comparator getComparator ();
}
