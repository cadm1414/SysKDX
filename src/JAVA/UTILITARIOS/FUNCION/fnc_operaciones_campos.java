package JAVA.UTILITARIOS.FUNCION;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JTextField;
import org.apache.commons.codec.binary.Base64;

public class fnc_operaciones_campos {

    public boolean campo_blanco(JTextField txt_campo) {
        boolean resp = false;
        String dato = txt_campo.getText().trim();
        if (!dato.equalsIgnoreCase("")) {
            resp = true;
        }
        return resp;
    }

    public String get_campo_str(JTextField txt_campo) {
        String dato = txt_campo.getText().trim();
        return dato;
    }

    public int get_campo_int(JTextField txt_campo) {
        int dato = Integer.parseInt(txt_campo.getText().trim());
        return dato;
    }

    public void get_focus(JTextField txt_campo) {
        txt_campo.requestFocus();
    }

    public void set_campo_vacio(JTextField txt_campo) {
        txt_campo.setText("");
    }

    public boolean cant_caracter(String dato, int op, int caracteres) {
        /* TIPO OPERACION
        0 = menor igual
        1 = mayor igual
        2 = menor
        3 = mayor
        4 = igual
        5 = mayor que menor que
         */
        boolean resp = false;
        switch (op) {
            case 0:
                if (dato.length() <= caracteres) {
                    resp = true;
                }
                break;
            case 1:
                if (dato.length() >= caracteres) {
                    resp = true;
                }
                break;
            case 4:
                if (dato.length() == caracteres) {
                    resp = true;
                }
                break;
        }

        return resp;
    }
    
    public double redondea(double numero,int digito){
        double resp=0;
        resp = numero * Math.pow(10, digito);
        resp = Math.round(resp);
        resp = resp/Math.pow(10, digito);
        return resp;
    }

    public String completa_digitos(String dato, String valor, int cant) {
        String resp = dato;
        for (int i = dato.length(); i < cant; i++) {
            resp = valor + resp;
        }
        return resp;
    }

    public boolean valida_fecha(String dato) {
        boolean resp = false;
        try {
            SimpleDateFormat FormatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            FormatoFecha.setLenient(false);
            Date fecha = FormatoFecha.parse(dato);
            resp = true;
        } catch (Exception e) {
        }

        return resp;
    }

    public Date formarto_date(String dato) {
        Date fecha = null;
        try {
            SimpleDateFormat FormatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            FormatoFecha.setLenient(false);
            fecha = FormatoFecha.parse(dato);
        } catch (Exception e) {
        }

        return fecha;
    }

    /*COMPARA FECHAS
     0 = fechas iguales
     negativo = fecha menor
     positivo = fecha mayor
     */
    public int compara_fechas(String dato_ini, String dato_fin) {
        int resp = 0;
        try {
            SimpleDateFormat FormatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            FormatoFecha.setLenient(false);
            Date fecha_ini = FormatoFecha.parse(dato_ini);
            Date fecha_fin = FormatoFecha.parse(dato_fin);

            resp = fecha_ini.compareTo(fecha_fin);
        } catch (Exception e) {
        }
        return resp;
    }

    public String recupera_fecha(String dato) {
        String fecha = (dato.substring(8, 10)) + (dato.substring(5, 7)) + (dato.substring(0, 4));
        return fecha;
    }

    public String recupera_fecha_formato(String dato) {
        String fecha = (dato.substring(8, 10)) + "/" + (dato.substring(5, 7)) + "/" + (dato.substring(0, 4));
        return fecha;
    }

    public int boolean_int(boolean dato) {
        int resp = 0;
        if (dato) {
            resp = 1;
        }
        return resp;
    }

    public boolean int_boolean(int dato) {
        boolean resp = false;
        if (dato == 1) {
            resp = true;
        }
        return resp;
    }

    public String get_mac(byte[] mac) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
            sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
        }
        return sb.toString();
    }

    public boolean valida_ruc(String dato) {
        boolean resp = false;
        int[] datos = {5, 4, 3, 2, 7, 6, 5, 4, 3, 2};
        try {
            int suma = 0;
            int digito, entero, op_final;
            int digito_ini = Integer.parseInt(dato.substring(0, 2));
            int digito_fin = Integer.parseInt(dato.substring(10, 11));
            if (digito_ini == 10 || digito_ini == 15 || digito_ini == 17 || digito_ini == 20) {
                for (int i = 0; i < 10; i++) {
                    digito = Integer.parseInt(dato.substring(i, i + 1));
                    suma = suma + digito * datos[i];
                }
                entero = (int) (suma / 11);
                op_final = 11 - (suma - entero * 11);
                if (digito_fin == op_final%10) {
                    resp = true;
                }
            }
        } catch (Exception e) {
        }
        return resp;
    }

    public String encriptar(String dato) {
        String secretKey = "CaDmXD";
        String base64EncryptedString = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] plainTextBytes = dato.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
        }
        return base64EncryptedString;
    }

    public String desencriptar(String dato) {
        String secretKey = "CaDmXD";
        String base64EncryptedString = "";

        try {
            byte[] message = Base64.decodeBase64(dato.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");

            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);

            byte[] plainText = decipher.doFinal(message);

            base64EncryptedString = new String(plainText, "UTF-8");

        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
        }
        return base64EncryptedString;
    }

}
