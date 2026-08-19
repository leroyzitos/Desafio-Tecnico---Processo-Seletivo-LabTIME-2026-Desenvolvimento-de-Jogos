package javacode.ticket3;

/**
 * Decorador que adiciona efeitos de perfuração de blindagem à arma.
 *
 * <p>Estende {@link DecoratorModificadores} e acrescenta danos adicionais
 * aos escudos, à blindagem e à estrutura da arma decorada.</p>
 */
public class PerfuracaoDeBlindagem extends DecoratorModificadores{

    /**
     * Construtor de {@code PerfuracaoDeBlindagem}.
     *
     * @param arma arma ou modificador que será decorado
     */
    public PerfuracaoDeBlindagem(Arma arma) {
        super(arma, 30, 70, 50);
    }
}