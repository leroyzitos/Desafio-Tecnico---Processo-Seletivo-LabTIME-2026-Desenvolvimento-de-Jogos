package javacode.ticket3;

public abstract class DecoratorModificadores implements Arma{

    protected Arma arma;

    protected final int danoIEscudos;
    protected final int danoIBlindagem;
    protected final int danoIEstrutura;

    public DecoratorModificadores(Arma arma, int danoIEscudos, int danoIBlindagem, int danoIEstrutura) {
        this.arma = arma;
        this.danoIEscudos = danoIEscudos;
        this.danoIBlindagem = danoIBlindagem;
        this.danoIEstrutura = danoIEstrutura;
    }

    @Override
    public String getNome() {
        return arma.getNome();
    }

    @Override
    public int getDanoEscudos() {
        return arma.getDanoEscudos() + danoIEscudos;
    }

    @Override
    public int getDanoBlindagem() {
        return arma.getDanoBlindagem() + danoIBlindagem;
    }

    @Override
    public int getDanoEstrutura() {
        return arma.getDanoEstrutura() + danoIEstrutura;
    }

    @Override
    public int getAlcanceMin() {
        return arma.getAlcanceMin();
    }

    @Override
    public int getAlcanceMax() {
        return arma.getAlcanceMax();
    }

    @Override
    public int getDpsEscudos() {
        return arma.getDpsEscudos();
    }

    @Override
    public int getDpsBlindagem() {
        return arma.getDpsBlindagem();
    }

    @Override
    public int getDpsEstrutura() {
        return arma.getDpsEstrutura();
    }
}
