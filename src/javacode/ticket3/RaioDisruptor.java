package javacode.ticket3;

/**
 * Representa o estado correspondente à arma-base Raio Disruptor.
 *
 * <p>Define os valores específicos de dano, alcance e dano por segundo
 * utilizados por esse tipo de arma.</p>
 */
public class RaioDisruptor extends StateArma{

    /**
     * Construtor de {@code RaioDisruptor}.
     *
     * <p>Inicializa a arma com seus atributos específicos.</p>
     */
    public RaioDisruptor() {
        super("Raio Disruptor", 800, 150, 200, 0, 150, 0, 0, 0);
    }
}