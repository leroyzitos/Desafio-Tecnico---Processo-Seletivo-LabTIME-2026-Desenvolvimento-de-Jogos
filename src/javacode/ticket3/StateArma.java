package javacode.ticket3;

/**
 * Classe abstrata que representa a estrutura comum dos estados
 * correspondentes às armas-base.
 *
 * <p>Implementa {@link Arma} e concentra os atributos e comportamentos
 * compartilhados pelas diferentes armas disponíveis no sistema.</p>
 *
 * <p>Cada subclasse concreta define, por meio do construtor, os valores
 * específicos de nome, dano, alcance e dano por segundo que caracterizam
 * sua respectiva arma.</p>
 */
public abstract class StateArma implements Arma{

    /** Nome da arma. */
    protected final String nome;

    /** Dano da arma aos escudos. */
    protected final int danoEscudos;

    /** Dano da arma à blindagem. */
    protected final int danoBlindagem;

    /** Dano da arma à estrutura. */
    protected final int danoEstrutura;

    /** Alcance mínimo da arma. */
    protected final int alcanceMin;

    /** Alcance máximo da arma. */
    protected final int alcanceMax;

    /** Dano por segundo causado aos escudos. */
    protected final int dpsEscudos;

    /** Dano por segundo causado à blindagem. */
    protected final int dpsBlindagem;

    /** Dano por segundo causado à estrutura. */
    protected final int dpsEstrutura;

    /**
     * Construtor de {@code StateArma}.
     *
     * @param nome nome da arma
     * @param danoEscudos dano causado aos escudos
     * @param danoBlindagem dano causado à blindagem
     * @param danoEstrutura dano causado à estrutura
     * @param alcanceMin alcance mínimo da arma
     * @param alcanceMax alcance máximo da arma
     * @param dpsEscudos dano por segundo causado aos escudos
     * @param dpsBlindagem dano por segundo causado à blindagem
     * @param dpsEstrutura dano por segundo causado à estrutura
     */
    public StateArma(String nome, int danoEscudos, int danoBlindagem, int danoEstrutura, int alcanceMin, int alcanceMax, int dpsEscudos, int dpsBlindagem, int dpsEstrutura) {
        this.nome = nome;
        this.danoEscudos = danoEscudos;
        this.danoBlindagem = danoBlindagem;
        this.danoEstrutura = danoEstrutura;
        this.alcanceMin = alcanceMin;
        this.alcanceMax = alcanceMax;
        this.dpsEscudos = dpsEscudos;
        this.dpsBlindagem = dpsBlindagem;
        this.dpsEstrutura = dpsEstrutura;
    }

    /**
     * Retorna o nome da arma.
     *
     * @return nome da arma
     */
    @Override
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o dano aos escudos.
     *
     * @return dano aos escudos
     */
    @Override
    public int getDanoEscudos() {
        return danoEscudos;
    }

    /**
     * Retorna o dano à blindagem.
     *
     * @return dano à blindagem
     */
    @Override
    public int getDanoBlindagem() {
        return danoBlindagem;
    }

    /**
     * Retorna o dano à estrutura.
     *
     * @return dano à estrutura
     */
    @Override
    public int getDanoEstrutura() {
        return danoEstrutura;
    }

    /**
     * Retorna o alcance mínimo da arma.
     *
     * @return alcance mínimo
     */
    @Override
    public int getAlcanceMin() {
        return alcanceMin;
    }

    /**
     * Retorna o alcance máximo da arma.
     *
     * @return alcance máximo
     */
    @Override
    public int getAlcanceMax() {
        return alcanceMax;
    }

    /**
     * Retorna o dano por segundo aos escudos.
     *
     * @return dano por segundo aos escudos
     */
    @Override
    public int getDpsEscudos() {
        return dpsEscudos;
    }

    /**
     * Retorna o dano por segundo à blindagem.
     *
     * @return dano por segundo à blindagem
     */
    @Override
    public int getDpsBlindagem() {
        return dpsBlindagem;
    }

    /**
     * Retorna o dano por segundo à estrutura.
     *
     * @return dano por segundo à estrutura
     */
    @Override
    public int getDpsEstrutura() {
        return dpsEstrutura;
    }

    /**
     * Retorna uma representação textual dos atributos da arma-base.
     *
     * @return representação textual da arma e de seus atributos
     */
    @Override
    public String toString() {

        int danoTotal = danoEscudos + danoBlindagem + danoEstrutura;
        int dpsTotal = dpsEscudos + dpsBlindagem + dpsEstrutura;
        return "Arma equipada: " + nome

                + "\n\nDano imediato:"
                + "\n\tEscudos:    " + danoEscudos
                + "\n\tBlindagem:  " + danoBlindagem
                + "\n\tEstrutura:  " + danoEstrutura
                + "\n\t--------------------"
                + "\n\tTotal:      " + danoTotal

                + "\n\nDano por segundo:"
                + "\n\tEscudos:    " + dpsEscudos
                + "\n\tBlindagem:  " + dpsBlindagem
                + "\n\tEstrutura:  " + dpsEstrutura
                + "\n\t--------------------"
                + "\n\tTotal:      " + dpsTotal

                + "\n\nAlcance:"
                + "\n\tMínimo:     " + alcanceMin
                + "\n\tMáximo:     " + alcanceMax
                + "\n\t--------------------"
                + "\n\tIntervalo:  De " + alcanceMin
                + " a " + alcanceMax + "\n";
    }
}