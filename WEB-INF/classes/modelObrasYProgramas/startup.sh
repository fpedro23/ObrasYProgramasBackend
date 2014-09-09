export JAVA_HOME=/Library/Java/Home
export CATALINA_HOME=/Library/apache-tomcat-7.0.42
export STRUTS_HOME=/Library/struts-2.3.15.3
export STRUTS_HOME=/Library/struts-2.3.15.3
export CLASSPATH=/Library/struts-2.3.15.3/lib/struts2-core-2.3.15.3.jar:$CLASSPATH
export CLASSPATH=/Library/apache-tomcat-7.0.42/lib/servlet-api.jar:$CLASSPATH
export CLASSPATH=/Library/apache-tomcat-7.0.42/webapps/proyectoSegundoParcial/WEB-INF/lib/mysql-connector-java-5.1.23-bin.jar:$CLASSPATH
export CLASSPATH=/Library/apache-tomcat-7.0.42/webapps/Struts2/WEB-INF/lib/xwork-core-2.3.15.3.jar:$CLASSPATH
export CLASSPATH=/Library/apache-tomcat-7.0.42/webapps/Struts2/WEB-INF/lib/struts2-core-2.3.15.3.jar:$CLASSPATH
export CLASSPATH=/Library/apache-tomcat-7.0.42/webapps/obras/WEB-INF/lib/xwork-2.0.4.jar:$CLASSPATH


cd /Library/apache-tomcat-7.0.42/bin
./startup.sh
