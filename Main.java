package HotelMgmtSys;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


/*create object from service class , admin portal  and other class for access method
 * for hotel room just make array for 30  room
 *  for room charge and payment using (if else and choose) condition and fix room rent  in main class  reason time shortage .
 *  for log in front desk and admin just create  username and password  in main class reason time shortage.
*/
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    /** create object from service class , admin portal  and other class for access method
     *  for hotel room just make array for 30  room
     * for room charge and payment using (if else and choose) condition and fix room rent  in main class  reason time shortage .
     *  for log in front desk and admin just create  username and pass  in main class reason time shortage.
     *
     *
     * @param args
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        Scanner scan = new Scanner(System.in);
        HmsService hmsService = new HmsService();
        CheckIn checkIn = null;
        Adminportal adminportal = new Adminportal();
        ViewRoomNumber viewRoomNumber = new ViewRoomNumber();
        Hmsdatabase hmsdatabase=new Hmsdatabase();

        // print main page
while (true){
        System.out.println("Welcome To Extended Stay America");
        System.out.println("Please choose your option");
        System.out.println("1.Front Desk ");
        System.out.println("2.Admin Portal");

       int choice=0;

        choice = scan.nextInt();
        
        // GuestCheckIn Method
        
        if (choice == 1) {
            System.out.println("Front Desk  ### Start Your Shift ###  ");
            System.out.println("Please Input your username and password");
            System.out.println("username");
            String username = scan.next();
            System.out.println("password");
            String password = scan.next();
            if ((username.equals("frontdesk")) && (password.equals("hotel"))) {
                System.out.println(" login successfully ");
            } else {
                System.out.println("user incorrect !!! ");
                continue;
            }

            System.out.println("Choose your operation ");
            System.out.println("1.Guest Check In ");
            System.out.println("2.Guest Check out ");
            System.out.println("3.End Shift");
            int option = 1;
            option = scan.nextInt();
            if (option == 1) {
                //check in
                System.out.println("Enter First Name");
                String firstName = scan.next();
                System.out.println("Enter Last Name");
                String lastName = scan.next();
                Gender g = null;
                while (true) {
                    System.out.println("1.Male\t 2.Female\t 3.Others");
                    System.out.println("Choose the gender.");
                    int genderChoice = scan.nextInt();
                    if (genderChoice == 1) {
                        g = Gender.MALE;
                    } else if (genderChoice == 2) {
                        g = Gender.FEMALE;
                    } else if (genderChoice == 3) {
                        g = Gender.OTHERS;
                    } else {
                        System.out.println("Invalid option.");
                        continue;
                    }
                    break;
                }
                System.out.println("Address");
                String address = scan.next();
                RoomType r = null;
                while (true) {
                    System.out.println("1.STANDARD\t 2.DELUXE\t 3.SUPERDELUXE");
                    System.out.println("Choose Room Type.");
                    int roomchoice = scan.nextInt();
                    if (roomchoice == 1) {
                        r = RoomType.STANDARD;
                    } else if (roomchoice == 2) {
                        r = RoomType.DELUXE;
                    } else if (roomchoice == 3) {
                        r = RoomType.SUPERDELUXE;
                    } else {
                        System.out.println("Invalid option.");
                        continue;
                    }
                    break;
                }

                int roomNum = 0;
                while (true) {
                    System.out.println("Room No.");
                    int finalroomnumber = scan.nextInt();
                    if (finalroomnumber >= 1 && finalroomnumber <= 30) {

                        roomNum = finalroomnumber;
                        break;
                    }
                }

                System.out.println("Id Number");
                int idNum = scan.nextInt();

                System.out.println("Id type (DL,GC,SI,PP");
                String idType = scan.next();
                // fix room charger

                System.out.println("Room charge :- Press ~~~ 1.Standard $500,2. Deluxe $700,3.SuperDeluxe $900");
                int value=0;
                value=scan.nextInt();
                int charge = value;
                if(value==1){charge =500;}
                else if(value==2){charge=700;}
                else if(value==3){charge =900;}

                System.out.println("Collect Payment as a same amount with same roomType ");
                //int collectPayment=value;
               int values=0;
                values=scan.nextInt();
                int collectPayment = values;
                if(values==1){collectPayment =500;}
                else if(values==2){collectPayment=700;}
                else if(values==3){collectPayment =900;}

                System.out.println("Ready for Check In ");
                LocalDate checkInDate = LocalDate.now();

                CheckIn checkIn1 = new CheckIn(firstName, lastName, g, address, r, roomNum, idType, idNum, charge, collectPayment, checkInDate);
                hmsService.checkInGuest(checkIn1);
                continue;}


             else if (option == 2) {
                //CHECK Out
                System.out.println("Enter First Name of Guest ::");
                String first_name = scan.next();
                System.out.println("Enter Room Number");
                int room_no = scan.nextInt();
                checkIn = hmsService.searchByRoomAndName(first_name, room_no);
                if (checkIn != null) {
                    System.out.println("Ready for CheckOut");
                } else {
                    System.out.println("Please conform your Room number ");
                }
                System.out.println("Enter room number");
                int room_no1 = scan.nextInt();
                System.out.println("Checking Out !!!!");
                LocalDate checkOutDate = LocalDate.now();
                hmsService.checkOut(room_no1, checkOutDate);
                continue;
            } else if (option == 3) {
                System.out.println("Thank you for Carried your shift BYE !!! ");
            }
            System.exit(1);
            continue;
        }

        if (choice == 2) {
            System.out.println("This is Admin Portal Only Authorize Person Can Access");
            System.out.println("Please Input your username and password");
            System.out.println("Enter user name");
            String username = scan.next();
            System.out.println("Enter password");
            String password = scan.next();
            if ((username.equals("manager")) && (password.equals("hotel"))) {
                System.out.println(" login successfully ");
            } else {
                System.out.println("you are not authorize person ");
                continue;

            }
            System.out.println("Admin Can Access Those Function ");
            System.out.println("1.Total Transaction of The Day");
            System.out.println("2.Front Desk Activities and In House Guest List ");
            System.out.println("3.View All Guest List ");
            System.out.println("4.View Room Sold Record (Search By date)");
            System.out.println("5. Hotel Employees");

            int choose = 0;
            choose = scan.nextInt();

            if (choose == 1) {

                System.out.println("Please Enter Searching Date (yyyy-mm-dd)");
                String check_in = scan.next();
                check_in = String.valueOf(LocalDate.parse(check_in, DateTimeFormatter.ISO_LOCAL_DATE));
                hmsdatabase.dayTransication(LocalDate.parse(check_in));


            } else if (choose == 2) {
                // In house guest list mean who is in hotel but not check out yet ...
                hmsService.inHouseGuestList();

            } else if (choose == 3) {
                // view all  mean they are  in our  hotel (check in and check out) both its like history or all record  ...
                System.out.println("View All Guest");

                hmsService.viewAll();


            } else if (choose == 4) {
                System.out.println("Please Enter Searching Date (yyyy-mm-dd)");
                String check_in = scan.next();
                check_in = String.valueOf(LocalDate.parse(check_in, DateTimeFormatter.ISO_LOCAL_DATE));

                viewRoomNumber.roomSoldRecord(LocalDate.parse(check_in));
               // List<ViewRoomNumber> toCheck = viewRoomNumber.viewAllRoom();
            } else if (choose == 5) {
                // View All employee mean who are working in hotel manager to housekeeper  ....
                adminportal.viewAllemp();
            }
        }
    }}}