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
package org.apache.openjpa.jdbc.kernel.exps;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.apache.openjpa.kernel.Filters;

/**
 * Absolute value.
 *
 * @author Abe White
 */
class Abs
    extends UnaryOp {

    /**
     * Constructor. Provide the value to operate on.
     */
    public Abs(Val val) {
        super(val);
    }

    protected Class getType(Class c) {
        Class wrap = Filters.wrap(c);
        if (wrap == Integer.class
            || wrap == Float.class
            || wrap == Double.class
            || wrap == Long.class
            || wrap == BigDecimal.class
            || wrap == BigInteger.class)
            return c;
        return int.class;
    }

    protected String getOperator() {
        return "ABS";
    }
}

