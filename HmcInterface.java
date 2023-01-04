package HotelMgmtSys;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

///*** created interface for common method .
 
public interface  HmcInterface  {

    public CheckIn checkInGuest(CheckIn checkIn) throws ClassNotFoundException, SQLException;
    public CheckIn searchByRoomNumberandGuestName (String first_name, int room_no) throws IOException;
    public CheckIn  inHouse() throws SQLException;
    public CheckIn viewAllGuestRecord () throws IOException;
    public CheckIn CHECKOUT(int room_no,LocalDate check_out) throws ClassNotFoundException, SQLException;









}
