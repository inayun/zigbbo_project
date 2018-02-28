<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="zigbo.model.dto.RequestDTO" %>

<% String url = application.getContextPath() + "/"; %>

<c:forEach var ="item" items = "${requestScope.recentRequestItems}" varStatus="status"> 
 		<div class="col-sm-4 col-md-3">
			<div class="thumbnail">
				<img src="img/${item.picture}" alt="" style="width:252.5px;height:252.5px;">
					<div class="caption">
							<h3 style="height:40px;">${item.title}</h3>
							<p style="text-align:right;">조회수: ${requestScope.requestList[status.index].views}</p>
							<p style="height:80px;">${item.detail }</p>
							<p>
								<a href='<%=url%>request?command=requestDetail&requestCode=${requestScope.requestList[status.index].requestCode}' class="btn btn-primary" role="button" style="margin-left:5px;"><i class="fa fa-krw"></i>${item.price}</a>
								<a href='<%=url%>request?command=requestDetail&requestCode=${requestScope.requestList[status.index].requestCode}' class="btn btn-default" role="button">상세보기</a>
							</p>
		      		</div>
		     </div>
		</div>
</c:forEach> 
 	
