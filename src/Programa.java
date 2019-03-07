import java.util.Scanner;
import java.util.Arrays;
 
public class Programa {
        public static void main(String[] args) {
                
                // 1. Declara dos variables locales de tipo Premio
                Fruta[] combinacion1 = {Fruta.FRESA, Fruta.FRESA, Fruta.FRESA};
                Premio premio1 = new Premio(combinacion1, 20);
                Fruta[] combinacion2 = {Fruta.SANDIA, Fruta.FRESA,Fruta.SANDIA};
                Premio premio2 = new Premio(combinacion2, 10);
                
                /* 2. Crea una máquina con un tamaño de combinación de 3 frutas,
                * un precio por partida de 0,5 euros
                * y los dos premios declarados previamente
                */
                Maquina maquina = new Maquina(3, 0.5, premio1, premio2);
                
                /* 3. Solicita al usuario que introduzca por teclado la cantidad
                * de crédito para jugar.
                */
                System.out.println("Introduzca el crédito: ");
                Scanner teclado = new Scanner(System.in);
                double credito = teclado.nextDouble();
                teclado.nextLine();
                maquina.incrementarCredito(credito);
                System.out.println(credito);
                
                
                // 4. Jugamos mientras haya crédito disponible
                Fruta[] combinacion;
                maquina.setCreditos(credito);
                while (maquina.getCredito() > 0){
                        
                        //4.1 Realiza la jugada
                        combinacion = maquina.jugar();
                        
                        //4.2 Muestra la combinación obtenida y el crédito
                        System.out.println(Arrays.toString(combinacion)+" --- "+maquina.getCredito());
                        
                        //4.3 Pide al usuario que pulse intro para continuar
                        System.out.println("Pulse intro para volver a jugar");
                        teclado.nextLine();
                }
                System.out.println("Fin del juego: no dispone de credito suficiente");
        }
}
