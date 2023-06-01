package com.ironhack.final_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@SpringBootApplication
public class FinalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);

//		try {
//			// Connect to database
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffee_project", "root", "ironhack");
//
//			// Create a statement
//			Statement statement = connection.createStatement();
//
//			// Change the VARCHAR length
//			String modDesc = "ALTER TABLE coffee MODIFY COLUMN description VARCHAR(1000)";
//			String modNotes = "ALTER TABLE coffee MODIFY COLUMN notes VARCHAR(1000)";
//			statement.executeUpdate(modDesc);
//			statement.executeUpdate(modNotes);
//
//			// Close the statement and connection
//			statement.close();
//			connection.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}

