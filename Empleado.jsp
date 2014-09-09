<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="EN" lang="EN" dir="ltr">
<head profile="http://gmpg.org/xfn/11">
<title>Gallerised | Style Demo</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta http-equiv="imagetoolbar" content="no" />
<link rel="stylesheet" href="styles/layout.css" type="text/css" />
</head>
<body id="top">



	  <script language="javascript">
	  	
	  	var xhr;
	  	var titulo;
	  	var editorial;
	  	
	  	function consultarEmpleadoJSon()
	  	{  		  		
	  		// 1. Obtener Titulo a buscar del campo "titulo"
	  		var numero = document.getElementById("nss").value;
	  		
	  		// 2. Crear el objeto XMLHttpRequest
	  		iniciarObjetoXmlHttpRequest();
	  		
  			// 3. Establecer conexion con el server Http (Tomcat, WLS, Web Sphere)
  			establecerConexionConsulta(numero);
	  	}
	  	
	  		  	function consultarGeneralEmpleadoJSon()
	  	{  		  		
	  		
	  		// 2. Crear el objeto XMLHttpRequest
	  		iniciarObjetoXmlHttpRequest();
	  		
  			// 3. Establecer conexion con el server Http (Tomcat, WLS, Web Sphere)
  			establecerConexionConsultaGeneral();
	  	}
	  	
	  	

	  	function iniciarObjetoXmlHttpRequest()
	  	{
	  		if((window.XMLHttpRequest) || ((typeof XMLHttpRequest) != undefined))
  			{
  				xhr = new XMLHttpRequest();
  			}
  			else
	  		{
	  			xhr = new ActiveXObject(Microsoft.XMLHTTP);
	  		}
	  	}
	  	
	  	function establecerConexionConsulta(numero)
	  	{			
	  		xhr.onreadystatechange=obtenerDatosTit;
	  		xhr.open("GET","operacionEmpleado.action?nss="+numero+"&bConsultarJSon=Consultar+No.+Empleado",true);
	  		xhr.send(null);
	  	}
	  	

	  	function establecerConexionConsultaGeneral()
	  	{			
	  		xhr.onreadystatechange=obtenerDatosTit;
	  		xhr.open("GET","operacionEmpleado.action?bConsultarGeneralJSon=ConsultarGeneralJSON",true);
	  		xhr.send(null);
	  	}
	  
	  
	  	 	function obtenerDatosTit()
	  	{	  			  		
	  	var datosJson = eval("("+xhr.responseText+")");

	  		if(xhr.readyState==4) // && xhr.status==200)
	  		{
	  		var strHtml = "<table border=1>";
			strHtml = strHtml+"<tr><td>NSS</td><td>NOMBRE</td><td>DIRECCION</td><td>SALARIO</td><td>NACIMIENTO</td><td>SEXO</td><td>Supervisor</td><td>Departamento</td></tr>";
	  			for(var i =0; i<datosJson.length;i++)
	  			{
	  				strHtml = strHtml+"<tr>";
	  				strHtml = strHtml+"<td>"+datosJson[i].nss+"</td><td>"+datosJson[i].nombre+"</td><td>"+datosJson[i].direccion+"</td><td>"+datosJson[i].salario+"</td><td>"+datosJson[i].nacimiento+"</td>"+"<td>"+datosJson[i].sexo+"</td>"+"<td>"+datosJson[i].nssSupervisor+"</td>"+"<td>"+datosJson[i].noDepto+"</td>";
	  				strHtml = strHtml+"</tr>";
	  			}
	  			strHtml = strHtml+"</table>";

	  			document.getElementById("resultado").innerHTML=strHtml;
	  			
	  		}
	  		else
	  			document.getElementById("resultado").innerHTML="<i>"+"Obteniendo datos..."+"</i>";
	  	}
	  </script> 

      </ul>
    </div>

  
</div>
</body>
</html>
