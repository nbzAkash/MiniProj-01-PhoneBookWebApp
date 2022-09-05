<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Contact Application</h1>
<h2>Contact Info Form</h2>

<font color='green'>${succMsg}</font>
<font color='red'>${errMsg}</font>

<form:form action="saveContact" method="Post" modelAttribute="contact" >


           <table border="1" align="center" tablespacing="10" padding="10" bgcolor="#DAF7A6">
                  <tr>
                      <td>Contact Name</td>
                      <td><form:input path="cname"/></td>
                      <form:hidden path="cid"/>
                  </tr>
                
                  
                  <tr>
                      <td>Contact Number</td>
                      <td><form:input path="cnum"/></td>
                  </tr>
                  
                  <tr>
                      <td>Contact Email</td>
                      <td><form:input path="email"/></td>
                  </tr>
                  
                  <tr>
                      <td><input type="submit" value="Submit"/></td>
                  </tr>
           </table>


</form:form>

<a href="viewContacts">View All Contacts</a>

</body>
</html>