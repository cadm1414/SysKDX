package JAVA.ANCESTRO.LOGICA;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class jt_panel extends JPanel {

    public jt_panel(JTabbedPane pestania, int op) {

        if (pestania != null) {
            setOpaque(false);
            JLabel titulo = new JLabel() {                
                public String getText() {
                    setFont(new Font("Arial", Font.BOLD, 10));
                    setForeground(new java.awt.Color(0, 153, 153));
                    int i = pestania.indexOfTabComponent(jt_panel.this);
                    if (i != -1) {
                        return pestania.getTitleAt(i);
                    }
                    return null;
                }
            };
            
            add(titulo);
            JButton button = new jt_boton(pestania, this, op);
            add(button);
        }

    }
}
