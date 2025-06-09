import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        // gerando o campo q o jogador nao ve
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

        // gerando o campo q o jogador irá ver
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
        int pontuacao = 0;
        int qtTesourosAchados = 0;
        boolean ganhou = false;
        System.out.println("*** Bem vindo à Caça ao Tesouro! ***");
        do {
            // mostrando o campo
            System.out.println("   0 1 2 3 4 5 6 7");
            for (int i = 0; i < campoJogador.length; i++) {
                System.out.print(i + "  "); // índice da linha
                for (int j = 0; j < campoJogador[i].length; j++) {
                    System.out.print(campoJogador[i][j] + " ");
                }
                System.out.println();
            }
            // Imprimindo pontuação
            System.out.println("Sua pontuação atual: " + pontuacao + " pontos");

            // input da linha e coluna
            System.out.println("Insira a linha da posição que você quer escavar:");
            int posLinha = input.nextInt();

            System.out.println("Insira a coluna da posição que você quer escavar:");
            int posColuna = input.nextInt();

            if ((posColuna > 7 || posColuna < 0) || (posLinha > 7 || posLinha < 0)) {
                System.out.println("Valor invalido");
                continue;
            }

            if (campoJogador[posLinha][posColuna].equals("O") ||
                    campoJogador[posLinha][posColuna].equals("T") ||
                    campoJogador[posLinha][posColuna].equals("A")) {
                System.out.println("Posição ja jogada manooo");
                continue;
            }

            switch (campo[posLinha][posColuna]) {
                case "~":
                    System.out.println("Só areia campeão");
                    campoJogador[posLinha][posColuna] = "O";
                    break;

                case "t":
                    System.out.println("Achou um Tesouro!");
                    campoJogador[posLinha][posColuna] = "T";
                    qtTesourosAchados++;
                    pontuacao += 10;
                    break;

                case "a":
                    System.out.println("Kabooommm armadilha");
                    campoJogador[posLinha][posColuna] = "A";
                    pontuacao -= 5;
                    break;

                default:
                    System.out.println("Nada");
                    break;
            }
            if (qtTesourosAchados == 8) {
                ganhou = true;
                break;
            }

            jogadas++;
        } while (jogadas < 25);

        System.out.println("Fim de jogo");
          System.out.println("   0 1 2 3 4 5 6 7");
            for (int i = 0; i < campo.length; i++) {
                System.out.print(i + "  "); // índice da linha
                for (int j = 0; j < campo[i].length; j++) {
                    System.out.print(campo[i][j] + " ");
                }
                System.out.println();
            }
        if(ganhou){
            System.out.println("Parabéns voce achou todos os tesouros!");
        } else {
            System.out.println("Voce perdeu!");
        }
        System.out.println("Sua pontuação final: "+pontuacao+" pontos");
        if(pontuacao >= 70){
            System.out.println("Explorador Lendario!");
        } else if(pontuacao >= 50 && pontuacao <= 69){
            System.out.println("Caçador de Tesouros Experiente");
        } else if(pontuacao >= 30 && pontuacao <=49){
            System.out.println("Aventureiro Iniciante");
        } else {
            System.out.println("Precisa de mais prática na exploração");
        }
    }
}