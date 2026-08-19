package javacode.ticket3;

/**
 * Representa o estado correspondente à arma-base Láser Contínuo.
 *
 * <p>Define os valores específicos de dano, alcance e dano por segundo
 * utilizados por esse tipo de arma.</p>
 */
public class LaserContinuo extends StateArma{

    /**
     * Construtor de {@code LaserContinuo}.
     *
     * <p>Inicializa a arma com seus atributos específicos.</p>
     */
    public LaserContinuo() {
        super("Láser Contínuo", 100, 150, 700, 0, 200, 0, 0, 0);
    }
}