package in.pwskills;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcSelectApp {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql:///javaconnectiondb";
		String username = "root";
		String password = "root";

		Connection connection = DriverManager.getConnection(url, username, pasword);
		System.out.println("Connection object is created:: " + connection);

		Statement statement = connection.createStatement();
		System.out.println("Statement object is created:: " + statement);

		String sqlSelectQuery = "select eid,ename,eage,eaddress from employee";
		ResultSet resultSet = statement.executeQuery(sqlSelectQuery);
		System.out.println("ResultSet object is created:: " + resultSet);

		System.out.println("EID\tENAME\tEAGE\tEADDRESS");
		while (resultSet.next()) {
			Integer id = resultSet.getInt(1);
			String name = resultSet.getString(2);
			Integer age = resultSet.getInt(3);
			String team = resultSet.getString(4);
			System.out.println(id + "\t" + name + "\t" + age + "\t" + team);
		}

		// Close the Connection
		connection.close();
		System.out.println("Closing the connection...");

	}

}