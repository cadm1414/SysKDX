package JAVA.UTILITARIOS.FUNCION;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class fnc_txt_mayuscula extends PlainDocument{
    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
            super.insertString(offset, str.toUpperCase(), attr);
        }
}
