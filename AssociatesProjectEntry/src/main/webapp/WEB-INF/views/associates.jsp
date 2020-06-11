<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Associates List</title>
</head>
<table>
	<thead>
		<td>Associate id</td>
		<td>Name</td>
		<td>Location</td>
		<td></td>
		<td></td>
	</thead>
	<c:forEach var="associate" items="${associates}">
	    <c:url var="updateLink" value="/associates/update?id=${associate.id }"/>
	    <c:url var="deleteLink" value="/associates/delete?id=${associate.id }"/>
    	<tr>
    		<td>${associate.gID}</td>
    		<td>${associate.name}</td>
    		<td>${associate.location}</td>
    		<td><a href="${updateLink}">Update</a></td>
    		<td><a href="${deleteLink}">Delete</a></td>
    	</tr>
	</c:forEach>
</table>
</html>