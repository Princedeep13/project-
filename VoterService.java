
import java.sql.*;
import model.User;

public class VoterService {
    public static boolean registerUser(String name, String email, String password) throws Exception {
        Connection conn = Database.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO users(name, email, password, voted) VALUES (?, ?, ?, 0)");
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, password);
        int result = ps.executeUpdate();
        return result > 0;
    }

    public static User loginUser(String email, String password) throws Exception {
        Connection conn = Database.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new User(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getBoolean("voted")
            );
        }
        return null;
    }
}
