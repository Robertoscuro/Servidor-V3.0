package Funcionalidad;
import java.io.*;
import java.net.Socket;

import Interfaz.*;
    public class HiloParaTratarElCliente extends Thread {
        Socket cs;
        int T;
        Interfaz interfaz;
        public HiloParaTratarElCliente (Socket cs, int t,Interfaz inter) {
            this.cs = cs;
            this.T=t;
            this.interfaz = inter;

        }
        public void start(){
            BufferedReader entrada;
            BufferedWriter bws;
            OutputStream os;
            

            try {

                entrada = new BufferedReader(new InputStreamReader(
                        cs.getInputStream()));
                os = cs.getOutputStream();
                bws = new BufferedWriter(new OutputStreamWriter(os));
                bws.write("El resultado del Master es: "+T);

                bws.newLine();
                bws.flush();
                String mensajeRecibido = entrada.readLine();
             //   System.out.println("\n"+mensajeRecibido);
                interfaz.mostarJugador(mensajeRecibido);
                cs.close();
            } catch (IOException e) {
                System.out.println("Error de entrada/salida."  + e.getMessage());
            }
        }

        public void enviar() throws IOException {
            try {
            BufferedWriter bws;
            BufferedReader br = null;
            OutputStream os;
            os = cs.getOutputStream();
            bws = new BufferedWriter(new OutputStreamWriter(os));
            bws.write("El resultado del Master es: "+T);
            bws.newLine();
            bws.flush();
            interfaz.mostarJugador(" ");
            cs.close();
        } catch (IOException e) {
            System.out.println("Error de entrada/salida."  + e.getMessage());
        }
        }

        public void ver() {
            try {
                BufferedReader entrada;
                entrada = new BufferedReader(new InputStreamReader(
                        cs.getInputStream()));
                String mensajeRecibido = entrada.readLine();
                //System.out.println("\n"+mensajeRecibido);
                interfaz.mostarJugador(mensajeRecibido);
                cs.close();
            } catch (IOException e) {
                System.out.println("Error de entrada/salida."  + e.getMessage());
            }
        }
    }

