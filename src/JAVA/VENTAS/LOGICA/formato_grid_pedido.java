package JAVA.VENTAS.LOGICA;

import java.awt.Component;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class formato_grid_pedido extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        Component c = renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        String s = "";

        if (column == 8) {
            try {
                DecimalFormat dFormat = new DecimalFormat("#.00000");
                Double d = (Double) value;
                s = dFormat.format(d);
                c = renderer.getTableCellRendererComponent(table, s,
                        isSelected, hasFocus, row, column);
                ((JLabel) c).setHorizontalAlignment(SwingConstants.RIGHT);
            } catch (Exception e) {
            }
        }
        return c;
    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }

}
