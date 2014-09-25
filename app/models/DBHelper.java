package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBHelper {

    public static Connection con;

    // create connectrion to database
    public Connection getConnection(String userName, String password, String dbName) throws SQLException,
	    ClassNotFoundException {

	Class.forName("org.h2.Driver");
	con = DriverManager.getConnection("jdbc:h2:mem:" + dbName);
	Properties connectionProps = new Properties();
	connectionProps.put("user", userName);
	connectionProps.put("password", password);

	System.out.println("Connected to database");
	return con;
    }

    public void createTable(String dbName) throws SQLException {
	String createString = "create table " + dbName + ".USERS " + "(USER_ID integer NOT NULL, "
		+ "NAME varchar(40) NOT NULL, " + "EMAIL varchar(40) NOT NULL, " + "PHONE varchar(40) NOT NULL, "
		+ "COMPANY_NAME varchar(40) NOT NULL, " + "STREET_ADDRESS varchar(40) NOT NULL, "
		+ "PRIMARY KEY (USER_ID))";

	Statement stmt = null;
	try {
	    // CON - CONNECTION
	    stmt = con.createStatement();
	    stmt.executeUpdate(createString);
	} catch (SQLException e) {

	} finally {
	    if (stmt != null) {
		stmt.close();
	    }
	}
    }

}
