<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.util.StringTokenizer" errorPage="" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.io.*" errorPage="" %>



<%
	String respuesta = (String)request.getAttribute("datos");
	StringTokenizer st = new StringTokenizer(respuesta,"_\n");	

%>
<%
//<A HREF="biblio1?bModificar=modificar&clave=1133">1133</a>
//<A HREF="biblioDB/biblioteca?bModificar=modificar&tfClave=1133"</a>
		String arrayDatosJSon = "[";
		while(st.hasMoreTokens()){
			String nss 	  = st.nextToken();
			String nombre     = st.nextToken();
			String direccion     = st.nextToken();
			String salario  = st.nextToken();
			String nacimiento = st.nextToken();
			String sexo     = st.nextToken();
			String nssSupervisor     = st.nextToken();
			String noDepto     = st.nextToken();

			arrayDatosJSon = arrayDatosJSon+"{nss:'"+nss+"',nombre:'"+nombre+"',direccion:\""+direccion+"\",salario:\""+salario+"\",nacimiento:\""+nacimiento+"\",sexo:\""+sexo+"\",nssSupervisor:\""+nssSupervisor+"\",noDepto:\""+noDepto+"\"},";

		}
		char array[] = arrayDatosJSon.toCharArray();
		System.out.println(array[arrayDatosJSon.length()-1]);
		array[arrayDatosJSon.length()-1] = ']';
		//System.out.println(array[arrayDatosJSon.length()-1]);
		
		arrayDatosJSon = new String(array);
		
		out.println(arrayDatosJSon);
		out.close();
		System.out.println(arrayDatosJSon);
%>

