<%-- bookList.jsp --%>
<%@ page import="java.util.List, java.util.*" %>
<html>
<body>
<h2>Library Books</h2>
<table border="1">
<tr><th>ID</th><th>Title</th><th>Author</th></tr>
<%
List<Book> books = (List<Book>) request.getAttribute("books");
for (Book b : books) {
%>
<tr><td><%= b.getBookId() %></td><td><%= b.getTitle() %></td><td><%= b.getAuthor() %></td></tr>
<%
}
%>
</table>
</body>
</html>