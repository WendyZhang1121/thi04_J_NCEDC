package thi04_J_NCEDC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class DBConnector implements Runnable { 
	private final String query;
	
	DBConnector(String query) { 
		this.query = query;
	}

	@Override public void run() { 
		Connection connection;
		try {
			// Username and password are hard coded for brevity 
			connection = DriverManager.getConnection(
					"jdbc:driver:name",
					"username",
					"password"
					);
			Statement stmt = connection.createStatement(); 
			ResultSet rs = stmt.executeQuery(query);
			//...
		} catch (SQLException e) { 
			// Forward to handler
		}
//... 
	}

	public static void main(String[] args) throws InterruptedException { 
		DBConnector connector = new DBConnector("suitable query");
		Thread thread = new Thread(connector);
		thread.start();
		Thread.sleep(5000);
		thread.interrupt();
	}
}