package javacode.ticket3;

public class DanoDeFogo extends DecoratorModificadores{

    public DanoDeFogo(Arma arma) {
        super(arma, 10, 20, 30);
    }

    @Override
    public int getDpsEscudos() {
        return super.getDpsEscudos() + danoIEscudos / 2;
    }

    @Override
    public int getDpsBlindagem() {
        return super.getDpsBlindagem() + danoIBlindagem / 2;
    }

    @Override
    public int getDpsEstrutura() {
        return super.getDpsEstrutura() + danoIEstrutura / 2;
    }
}
