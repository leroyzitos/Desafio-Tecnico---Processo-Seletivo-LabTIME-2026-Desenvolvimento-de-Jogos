package javacode.ticket3;

public abstract class StateArma {

    protected String nome;
    protected final int danoEscudos;
    protected final int danoBlindagem;
    protected final int danoEstrutura;
    protected final int alcanceMin;
    protected final int alcanceMax;

    protected int danoPorSegundo = 0;

    public StateArma(String nome, int danoEscudos, int danoBlindagem, int danoEstrutura, int alcanceMin, int alcanceMax) {
        this.nome = nome;
        this.danoEscudos = danoEscudos;
        this.danoBlindagem = danoBlindagem;
        this.danoEstrutura = danoEstrutura;
        this.alcanceMin = alcanceMin;
        this.alcanceMax = alcanceMax;
    }

    public String getNome() {
        return nome;
    }

    public int getDanoEscudos() {
        return danoEscudos;
    }

    public int getDanoBlindagem() {
        return danoBlindagem;
    }

    public int getDanoEstrutura() {
        return danoEstrutura;
    }

    public int getAlcanceMin() {
        return alcanceMin;
    }

    public int getAlcanceMax() {
        return alcanceMax;
    }

    public int getDanoPorSegundo() {
        return danoPorSegundo;
    }
}
