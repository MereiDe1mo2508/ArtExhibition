package repositories;

import data.interfaces.IDB;
import entities.artwork;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
public class artworkRepository {
    private final IDB db;
    public artworkRepository(IDB db) throws SQLException, ClassNotFoundException {
        this.db = db;
    }
    public boolean createArtwork(artwork artwork) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO artwork(title, artist, date_of_creating, copyrighted) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, artwork.getTitle());
            ps.setString(2, artwork.getArtist());
            ps.setInt(3, artwork.getDate_of_creating());
            ps.setBoolean(4, artwork.getCopyrighted());
            ps.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
    public artwork getArtwork(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM artwork WHERE id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                artwork artwork = new artwork(rs.getInt("id"),
                rs.getString("title"), rs.getString("artist"),
                        rs.getInt("date_of_creating"), rs.getBoolean("copyrighted"));
                return artwork;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    public List<artwork> getAllArtwork() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM artwork";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<artwork> artworks = new LinkedList<>();
            while (rs.next()) {
                artwork artwork = new artwork(rs.getInt("id"), rs.getString("title"),
                        rs.getString("artist"), rs.getInt("date_of_creaing"),
                        rs.getBoolean("copyrighted"));
                artworks.add(artwork);
            }
            return artworks;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
