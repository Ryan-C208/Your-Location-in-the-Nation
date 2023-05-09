<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		
		
		<title>Zip Info</title>
		
		
		
		<style type="text/css">
		
		* {background-color: lightblue}
		
		
		
		
		.header {
			color: #4CAF50;
  			text-align: center;
   			font-family: Arial, Helvetica, sans-serif;		
		}
		
		.index {
			position: relative;
			left: -45%;
			bottom: 60%;
			background-color:  #4CAF50;
  			color: black;
  			border: 2px solid #4CAF50;
			height: 50px;
			width: 100px;
			
		}
		
		.message {
			color: red;
			font-size: 23px;
		}
		
		
		h1 {
 	 color: #4CAF50;
  	text-align: center;
   	font-family: Arial, Helvetica, sans-serif;
}
		
		
		.LocationTable{
			position : absolute;
			top: 70%;
			left: 12%;
			border: 1px solid;
		
		}
		tr, th {
			border: 1px solid;
		}
	
	
		
		.searchbar {
			text-align: center;
			height: 25px;
			width: 450px;
			
			
		}
		.save {
			background-color:  #4CAF50;
  			color: black;
  			border: 2px solid #4CAF50;
			position: absolute;
			height: 75px;
			width: 150px;
			top: 400%;
			left: 40%;
		
		
		}
		
		
		.Enter {
			background-color:  #4CAF50;
  			color: black;
  			border: 2px solid #4CAF50;
			position: relative;
			height: 75px;
			width: 150px;
			top: 10%;
		}
		.searchDiv {
			
  			margin: auto;
  			position: absolute;
  			text-align: center;
  			top: 40%;
  			bottom: 50%;
  			left: 25%;
  			
  			width: 50%;  
			
		}
		</style>
		
		
		
		
	
	
	
	
	</head>

	<body>

	
		<form action="${pageContext.servletContext.contextPath}/searchzip" method="post">
			
				<div class = "searchDiv">
				
				<input class = "searchbar" type="text" name="Zipcode" size="75" value="${Zipcode}" />
				
				<br>
				
				<input class = "Enter" type="Submit" name="submit" value="Search">
				
				<c:if test="${! empty Location}">
				
					<input class = "save" type="Submit" name="save" value="Save this Location">
				</c:if>
				
				</div>
				
			<div class="header">
				<input class = "index" type="Submit" name="index" value="Index">
				
				<h1 align="center">Enter the ZIP code that you would like more information about!</h1>
			
				
			
			
				<hr  color="black">
				
				
				
		
		
			</div>
				
				
			</form>
				
				
				
				
			<c:if test="${! empty errorMessage}">
					<div class="message">${errorMessage}</div>
				
				</c:if>
					
			<div class = "LocationTable">
					
				
				
				
				
				
				
					
					
				<c:if test="${! empty Location}">
				
				
				<table>
					
					<tr>
						<th>Name</th>
						<th>County</th>
						<th>State</th>
						<th>ZIP code</th>
						<th>Income</th>
						<th>Cost of Living(with rent)</th>
						<th>Cost of Living(with mortgage)</th>
						<th>Cost of Living(with no mortgage)</th>
						<th>Crime Rate</th>
						<th>Region</th>
						<th>Population</th>
					
					
					
					</tr>
					
					
					<tr>
					
						<th>${Location.locationName}</th>
						<th>${Location.county}</th>
						<th>${Location.state}</th>
						<th>${Location.zipcode}</th>
						<th>${avgsal}</th>
						<th>${Location.costOfLivingRent}</th>
						<th>${Location.costOfLivingOwnWithMortgage}</th>
						<th>${Location.costOfLivingOwnNoMortgage}</th>
						<th>${Location.crimeRate}</th>
						<th>${Location.region}</th>
						<th>${Location.population}</th>
					
					
					
					
					</tr>
					
					
					
					
					</table>
				
				</c:if>
				
				
				
				</div>
				
				<c:if test="${! empty success}">
					<div class="message">${success}</div>
				</c:if>
		
				
			
		
	</body>
</html>