package HotelMgmtSys;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateHMSdatabase {
    private final static String USERNAME = "root";

    private final static String PASSWORD = "Root@12345";

    private final static String URL = "jdbc:mysql://localhost:3306/hms";
    public void addTable() {
        Connection con = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            //			String query = "Create table if not exists emp1 (id int not null, firstname varchar(20) not null)";

            StringBuilder query = new StringBuilder();
            query.append("Create table if not exists guestlist (guestId int not null auto_increment primary key, firstName varchar(20)" +
                    " not null,lastName varchar(20) not null,address varchar(20),roomType varchar(20) not null,idType varchar(20) not null,charge int not null," +
                    "collectPayment int not null,checkInDate date,checkOutDate date)");

            statement = con.createStatement();
            statement.execute(query.toString());

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }}



