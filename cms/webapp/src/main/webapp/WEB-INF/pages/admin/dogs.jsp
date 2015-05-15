<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<link href="<c:url value="/adminResources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/adminResources/css/bootstrap-theme.min.css" />" rel="stylesheet">
<script src="<c:url value="/adminResources/js/jquery.min.js" />"></script>
<script src="<c:url value="/adminResources/js/bootstrap.min.js" />"></script>

<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Dogs List</title>

</head>
<body>
	<h2>Dog List</h2>
	<input type="button" onclick="location.href='../dogs/0'" value="Add New Dog" class="btn btn-default">
	<div class="table-responsive">
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Publish</th>
					<th>For Sale</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty dogs}">
					<c:forEach var="dog" items="${dogs}">
						<tr>
							<td><a href="../dogs/${dog.id}">${dog.id}</a></td>
							<td><a href="../dogs/${dog.id}">${dog.name}</a></td>
							<td><a href="../dogs/${dog.id}">${dog.publish}</a></td>
							<td><a href="../dogs/${dog.id}">${dog.forSale}</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</body>
</html>