package JAVA.UTILITARIOS.FUNCION;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class fnc_filtrar_tablas {

    public void filtro(DefaultTableModel modelo, JTable TBL_table, String dato, int row) {
        try {
            TableRowSorter lf_filtrar;
            dato = dato.replaceAll(" ", ".+");
            lf_filtrar = new TableRowSorter(modelo);
            lf_filtrar.setRowFilter(RowFilter.regexFilter(dato, row));
            TBL_table.setRowSorter(lf_filtrar);
        } catch (Exception e) {
        }
    }
}
