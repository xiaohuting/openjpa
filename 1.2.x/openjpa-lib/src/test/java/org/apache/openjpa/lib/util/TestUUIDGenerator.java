/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.    
 */
package org.apache.openjpa.lib.util;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

/**
 * Test UUID generation.
 *
 * @author Abe White
 */
public class TestUUIDGenerator extends TestCase {

    public void testUniqueString() {
        Set seen = new HashSet();
        for (int i = 0; i < 10000; i++)
            assertTrue(seen.add(
                UUIDGenerator.nextString(UUIDGenerator.TYPE1)));
    }

    public void testUniqueHex() {
        Set seen = new HashSet();
        for (int i = 0; i < 10000; i++)
            assertTrue(seen.add(
                UUIDGenerator.nextHex(UUIDGenerator.TYPE1)));
    }

    public void testUniqueType4String() {
        Set seen = new HashSet();
        for (int i = 0; i < 10000; i++)
            assertTrue(seen.add(
                UUIDGenerator.nextString(UUIDGenerator.TYPE4)));
    }

    public void testUniqueType4Hex() {
        Set seen = new HashSet();
        for (int i = 0; i < 10000; i++)
            assertTrue(seen.add(
                UUIDGenerator.nextHex(UUIDGenerator.TYPE4)));
    }

    public void testUniqueMixedTypesHex() {
        Set seen = new HashSet();
        for (int i = 0; i < 10000; i++) {
            int type = (i % 2 == 0) ? 
                UUIDGenerator.TYPE4 : UUIDGenerator.TYPE1;
            assertTrue(seen.add(
                UUIDGenerator.nextHex(type)));
        }
    }

    public void testGetTime() {
        long time = 0;
        for (int i = 0; i < 10000; i++) {
            long newTime = UUIDGenerator.getTime();
            assertTrue(newTime != time);
            time = newTime;
        }
    }
}
