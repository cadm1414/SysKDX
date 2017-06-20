package JAVA.CONFIG.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CONFIG.REPORT.ruta_config_report;
import java.net.URL;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

public class muestra_reporte_config {

    JasperReport jr = null;
    URL path;
    String ls_modulo = "CONFIG", ls_capa = "LOGICA", ls_clase = "muestra_reporte_config";

    public void reporte_frame(String reporte, Map<String, Object> parametro) {
        try {
            path = ruta_config_report.class.getResource(reporte);
            jr = (JasperReport) JRLoader.loadObject(path);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, go_conexion_db.getConexion_db());
            JasperViewer.viewReport(jp, false);

        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "reporte_frame", e.getMessage());
        }
    }

    public void reporte_pestania(String reporte, Map<String, Object> parametro, String nombre, int op) {
        try {
            path = ruta_config_report.class.getResource(reporte);
            jr = (JasperReport) JRLoader.loadObject(path);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, go_conexion_db.getConexion_db());
            JRViewer jr = new JRViewer(jp);
            switch (op) {
                case 0:
                    go_muestra_pestania.rpt_lista_usuario(jr, nombre);
                    break;
                case 1:
                    go_muestra_pestania.rpt_lista_sucursal(jr,nombre);
                    break;
                case 2:
                    go_muestra_pestania.rpt_lista_almacen(jr, nombre);
                    break;
                case 3:
                    go_muestra_pestania.rpt_lista_usuario_permisos(jr, nombre);
                    break;
                case 4:
                    go_muestra_pestania.rpt_lista_tipo_movimiento(jr, nombre);
                    break;
                case 5:
                    go_muestra_pestania.rpt_lista_unidad_medida(jr, nombre);
                    break;
            }

        } catch (Exception e) {
            go_fnc_mensaje.GET_mensaje(2, ls_modulo, ls_capa, ls_clase, "reporte_pestania", e.getMessage());
        }
    }
}
