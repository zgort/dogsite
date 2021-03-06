<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<link href="<c:url value="/adminResources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/adminResources/css/fileinput.min.css" />" rel="stylesheet">
<link href="<c:url value="/adminResources/css/bootstrap-theme.min.css" />" rel="stylesheet">
<link href="<c:url value="/adminResources/css/datepicker/bootstrap-datepicker.min.css" />" rel="stylesheet">
<script src="<c:url value="/adminResources/js/jquery.min.js" />"></script>
<script src="<c:url value="/adminResources/js/fileinput.min.js" />"></script>
<script src="<c:url value="/adminResources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/adminResources/js/datepicker/bootstrap-datepicker.min.js" />"></script>

<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Dog Page</title>

<script type="text/javascript">
	$(document).ready(function() {
		$('#dateOfBirth').datepicker({
			format : "dd/mm/yyyy",
			todayBtn : "linked",
			startView : 2,
			autoclose : true,
			todayHighlight : true
		});
		$('#sortDate').datepicker({
			format : "dd/mm/yyyy",
			todayBtn : "linked",
			startView : 3,
			autoclose : true,
			todayHighlight : true,
			todayBtn : "linked"
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$("input[type='file']").fileinput({'showUpload':false, 'previewFileType':'any'});
	});
</script>
</head>
<body>

	<h2>Dog Information</h2>

	<form:form method="${formMethod}" action="../dogs/${dogId}" enctype="multipart/form-data">
		<table>
			<tr>
				<td><form:label path="name">Dog Name</form:label></td>
				<td><form:input path="name" /></td>
				<form:hidden path="id" />
			</tr>

			<tr>
				<td><form:label path="dateOfBirth">Date Of Birth</form:label></td>
				<fmt:formatDate value="${dateOfBirth}" var="dateString" pattern="dd/MM/yyyy" />
				<td><form:input id="dateOfBirth" path="dateOfBirth" value="${dateOfBirth}" cssClass="datepicker span2" /></td>
			</tr>

			<tr>
				<td><form:label path="sortDate">Sort Date</form:label></td>
				<fmt:formatDate value="${sortDate}" var="dateString" pattern="dd/MM/yyyy" />
				<td><form:input id="sortDate" path="sortDate" value="${sortDate}" cssClass="datepicker span2" /></td>
			</tr>

			<tr>
				<td><form:label path="desc">Dog Description</form:label></td>
				<td><form:input id="desc" path="desc" /></td>
			</tr>

			<tr>
				<td><form:label path="male">Male</form:label></td>
				<td><form:checkbox id="male" path="male" /></td>
			</tr>
			<tr>
				<td><form:label path="forSale">For Sale</form:label></td>
				<td><form:checkbox path="forSale" /></td>
			</tr>
			<tr>
				<td><form:label path="publish">Publish</form:label></td>
				<td><form:checkbox path="publish" /></td>
			</tr>
		</table>
		<table>
			<tr>
				<td>
					<p>Select main Image</p>
					<table id="mainImageTable">
						<tr>
							<td><input name="mainImageFile" type="file" /></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<p>Select Images to upload. Press Add button to add more Images.</p>
					<table id="imageTable">
						<tr>
							<td><input name="imageFile" type="file" multiple/></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<p>Select Reports to upload. Press Add button to add more Reports.</p>
					<table id="reportTable">
						<tr>
							<td><input name="reportFile" type="file" multiple/></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<p>Select xRayImage to upload. Press Add button to add more XRayImage.</p>
					<table id="xRayImageTable">
						<tr>
							<td><input name="xRayImageFile" type="file" multiple/></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<input type="submit" value="Submit" class="btn btn-primary" />
		<input type="button" onclick="location.href='../dogs/'" value="Cancel" class="btn btn-default">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form:form>

</body>
</html>