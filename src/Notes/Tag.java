package Notes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Tag {

    static boolean deleteById(int id) {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String query = "DELETE FROM Tag "
                + " WHERE id = ?";

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, id);

            pst.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    public int id;
    public String value;

    public static ArrayList<Tag> fetchTags() {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String query = "SELECT id, value from Tag";
            PreparedStatement pst = conn.prepareStatement(query);

            ResultSet rs = pst.executeQuery();
            ArrayList<Tag> tags = new ArrayList<Tag>();

            Tag tag;

            while (rs.next()) {
                tag = new Tag();
                tag.id = rs.getInt(rs.findColumn("id"));
                tag.value = rs.getString(rs.findColumn("value"));

                tags.add(tag);
            }
            return tags;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tag)) {
            return false;
        }
        Tag rhs = (Tag) other;
        if (this.id == rhs.id) {
            return true;
        }
        return false;
    }

    public static void createNonexistentTags(String[] tagNames) {
        List<Tag> existingTags = Tag.fetchTags();
        for (String tagName : tagNames) {
            boolean exists = existingTags
                .stream()
                .anyMatch(tag -> tag.value.equals(tagName));

            if (!exists) {
                Tag tag = new Tag();
                tag.value = tagName;
                tag.save();
            }
        }
    }

    public void save() {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String query = "INSERT INTO Tag (value) VALUES (?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, value);

            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public void update(String value) {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String query = "UPDATE Tag SET value = ? "
                + " WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, value.trim().replaceAll(",", " ").replaceAll("\\s+", " "));
            pst.setInt(2, id);

            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
