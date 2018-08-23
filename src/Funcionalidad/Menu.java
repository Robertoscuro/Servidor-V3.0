package Funcionalidad;
import Interfaz.*;

import java.io.IOException;

public class Menu {
    Dados dado;
    GestorIO gestorIO;
    Servidor con = new Servidor();
 

    public Menu(){
        dado = new Dados();
        gestorIO= GestorIO.getGestorIO();
      
    }
    public int Opciones(int op) throws IOException {
        int x;
        switch (op){
            case 4:
                x=dado.Dado4();
                break;
            case 6:
                x= dado.Dado6();
                break;
            case 10:
                x= dado.Dado10();
                break;
            case 12:
                x= dado.Dado12();
                break;
            case 20:
                x= dado.Dado20();
                break;
            case 30:
                x= dado.Dado30();
                break;
            case 100:
                x=dado.Dado100();

                break;
            case 8:
                x=dado.Dado8();

                break;
            default:
                x=0;
                break;


        }
        return x;
    }

    public void iniciar(int op, int dado, Interfaz interfaz) throws InterruptedException, IOException {
        int y,x;
        x=dado;
      //  while(true){
            
         //   op=gestorIO.leerInt("\nEscriba que desea hacer(1 duelo, 2 tirada simple,3 ver tirada simple,4 offline, 0 salir): ");
            if(op==1){

              //  x=gestorIO.leerInt("Escriba el dado que desea lanzar: ");
                y=this.Opciones(x);
                interfaz.mostrarMiresultado(y);
                //gestorIO.escribir("Su resultado es: "+y);
                this.mandarTirada(y,interfaz);
            }else if(op==2){
                //x=gestorIO.leerInt("Escriba el dado que desea lanzar: ");
                y=this.Opciones(x);
                //gestorIO.escribir("Su resultado es: "+y);
                this.mandarTiradaSimple(y,interfaz);
                interfaz.mostrarMiresultado(y);
            }else if(op==3){
                con.ver(interfaz);
            }
            else if(op==4){
              //  x=gestorIO.leerInt("Escriba el dado que desea lanzar: ");
                y=this.Opciones(x);
                interfaz.mostrarMiresultado(y);
              //  gestorIO.escribir("Su resultado es: "+y);
            }
            else{
                return;
        //    }


        }

    }

    private void mandarTiradaSimple(int y, Interfaz interfaz) throws IOException {
        con.simple(y,interfaz);
    }

    public void mandarTirada(int t,Interfaz interfaz) throws IOException {

        con.run(t,interfaz);
    }

}
