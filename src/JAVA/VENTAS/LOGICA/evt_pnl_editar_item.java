package JAVA.VENTAS.LOGICA;

import JAVA.VENTAS.GUI.pnl_editar_item;
import java.awt.event.KeyListener;

public class evt_pnl_editar_item {
        
    public KeyListener evento_press(pnl_editar_item OBJ_pgp, KeyListener KeyEvnt) {
        OBJ_pgp.TXT_cantidad.addKeyListener(KeyEvnt);
        OBJ_pgp.TXT_precio.addKeyListener(KeyEvnt);
        OBJ_pgp.TXT_codigo_articulo.addKeyListener(KeyEvnt);
        OBJ_pgp.CBX_presentacion.addKeyListener(KeyEvnt);
        return KeyEvnt;
    }
}
