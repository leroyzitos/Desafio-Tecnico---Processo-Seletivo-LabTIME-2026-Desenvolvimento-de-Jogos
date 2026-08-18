package javacode.ticket3;

public abstract class StateArma implements Arma{

    protected final String nome;
    protected final int danoEscudos;
    protected final int danoBlindagem;
    protected final int danoEstrutura;
    protected final int alcanceMin;
    protected final int alcanceMax;
    protected final int dpsEscudos;
    protected final int dpsBlindagem;
    protected final int dpsEstrutura;

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

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getDanoEscudos() {
        return danoEscudos;
    }

    @Override
    public int getDanoBlindagem() {
        return danoBlindagem;
    }

    @Override
    public int getDanoEstrutura() {
        return danoEstrutura;
    }

    @Override
    public int getAlcanceMin() {
        return alcanceMin;
    }

    @Override
    public int getAlcanceMax() {
        return alcanceMax;
    }

    @Override
    public int getDpsEscudos() {
        return dpsEscudos;
    }

    @Override
    public int getDpsBlindagem() {
        return dpsBlindagem;
    }

    @Override
    public int getDpsEstrutura() {
        return dpsEstrutura;
    }

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