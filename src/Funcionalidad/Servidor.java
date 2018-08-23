package Funcionalidad;

import Interfaz.Interfaz;
import java.io.*;
import java.net.*;

public class Servidor {
    private static int PUERTO = 28197;
    static GestorIO g= GestorIO.getGestorIO();
    private static Socket cs;
    private static ServerSocket ss;

   // public static void main(String args[]) throws IOException {
    public void run(int t,Interfaz interfaz) throws IOException {

       // while (true) {
            ss = new ServerSocket(PUERTO);
            cs = ss.accept();
            Thread hiloParaTratarElCliente = new HiloParaTratarElCliente(cs,t,interfaz);
            hiloParaTratarElCliente.start();
            ss.close();
    //   }

    }

    public void simple(int y,Interfaz interfaz) throws IOException {
        ss = new ServerSocket(PUERTO);
        cs = ss.accept();
        Thread hiloParaTratarElCliente = new HiloParaTratarElCliente(cs,y,interfaz);
        ((HiloParaTratarElCliente) hiloParaTratarElCliente).enviar();
        ss.close();
    }

    public void ver(Interfaz interfaz) throws IOException {
        ss = new ServerSocket(PUERTO);
        cs = ss.accept();
        Thread hiloParaTratarElCliente = new HiloParaTratarElCliente(cs,0,interfaz);
        ((HiloParaTratarElCliente) hiloParaTratarElCliente).ver();
        ss.close();
    }
}