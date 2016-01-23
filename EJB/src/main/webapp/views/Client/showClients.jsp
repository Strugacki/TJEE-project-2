<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pl">
<head>
	<script>
		$(document).ready(function()
				{		
				$.ajax
					(
						{
							url: '${pageContext.request.contextPath}/rest/clientr/getAll',
							type: 'GET',
							success: function(dane)
							{ 
								var d = data.length;
								var table = document.getElementById("table");
								for (var i = 0; i < d; i++)
								{

									    tr = $('<tr/>');
									    tr.append("<td>"+data[i].firstName+"</td>");
									    tr.append("<td>"+data[i].lastName+"</td>");
									    tr.append("<td>"+data[i].phoneNumber+"</td>");
									    td = $('<td/>');
									    tr.append(td);
									    $(table).append(tr);
								}
							}
						}	
					);
				}
			);
	</script>
</head>

<body>

<div class="container">
    <div class="row">
        <h1 class="text-center">Clients</h1>
        <br/>

        <table id="table" class="table table-striped">
               <tr>
                     <th>First name</th>
                     <th>Last name</th>
                     <th>Phone number</th>
                     <th></th>
              </tr>
	</table>
    </div>
   </div>
    <script src="${pageContext.request.contextPath}/views/elements/jquery-min.js"></script>
	<script src="${pageContext.request.contextPath}/views/elements/jquery-ui.js"></script>
</body>
</html>
