package javacode.ticket3;

/**
 * Decorador que adiciona dano adicional aos escudos da arma atualmente
 * equipada.
 *
 * <p>Estende {@link DecoratorModificadores} e acrescenta sua contribuição
 * específica aos valores de dano da arma decorada.</p>
 */
public class DisruptorDeEscudos extends DecoratorModificadores{

    /**
     * Construtor de {@code DisruptorDeEscudos}.
     *
     * @param arma arma ou modificador que será decorado
     */
    public DisruptorDeEscudos(Arma arma) {
        super(arma, 80, 0, 0);
    }
}