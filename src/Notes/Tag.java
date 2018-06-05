package Notes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Tag {

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
}
