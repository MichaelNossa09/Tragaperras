import java.util.Random;
import java.util.Arrays;
 
public class Maquina {
        private int casillas;
        private double precJug;
        private double creditos;
        private Premio[] premios;
        
        public Maquina(int nCasillas, double precio, Premio... premio) {
                precJug=precio;
                casillas=nCasillas;
                premios=premio;
        }
        public double getPrecJug() {
                return precJug;
        }
        public void setPrecJug(double precio) {
                precJug = precio;
        }
        public double getCredito() {
                return creditos;
        }
        public void setCreditos(double credito) {
                creditos = credito;
        }
        public int getnCasillas() {
                return casillas;
        }
        public Premio[] getColeccion() {
                return premios;
        }        
       
        
        public double incrementarCredito(double incremento) {
                return creditos + incremento;
        }
        
        public double cobrar() {
                System.out.println("Retirando "+creditos+" euros de la maquina");
                creditos = 0;
                return creditos;
        }
        
        public Fruta[] jugar() {
                setPrecJug(precJug);
                if (getCredito() >= precJug) {
                        creditos = creditos - precJug;
                        
                        Random generador = new Random();
                        Fruta[] frutas;
                        frutas = new Fruta[casillas]; 
                        Fruta[] frutas_aleatorias=Fruta.values();
                        
                        for (int i = 0;i<casillas; i++){
                                int index = generador.nextInt(5);
                                frutas[i]=frutas_aleatorias[index];
                        }
                        
                        int n = 1; // n = numero de premios
                        for (int i = 0; i <= n; i++) {
                                //comprueba si combinación esta en premios registrados
                                if (Arrays.equals(frutas, premios[i].getCombGanad()) == true){
                                        creditos = creditos + premios[i].getPremio();
                                }       
                        }
                        return frutas;
                }
                return null;
        }
}