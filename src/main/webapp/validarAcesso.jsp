<%
session.setAttribute("Acesso", request.getAttribute("logar"));
response.sendRedirect("main");
%>
