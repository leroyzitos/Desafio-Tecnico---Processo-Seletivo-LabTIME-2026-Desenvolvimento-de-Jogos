package javacode.ticket3;

/**
 * Decorador que adiciona efeitos de impacto explosivo à arma.
 *
 * <p>Estende {@link DecoratorModificadores} e acrescenta danos adicionais
 * aos escudos, à blindagem e à estrutura da arma decorada.</p>
 */
public class ImpactoExplosivo extends DecoratorModificadores{

    /**
     * Construtor de {@code ImpactoExplosivo}.
     *
     * @param arma arma ou modificador que será decorado
     */
    public ImpactoExplosivo(Arma arma) {
        super(arma, 20, 35, 100);
    }
}