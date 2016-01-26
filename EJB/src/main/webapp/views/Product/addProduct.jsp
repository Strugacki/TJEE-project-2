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
				$( "#add" ).on('click', function(e)
					{	
						e.preventDefault();
						$.ajax
						(
						{
						    url: '${pageContext.request.contextPath}/rest/productr/add',
						    type: 'POST',
						    data:
							{
						    	productName: document.getElementById('productName').value,
								brandName: document.getElementById('brandName').value,
								price: document.getElementById('price').value
			
							},
						    success: function() { document.location.replace("${pageContext.request.contextPath}/views/Product/showProducts.jsp"); },
 						    error: function() { alert("Nieprawidłowo wprowadzono dane!"); }
						}		
						);
					}
				);
			}
		);
	</script>
</head>

<body>

<div class="container">
    <div class="row">
        <h1 class="text-center">Add Product Rest</h1>

        	<form action="${pageContext.request.contextPath}/rest/productr/add" method="post" class="form-horizontal">
		        <div class="form-group">
		            <label for="productName" class="col-sm-2 control-label">Product name: </label>

		            <div class="col-sm-10">
		                <input type="text" name="productName" id="productName" class="form-control" required>
		            </div>
		        </div>

		        <div class="form-group">
		            <label for="brandName" class="col-sm-2 control-label">Brand name: </label>

		            <div class="col-sm-10">
		                <input type="text" name="brandName" id="brandName" class="form-control"  required>
		            </div>
		        </div>

		        <div class="form-group">
		            <label for="price" class="col-sm-2 control-label">Price: </label>

		            <div class="col-sm-10">
		                <input type="number" step="0.01" name="price" id="price" class="form-control" placeholder="0" required>
		            </div>
		        </div>
		        <div class="form-group text-center">
		                <button id="add" type="submit" class="btn btn-success">Add</button>
				<a href="${pageContext.request.contextPath}/views/Product/showProducts.jsp" class="btn btn-default" role="button">Return</a>
		 	    </div>
		        </div>
		        
          </form>
</div>

</body>
</html>
