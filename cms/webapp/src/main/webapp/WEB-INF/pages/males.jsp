<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@include file="../../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<div class="page_conetnt">
	<div class="left_column">
		<h3 class="list_header">Males</h3>
		<h4 class="category">Available in Kennel</h4>
		<c:forEach items="${dogs.content}" var="dog" varStatus="status">
			
			<c:if test="${(status.index mod 2) == 0}">
				<div class="breathing-dog-container">
			</c:if>
			
				<div class="breathing-dog-div">
					<a href="/dogs/${dog.id}"> <img src="/image/${dog.mainImage.fileName}" />
					</a>
					<div class="name-badge">
						<a href="/dogs/${dog.id}">${dog.name}</a>
					</div>
				</div>
			<c:if test="${(status.index mod 2) == 1 || status.last}">
				</div>
			</c:if>
		</c:forEach>
	</div>
	<div class="right_column">
		<div class="news_feeds">
			<h3 class="page-header">Side Module</h3>
			<div class="custom">
				<p>This is a module where you might want to add some more information or an image, a link to your social media presence, or whatever makes sense for your site.</p>
				<p>You can edit this module in the module manager. Look for the Side Module.</p>
			</div>
		</div>
		<div class="right_links">
			<ul class="right_link_list">
				<li><a href="#">Link 1</a></li>
				<li><a href="#">Link 2</a></li>
			</ul>
		</div>
		<div class="visitors_number">Visitor Number: 13599</div>
	</div>
</div>
<%@include file="../../footer.jsp"%>