/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ~ Licensed to the Apache Software Foundation (ASF) under one
 ~ or more contributor license agreements.  See the NOTICE file
 ~ distributed with this work for additional information
 ~ regarding copyright ownership.  The ASF licenses this file
 ~ to you under the Apache License, Version 2.0 (the
 ~ "License"); you may not use this file except in compliance
 ~ with the License.  You may obtain a copy of the License at
 ~
 ~     http://www.apache.org/licenses/LICENSE-2.0
 ~
 ~ Unless required by applicable law or agreed to in writing,
 ~ software distributed under the License is distributed on an
 ~ "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 ~ KIND, either express or implied.  See the License for the
 ~ specific language governing permissions and limitations
 ~ under the License.
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
package org.apache.sling.capabilities.internal;

import java.util.HashMap;
import java.util.Map;
import org.osgi.service.component.annotations.Component;
import org.apache.sling.capabilities.CapabilitiesSource;

/**
 * Builds Probes that provide basic JVM information, as an example.
 */
@Component(service = CapabilitiesSource.class)
public class JvmCapabilitiesSource implements CapabilitiesSource {

    @Override
    public String getNamespace() {
        return "org.apache.sling.capabilities.demo." + getClass().getSimpleName();
    }
    
    @Override
    public Map<String, String> getCapabilities() throws Exception {
        // Return semi-useful JVM properties for our proof of concept
        final Map<String, String> result = new HashMap<>();

        final String[] props = {
            "java.specification.version",
            "java.vm.vendor",
            "java.vm.version"
        };

        for (String prop : props) {
            result.put(prop, System.getProperty(prop));
        }

        return result;
    }
}
