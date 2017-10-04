package JAVA.INVENT.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.INVENT.REPORT.ruta_invent_report;
import java.net.URL;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;

public class muestra_reporte_invent {

    JasperReport jr = null;
    URL path;
    String ls_modulo = "INVENT", ls_capa = "LOGICA", ls_clase = "muestra_reporte_invent";

    public void reporte_pestania(String reporte, Map<String, Object> parametro, String nombre, int op) {
        try {
            path = ruta_invent_report.class.getResource(reporte);
            jr = (JasperReport) JRLoader.loadObject(path);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, go_conexion_db.getConexion_db());
            JRViewer jr = new JRViewer(jp);
            switch (op) {
                case 0:
                    go_muestra_pestania_invent.rpt_lista_marca(jr, nombre);
                    break;
                case 1:
                    go_muestra_pestania_invent.rpt_lista_producto(jr, nombre);
                    break;
                case 2:
                    go_muestra_pestania_invent.rpt_lista_familia(jr, nombre);
                    break;
                case 3:
                    go_muestra_pestania_invent.rpt_lista_subfamilia(jr, nombre);
                    break;
                case 4:
                    go_muestra_pestania_invent.rpt_stock_normal(jr, nombre);
                    break;
                case 5:
                    go_muestra_pestania_invent.rpt_stock_valorizado(jr, nombre);
                    break;
                case 6:
                    go_muestra_pestania_invent.rpt_stock_futuro(jr, nombre);
                    break;
                case 7:
                    go_muestra_pestania_invent.rpt_stock_simplificado(jr, nombre);
                    break;
                case 8 :
                    go_muestra_pestania_invent.rpt_kardex_mercaderia_normal(jr, nombre);
                    break;
                case 9 :
                    go_muestra_pestania_invent.rpt_kardex_mercaderia_val(jr, nombre);
                    break;
            }

        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "reporte_pestania", e.getMessage());
        }
    }
}
