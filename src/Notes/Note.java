package Notes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Note {

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
                note.createdAt = rs.getDate(rs.findColumn("createdAt"));
                note.updatedAt = rs.getDate(rs.findColumn("updatedAt"));

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
}
