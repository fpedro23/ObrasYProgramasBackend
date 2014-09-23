package modelObrasYProgramas;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.nio.charset.*;

public class ObrasAD
{
    private Connection conexion;
    private CallableStatement statement;
    private List<String> nombreTipoClasificacion;
    private List<String> nombreTipoInversion;
    private Obra obra;
    public ObrasAD()
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
        
       nombreTipoClasificacion =  new ArrayList<String>();

        nombreTipoInversion= new ArrayList<String>();

    }
	
    

    
    public Obra generarFichaTecnicaObra(String idObra)
	{
        ResultSet tr = null;

        System.out.println("Entro");

        
		try
		{
            statement = conexion.prepareCall("{CALL generarFichaTecnicaObra(?)}");
            statement.setString(1, idObra);
            boolean hasResults = statement.execute();
            int contador = 0;
            
            System.out.println("hasResults: "+hasResults);

            while(hasResults)
            {
                if(contador == 0){
                    tr = statement.getResultSet();
                    if(tr.next()){
                     obra  = new Obra(
                                          
                                          tr.getString("idObra"),
                                          tr.getString("nombreDependencia"),
                                          tr.getString("nombreEstado"),
                                          tr.getString("nombreMunicipio"),
                                          tr.getString("denominacion"),
                                          tr.getString("fechaInicio"),
                                          tr.getString("fechaTermino"),
                                          tr.getString("inversionTotal"),
                                          tr.getString("nombrePobObj"),
                                          tr.getString("totalBeneficiarios"),
                                          tr.getString("nombreImpacto"),
                                          tr.getString("descripcion"),
                                          null,
                                          null
                                      );}
                }
                else if (contador == 1){
                    
                    tr = statement.getResultSet();
                    
                    while(tr.next())
                    {
                        nombreTipoInversion.add(tr.getString("nombreTipoInv"));
                    }
                    
                }
                else if(contador==2){
                    
                    tr = statement.getResultSet();
                    
                    while(tr.next())
                    {
                        nombreTipoClasificacion.add(tr.getString("nombreTipoClasificacion"));
                    }
                    
                }
                
                hasResults = statement.getMoreResults();
                contador++;
            }
            
            obra.setNombreTipoInversion(nombreTipoInversion);
            obra.setNombreTipoClasificacion(nombreTipoClasificacion);
			//archivoIn.close();
            statement.close();
		}
        catch(SQLException sqle)
        {
			System.out.println(sqle);
        }
		
		return obra;
	}
    
}
