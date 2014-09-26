package modelObrasYProgramas;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.nio.charset.*;

public class ObrasAD
{
    private Connection conexion;
    private CallableStatement callableStatement;
    private Obra obra;
    
    private Dependencia dependencia;
    private List<Dependencia> listaDependencia;

    private Estado estado;
    private List<Estado> listaEstado;

    private Impacto impacto;
    private List<Impacto> listaImpacto;
    
    private Inaugurador inaugurador;
    private List<Inaugurador> listaInaugurador;
    
    private PoblacionObjetivo poblacionObjetivo;
    private List<PoblacionObjetivo> listaPoblacionObjetivo;
    
    private TipoClasificacion tipoClasificacion;
    private List<TipoClasificacion> listaTipoClasificacion;
    
    private TipoInversion tipoInversion;
    private List<TipoInversion> listaTipoInversion;
    
    private TipoObra tipoObra;
    private List<TipoObra> listaTipoObra;
    
    private Statement statement;

    
    public ObrasAD()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion= DriverManager.getConnection("jdbc:mysql://localhost/ObrasYProgramas?user=root");
            System.out.println("Conexion exitosa a la BD");
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
        


    }
	
    public List<Estado> listaDeEstados(){
        ResultSet tr = null;
        String select = "SELECT * FROM estados";
        listaEstado = new ArrayList<Estado>();

        
        try{
            statement=conexion.createStatement();
            tr = statement.executeQuery(select);
            
            
            while(tr.next())
            {
                estado = new Estado();
                
                estado.setIdEstado(tr.getString("idEstado"));
                estado.setNombreEstado(tr.getString("nombreEstado"));
                estado.setLatitud(tr.getString("latitud"));
                estado.setLongitud(tr.getString("longitud"));
                
                listaEstado.add(estado);
                
            }
            
        }
        catch(SQLException sqle){
            System.out.println(sqle);

        }
        
        return listaEstado;
    }
    
    
    
    public List<Dependencia> listaDeDependencias(){
        ResultSet tr = null;
        String select = "SELECT * FROM dependencias";
        listaDependencia = new ArrayList<Dependencia>();
        
        
        try{
            statement=conexion.createStatement();
            tr = statement.executeQuery(select);
            
            
            while(tr.next())
            {
                dependencia = new Dependencia();
                
                dependencia.setIdDependencia(tr.getString("idDependencia"));
                dependencia.setNombreDependencia(tr.getString("nombreDependencia"));
                
                listaDependencia.add(dependencia);
                
            }
            
        }
        catch(SQLException sqle){
            System.out.println(sqle);
            
        }
        
        return listaDependencia;
    }
    
    
    
    public List<Impacto> listaDeImpactos(){
        ResultSet tr = null;
        String select = "SELECT * FROM impactos";
        listaImpacto = new ArrayList<Impacto>();
        
        
        try{
            statement=conexion.createStatement();
            tr = statement.executeQuery(select);
            
            
            while(tr.next())
            {
                impacto = new Impacto();
                
                impacto.setIdImpacto(tr.getString("idImpacto"));
                impacto.setNombreImpacto(tr.getString("nombreImpacto"));
                
                listaImpacto.add(impacto);
                
            }
            
        }
        catch(SQLException sqle){
            System.out.println(sqle);
            
        }
        
        return listaImpacto;
    }
    
    
    public List<Inaugurador> listaDeInauguradores(){
        
        ResultSet tr = null;
        String select = "SELECT * FROM cargo_inaugura";
        listaInaugurador = new ArrayList<Inaugurador>();
        
        
        try{
            statement=conexion.createStatement();
            tr = statement.executeQuery(select);
            
            
            while(tr.next())
            {
                inaugurador = new Inaugurador();
                
                inaugurador.setIdCargoInaugura(tr.getString("idCargoInaugura"));
                inaugurador.setNombreCargoInaugura(tr.getString("nombreCargoInaugura"));
                
                listaInaugurador.add(inaugurador);
                
            }
            
        }
        catch(SQLException sqle){
            System.out.println(sqle);
            
        }
        
        return listaInaugurador;
        
    }
    
    public List<PoblacionObjetivo> listaDePoblacionesObjetivo(){
    
        
        ResultSet tr = null;
        String select = "SELECT * FROM poblacion_objetivo";
        listaPoblacionObjetivo = new ArrayList<PoblacionObjetivo>();
        
        
        try{
            statement=conexion.createStatement();
            tr = statement.executeQuery(select);
            
            
            while(tr.next())
            {
                poblacionObjetivo = new PoblacionObjetivo();
                
                poblacionObjetivo.setIdPoblacion(tr.getString("idpoblacionObjetivo"));
                poblacionObjetivo.setNombrePoblacionObjetivo(tr.getString("nombrePobObj"));
                
                listaPoblacionObjetivo.add(poblacionObjetivo);
                
            }
            
        }
        catch(SQLException sqle){
            System.out.println(sqle);
            
        }
        
        return listaPoblacionObjetivo;

    
    }
    
    public List<TipoClasificacion>  listaDeClasificaciones(){
    
        
        ResultSet tr = null;
        String select = "SELECT * FROM tipo_clasificacion";
        listaTipoClasificacion = new ArrayList<TipoClasificacion>();
        
        
        try{
            statement=conexion.createStatement();
            tr = statement.executeQuery(select);
            
            
            while(tr.next())
            {
                tipoClasificacion = new TipoClasificacion();
                
                tipoClasificacion.setIdTipoClasificacion(tr.getString("idTipoClasificacion"));
                tipoClasificacion.setNombreTipoClasificacion(tr.getString("nombreTipoClasificacion"));
                
                listaTipoClasificacion.add(tipoClasificacion);
                
            }
            
        }
        catch(SQLException sqle){
            System.out.println(sqle);
            
        }
        
        return listaTipoClasificacion;
    
        
    }
    
    public List<TipoInversion> listaDeInversiones(){
        
        
        
        ResultSet tr = null;
        String select = "SELECT * FROM tipo_inversion";
        listaTipoInversion = new ArrayList<TipoInversion>();
        
        
        try{
            statement=conexion.createStatement();
            tr = statement.executeQuery(select);
            
            
            while(tr.next())
            {
                tipoInversion = new TipoInversion();
                
                tipoInversion.setIdTipoInversion(tr.getString("idTipoInversion"));
                tipoInversion.setNombreTipoInversion(tr.getString("nombreTipoInv"));
                
                listaTipoInversion.add(tipoInversion);
                
            }
            
        }
        catch(SQLException sqle){
            System.out.println(sqle);
            
        }
        
        return listaTipoInversion;
    
    }
    public List<TipoObra> listaDeObras(){
    
        
        
        
        ResultSet tr = null;
        String select = "SELECT * FROM tipo_obra";
        listaTipoObra = new ArrayList<TipoObra>();
        
        
        try{
            statement=conexion.createStatement();
            tr = statement.executeQuery(select);
            
            
            while(tr.next())
            {
                tipoObra = new TipoObra();
                
                tipoObra.setIdTipoObra(tr.getString("idTipoObra"));
                tipoObra.setNombreTipoObra(tr.getString("nombreTipoObra"));
                
                listaTipoObra.add(tipoObra);
                
            }
            
        }
        catch(SQLException sqle){
            System.out.println(sqle);
            
        }
        
        return listaTipoObra;
        

    }

    
    
    public Obra generarFichaTecnicaObra(String idObra)
	{
       /* ResultSet tr = null;

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
		*/
        obra = new Obra();
		return obra;
	}
    
}
