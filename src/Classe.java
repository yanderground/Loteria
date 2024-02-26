import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Classe {

    public double loteria(List<Integer> jogo, double premioTotal) {

        List<Integer> jogoValido = validaNumeros(jogo);
        if (jogoValido == null) return 0.0;

        int acertos = sorteio(jogo, jogoValido);

        double premioGanho = calcularPremio(premioTotal, acertos);

        return premioGanho;
    }

    private static List<Integer> validaNumeros(List<Integer> jogo) {
        List<Integer> jogoValido = new ArrayList<>();
        for (Integer n: jogo){
            if (n < 1 || n > 60){
                return null;
            }
            if (jogoValido.contains(n)){
                return null;
            }
            jogoValido.add(n);
        }
        return jogoValido;
    }

    private static int sorteio(List<Integer> jogo, List<Integer> jogoValido) {
        int acertos = 0;
        if (jogoValido.size() >= 6 && jogoValido.size() <= 15) {

            List<Integer> numerosCertos = sorteiaNumeros();
            acertos = verificarAcertos(jogo, numerosCertos);
        }
        return acertos;
    }

    private static List<Integer> sorteiaNumeros() {
        List<Integer> numerosCertos = new ArrayList<>();
        int s;
        while (numerosCertos.size() < 6) {
            s = new Random().nextInt(59) + 1;
            if (!numerosCertos.contains(s)) {
                numerosCertos.add(s);
            }
        }
        return numerosCertos;
    }

    private static int verificarAcertos(List<Integer> jogo, List<Integer> numerosCertos) {
        int acertos =0;
        for (Integer i: jogo){
            if (numerosCertos.contains(i)){
                acertos++;
            }
        }
        return acertos;
    }

    private static double calcularPremio(double premioTotal, int acertos) {
        if (acertos == 6){
            return premioTotal;
        } else if (acertos == 5){
            return premioTotal * 0.2;
        } else if (acertos == 4){
            return premioTotal * 0.05;
        }
        return 0.0;
    }

}
