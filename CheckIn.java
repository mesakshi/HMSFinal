package HotelMgmtSys;

import java.time.LocalDate;
import java.util.Scanner;

///**/** plane old java object class for check in guest
// * created getter setter and constructor
 

public class CheckIn {
    private int guestId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String address;
    private RoomType roomType;
    private int roomNum;
    private String idType;
    private int idNum;
    private int charge;
    private int collectPayment;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;


    public CheckIn(int roomNum, LocalDate checkOutDate) {
        this.roomNum = roomNum;
        this.checkOutDate = checkOutDate;
    }

    public CheckIn(String firstName, int roomNum) {
        this.firstName = firstName;
        this.roomNum = roomNum;
    }


    public CheckIn(String firstName, String lastName, Gender gender, String address, RoomType roomType, int roomNum, String idType, int idNum, int charge, int collectPayment, LocalDate checkInDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.roomType = roomType;
        this.roomNum = roomNum;
        this.idType = idType;
        this.idNum = idNum;
        this.charge = charge;
        this.collectPayment = collectPayment;
        this.checkInDate=checkInDate;
    }

    public CheckIn() {

    }



    public CheckIn(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }


    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public int getCollectPayment() {
        return collectPayment;
    }

    public void setCollectPayment(int collectPayment) {
        this.collectPayment = collectPayment;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    @Override
    public String toString() {
        return "CheckIn{" +
                "guestId=" + guestId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", roomType=" + roomType +
                ", roomNum=" + roomNum +
                ", idType='" + idType + '\'' +
                ", idNum=" + idNum +
                ", charge=" + charge +
                ", collectPayment=" + collectPayment +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                '}';
    }
    public LocalDate getClockIn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter number 1 for ClockIn");
        String operation = sc.nextLine();
        if ("1".equals(operation)) {
            LocalDate date1 = LocalDate.now();
            this.checkInDate=date1;
            System.out.println("ClockIn" + ":" + date1);
        } else {
            System.out.println("Mismatch!!check your number");
            System.exit(2);
        }
        return null;
    }
}
