import java.net.*;
import java.io.*;

public class Receptor {
  public static void main(String[] args) {
    try {
      int porta = 3333;
      byte[] dados = new byte[100];
      try (DatagramSocket socket = new DatagramSocket(porta)) {
        DatagramPacket pacote = new DatagramPacket(dados, dados.length);

        System.out.print("\n\nUsuário está digitando...\n\n");

        socket.receive(pacote);

        String mensagem = new String(pacote.getData(), 0, pacote.getLength());
        System.out.printf("Mensagem: %s \n\n", mensagem);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}