import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.sql.Connection;
import java.sql.DriverManager;


public class sqliteConnectionTest {
    Connection  conn;
    sqliteConnection db;
    DriverManager dm;
    @Before
    public void setUp() throws Exception {
        dm = Mockito.mock(DriverManager.class);
        db = new sqliteConnection();
    }

    @Test
    public void dbConnector() throws Exception {
        Mockito.doNothing().when(dm).getConnection("jdbc:sqlite:D:\\supershop management nwe 1\\EmployeeData.sqlite");
        db.dbConnector();
        System.out.println("dbConnector working without any error");
    }
}