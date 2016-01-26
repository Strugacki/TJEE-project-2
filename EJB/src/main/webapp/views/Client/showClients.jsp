<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pl">
<head>
	<link href="${pageContext.request.contextPath}/views/elements/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/views/elements/bootstrap/css/jquery-ui.css" rel="stylesheet">
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
									    td.append(
"<a href='${pageContext.request.contextPath}/PodgladTrumna/"+data[i].id+"' class='btn btn-xs btn-warning' role='button'> Podgląd </a> "+
"<a href='${pageContext.request.contextPath}/EdytujTrumne/"+dane[i].id+"' class='btn btn-xs btn-primary' role='button'>Edytuj</a> "+
"<button id="+dane[i].id+" onClick='usun("+dane[i].id+")' type='submit' class='btn btn-xs btn-danger'>Usuń</button>");
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
