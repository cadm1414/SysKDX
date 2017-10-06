package JAVA.VENTAS.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.VENTAS.REPORT.ruta_ventas_report;
import java.net.URL;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;

public class muestra_reporte_ventas {

    JasperReport jr = null;
    URL path;
    String ls_modulo = "VENTAS", ls_capa = "LOGICA", ls_clase = "muestra_reporte_ventas";

    public void reporte_pestania(String reporte, Map<String, Object> parametro, String nombre, int op) {
        try {
            path = ruta_ventas_report.class.getResource(reporte);
            jr = (JasperReport) JRLoader.loadObject(path);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, go_conexion_db.getConexion_db());
            JRViewer jr = new JRViewer(jp);
            switch (op) {
                case 0:
                    go_muestra_pestania_ventas.rpt_control_pedido(jr, nombre);
                    break;
                case 1:
                    go_muestra_pestania_ventas.rpt_control_pedido_pendiente(jr, nombre);
                    break;
                case 2:
                    go_muestra_pestania_ventas.rpt_diferencia_pedido(jr, nombre);
                    break;
                case 3:
                    go_muestra_pestania_ventas.rpt_despacho_pedido(jr, nombre);
                    break;
                case 4:
                    go_muestra_pestania_ventas.rpt_registro_ventas(jr, nombre);
                    break;
            }
        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "reporte_pestania", e.getMessage());
        }
    }
}
