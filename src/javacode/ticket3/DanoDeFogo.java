package javacode.ticket3;

/**
 * Decorador que adiciona efeitos de dano de fogo à arma.
 *
 * <p>Estende {@link DecoratorModificadores} e acrescenta danos imediatos
 * aos escudos, à blindagem e à estrutura, além de gerar dano por segundo
 * correspondente a metade do dano imediato adicionado em cada componente.</p>
 */
public class DanoDeFogo extends DecoratorModificadores{

    /**
     * Construtor de {@code DanoDeFogo}.
     *
     * @param arma arma ou modificador que será decorado
     */
    public DanoDeFogo(Arma arma) {
        super(arma, 10, 20, 30);
    }

    /**
     * Retorna o dano por segundo aos escudos, adicionando metade do dano
     * imediato fornecido pelo modificador de fogo.
     *
     * @return dano por segundo acumulado aos escudos
     */
    @Override
    public int getDpsEscudos() {
        return super.getDpsEscudos() + danoIEscudos / 2;
    }

    /**
     * Retorna o dano por segundo à blindagem, adicionando metade do dano
     * imediato fornecido pelo modificador de fogo.
     *
     * @return dano por segundo acumulado à blindagem
     */
    @Override
    public int getDpsBlindagem() {
        return super.getDpsBlindagem() + danoIBlindagem / 2;
    }

    /**
     * Retorna o dano por segundo à estrutura, adicionando metade do dano
     * imediato fornecido pelo modificador de fogo.
     *
     * @return dano por segundo acumulado à estrutura
     */
    @Override
    public int getDpsEstrutura() {
        return super.getDpsEstrutura() + danoIEstrutura / 2;
    }
}