<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New License</title>
</head>
<body>
	<div id="container">
		<div id="leftpanel">
			<h1>New License</h1>
			<form:form action="/addlicense" method="post" modelAttribute="licenseObject">
				<h2>
			        <form:label path="person">Person:</form:label>
			        <form:select path="person">
						<c:forEach items="${personslist}" var="per">
							<form:option value="${per.id}"><c:out value="${per.firstName} ${per.lastName}"/></form:option>
						</c:forEach>c:forEach>
					</form:select>
			    </h2>	  
			    <h2>
			        <form:label  path="state">State:</form:label>
    			    <form:select path="state">
						<c:forEach items="${states}" var="state">
							<form:option value="${state}"><c:out value="${state}"/></form:option>
						</c:forEach>c:forEach>
					</form:select>
			    </h2>
			    <h2>
			        <form:label path="expiration_date">Expiration Date:</form:label>
			        <form:input type="date" path="expiration_date"/>
			    </h2>
			    <input id="btn" type="submit" value="Create"/>	 
			</form:form>
		</div>
		<div>
		<form:errors path="licenseObject.*"/>
		</div>
	</div>
</body>
</html>