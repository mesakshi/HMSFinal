package HotelMgmtSys;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

///*** created object for employee
// * generate getter setter and constructor
// * connect database with mysql
// * access emp table
// * created method for view all employee use in ADMIN
// * pass method to mean  class
// *
// *

public class Adminportal {
    private int emp_id;
    private String name;
    private String address;
    private String post;
    private String contact;
    private String username;
    private String password;

    public Adminportal(int emp_id, String name, String address, String post, String contact, String username, String password) {
        this.emp_id = emp_id;
        this.name = name;
        this.address = address;
        this.post = post;
        this.contact = contact;
        this.username = username;
        this.password = password;
    }

    public Adminportal() {

    }



  /*public Adminportal() {

    }*/


    @Override
    public String toString() {
        return "Adminportal{" +
                "emp_id=" + emp_id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", post='" + post + '\'' +
                ", contact='" + contact + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private final static String USERNAME = "root";

    private final static String PASSWORD = "Root@12345";

    private final static String URL = "jdbc:mysql://localhost:3306/hms";

    public List<Adminportal> viewAllemp() throws IOException {
        Connection con = null;
        Statement statement = null;
        List<Adminportal>emplist=new ArrayList<>();


        Adminportal admin = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            String query = "select * from hms.employee";
            System.out.println(query);


            statement = con.createStatement();
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                admin = new Adminportal();
                admin.setEmp_id(results.getInt(1));
                admin.setName(results.getString(2));
                admin.setAddress(results.getString(3));
                admin.setPost(results.getString(4));
                admin.setContact(results.getString(5));
                admin.setUsername(results.getString(6));
                admin.setPassword(results.getString(7));
                /*System.out.println(admin.getContact());
                System.out.println(admin.getName());
                System.out.println("hello");*/

                emplist.add(admin);
                System.out.println(admin);
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
        return emplist;
    }

}
