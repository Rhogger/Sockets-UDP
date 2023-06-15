import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Emissor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            int porta = 3333;
            try (DatagramSocket socket = new DatagramSocket()) {
                // Aqui coloca o IPV4 da maquina que vai receber a mensagem.
                InetAddress destino = InetAddress.getByName("127.0.0.1");

                System.out.println("Conectado ao servidor...");

                System.out.print("Insira a mensagem: ");
                String mensagem = input.nextLine() + "\n\n";
                byte[] dados = mensagem.getBytes();

                DatagramPacket datagram = new DatagramPacket(dados, dados.length, destino, porta);

                socket.send(datagram);

                System.out.println("\n\nMensagem enviada\n\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}