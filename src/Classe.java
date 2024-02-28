import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Classe {

    public double loteria(List<Integer> jogo, double premioTotal) {
        List<Integer> numerosSorteados = sorteiaNumeros();
        List<Integer> jogoValido = new ArrayList<>();
        int acertos;

        try{
            jogoValido = validaJogo(jogo);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        acertos = jogoSorteado(numerosSorteados, jogoValido);

        return calcularPremio(premioTotal, acertos);
    }

    private static List<Integer> sorteiaNumeros() {
        int numero;
        List<Integer> numerosSorteados = new ArrayList<>();

        while (numerosSorteados.size() < 6) {
            numero = (new Random().nextInt(59) + 1);
            if (!numerosSorteados.contains(numero)){
                numerosSorteados.add(numero);
            }
        }
        return numerosSorteados;
    }

    private List<Integer> validaJogo(List<Integer> jogo) throws Exception {
        List<Integer> jogoValido = new ArrayList<>();

        if (jogo.size() < 6 || jogo.size() > 15) {
            throw new Exception("Jogo valido!! Tamanho");
        }

        for (Integer n : jogo) {
            if (n < 1 || n > 60) {
                throw new Exception("Jogo invalido! Numero incorreto");
            }
            if (jogoValido.contains(n)){
                throw new Exception("Numero repetido!");
            }
            jogoValido.add(n);
        }
        return jogoValido;
    }


    private static int jogoSorteado(List<Integer> numerosSorteados, List<Integer> jogoValido) {
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
