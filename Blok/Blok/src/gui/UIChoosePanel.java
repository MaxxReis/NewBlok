package gui;

import interfaces.ICore;
import interfaces.IUIFactory;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UIChoosePanel extends JPanel{
    
    private String[] UIPluginsName;
    private String[] physicsPluginsName;
    public ICore core;
    private int chose;

    public UIChoosePanel(ICore core) throws InstantiationException, IllegalAccessException {
        this.core = core;
        UIPluginsName = new String[core.getPluginController().getName(core.getPluginController().getLoadedPluginsByType(IUIFactory.class)).size()];
        physicsPluginsName = new String[core.getPluginController().getClassesNamesInPackage("plugins/PhysicsSimulator.jar", "physicssimulator").size()];
        initComponents();
        setFocusable(true);
    }	
    
    public int getChose() {
        return chose;
    }
	
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new JList();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();

        setLayout(null);

        try {
            for(int i = 0; i < core.getPluginController().getName(core.getPluginController().getLoadedPluginsByType(IUIFactory.class)).size(); i++) {
                UIPluginsName[i] = core.getPluginController().getName(core.getPluginController().getLoadedPluginsByType(IUIFactory.class)).get(i);
            }
        } catch (InstantiationException ex) {
            Logger.getLogger(UIChoosePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UIChoosePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = UIPluginsName;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        jList1.setNextFocusableComponent(jButton1);
        jList1.setVisibleRowCount(10);
        jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jList1);

        add(jScrollPane2);
        jScrollPane2.setBounds(60, 70, 100, 170);

        jButton1.setText("Iniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(150, 260, 110, 23);

        jLabel1.setText(" BLOCK");
        add(jLabel1);
        jLabel1.setBounds(180, 20, 60, 14);

        jLabel2.setText("Cenários");
        add(jLabel2);
        jLabel2.setBounds(80, 50, 70, 14);

        jLabel3.setText("Fisicas do jogo");
        add(jLabel3);
        jLabel3.setBounds(250, 50, 90, 14);

        try {
            ArrayList<String> physicsPlugins = core.getPluginController().getClassesNamesInPackage("plugins/PhysicsSimulator.jar", "physicssimulator");

            for(int i = 0; i < physicsPlugins.size(); i++) {
                physicsPluginsName[i] = physicsPlugins.get(i);
            }
        } catch (Exception ex) {
            Logger.getLogger(UIChoosePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = physicsPluginsName;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList2);

        add(jScrollPane1);
        jScrollPane1.setBounds(240, 70, 100, 170);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrame frame = new JFrame("Erro!");
        if(jList1.getSelectedIndex() != -1 && jList2.getSelectedValue() != null) {
            core.getUIController().setCurrentPlugins(jList1.getSelectedIndex(), jList2.getSelectedValue());
            core.getUIController().GamePanelScreen();
        } else if(jList1.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(frame, "Selecione um UIPlugin.", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else if(jList2.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(frame, "Selecione um PhysicsPlugin.", "Erro", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "Selecione um UIPlugin e um PhysicsPlugin.", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
