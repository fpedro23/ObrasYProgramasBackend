package DBManagement;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

/**
 * Created by pedrocontreras on 27/02/15.
 */
public class DataSourceFactory {

    public static DataSource getMySQLDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/obrasyprogramas");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }
}
