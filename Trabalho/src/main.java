import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        //gerando o campo q o jogador nao ve
        Random random = new Random();
        String campo[][] = {
                { "~", "~", "~", "~", "~", "~", "~", "~" },
                { "~", "~", "~", "~", "~", "~", "~", "~" },
                { "~", "~", "~", "~", "~", "~", "~", "~" },
                { "~", "~", "~", "~", "~", "~", "~", "~" },
                { "~", "~", "~", "~", "~", "~", "~", "~" },
                { "~", "~", "~", "~", "~", "~", "~", "~" },
                { "~", "~", "~", "~", "~", "~", "~", "~" },
                { "~", "~", "~", "~", "~", "~", "~", "~" },
        };
        // aqui é a rotina para add os tesouros
        for (int i = 0; i < 8; i++) {
            int linha = random.nextInt(8);
            int coluna = random.nextInt(8);

            if (campo[linha][coluna].equals("~")) {
                campo[linha][coluna] = "t";
            } else {
                i--;
            }
        }
        // aqui a rotina para add as armadilhas
        for (int i = 0; i < 5; i++) {
            int linha = random.nextInt(8);
            int coluna = random.nextInt(8);

            if (campo[linha][coluna].equals("~")) {
                campo[linha][coluna] = "a";
            } else {
                i--;
            }
        }


        //gerando o campo q o jogador irá ver
        String campoJogador[][] = {
                { "~", "~", "~", "~", "~", "~", "~", "~" },
                { "~", "~", "~", "~", "~", "~", "~", "~" },
                { "~", "~", "~", "~", "~", "~", "~", "~" },
                { "~", "~", "~", "~", "~", "~", "~", "~" },
                { "~", "~", "~", "~", "~", "~", "~", "~" },
                { "~", "~", "~", "~", "~", "~", "~", "~" },
                { "~", "~", "~", "~", "~", "~", "~", "~" },
                { "~", "~", "~", "~", "~", "~", "~", "~" },
        };
        Scanner input = new Scanner(System.in);
        int jogadas = 0;
        while (jogadas < 25) {
            
            jogadas++;
        }
    }
}