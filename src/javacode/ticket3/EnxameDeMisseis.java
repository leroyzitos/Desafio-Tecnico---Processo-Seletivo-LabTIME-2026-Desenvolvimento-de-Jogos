package javacode.ticket3;

/**
 * Representa o estado correspondente à arma-base Enxame de Mísseis.
 *
 * <p>Define os valores específicos de dano, alcance e dano por segundo
 * utilizados por esse tipo de arma.</p>
 */
public class EnxameDeMisseis extends StateArma{

    /**
     * Construtor de {@code EnxameDeMisseis}.
     *
     * <p>Inicializa a arma com seus atributos específicos.</p>
     */
    public EnxameDeMisseis() {
        super("Enxame de Mísseis", 200, 400, 700, 50, 500, 0, 0, 0);
    }
}