<h1>ObrasYProgramasBackend</h1>

======================

<h2>Proyecto de Obras y Programas</h2>



Proyecto que contiene una instalación de el framework Struts 2 sobre Apache Tomcat 7. 

En el proyecto hay un script que sirve para inicializar el server. Básicamente setea las siguientes variables de entorno:



export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home - La ruta hacia los ejecutables de Java



export CATALINA_HOME=/Library/apache-tomcat-7.0.42

La ruta hacia el servidor de apache tomcat.



export STRUTS_HOME=/Library/struts-2.3.15.3

La ruta hacia las clases de struts.



<h3>Rutas hacia los .jar para que puedan compilar bien los .java</h3>



* servlet-api.jar

* struts-core-1.3.10.jar

* struts-extras-1.3.10.jar:

* mysql-connector-java-5.1.23-bin.jar - Driver de la base de datos

* xwork-2.0.4.jar

* struts2-core-2.0.11.jar



export CLASSPATH=/Library/apache-tomcat-7.0.42/lib/servlet-api.jar:$CLASSPATH 

export CLASSPATH=/Library/apache-tomcat-7.0.42/webapps/BiblioStrutsAcc/WEB-INF/lib/struts-core-1.3.10.jar:$CLASSPATH

export CLASSPATH=/Library/apache-tomcat-7.0.42/webapps/BiblioStrutsAcc/WEB-INF/lib/struts-extras-1.3.10.jar:$CLASSPATH

export CLASSPATH=/Users/Pedro/Documents/Escuela/CuartoSemestre/BaseDatos/mysql-connector-java-5.1.23/mysql-connector-java-5.1.23-bin.jar:$CLASSPATH

export CLASSPATH=/Library/apache-tomcat-7.0.42/webapps/companyStrutsJQuery/WEB-INF/lib/xwork-2.0.4.jar:$CLASSPATH

export CLASSPATH=/Library/apache-tomcat-7.0.42/webapps/companyStrutsJQuery/WEB-INF/lib/struts2-core-2.0.11.jar:$CLASSPATH


cd /Library/apache-tomcat-7.0.42/bin - Navegar hacia el directorio /bin de apache

./startup.sh - Iniciar el Server
