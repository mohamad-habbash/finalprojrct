
import com.mysql.jdbc.PreparedStatement;
import dbconn.connecteddb;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginclass {

    Connection connection;

    public loginclass() {
        this.connection = connecteddb.con;
        if (this.connection == null) {
            System.exit(1);
        }

    }

    public boolean isdatabasecon() {
        return this.connection != null;
    }

    public boolean islogin(String user, String password) throws SQLException {
        PreparedStatement pr = null;
        ResultSet rs = null;

        String sql = "select * from users where id = ? and username = ? and password = ? ";
        try {
            pr = (PreparedStatement) this.connection.prepareStatement(sql);
            pr.setString(1, user);
            pr.setString(2, password);
            rs = pr.executeQuery();
            boolean bool;
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException EX) {
            return false;
        } finally {
            pr.close();
            rs.close();
        }
        //return false;
    }
}
