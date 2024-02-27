import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class Classe {
    private static Random random = new Random();

    public double loteria(List<Integer> jogo, double premioTotal) {
        Set<Integer> numerosSorteados = sorteiaNumeros();
        List<Integer> jogoValido = validaJogo(jogo);
        if (jogoValido == null) return 0.0;

        int acertos = jogoSorteado(numerosSorteados, jogoValido);

        return calcularPremio(premioTotal, acertos);
    }

    private static Set<Integer> sorteiaNumeros() {
        Set<Integer> numerosSorteados = new HashSet<>();
        while (numerosSorteados.size() < 6) {
            try {
                numerosSorteados.add(random.nextInt(59) + 1);
            } catch (IllegalArgumentException e) {
            }
        }
        return numerosSorteados;
    }

    private List<Integer> validaJogo(List<Integer> jogo) {
        if (jogo.size() < 6 || jogo.size() > 15) {
            System.out.println("O jogo deve conter entre 6 e 15 números.");
            return null;
        }

        Set<Integer> numeros = new HashSet<>();
        List<Integer> numerosRepetidos = new ArrayList<>();

        for (Integer n : jogo) {
            if (n < 1 || n > 60 || numeros.contains(n)) {
                if (!numerosRepetidos.contains(n)) {
                    numerosRepetidos.add(n);
                    System.out.println("Não foi possível adicionar o número " + n + ": número repetido.");
                }
            } else {
                numeros.add(n);
            }
        }
        return new ArrayList<>(numeros);
    }


    private static int jogoSorteado(Set<Integer> numerosSorteados, List<Integer> jogoValido) {
        int acertos = 0;
        for (Integer numero : jogoValido) {
            if (numerosSorteados.contains(numero)) {
                acertos++;
            }
        }
        return acertos;
    }

    private static double calcularPremio(double premioTotal, int acertos) {
        if (acertos == 6) {
            return premioTotal;
        } else if (acertos == 5) {
            return premioTotal * 0.2;
        } else if (acertos == 4) {
            return premioTotal * 0.05;
        }
        return 0.0;
    }
}
