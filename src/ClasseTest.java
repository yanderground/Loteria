/*import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClasseTest {

    @Test
    public void sorteiaNumeros(){

    }
    @Test
    public void validaJogo(){

    }

}*/
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClasseTest {

    @Test
    public void testSorteiaNumeros() {
        Classe classe = new Classe();
        List<Integer> numerosSorteados = classe.sorteiaNumeros();

        assertTrue(numerosSorteados.size() <= 6);

        for (int numero : numerosSorteados) {
            assertTrue(numero >= 1 && numero <= 60);
        }

        for (int i = 0; i < numerosSorteados.size(); i++) {
            for (int j = i + 1; j < numerosSorteados.size(); j++) {
                assertNotEquals(numerosSorteados.get(i), numerosSorteados.get(j));
            }
        }
    }

    @Test
    public void testValidaJogo() {
        Classe classe = new Classe();
        List<Integer> jogo1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> jogo2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        List<Integer> jogo3 = Arrays.asList(65, 70, 75, 80, 85, 90);
        List<Integer> jogo4 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1);

        try {
            classe.validaJogo(jogo1);
            fail("Deveria ter lançado uma exceção para jogo com menos de 6 números");
        } catch (Exception e) {
            assertEquals("Jogo valido!! Tamanho", e.getMessage());
        }

        try {
            classe.validaJogo(jogo2);
            fail("Deveria ter lançado uma exceção para jogo com mais de 15 números");
        } catch (Exception e) {
            assertEquals("Jogo valido!! Tamanho", e.getMessage());
        }

        try {
            classe.validaJogo(jogo3);
            fail("Deveria ter lançado uma exceção para números fora do intervalo permitido");
        } catch (Exception e) {
            assertEquals("Jogo invalido! Numero incorreto", e.getMessage());
        }

        try {
            classe.validaJogo(jogo4);
            fail("Deveria ter lançado uma exceção para números repetidos no jogo");
        } catch (Exception e) {
            assertEquals("Numero repetido!", e.getMessage());
        }
    }

    @Test
    public void testJogoSorteado() {
        Classe classe = new Classe();
        List<Integer> numerosSorteados = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> jogo1 = Arrays.asList(7, 8, 9, 10, 11, 12);
        List<Integer> jogo2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> jogo3 = Arrays.asList(1, 2, 3, 4, 7, 8);

        assertEquals(0, classe.jogoSorteado(numerosSorteados, jogo1));

        assertEquals(6, classe.jogoSorteado(numerosSorteados, jogo2));

        assertEquals(4, classe.jogoSorteado(numerosSorteados, jogo3));
    }

    @Test
    public void testCalcularPremio() {
        Classe classe = new Classe();
        double premioTotal = 1000.0;

        assertEquals(premioTotal, classe.calcularPremio(premioTotal, 6), 0.0);

        assertEquals(premioTotal * 0.2, classe.calcularPremio(premioTotal, 5), 0.0);

        assertEquals(premioTotal * 0.05, classe.calcularPremio(premioTotal, 4), 0.0);

        assertEquals(0.0, classe.calcularPremio(premioTotal, 0), 0.0);
    }
}
