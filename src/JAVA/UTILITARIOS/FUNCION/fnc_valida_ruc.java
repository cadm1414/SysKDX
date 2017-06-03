package JAVA.UTILITARIOS.FUNCION;

public class fnc_valida_ruc {

    public boolean valida_ruc(String dato) {
        boolean resp = false;
        int vi, vf, suma = 0, entero, op_final;
        int valores[] = {5, 4, 3, 2, 7, 6, 5, 4, 3, 2};

        if (dato.length() == 11) {
            vi = Integer.parseInt(dato.substring(0, 2));
            vf = Integer.parseInt(dato.substring(10, 11));

            if (vi == 10 || vi == 15 || vi == 17 || vi == 20) {
                for (int i = 0; i < 10; i++) {
                    suma = suma + Integer.parseInt(dato.substring(i, i + 1)) * valores[i];
                }
                entero = (int) (suma / 11);
                op_final = 11 - (suma - entero * 11);

                if (vf == (op_final % 10)) {
                    resp = true;
                }
            }
        }
        return resp;
    }
}
