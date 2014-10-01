package modelObrasYProgramas;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.nio.charset.*;

public class ProgramasAD
{
    private Connection conexion;
    private Statement statement;
    private CallableStatement callableStatement;

    private List<Programa> listaBusqueda;
    private Programa programa;
    private ResultadoPrograma resultadoPrograma;


    
    public ProgramasAD()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //conexion= DriverManager.getConnection("jdbc:mysql://localhost/ObrasYProgramas?user=root");
            
            conexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/obrasyprogramas","oypdbuser","0ypProj3ct!");
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
	
    
    public ResultadoPrograma buscar(Consulta consulta)
    {
        
        ResultSet tr = null;
        listaBusqueda = new ArrayList<Programa>();
        
        
        
        try{
            callableStatement = conexion.prepareCall("{CALL buscarProgramas(?,?,?,?,?)}");
            
            callableStatement.setString("inDependencia", consulta.getDependencia());
            callableStatement.setString("inEstado", consulta.getEstado());
            callableStatement.setString("inRangoInversionMin", consulta.getInversionMinima());
            callableStatement.setString("inRangoInversionMax", consulta.getInversionMaxima());
            callableStatement.setString("inTipoClasificacion", consulta.getClasificacion());
            
            
            
            boolean hasResults = callableStatement.execute();
            
            tr = callableStatement.getResultSet();
            System.out.println(hasResults);
            
            
            while(tr.next())
            {
                programa  = new Programa(tr);
                
                
                listaBusqueda.add(programa);
                
            }
            
        }
        catch(SQLException sqle){
            System.out.println(sqle);
            
        }
        
        resultadoPrograma = new ResultadoPrograma();
        resultadoPrograma.setListaProgramas(listaBusqueda);
        
        return resultadoPrograma;
        
    }

    
}
