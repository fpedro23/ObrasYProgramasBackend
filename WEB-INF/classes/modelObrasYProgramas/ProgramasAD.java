package modelObrasYProgramas;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.nio.charset.*;

public class ProgramasAD
{
    private Connection conexion;
    private Statement statement;
	    
    public ProgramasAD()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion= DriverManager.getConnection("jdbc:mysql://localhost/ObrasYProgramas?user=root");
        }
        catch(ClassNotFoundException cnfe)
        {
            System.out.println("Error: "+cnfe);
        }
        catch(InstantiationException ie)
        {
            System.out.println("Error: "+ie);
        }
        catch(IllegalAccessException iae)
        {
            System.out.println("Error: "+iae);
        }
        catch(SQLException sqle)
        {
            System.out.println("Error: "+sqle);
        }
        System.out.println("Conexion exitosa a la BD");

    }
	
    
    public List<Programa> consultarProgramas()
	{
        ResultSet tr = null;
		String datos="";
        String select="";
        List<Programa> listaProgramas = new ArrayList<Programa>();
        
        select  = "SELECT Programa.Id_programa,Dependencias.Nombre,Tipo_Apoyo.Nombre,Programa.Monto_Apoyo, Poblacion_Objetivo.Nombre,Programa.Total_Beneficiario,Estados.Nombre,Programa.Total_Municipios_Beneficiados,Programa.Inversion_Total,Programa.Meta_Beneficiarios,Programa.Absoluto, Programa.Porcentual,Programa.Observaciones FROM Programa JOIN Tipo_Apoyo USING (ID_Tipo_Apoyo) JOIN Estados USING (Id_Estado) JOIN Dependencias USING(Id_Dependencia) JOIN Poblacion_Objetivo USING (Id_Pob_Objetivo);";
		
        Charset.forName("UTF-8").encode(select);
        
        
		try
		{
            //1. abrir bd
			//archivoIn = new BufferedReader(new FileReader("Clientes.txt"));
            statement=conexion.createStatement();
            //1.5 ejecutar query
            tr=statement.executeQuery(select);
            
            //2. Procesar Datos
			//while(archivoIn.ready())
            //datos = datos + archivoIn.readLine() + "\n";
            
            while(tr.next())
            {
               Programa programa  = new Programa(
                                                 tr.getString("Id_Programa"),
                                                 tr.getString("Nombre"),
                                                 tr.getString("Nombre"),
                                                 tr.getString("Monto_Apoyo"),
                                                 tr.getString("Nombre"),
                                                 tr.getString("Total_Beneficiario"),
                                                 tr.getString("Nombre"),
                                                 tr.getString("Total_Municipios_Beneficiados"),
                                                 tr.getString("Inversion_Total"),
                                                 "100",
                                                 tr.getString("Meta_Beneficiarios"),
                                                 tr.getString("Absoluto"),
                                                 tr.getString("Porcentual"),
                                                 tr.getString("Observaciones")

                                                 );
                listaProgramas.add(programa);
                System.out.println("Datos: "+programa.toString());

            }
            
            
			//archivoIn.close();
            statement.close();
		}
        catch(SQLException sqle)
        {
            datos = "Error";
			System.out.println(sqle);
        }
		
		return listaProgramas;
	}
    
    
}
