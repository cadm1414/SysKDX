package JAVA.CONFIG.LOGICA;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class formato_grid_rol_menu extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (table.getValueAt(row, 3).toString().substring(0, 1).equalsIgnoreCase("M")) {
            this.setBackground(Color.LIGHT_GRAY);
            this.setForeground(new java.awt.Color(0, 153, 153));            
        } else if (table.getValueAt(row, 3).toString().substring(0, 1).equalsIgnoreCase("S")) {
            this.setBackground(Color.LIGHT_GRAY);
            this.setForeground(new java.awt.Color(51, 102, 255));
        } else {
            this.setForeground(Color.BLACK);
            this.setBackground(Color.WHITE);
        }
        return this;
    }

    public boolean isCellEditable(int row, int column) {        
        return false;
    }

}
