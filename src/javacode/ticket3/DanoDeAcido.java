package javacode.ticket3;

/**
 * Decorador que adiciona efeitos de dano de ácido à arma.
 *
 * <p>Estende {@link DecoratorModificadores} e acrescenta danos imediatos
 * aos diferentes componentes da nave, além de contribuir com dano por
 * segundo em proporções específicas para escudos, blindagem e estrutura.</p>
 */
public class DanoDeAcido extends DecoratorModificadores{

    /**
     * Construtor de {@code DanoDeAcido}.
     *
     * @param arma arma ou modificador que será decorado
     */
    public DanoDeAcido(Arma arma) {
        super(arma, 10, 40, 50);
    }

    /**
     * Retorna o dano por segundo aos escudos, adicionando metade do dano
     * imediato fornecido pelo modificador de ácido.
     *
     * @return dano por segundo acumulado aos escudos
     */
    @Override
    public int getDpsEscudos() {
        return super.getDpsEscudos() + danoIEscudos / 2;
    }

    /**
     * Retorna o dano por segundo à blindagem, adicionando um quarto do dano
     * imediato fornecido pelo modificador de ácido.
     *
     * @return dano por segundo acumulado à blindagem
     */
    @Override
    public int getDpsBlindagem() {
        return super.getDpsBlindagem() + danoIBlindagem / 4;
    }

    /**
     * Retorna o dano por segundo à estrutura, adicionando um quinto do dano
     * imediato fornecido pelo modificador de ácido.
     *
     * @return dano por segundo acumulado à estrutura
     */
    @Override
    public int getDpsEstrutura() {
        return super.getDpsEstrutura() + danoIEstrutura / 5;
    }
}