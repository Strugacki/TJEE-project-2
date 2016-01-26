<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pl">
<head>
	<link href="${pageContext.request.contextPath}/views/elements/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/views/elements/bootstrap/css/jquery-ui.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/views/elements/jquery-min.js"></script>
	<script src="${pageContext.request.contextPath}/views/elements/jquery-ui.js"></script>
	<script>
		$(document).ready(function()
				{		
				$.ajax
					(
						{
							url: '${pageContext.request.contextPath}/rest/productr/all',
							type: 'GET',
							success: function(data)
							{ 
								var d = data.length;
								for (var i = 0; i < d; i++)
								{

									var tblRow = "<tr>" + "<td>"
									+ data[i].productName + "</td>"
									+ "<td>" + data[i].brandName
									+ "</td>" + "<td>"
									+ data[i].price + "</td>"
									+ "<td><a href='${pageContext.request.contextPath}/updateProduct/"+data[i].id+"' class='btn btn-xs btn-primary' role='button'>Update</a> "+
									"<button id="+data[i].id+" onClick='deleteProduct("+data[i].id+")' type='submit' class='btn btn-xs btn-danger'>Delete</button></td>"
									+ "</tr>"
								$(tblRow).appendTo("#table tbody");
								}
							}
						}	
					);
				}
			);
	</script>
	<script>
		function deleteProduct(id)
				{	
					$.ajax
					(
						{
							url: '${pageContext.request.contextPath}/rest/productr/delete/'+id,
							type: 'DELETE',
							success: function() { document.location.reload(true);}
						}	
					);
				}
	</script>
</head>

<body>

<div class="container">
    <div class="row">
        <h1 class="text-center">Products</h1>
        <br/>

        <table id="table" class="table table-striped">
               <thead>
                     <th>Product name</th>
                     <th>Brand name</th>
                     <th>Price</th>
                     <th></th>
              </thead>
              <tbody></tbody>
	</table>
    </div>
   </div>
</body>
</html>
