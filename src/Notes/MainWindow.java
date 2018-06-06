/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Notes;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Group;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kirill
 */
public class MainWindow extends javax.swing.JFrame {

    private ArrayList<Note> notes;

    /**
     * Creates new form NewJFrame
     *
     * @throws java.io.IOException
     */
    public MainWindow() throws IOException {
        initComponents();
        initTagCheckboxes();
        initNotes();
        Image i = ImageIO.read(getClass().getResource("/notes.png"));
        setIconImage(i);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Notes");

        jSplitPane1.setDividerLocation(200);

        jPanel1.setPreferredSize(new java.awt.Dimension(200, 360));

        jButton4.setText("Manage Tags");
        jButton4.setToolTipText("");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel3.setPreferredSize(new java.awt.Dimension(200, 468));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jButton1.setText("Delete Note");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Open Note");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Add note");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CreateOrUpdateNote form = new CreateOrUpdateNote(this, true);
        form.setLocationRelativeTo(this);
        form.setVisible(true);
        showAll = true;
        initTagCheckboxes();
        initNotes();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int rowNumber = jTable1.getSelectedRow();
        if (rowNumber == -1) {
            JOptionPane.showMessageDialog(
                null,
                "Select note!",
                "Info",
                JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }
        int id = (int) jTable1.getModel().getValueAt(rowNumber, 0);

        List<Note> nts = notes;
        Optional<Note> note = nts.stream().filter(n -> n.id == id).findFirst();

        if (!note.isPresent()) {
            JOptionPane.showMessageDialog(
                null,
                "Something went wrong!",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        CreateOrUpdateNote form = new CreateOrUpdateNote(this, true, note.get());
        form.setLocationRelativeTo(this);
        form.setVisible(true);
        showAll = true;
        initTagCheckboxes();
        initNotes();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int[] selectedRows = jTable1.getSelectedRows();
        if (selectedRows.length == 0) {
            JOptionPane.showMessageDialog(
                null,
                "Select at least one note!",
                "Info",
                JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }
        for (int selectedRow : selectedRows) {
            int id = (int) jTable1.getModel().getValueAt(selectedRow, 0);
            Note.deleteById(id);
        }
        initNotes();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ManageTagsForm form = new ManageTagsForm(this, true);
        form.setLocationRelativeTo(this);
        form.setVisible(true);
        initTagCheckboxes();
        initNotes();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void onCheckboxClick(ActionEvent evt, Tag tag) {
        JCheckBox checkbox = (JCheckBox) evt.getSource();
        boolean selected = checkbox.isSelected();
        if (selected) {
            if (!selectedTags.contains(tag)) {
                selectedTags.add(tag);
            }
        } else {
            if (selectedTags.contains(tag)) {
                selectedTags.remove(tag);
            }
        }
        initNotes();
    }

    private void onShowAllClicl(ActionEvent evt) {
        JCheckBox checkbox = (JCheckBox) evt.getSource();
        boolean selected = checkbox.isSelected();
        showAll = selected;
        initTagCheckboxes();
        initNotes();
    }

    private ArrayList<Tag> selectedTags;
    private boolean showAll = true;

    private void initTagCheckboxes() {
        jPanel3.removeAll();
        GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);

        Group horizontalGroup = jPanel3Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);

        Group verticalGroup = jPanel3Layout
            .createSequentialGroup()
            .addContainerGap();

        ArrayList<Tag> tags = Tag.fetchTags();
        selectedTags = new ArrayList<>(tags);

        JCheckBox checkbox = new JCheckBox();
        checkbox.setText("Show all notes");
        checkbox.setSelected(showAll);
        checkbox.addActionListener((java.awt.event.ActionEvent evt) -> {
            onShowAllClicl(evt);
        });

        horizontalGroup.addComponent(checkbox);
        verticalGroup.addComponent(checkbox);

        for (int i = 0; i < tags.size(); i++) {
            Tag tag = tags.get(i);
            checkbox = new JCheckBox();
            checkbox.setText(tag.value);
            checkbox.setSelected(true);
            if (showAll) {
                checkbox.setEnabled(false);
            }
            checkbox.addActionListener((java.awt.event.ActionEvent evt) -> {
                onCheckboxClick(evt, tag);
            });

            horizontalGroup.addComponent(checkbox);
            verticalGroup.addComponent(checkbox);
        }
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(horizontalGroup)
                    .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(verticalGroup));
    }

    private void initNotes() {
        notes = Note.fetchNotes();

        DefaultTableModel tableModel = new DefaultTableModel(
            new String[]{"Id", "Title", "Tags", "Last updated"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column
            ) {
                return false;
            }
        };

        for (int i = 0; i < notes.size(); i++) {
            Note note = notes.get(i);
            if (!showAll) {
                boolean show = false;
                for (Tag tag : note.getTags()) {
                    if (selectedTags.contains(tag)) {
                        show = true;
                        break;
                    }
                }
                if (!show) {
                    continue;
                }
            }

            Object[] row = new Object[4];
            row[0] = note.id;
            row[1] = note.title;
            row[2] = note.getTagString();
            row[3] = Note.dateFormat.format(note.updatedAt);

            tableModel.addRow(row);
        }

        jTable1.setModel(tableModel);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            JFrame frame;
            try {
                frame = new MainWindow();
                frame.pack();

                // make the frame half the height and width
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int height = screenSize.height < 600 ? screenSize.height : 600;
                int width = screenSize.width < 1000 ? screenSize.width : 1000;
                frame.setSize(width, height);

                // here's the part where i center the jframe on screen
                frame.setLocationRelativeTo(null);

                frame.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
