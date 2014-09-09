<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.util.*" errorPage="" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.io.*" errorPage="" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="modelObrasYProgramas.*" errorPage="" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />



<%
	 List<Programa> listaProgramas;
	listaProgramas = (List)request.getAttribute("listaProgramas");


		out.println(listaProgramas.get(0).toString());
		//out.println(str);
		out.flush();
		
	
	
%>
</body>
</html>