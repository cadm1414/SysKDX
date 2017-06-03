package JAVA.UTILITARIOS.FUNCION;

import javax.swing.JOptionPane;

public class fnc_mensaje {

    /*TIPO MENSAJE
    0 = ERROR
    1 = QUESTION
    2 = WARNING
    3 = INFORMATION
     */
    public void GET_mensaje(int tipo_mensaje, String modulo, String capa, String clase, String metodo, String msn) {
        switch (tipo_mensaje) {
            case 0:
                JOptionPane.showMessageDialog(null, "Modulo: " + modulo + "\nCapa: " + capa + "\nClase: " + clase
                        + "\nMetodo: " + metodo + "\nMensaje: " + msn, "ERROR", JOptionPane.ERROR_MESSAGE);
                ;
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Modulo: " + modulo + "\nCapa: " + capa + "\nClase: " + clase
                        + "\nMetodo: " + metodo + "\nMensaje: " + msn, "CONSULTA", JOptionPane.QUESTION_MESSAGE);
                ;
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Modulo: " + modulo + "\nCapa: " + capa + "\nClase: " + clase
                        + "\nMetodo: " + metodo + "\nMensaje: " + msn, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                ;
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Modulo: " + modulo + "\nCapa: " + capa + "\nClase: " + clase
                        + "\nMetodo: " + metodo + "\nMensaje: " + msn, "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                ;
                break;
        }
    }
    
    /* TIPO RESPUESTA
    0 = YES_NO
     */
    public int get_respuesta(int tipo, String msn) {
        int resp = 0;
        switch (tipo) {
            case 0:
                resp = JOptionPane.showConfirmDialog(null  , msn,"CONFIRMAR",JOptionPane.YES_NO_OPTION);
                break;
        }
        return resp;
    }
}
