package HotelMgmtSys;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

///** Implemented Interface
// * Connected to Database using jdbc (help of mysql connector jar file)
// * created  method (Check in guest -> for front desk, user option 1 check in guest)
// * created method (check out ->for front desk user, option 2 check out guest)
// * created method (searchByRoomNumberandGuestName -> for front desk  user  use in checkout )
// * created method (dayTransication -> for admin 1.Total Transaction of The Day)
// * created method ( in house -> for admin ,option  2.Front Desk Activities and In House Guest List
// * created method (viewAllGuestRecord -> for admin, option viewAllGuestRecord )
// * every method connect with database  and HmsService class



class Hmsdatabase implements HmcInterface {


    private final static String USERNAME = "root";

    private final static String PASSWORD = "Root@12345";

    private final static String URL = "jdbc:mysql://localhost:3306/hms";

    Connection con = null;
    Statement statement = null;
    CheckIn checkIn = null;


    @Override
    public CheckIn checkInGuest(CheckIn checkIn) throws ClassNotFoundException, SQLException {


        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        String insertQuery = "INSERT INTO guestlist (first_name, last_name,gender,address,room_type,room_no,id_no,id_type,charge,payment,check_in)" + "value ( '" + checkIn.getFirstName() + "', '" + checkIn.getLastName() + "','" + checkIn.getGender() + "'," + "'" + checkIn.getAddress() + "','" + checkIn.getRoomType() + "','" + checkIn.getRoomNum() + "','" + checkIn.getIdNum() + "','" + checkIn.getIdType() + "','" + checkIn.getCharge() + "','" + checkIn.getCollectPayment() + "','" + checkIn.getCheckInDate() + "')";


        System.out.println(insertQuery);

        Statement statement = con.createStatement();
        int resultValue = statement.executeUpdate(insertQuery);


        if (resultValue == 2) {
            System.out.println("Failed to insert/update data. Check your data and try again.");
        }

        statement.close();
        con.close();

        return checkIn;

    }


    // @Override
    public CheckIn inHouse() throws SQLException {

        Connection con = null;
        Statement statement = null;
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            Statement stmt1 = con.createStatement();

            ResultSet rs1 = stmt1.executeQuery("SELECT COUNT(*) AS COUNT FROM guestlist where check_in is not null");
            Integer check_in = null;
            while (rs1.next()) {
                System.out.println("The Total Number of Check in guest:: " + rs1.getInt("COUNT"));
                check_in = rs1.getInt(1);
            }

            //Create a Statement class to execute the SQL statement
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS COUNT FROM guestlist where check_out is not null");
            Integer check_out = null;
            while (rs.next()) {
                System.out.println("The total number of checkout guest:: " + rs.getInt("COUNT"));
                check_out = rs.getInt(1);

                int inhouseGuest = (check_in - check_out);
                System.out.println("The number of In House Guest ::  " + inhouseGuest);
                //Closing the connection
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    public CheckIn searchByRoomNumberandGuestName(String first_name, int room_no) throws IOException {
        Connection con = null;
        Statement statement = null;
        CheckIn checkIn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            String query = "select * from hms.guestlist where first_name ='" + first_name + "' and room_no='" + room_no + "'";
            System.out.println(query);


            statement = con.createStatement();
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {

                checkIn = new CheckIn();
                checkIn.setGuestId(results.getInt(1));
                checkIn.setFirstName(results.getString(2));
                checkIn.setLastName(results.getString(3));
                checkIn.setGender(Gender.getByValue(results.getString(4)));
                checkIn.setAddress(results.getString(5));
                checkIn.setRoomType(RoomType.getByValue(results.getString(6)));
                checkIn.setRoomNum(results.getInt(7));
                checkIn.setIdNum(results.getInt(8));
                checkIn.setIdType(results.getString(9));
                checkIn.setCharge(results.getInt(10));
                checkIn.setCollectPayment(results.getInt(11));
                LocalDate check_in = LocalDate.parse(results.getString(12));
                checkIn.setCheckInDate(check_in);
                System.out.println(checkIn);
                return checkIn;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return checkIn;


    }

    public CheckIn viewAllGuestRecord() throws IOException {
        Connection con = null;
        Statement statement = null;
        CheckIn checkIn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            String query = "select * from hms.guestlist";
            System.out.println(query);


            statement = con.createStatement();
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {

                checkIn = new CheckIn();
                checkIn.setGuestId(results.getInt(1));
                checkIn.setFirstName(results.getString(2));
                checkIn.setLastName(results.getString(3));
                checkIn.setGender(Gender.getByValue(results.getString(4)));
                checkIn.setAddress(results.getString(5));
                checkIn.setRoomType(RoomType.getByValue(results.getString(6)));
                checkIn.setRoomNum(results.getInt(7));
                checkIn.setIdNum(results.getInt(8));
                checkIn.setIdType(results.getString(9));
                checkIn.setCharge(results.getInt(10));
                checkIn.setCollectPayment(results.getInt(11));
                LocalDate check_in = LocalDate.parse(results.getString(12));
                checkIn.setCheckInDate(check_in);
                System.out.println(checkIn);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return checkIn;


    }

    public CheckIn CHECKOUT(int room_no, LocalDate check_out) throws ClassNotFoundException, SQLException {

        CheckIn checkout = new CheckIn(room_no, check_out);
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        String insertQuery = "UPDATE guestlist SET check_out ='" + checkout.getCheckOutDate() + "'WHERE room_no='" + checkout.getRoomNum() + "'";

        //System.out.println(insertQuery);

        Statement statement = con.createStatement();
        int resultValue = statement.executeUpdate(insertQuery);


        if (resultValue == 2) {
            System.out.println("You already Checked Out");
        }

        statement.close();
        con.close();
        return null;
    }

   public CheckIn dayTransication( LocalDate check_in) throws ClassNotFoundException, SQLException {

       CheckIn transication= new CheckIn(check_in);
       Class.forName("com.mysql.cj.jdbc.Driver");

       Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

       Statement stmt1 = con.createStatement();

       ResultSet rs1 = stmt1.executeQuery("SELECT sum(payment) FROM guestlist where check_out ='" + transication.getCheckInDate()+"'");

       while (rs1.next()) {
           System.out.println("The Total Collected Amount  :: " + rs1.getInt(1));
       }

       stmt1.close();
       con.close();
       return null;
    }



}
