package JAVA.VENTAS.LOGICA;

import static JAVA.CONFIG.GUI.pnl_datos_entidad.simbolos;
import java.awt.Component;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class formato_grid_pedido extends DefaultTableCellRenderer {

    public static DecimalFormatSymbols simbolos = new DecimalFormatSymbols();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        Component c = renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        String s = "";
        simbolos.setDecimalSeparator('.');
        simbolos.setGroupingSeparator(',');
        DecimalFormat dFormat = null;

        switch (column) {
            case 8:
                dFormat = new DecimalFormat("#,##0.00000", simbolos);
                break;
            case 11:
                dFormat = new DecimalFormat("#,##0.00", simbolos);
                break;
            case 12:
                dFormat = new DecimalFormat("#,##0", simbolos);
                break;
        }
        try {

            Double d = (Double) value;
            s = dFormat.format(d);
            c = renderer.getTableCellRendererComponent(table, s,
                    isSelected, hasFocus, row, column);
            ((JLabel) c).setHorizontalAlignment(SwingConstants.RIGHT);
        } catch (Exception e) {
        }

        return c;
    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }

}
