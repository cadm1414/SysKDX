package JAVA.ANCESTRO.LOGICA;

import JAVA.ANCESTRO.IMAGES.IMAGES_ruta_ancestro;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicButtonUI;

public class jt_boton extends JButton implements MouseListener {

    public jt_boton(JTabbedPane panel, jt_panel btc, int op) {
        int size = 20;
        setPreferredSize(new Dimension(size, size));
        setToolTipText("Cerrar Pestaña");
        setUI(new BasicButtonUI());
        setContentAreaFilled(false);
        setFocusable(false);
        setBorderPainted(false);
        addMouseListener(this);
        setRolloverEnabled(true);
        //setText("x");
        setIcon(new javax.swing.ImageIcon(IMAGES_ruta_ancestro.class.getResource("close_jt.png")));

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int i = panel.indexOfTabComponent(btc);
                panel.remove(i);
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {
        Component component = me.getComponent();
        if (component instanceof AbstractButton) {
            AbstractButton button = (AbstractButton) component;
            button.setBorderPainted(false);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        Component component = me.getComponent();
        if (component instanceof AbstractButton) {
            AbstractButton button = (AbstractButton) component;
            button.setBorderPainted(false);
        }

    }

}
