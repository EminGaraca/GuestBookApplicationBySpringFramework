<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guestbook</title>
    </head>
    <body>
        <h1>Guestbook</h1>
        <form:form action="impression.htm" method="post" commandName="impression">
            <form:label path="username">Enter your name : </form:label> <br/> 
            <form:input id="name" type="text" path="username" placeholder="your name..."></form:input> <br/> 
            <form:label path="text">Enter your impression : </form:label> <br/> 
            <form:textarea id="impression" path="text" placeholder="your impression..." rows="4" cols="50"></form:textarea> <br/> 
            <input type="submit" value="Submit"/> 
        </form:form>
            <label for="impression_list" id="impression_list_label">All impressions : </label> <br/> 
            <textarea id="impression_list" rows="20" cols="100" readonly="true">${impressions}</textarea>
    </body>
</html>
