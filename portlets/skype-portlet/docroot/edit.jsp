<%--
/**
 * Copyright (C) 2005-2014 Rivet Logic Corporation.
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; version 3 of the License.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 */
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:actionURL name="savePreferences" var="savePreferencesURL"/>

<aui:form name="fm" action="${savePreferencesURL}">
	<aui:input name="usersPerPage" label="label.users.per.page" value="${prefBean.usersPerPage}" >
		<aui:validator name="digits"/>
		<aui:validator name="required"/>
	</aui:input>
	<aui:input name="groupsPerPage" label="label.groups.per.page" value="${prefBean.groupsPerPage}">
		<aui:validator name="digits"/>
		<aui:validator name="required"/>
	</aui:input>
	<aui:button-row>
		<aui:button type="submit" value="submit"/>
	</aui:button-row>
</aui:form>