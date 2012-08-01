/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jclouds.azure.servicemanagement;

import java.util.concurrent.TimeUnit;

import org.jclouds.azure.servicemanagement.features.RoleClient;
import org.jclouds.concurrent.Timeout;
import org.jclouds.rest.annotations.Delegate;

/**
 * Provides synchronous access to Azure Service Management.
 * <p/>
 * 
 * @see AzureServiceManagementAsyncClient
 * @see <a href="http://msdn.microsoft.com/en-us/library/ee460799" />
 * @author Gerald Pereira
 */
@Timeout(duration = 4, timeUnit = TimeUnit.SECONDS)
public interface AzureServiceManagementClient {

	/**
	 * Provides synchronous access to Role features.
	 */
	@Delegate
	RoleClient getRoleClient();

}
