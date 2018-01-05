package JAVA.CTACOB.LOGICA;

import static JAVA.ANCESTRO.LOGICA.variables_globales.*;
import JAVA.CTACOB.REPORT.ruta_ctacob_report;
import java.net.URL;
import java.sql.Connection;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;

public class muestra_reporte_ctacob {

    JasperReport jr = null;
    URL path;
    Connection lq_con;
    String ls_modulo = "CTACOB", ls_capa = "LOGICA", ls_clase = "muestra_reporte_ctacob";

    public void reporte_pestania(String reporte, Map<String, Object> parametro, String nombre, int op) {
        try {
            lq_con = go_conexion_db.getConexion_db();
            path = ruta_ctacob_report.class.getResource(reporte);
            jr = (JasperReport) JRLoader.loadObject(path);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, lq_con);
            lq_con.close();
            JRViewer jr = new JRViewer(jp);
            switch (op) {
                case 0:
                    go_muestra_pestania_ctacob.rpt_saldo_cta_corriente(jr, nombre);
                    break;
                case 1:
                    go_muestra_pestania_ctacob.rpt_tarjeta_cuenta_corriente(jr, nombre);
                    break;
                case 2:
                    go_muestra_pestania_ctacob.rpt_estado_cuenta(jr, nombre);
                    break;
                case 3:
                    go_muestra_pestania_ctacob.rpt_listado_cobranzas(jr, nombre);
                    break;
                case 4:
                    go_muestra_pestania_ctacob.rpt_listado_cobranzas_sr(jr, nombre);
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
