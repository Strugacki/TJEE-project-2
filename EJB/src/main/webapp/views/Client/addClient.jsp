<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pl">
<head>
	<script>
		$(document).ready(function()
			{
				$( "#add" ).on('click', function(e)
					{	
						e.preventDefault();
						$.ajax
						(
						{
						    url: '${pageContext.request.contextPath}/rest/clientr/add',
						    type: 'POST',
						    data:
							{
						    	firstName: document.getElementById('firstName').value,
								lastName: document.getElementById('lastName').value,
								phoneNumber: document.getElementById('phoneNumber').value
								
							},
						    success: function() { document.location.replace("${pageContext.request.contextPath}/Client"); },
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
        <h1 class="text-center">Add client</h1>

        	<form action="${pageContext.request.contextPath}/rest/clientr/add" data-toggle="validator" method="post" class="form-horizontal">
        	
		        <div class="form-group">
		            <label for="firstName" class="col-sm-2 control-label">First name: </label>

		            <div class="col-sm-10">
		                <input type="text" name="firstName" id="firstName" class="form-control" data-minlength="2" required>
		            </div>
		        </div>

		        <div class="form-group">
		            <label for="lastName" class="col-sm-2 control-label">Last name: </label>

		            <div class="col-sm-10">
		                <input type="text" name="lastName" id="lastName" class="form-control"  required>
		            </div>
		        </div>

		        <div class="form-group">
		            <label for="phoneNumber" class="col-sm-2 control-label">Phone number</label>

		            <div class="col-sm-10">
		                <input type="text" name="phoneNumber" id="phoneNumber" class="form-control" placeholder="0" required>
		            </div>
		        </div>
		        <div class="form-group text-center">
		                <button id="add" type="submit" class="btn btn-success">Dodaj</button>
				<a href="${pageContext.request.contextPath}/Client" class="btn btn-default" role="button">return</a>
		 	    </div>
		        </div>
		        
          </form>
</div>

</body>
</html>
