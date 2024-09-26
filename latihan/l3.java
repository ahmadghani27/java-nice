import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class l3 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/nama_database";
        String user = "username";
        String password = "password";

        try {
            // Menghubungkan ke database
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM nama_tabel";
            ResultSet rs = stmt.executeQuery(sql);

            // Menampilkan data dari ResultSet
            while (rs.next()) {
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                int usia = rs.getInt("usia");
                System.out.println("ID: " + id + ", Nama: " + nama + ", Usia: " + usia);
            }

            // Menutup koneksi
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
