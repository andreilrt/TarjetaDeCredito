package tarjetadecredito;

import java.util.Scanner;

public class TarjetaDeCredito {

    static Scanner Input = new Scanner(System.in);

    static boolean ValidarTamanos(String TarjetaDeCredito) {
        if (TarjetaDeCredito.length() == 16) {
            return false;
        } else {
            System.out.println("Numero de tarjeta de credito erroneo, Por favor intentelo de nuevo\n");
            return true;
        }
    }

    static void Algoritmo(String TarjetaDeCredito) {
        int Operacion = 0;
        int Suma = 0;
        int SumaImpar = 0;
        int SumaPar = 0;
        for (int c = 0; c < 16; c++) {
            if (c % 2 == 0) {
                Operacion = ((int) TarjetaDeCredito.charAt(c) - 48) * 2;
                if (Operacion > 9) {
                    Operacion = (Operacion / 10) + Operacion - 10;
                }
                SumaImpar += Operacion;
            } else {
                SumaPar += ((int) TarjetaDeCredito.charAt(c)) - 48;
            }
        }
        Suma = SumaImpar + SumaPar;
        System.out.println(SumaImpar);
        System.out.println(SumaPar);
        System.out.println(Suma);
        if (Suma % 10 == 0) {
            System.out.println("Su tarjeta de credito tiene un numero valido");
        } else {
            System.out.println("Su tarjeta de credito tiene un numero invalido");
        }
    }

    static void Proceso() {
        String TarjetaDeCredito = new String();
        boolean Control = true;
        while (Control) {
            System.out.println("Bienvenid@ al programa que valida su codigo de Tarjeta de credito\n");
            System.out.println("Por favor ingrese su codigo sin espacios ni caracteres adicionales");
            System.out.print("Ingrese su número de tarjeta de credito:");
            TarjetaDeCredito = Input.next();
            Control = ValidarTamanos(TarjetaDeCredito);
        }
        if (TarjetaDeCredito.length() == 16) {
            Algoritmo(TarjetaDeCredito);
        }
    }

    public static void main(String[] args) {
        Proceso();
    }
}
