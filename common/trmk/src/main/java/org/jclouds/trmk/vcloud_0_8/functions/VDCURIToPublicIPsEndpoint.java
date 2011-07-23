/**
 *
 * Copyright (C) 2011 Cloud Conscious, LLC. <info@cloudconscious.com>
 *
 * ====================================================================
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
 * ====================================================================
 */
package org.jclouds.trmk.vcloud_0_8.functions;

import java.net.URI;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jclouds.rest.ResourceNotFoundException;
import org.jclouds.trmk.vcloud_0_8.domain.ReferenceType;
import org.jclouds.trmk.vcloud_0_8.domain.TerremarkVDC;
import org.jclouds.trmk.vcloud_0_8.endpoints.VDC;

import com.google.common.base.Function;
import com.google.common.base.Supplier;

/**
 * 
 * @author Adrian Cole
 */
@Singleton
public class VDCURIToPublicIPsEndpoint implements Function<Object, URI> {
   private final Supplier<Map<URI, ? extends org.jclouds.trmk.vcloud_0_8.domain.VDC>> orgVDCMap;
   private final ReferenceType defaultVDC;

   @Inject
   public VDCURIToPublicIPsEndpoint(Supplier<Map<URI, ? extends org.jclouds.trmk.vcloud_0_8.domain.VDC>> orgVDCMap,
         @VDC ReferenceType defaultVDC) {
      this.orgVDCMap = orgVDCMap;
      this.defaultVDC = defaultVDC;
   }

   public URI apply(Object from) {
      try {
         return TerremarkVDC.class.cast(orgVDCMap.get().get(from == null ? defaultVDC.getHref() : from)).getPublicIps()
               .getHref();
      } catch (NullPointerException e) {
         throw new ResourceNotFoundException("vdc " + from + " not found in " + orgVDCMap.get());
      }
   }

}