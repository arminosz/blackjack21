import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BlackjackGame {

    // Representação das cartas e os valores
    static String[] naipes = {"♠", "♥", "♦", "♣"};
    static String[] faces = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    static int[] valores = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        int saldo = 1000;  // Saldo inicial fictício do jogador

        System.out.println("=== Bem-vindo ao Blackjack 21! ===");
        System.out.println("Seu saldo inicial é: $" + saldo);

        while (saldo > 0) {
            System.out.print("\nQuanto você quer apostar? (Saldo: $" + saldo + "): ");
            int aposta = scanner.nextInt();
            if (aposta > saldo) {
                System.out.println("Você não pode apostar mais do que tem! Tente novamente.");
                continue;
            }

            List<String> maoJogador = new ArrayList<>();
            List<String> maoDealer = new ArrayList<>();

            // Distribuir 2 cartas para jogador e dealer
            maoJogador.add(distribuirCarta());
            maoJogador.add(distribuirCarta());
            maoDealer.add(distribuirCarta());
            maoDealer.add(distribuirCarta());

            System.out.println("\nSuas cartas: " + maoJogador + " (Total: " + calcularValor(maoJogador) + ")");
            System.out.println("Carta visível do Dealer: " + maoDealer.get(0));

            boolean jogadorPassou = false;
            while (!jogadorPassou) {
                System.out.print("\nVocê quer 'hit' ou 'stand'? ");
                String acao = scanner.next().toLowerCase();

                if (acao.equals("hit")) {
                    maoJogador.add(distribuirCarta());
                    System.out.println("Suas cartas: " + maoJogador + " (Total: " + calcularValor(maoJogador) + ")");

                    if (calcularValor(maoJogador) > 21) {
                        System.out.println("Você estourou! Total: " + calcularValor(maoJogador));
                        saldo -= aposta;
                        jogadorPassou = true;
                    }
                } else if (acao.equals("stand")) {
                    jogadorPassou = true;
                } else {
                    System.out.println("Opção inválida! Escolha 'hit' ou 'stand'.");
                }
            }

            if (calcularValor(maoJogador) <= 21) {
                // Turno do dealer (dealer para em 17 ou mais)
                System.out.println("\nTurno do Dealer...");
                System.out.println("Cartas do Dealer: " + maoDealer + " (Total: " + calcularValor(maoDealer) + ")");
                while (calcularValor(maoDealer) < 17) {
                    maoDealer.add(distribuirCarta());
                    System.out.println("Cartas do Dealer: " + maoDealer + " (Total: " + calcularValor(maoDealer) + ")");
                }

                // Determinar o vencedor
                int totalJogador = calcularValor(maoJogador);
                int totalDealer = calcularValor(maoDealer);

                if (totalDealer > 21) {
                    System.out.println("O dealer estourou! Você ganhou!");
                    saldo += aposta;
                } else if (totalJogador > totalDealer) {
                    System.out.println("Você ganhou!");
                    saldo += aposta;
                } else if (totalJogador < totalDealer) {
                    System.out.println("Você perdeu!");
                    saldo -= aposta;
                } else {
                    System.out.println("Empate!");
                }
            }

            // Verificar saldo
            System.out.println("Seu saldo atual é: $" + saldo);
            if (saldo == 0) {
                System.out.println("Você ficou sem saldo! Jogo terminado.");
                break;
            }

            // Perguntar se deseja continuar
            System.out.print("\nVocê quer jogar novamente? (sim/não): ");
            String jogarNovamente = scanner.next().toLowerCase();
            if (!jogarNovamente.equals("sim")) {
                break;
            }
        }

        System.out.println("Obrigado por jogar! Seu saldo final é: $" + saldo);
    }

    // Função para distribuir uma carta
    public static String distribuirCarta() {
        int indiceFace = random.nextInt(faces.length);
        int indiceNaipe = random.nextInt(naipes.length);
        return faces[indiceFace] + naipes[indiceNaipe];
    }

    // Função para calcular o valor da mão
    public static int calcularValor(List<String> mao) {
        int total = 0;
        int ases = 0;

        for (String carta : mao) {
            String face = carta.substring(0, carta.length() - 1); // Remove o naipe
            int valor = 0;

            for (int i = 0; i < faces.length; i++) {
                if (face.equals(faces[i])) {
                    valor = valores[i];
                    if (face.equals("A")) ases++;
                    break;
                }
            }

            total += valor;
        }

        // Ajustar valor do Ás se necessário (11 ou 1)
        while (total > 21 && ases > 0) {
            total -= 10;
            ases--;
        }

        return total;
    }
}
