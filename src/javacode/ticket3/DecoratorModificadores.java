package javacode.ticket3;

/**
 * Classe abstrata que representa o decorador base dos modificadores de armas.
 *
 * <p>Implementa {@link Arma} e mantém uma referência para outro objeto
 * {@link Arma}, permitindo que modificadores sejam empilhados
 * dinamicamente.</p>
 *
 * <p>Os valores de dano adicionados pelo modificador são armazenados na
 * própria instância do decorador, enquanto os demais comportamentos são
 * delegados ao objeto de arma decorado.</p>
 */
public abstract class DecoratorModificadores implements Arma{

    /** Componente de arma que está sendo decorado. */
    protected Arma arma;

    /** Dano adicional aos escudos fornecido pelo modificador. */
    protected final int danoIEscudos;

    /** Dano adicional à blindagem fornecido pelo modificador. */
    protected final int danoIBlindagem;

    /** Dano adicional à estrutura fornecido pelo modificador. */
    protected final int danoIEstrutura;

    /**
     * Construtor de {@code DecoratorModificadores}.
     *
     * @param arma componente de arma que será decorado
     * @param danoIEscudos dano imediato adicional aos escudos
     * @param danoIBlindagem dano imediato adicional à blindagem
     * @param danoIEstrutura dano imediato adicional à estrutura
     */
    public DecoratorModificadores(Arma arma, int danoIEscudos, int danoIBlindagem, int danoIEstrutura) {
        this.arma = arma;
        this.danoIEscudos = danoIEscudos;
        this.danoIBlindagem = danoIBlindagem;
        this.danoIEstrutura = danoIEstrutura;
    }

    /**
     * Retorna o nome da arma decorada.
     *
     * @return nome da arma
     */
    @Override
    public String getNome() {
        return arma.getNome();
    }

    /**
     * Retorna o dano aos escudos acumulado pelo componente decorado e
     * pelo modificador atual.
     *
     * @return dano acumulado aos escudos
     */
    @Override
    public int getDanoEscudos() {
        return arma.getDanoEscudos() + danoIEscudos;
    }

    /**
     * Retorna o dano à blindagem acumulado pelo componente decorado e
     * pelo modificador atual.
     *
     * @return dano acumulado à blindagem
     */
    @Override
    public int getDanoBlindagem() {
        return arma.getDanoBlindagem() + danoIBlindagem;
    }

    /**
     * Retorna o dano à estrutura acumulado pelo componente decorado e
     * pelo modificador atual.
     *
     * @return dano acumulado à estrutura
     */
    @Override
    public int getDanoEstrutura() {
        return arma.getDanoEstrutura() + danoIEstrutura;
    }

    /**
     * Retorna o alcance mínimo do componente de arma decorado.
     *
     * @return alcance mínimo
     */
    @Override
    public int getAlcanceMin() {
        return arma.getAlcanceMin();
    }

    /**
     * Retorna o alcance máximo do componente de arma decorado.
     *
     * @return alcance máximo
     */
    @Override
    public int getAlcanceMax() {
        return arma.getAlcanceMax();
    }

    /**
     * Retorna o dano por segundo aos escudos do componente decorado.
     *
     * @return dano por segundo aos escudos
     */
    @Override
    public int getDpsEscudos() {
        return arma.getDpsEscudos();
    }

    /**
     * Retorna o dano por segundo à blindagem do componente decorado.
     *
     * @return dano por segundo à blindagem
     */
    @Override
    public int getDpsBlindagem() {
        return arma.getDpsBlindagem();
    }

    /**
     * Retorna o dano por segundo à estrutura do componente decorado.
     *
     * @return dano por segundo à estrutura
     */
    @Override
    public int getDpsEstrutura() {
        return arma.getDpsEstrutura();
    }
}