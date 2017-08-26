package JAVA.INVENT.LOGICA;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class formato_grid_saldos_iniciales extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if(value instanceof JButton){
            JButton BTN_eliminar = (JButton)value;
            return BTN_eliminar;
        }
        return this;
    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }

}
