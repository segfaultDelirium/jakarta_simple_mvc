<%@ page import="schemas.Person" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Reading from database</title>
</head>
<body>

<jsp:useBean id="sql" scope="request" class="beans.Sql" />
<h1>Odczyt z bazy danych</h1>
<br />
<%
    List<Person> records = sql.getRecords();
    out.println("<table>");

    out.println("<tr>");
    out.println("<th>id</th>");
    out.println("<th>fname</th>");
    out.println("<th>lname</th>");
    out.println("<th>city</th>");
    out.println("</tr>");

    for (Person person : records) {
        out.println("<tr>");

        out.println("<td>" + person.id + "</td>");
        out.println("<td>" + person.fname + "</td>");
        out.println("<td>" + person.lname + "</td>");
        out.println("<td>" + person.city + "</td>");

        out.println("</tr>");
    }

    out.println("</table>");
%>
<span>koniec odczytu z bazy</span>

</body>
</html>