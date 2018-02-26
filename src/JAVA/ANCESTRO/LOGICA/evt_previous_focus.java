package JAVA.ANCESTRO.LOGICA;

import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class evt_previous_focus extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent ae) {
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.focusPreviousComponent();
    }
}
