package JAVA.CTACOB.LOGICA;

import java.awt.Component;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class formato_grid_recibo_cobranza extends DefaultTableCellRenderer {

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

        dFormat = new DecimalFormat("#,##0.00", simbolos);

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
