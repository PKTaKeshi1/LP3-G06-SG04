import java.util.Scanner; 
 
public class AppBanco { 
    public static void main(String[] args) { 
        Cuenta_5[] cuentas = new Cuenta_5[10]; 
        for (int i = 0; i < cuentas.length; i++) { 
            cuentas[i] = new CuentaCorriente(); 
        } 
         
        Scanner in = new Scanner(System.in); 
        boolean done = false; 
         
        while (!done) { 
            System.out.print("D)epositar R)etirar C)onsultar S)alir: "); 
            String op = in.next().toUpperCase(); 
             
            if (op.equals("D") || op.equals("R")) { 
                System.out.print("Ingrese número de cuenta (0-9) y un monto: "); 
                int num = in.nextInt(); 
                 
                if (num < 0 || num >= cuentas.length) { 
                    System.out.println("Número de cuenta inválido."); 
                    continue; 
                } 
                 
                double monto = in.nextDouble(); 
                 
                if (op.equals("D")) { 
                    cuentas[num].depositar(monto); 
                } else { 
                    cuentas[num].retirar(monto); 
                }
              System.out.println("Saldo: " + String.format("%.2f", cuentas[num].getSaldo())); 
            } else if (op.equals("C")) { 
              for (int n = 0; n < cuentas.length; n++) { 
                System.out.println("Cuenta " + n + ": " + String.format("%.2f", cuentas[n].getSaldo())); 
              } 
            } else if (op.equals("S")) { 
              done = true; 
            } else { 
              System.out.println("Opción no válida. Intente de nuevo."); 
            } 
        } 
      in.close(); 
    } 
} 
