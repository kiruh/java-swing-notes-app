package Notes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class Note {

    static boolean deleteById(int id) {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String query = "DELETE FROM Note "
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

    public static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");

    public int id;
    public String title;
    public String text;
    public Date createdAt;
    public Date updatedAt;

    private ArrayList<Tag> tags;

    public ArrayList<Tag> getTags() {
        if (tags == null) {
            Connection conn = null;
            try {
                conn = DBConnection.getConnection();
                String query = "SELECT t.id, t.value "
                    + "FROM Tag t INNER JOIN NoteTag nt ON t.id = nt.tagId "
                    + "WHERE nt.noteId = ?";
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setInt(1, id);

                ResultSet rs = pst.executeQuery();
                tags = new ArrayList<Tag>();

                Tag tag;

                while (rs.next()) {
                    tag = new Tag();
                    tag.id = rs.getInt(rs.findColumn("id"));
                    tag.value = rs.getString(rs.findColumn("value"));

                    tags.add(tag);
                }
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
        return tags;
    }

    public static String[] clearTagString(String tagString) {
        String[] splitted = tagString.split(",");
        List<String> tagNames = new ArrayList<String>();

        for (int i = 0; i < splitted.length; i++) {
            tagNames.add(splitted[i].trim().replaceAll("\\s+", " "));
        }

        tagNames.removeAll(Arrays.asList("", null));
        return new HashSet<String>(tagNames).toArray(new String[0]);
    }

    public static boolean createNote(String title, String text, String tagString) {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String query = "INSERT INTO Note (title, text, createdAt, updatedAt) "
                + "VALUES (?, ?, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP())";

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, title);
            pst.setString(2, text);

            pst.execute();

            ResultSet rs = pst.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);

            String[] tagNames = Note.clearTagString(tagString);
            if (tagNames.length == 0) {
                return true;
            }
            Tag.createNonexistentTags(tagNames);

            String tagsQuery = "INSERT INTO NoteTag (noteId, tagId) VALUES ";
            for (int i = 0; i < tagNames.length; i++) {
                String endWith = (i == tagNames.length - 1) ? ";" : ",";
                tagsQuery += " (?, SELECT id FROM Tag WHERE value = ?)" + endWith;
            }
            pst = conn.prepareStatement(tagsQuery);
            for (int i = 0; i < tagNames.length; i++) {
                String tagName = tagNames[i];
                pst.setInt(i * 2 + 1, id);
                pst.setString(i * 2 + 2, tagName);
            }
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

    public static ArrayList<Note> fetchNotes() {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String query = "SELECT id, title, text, createdAt, updatedAt from Note";
            PreparedStatement pst = conn.prepareStatement(query);

            ResultSet rs = pst.executeQuery();
            ArrayList<Note> notes = new ArrayList<Note>();

            Note note;

            while (rs.next()) {
                note = new Note();
                note.id = rs.getInt(rs.findColumn("id"));
                note.title = rs.getString(rs.findColumn("title"));
                note.text = rs.getString(rs.findColumn("text"));
                note.createdAt = rs.getTimestamp(rs.findColumn("createdAt"));
                note.updatedAt = rs.getTimestamp(rs.findColumn("updatedAt"));

                notes.add(note);
            }
            return notes;
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

    String getTagString() {
        ArrayList<String> tagValues = new ArrayList<>();
        for (Tag tag : getTags()) {
            tagValues.add(tag.value);
        }
        return String.join(", ", tagValues);
    }

    boolean update(String title, String text, String tagString) {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String query = "UPDATE Note SET"
                + " title = ?, "
                + " text = ?, "
                + " updatedAt = CURRENT_TIMESTAMP() "
                + " WHERE id = ?";

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, title);
            pst.setString(2, text);
            pst.setInt(3, id);

            pst.execute();

            query = "DELETE FROM NoteTag "
                + " WHERE noteId = ?";

            pst = conn.prepareStatement(query);
            pst.setInt(1, id);

            pst.execute();

            String[] tagNames = Note.clearTagString(tagString);
            if (tagNames.length == 0) {
                return true;
            }
            Tag.createNonexistentTags(tagNames);

            String tagsQuery = "INSERT INTO NoteTag (noteId, tagId) VALUES ";
            for (int i = 0; i < tagNames.length; i++) {
                String endWith = (i == tagNames.length - 1) ? ";" : ",";
                tagsQuery += " (?, SELECT id FROM Tag WHERE value = ?)" + endWith;
            }
            pst = conn.prepareStatement(tagsQuery);
            for (int i = 0; i < tagNames.length; i++) {
                String tagName = tagNames[i];
                pst.setInt(i * 2 + 1, id);
                pst.setString(i * 2 + 2, tagName);
            }
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
}
