/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasedemo2;

/**
 *
 * @author merwanluck
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDemo2 {
    




public static void main(String[] args) throws SQLException,
ClassNotFoundException {
System.out.println("Testing database access...STARTING");
/* The connection string describes how to access the
 * the database over a network. The pattern is
 * <protocol>://<domainName>:<portNumber>/<databaseName>
 * Make sure these values match what you have set up on
 * your system.*/
String connectStr="jdbc:mysql://localhost:3306/Medical_App";
//database username
String username="root";
//database password
String password="mluck";
/* The driver is the Java class used for accessing
 * a particular database. You must download this from
 * the database vendor.
 */
String driver="com.mysql.jdbc.Driver";
//Creates a connection object for your database
Connection con = DriverManager.getConnection(
 connectStr, username, password);
/* Creates a statement object to be executed on
 * the attached database.
 */

Statement stmt = con.createStatement();
/* Executes a database query and returns the results
 * as a ResultSet object.
 */

String medication1 = "aspirin";
ResultSet rs = stmt.executeQuery("SELECT * FROM conflictingMed where medName=\"" + medication1 + "\";");
/* This snippet shows how to parse a ResultSet object.
 * Basically, you loop through the object sort of like
 * a linkedlist, and use the getX methods to get data
 * from the current row. Each time you call rs.next()
 * it advances to the next row returned.
 * The result variable is just used to compile all the
 * data into one string.
 */
String result ="";
while (rs.next()) {
String theName = rs.getString("medName");
String conflictingMeds = rs.getString("conflictingMeds");

ConflictingMed conMeds = new ConflictingMed(theName, conflictingMeds);
conMeds.makeList();

//result += "medName: "+theName +
//"("+conflictingMeds+")\n";
}
//System.out.println("Results:\n\n"+result);
System.out.println("Testing database access...FINISHED");
}
}