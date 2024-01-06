package database;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private final String url = "jdbc:mysql://localhost:3306/mydb?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private final String username = "root";
    private final String password = "";
    
    protected Connection connection;
    protected Statement statement;
    protected PreparedStatement prepare;   
    protected ResultSet result;
    protected ResultSetMetaData metaData;
    
    private final Component component;
    public Database(Component component){
        this.component = component;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
            this.statement = connection.createStatement();
        }catch(ClassNotFoundException | SQLException e){
          
        }              
    }
    
    public boolean isDatabaseConnected() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }    
}
