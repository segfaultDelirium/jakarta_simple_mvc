package beans;

import schemas.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Sql {

    private static List<Person> resultSetToList(ResultSet rs) throws SQLException {
        List<Person> rows = new ArrayList<Person>();
        while(rs.next())  {
            Person newPerson = new Person(
                    rs.getInt("ID"),
                    rs.getString("FNAME"),
                    rs.getString("LNAME"),
                    rs.getString("CITY")
            );
            rows.add(newPerson);
        }
        return rows;
    }

    public static List<Person>  getRecords() throws SQLException, ClassNotFoundException {
        // Class.forName("org.apache.derby.jdbc.ClientDriver");
        // url = "jdbc:postgresql://host:port/database"
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://trumpet.db.elephantsql.com:5432/vppbhvzu";
        String username = "vppbhvzu" ;
        String password = "jSQW8UyiwBWLu9xSsjYnRzV3NLU3J8Xs" ;
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM public.person";
        ResultSet rs = stmt.executeQuery( sql );

        List<Person> rows = resultSetToList(rs);

        rs.close();
        stmt.close();
        conn.close();
        return rows;
    }
}
