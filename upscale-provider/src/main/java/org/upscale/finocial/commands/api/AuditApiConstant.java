package org.upscale.finocial.commands.api;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AuditApiConstant {
	
	public static final String idParamName = "id";
	
	public static final String actionParamName = "actionName";
	
	public static final String entityParamName = "entityName";
	
	public static final String resourceIdParamName = "resourceId";
	
	public static final String subresourceIdParamName = "subresourceId";

	public static final String makerParamName = "maker";
	
	public static final String madeOnDateParamName = "madeOnDate";
	
	public static final String checkerParamName = "checker";
	
	public static final String checkedOnDateParamName = "checkedOnDate";
	
	public static final String processingResultParamName = "processingResult";
	
	public static final String commandAsJsonParamName = "commandAsJson";
	
	public static final String officeParamName = "officeName";
	
	@Deprecated
	public static final String groupLevelParamName = "groupLevelName";
	
	@Deprecated
	public static final String groupParamName = "groupName";
	
	public static final String clientParamName = "clientName";
	
	public static final String loanAccountNoParamName = "loanAccountNo";
	

	@Deprecated
	public static final String savingsAccountNoParamName = "savingsAccountNo";
	
	public static final String clientIdParamName = "clientId";
	
	public static final String loanIdParamName = "loanId";
	
	public static final String urlParamName = "url";
	
	public static final String appUsersParamName = "appUsers";
	
	public static final String actionNamesParam = "actionNames";
	
	public static final String entityNamesParam = "entityNames";
	
	public static final String processingResultsParamNane = "processingResults";
	
	
	
	
	
	public static final Set<String> RESPONSE_DATA_PARAMETERS = new HashSet<>(Arrays.asList("idParamName", "actionParamName", "entityParamName", "resourceIdParamName",
            "subresourceIdParamName", "makerParamName", "madeOnDateParamName", "checkerParamName", "checkedOnDateParamName", "processingResultParamName", "commandAsJsonParamName", "officeParamName",
            "groupLevelParamName", "groupParamName", "clientParamName", "loanAccountNoParamName", "savingsAccountNoParamName", "clientIdParamName", "loanIdParamName", "urlParamName"));

	public static final Set<String> RESPONSE_DATA_PARAMETERS_SEARCH_TEMPLATE = new HashSet<>(Arrays.asList("appUsersParamName", "actionNamesParam",
            "entityNamesParam", "processingResultsParamNane"));
	

}
