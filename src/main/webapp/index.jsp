<%@  page import="java.io.*,java.util.*" %>
<% out.print(session.getAttribute("session")); %>
<% out.print(sessionScope.session) %>