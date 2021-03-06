/**
 * Copyright 2010-2011 Nicholas Blair, Eric Dalquist
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.ehcache.annotations.integration;

import com.googlecode.ehcache.annotations.Cacheable;
import com.googlecode.ehcache.annotations.KeyGenerator;
import com.googlecode.ehcache.annotations.Property;

/**
 * @author Eric Dalquist
 * @version $Revision$
 */
public interface KeyGeneratorAnnotationTestInterface {
    
    @Cacheable(cacheName="interfaceAnnotatedCache", 
            keyGenerator = @KeyGenerator (
                        name = "ListCacheKeyGenerator",
                        properties = {
                                @Property( name="useReflection", value="true" ),
                                @Property( name="checkforCycles", value="true" ),
                                @Property( name="includeMethod", value="false" )
                        }
                    )
            )
    public String listCacheKeyGenerator();
    public int listCacheKeyGeneratorCount();
    
    @Cacheable(cacheName="interfaceAnnotatedCache", 
            keyGenerator = @KeyGenerator (
                        name = "com.googlecode.ehcache.annotations.integration.MockCacheKeyGenerator"
                    )
            )
    public String customGeneratorOne();

    @Cacheable(cacheName="interfaceAnnotatedCache", 
            keyGenerator = @KeyGenerator (
                        name = "com.googlecode.ehcache.annotations.integration.MockCacheKeyGenerator",
                        properties = {
                                @Property( name="enumProperty", value="SECONDS"),
                                @Property( name="listProperty", ref="listBean" )
                        }
                    )
            )
    public String customGeneratorTwo();

    @Cacheable(cacheName="interfaceAnnotatedCache", 
            keyGenerator = @KeyGenerator (
                        name = "com.googlecode.ehcache.annotations.integration.MockCacheKeyGenerator",
                        properties = {
                                @Property( name="listProperty", ref="listBean" ),
                                @Property( name="enumProperty", value="SECONDS")
                        }
                    )
            )
    public String customGeneratorThree();

    @Cacheable(cacheName="interfaceAnnotatedCache", 
            keyGenerator = @KeyGenerator (
                        name = "com.googlecode.ehcache.annotations.integration.MockCacheKeyGenerator",
                        properties = {
                                @Property( name="enumProperty", value="SECONDS")
                        }
                    )
            )
    public String customGeneratorFour();
}