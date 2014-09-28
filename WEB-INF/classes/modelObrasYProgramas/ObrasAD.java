package modelObrasYProgramas;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.nio.charset.*;

public class ObrasAD
{
    private Connection conexion;
    private CallableStatement callableStatement;
    private Statement statement;
    private List<Obra> listaBusqueda;

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
    
    

    
    public ObrasAD()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion= DriverManager.getConnection("jdbc:mysql://localhost/ObrasYProgramas?user=root");
            
            //conexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/obrasyprogramas","oypdbuser","0ypProj3ct!");

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

    
    
    public List<Obra> buscar(Consulta consulta)
	{
        
        ResultSet tr = null;
        listaBusqueda = new ArrayList<Obra>();

        
        
        try{
            callableStatement = conexion.prepareCall("{CALL buscarObras(?,?,?,?,?,?,?,?,?,?,?,?)}");
            
            callableStatement.setString("inTipoObra", consulta.getTipoDeObra());
            callableStatement.setString("inDependencia", consulta.getDependencia());
            callableStatement.setString("inEstado", consulta.getEstado());
            callableStatement.setString("inMunicipio", null); //Municipio
            callableStatement.setString("inRangoInversionMin", consulta.getInversionMinima());
            callableStatement.setString("inRangoInversionMax", consulta.getInversionMaxima());
            callableStatement.setString("inFechaInicio", consulta.getFechaInicio());
            callableStatement.setString("inFechaTermino", consulta.getFechaFin());
            callableStatement.setString("inImpacto", consulta.getImpacto());
            callableStatement.setString("inCargoInaugura", consulta.getInaugurador());
            callableStatement.setString("inTipoInversion", consulta.getTipoDeInversion());
            callableStatement.setString("inTipoClasificacion", consulta.getClasificacion());
            
            
            
            boolean hasResults = callableStatement.execute();
            
            tr = callableStatement.getResultSet();
            System.out.println(hasResults);

            
            while(tr.next())
            {
                obra  = new Obra();
                
                obra.setIdObra(tr.getString(1));
                obra.setDenominacion(tr.getString(2));
                
                obra.tipoObra.setIdTipoObra(tr.getString(3));
                obra.tipoObra.setNombreTipoObra(tr.getString(4));
                
                obra.dependencia.setIdDependencia(tr.getString(5));
                obra.dependencia.setNombreDependencia(tr.getString(6));

                obra.estado.setIdEstado(tr.getString(7));
                obra.estado.setNombreEstado(tr.getString(8));
                obra.estado.setLatitud(tr.getString(9));
                obra.estado.setLongitud(tr.getString(10));
                
                obra.municipio.setIdMunicipio(tr.getString(11));
                obra.municipio.setEstado(obra.estado);
                obra.municipio.setNombreMunicipio(tr.getString(12));
                obra.municipio.setLatitud(tr.getString(13));
                obra.municipio.setLongitud(tr.getString(14));
                
                obra.poblacionObjetivo.setIdPoblacion(tr.getString(15));
                obra.poblacionObjetivo.setNombrePoblacionObjetivo(tr.getString(16));
        
                
                obra.impacto.setIdImpacto(tr.getString(17));
                obra.impacto.setNombreImpacto(tr.getString(18));
                
                //Hacer codigo para que de un tokenizer se vaya a objeto
                /*obra.tipoInversion.setIdDependencia(tr.getString(19));
                obra.tipoInversion.setNombreDependencia(tr.getString(20));
                
                obra.clasificacion.setIdDependencia(tr.getString(21));
                obra.clasificacion.setNombreDependencia(tr.getString(22));*/
                //Hacer Codigo para que de un tokenizer
                
                
               obra.inaugurador.setIdCargoInaugura(tr.getString(23));
                obra.inaugurador.setNombreCargoInaugura(tr.getString(24));
                
                obra.setDescripcion(tr.getString(25));
                obra.setObservaciones(tr.getString(26));
                obra.setFechaInicio(tr.getString(27));
                obra.setFechaTermino(tr.getString(28));
                obra.setInversionTotal(tr.getString(29));
                obra.setTotalBeneficiarios(tr.getString(30));
                obra.setSenalizacion(tr.getString(31));
                obra.setSusceptibleInauguracion(tr.getString(32));
                obra.setPorcentajeAvance(tr.getString(33));
                System.out.println(obra.toString());
                System.out.println(obra.toString());

                listaBusqueda.add(obra);
                
            }
            
        }
        catch(SQLException sqle){
            System.out.println(sqle);
            
        }
        
        return listaBusqueda;

    }
    
}
