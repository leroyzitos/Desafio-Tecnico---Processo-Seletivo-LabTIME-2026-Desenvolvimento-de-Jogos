package javacode.ticket3;

/**
 * Representa o estado correspondente à arma-base Canhões Perfurantes.
 *
 * <p>Define os valores específicos de dano, alcance e dano por segundo
 * utilizados por esse tipo de arma.</p>
 */
public class CanhoesPerfurantes extends StateArma{

    /**
     * Construtor de {@code CanhoesPerfurantes}.
     *
     * <p>Inicializa a arma com seus atributos específicos.</p>
     */
    public CanhoesPerfurantes() {
        super("Canhões Perfurantes", 300, 700, 500, 0, 250, 0, 0, 0);
    }

}