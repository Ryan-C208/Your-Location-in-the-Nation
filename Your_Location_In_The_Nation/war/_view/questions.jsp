<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>

<head>
  <title>Questions</title>
  
     <style>
        .img-container{
            text-align: center;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%,-50%);
width: 380px;
padding: 20px 30px;
background:#fff;
box-shadow: 2px 2px 5px 5px rgba(0,0,0,0.15);
border-radius: 10px;

        }
        
body{
animation: transition 0.75s;
}
@keyframes transition {
    from{
opacity: 0;
transform: translate(-10px);

    }
  to{
    opacity: 1;
    transform: translate(0);
  }  
}
h1 {
  color: #4CAF50;
  text-align: center;
   font-family: Arial, Helvetica, sans-serif;
}

h2 {
  color: #4CAF50;
   font-family: Arial, Helvetica, sans-serif;
}







.button {
    background-color: #4CAF50; 
  border: none;
  color: white;
  padding: 16px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
  border-radius: 10px;
}
.button1 {
  background-color:  #4CAF50;
  color: black;
  border: 2px solid #4CAF50;
}

.button1:hover {
  background-color: lightblue;
  color: white;
}

.button2 {
  background-color: #4CAF50;
  color: black;
  border: 2px solid #4CAF50;
}

.button2:hover {
  background-color: lightblue;
  color: white;
}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #4CAF50;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

/* Change the link color to #111 (black) on hover */
li a:hover {
  background-color: lightblue;
}
.active {
  background-color: lightblue;
}

.container {
  position: relative;
}

.topleft {
  position: absolute;
  top: 8px;
  left: 16px;
  font-size: 18px;
}

img { 
  width: 100%;
  height: auto;
  opacity: 0.3;
}


.loader {
  border: 16px solid #f3f3f3;
  border-radius: 50%;
  border-top: 16px solid green;
  width: 120px;
  height: 120px;
  -webkit-animation: spin 2s linear infinite; /* Safari */
  animation: spin 2s linear infinite;
  position: absolute;
  top: 80%;
  left: 45%
}


@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}



=======
td.label {
			text-align: right;
			color: #4CAF50;
		}
		
td.label1 {
		
		color: black;
		position: relative;
		left: 20%;

}

        </style>
  
</head>
<body>


<h1>Your Location In The Nation! </h1>
<hr>

    <div class="img-container"> 

<h2>Please answer each question.
  (All factors must add up to ten and none can be zero!)
</h2>
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
	
		
<form action="${pageContext.servletContext.contextPath}/questions" method="post">
 
			<table>
				<tr>
					<td class="label">Crime rate:</td>
					<td><input type="text" name="crimeRate" size="12" value="${crimeRate}" /></td>
				</tr>
        

				<tr>
					<td class="label">Average salary:</td>
					<td><input type="text" name="averageSalary" size="12" value="${averageSalary}" /></td>
				</tr>

				<tr>
					<td class="label">Cost of living:</td>
					<td><input type="text" name="costOfLiving" size="12" value="${costOfLiving}" /></td>
				</tr>
				
				<tr>
					
					<td class = "label1"> Are you looking to rent or own property?
					<select name = "COLTypes" multiple class="selectChoices">
  					<option value="Rent">I'm looking to rent</option>
  					<option value="Mortgage">I'm looking to own with Mortgage</option>
  					<option value="NoMortgage">I'm looking to own with no Mortgage</option>
  				
					</select>
					</td>
				
				</tr>
				
				
				
			</table>
			
			
			
			
			
      
			<input class="button button1" id = "doLoad" type="Submit" name="submit" value="Submit!">
			<script type="text/javascript">
    		
    			
    			const divItem = document.getElementById('doLoad');	
    			console.log("hi");
    			divItem.addEventListener('click', divClick);
    			
    			function divClick() {
    				console.log("HI");
    				
    				const div = document.createElement("DIV");
    		        
    		        
            		div.className = "loader";
            		document.body.appendChild(div);
            	
            		
            		
    			}
    			
    			
    			
    			
    </script>
      <br> 
    
  
     
		<input class="button button2" type="Submit" name="Backtoindex" value="Back to index">

  </form>

</div>
  
  
  <style>
      body{
        background-color: lightblue;
      }
    </style>
    
    
	</body>
</html>