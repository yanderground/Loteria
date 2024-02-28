import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> jogo = new ArrayList<>();
        jogo.add(19);
        jogo.add(13);
        jogo.add(15);
        jogo.add(21);
        jogo.add(26);
        jogo.add(22);

        Classe loteria = new Classe();
        int tentativas = 0;
        double premio = 0;
        while (premio != 100000000){
            premio = loteria.loteria(jogo, 100000000);
            tentativas++;
        }
        System.out.println("Voce tentou :"+tentativas+ "\nPremio de:"+premio);
    }
}