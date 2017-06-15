package JAVA.CONFIG.LOGICA;

import JAVA.ANCESTRO.IMAGES.IMAGES_ruta_ancestro;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.HashMap;
import javax.swing.*;

public class lst_menu_modulo extends JLabel implements ListCellRenderer {

    HashMap<String, Icon> ls_elementos;
    HashMap<String, String> ls_toolTip;

    ImageIcon lc_icononulo = new ImageIcon(IMAGES_ruta_ancestro.class.getResource("error.png"));

    public lst_menu_modulo(HashMap<String, Icon> pelementos, HashMap<String, String> tool) {
        this.ls_elementos = pelementos;
        ls_toolTip = tool;
    }

    public lst_menu_modulo() {
        ls_elementos = new HashMap<String, Icon>();
    }

    @Override
    @SuppressWarnings("element-type-mismatch")
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (ls_elementos.get(value) != null) {
            setIcon(ls_elementos.get(value));
            setText(value.toString());
            if (isSelected) {
                setFont(new Font("Arial", Font.BOLD, 12));
                setForeground(Color.white);
                setBackground(Color.LIGHT_GRAY);
                setOpaque(true);
            } else {
                setFont(null);
                setForeground(new java.awt.Color(0,153,153));
                setOpaque(false);
            }
        } else {
            setIcon(lc_icononulo);
            setText(value.toString());
            if (isSelected) {
                setFont(new Font("Arial", Font.BOLD, 14));
                setForeground(new java.awt.Color(24, 165, 211));
            } else {
                setFont(null);
                setForeground(Color.black);
            }
        }
        if (ls_toolTip != null) {
            if (ls_toolTip.get(value) != null) {
                setToolTipText(ls_toolTip.get(value));
            }
        }
        return this;
    }
}
