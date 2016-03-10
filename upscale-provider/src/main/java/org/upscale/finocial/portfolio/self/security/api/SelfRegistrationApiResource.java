/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.fineract.portfolio.self.security.api;


import javax.annotation.security.PermitAll;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.fineract.commands.domain.CommandWrapper;
import org.apache.fineract.commands.service.CommandWrapperBuilder;
import org.apache.fineract.commands.service.PortfolioCommandSourceWritePlatformService;
import org.apache.fineract.infrastructure.core.api.ApiRequestParameterHelper;
import org.apache.fineract.infrastructure.core.data.CommandProcessingResult;
import org.apache.fineract.infrastructure.core.serialization.ToApiJsonSerializer;
import org.apache.fineract.useradministration.data.AppUserData;
import org.apache.fineract.useradministration.service.AppUserWritePlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Path("/self/register")
@Component
@Profile("basicauth")
@Scope("singleton")
public class SelfRegistrationApiResource {
	
    private final ApiRequestParameterHelper apiRequestParameterHelper;
    private final PortfolioCommandSourceWritePlatformService commandsSourceWritePlatformService;
	private final AppUserWritePlatformService appUserWritePlatforservice;
	private final ToApiJsonSerializer<AppUserData> toApiJsonSerializer;
	
	@Autowired
	public SelfRegistrationApiResource(final ApiRequestParameterHelper apiRequestParameterHelper,
			final PortfolioCommandSourceWritePlatformService commandsSourceWritePlatformService,
			final AppUserWritePlatformService appUserWritePlatformservice,final ToApiJsonSerializer<AppUserData> toApiJsonSerializer){
		this.apiRequestParameterHelper = apiRequestParameterHelper;
		this.commandsSourceWritePlatformService = commandsSourceWritePlatformService;
		this.appUserWritePlatforservice = appUserWritePlatformservice;
		this.toApiJsonSerializer = toApiJsonSerializer;
	}
	
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public String register(final String apiRequestBodyAsJson){

		final CommandWrapper commandRequest = new CommandWrapperBuilder() //
				.createUser() //
				.withJson(apiRequestBodyAsJson) //
				.build(); //
				
				
		final CommandProcessingResult result = this.commandsSourceWritePlatformService.logCommandSource(commandRequest);

        return this.toApiJsonSerializer.serialize(result);

		
		
		
	}
	
	
	
	
}
