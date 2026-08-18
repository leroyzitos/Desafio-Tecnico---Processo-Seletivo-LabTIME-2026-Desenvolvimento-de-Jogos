package javacode.ticket3;

public class DanoDeAcido extends DecoratorModificadores{

    public DanoDeAcido(Arma arma) {
        super(arma, 10, 40, 50);
    }

    @Override
    public int getDpsEscudos() {
        return super.getDpsEscudos() + danoIEscudos / 2;
    }

    @Override
    public int getDpsBlindagem() {
        return super.getDpsBlindagem() + danoIBlindagem / 4;
    }

    @Override
    public int getDpsEstrutura() {
        return super.getDpsEstrutura() + danoIEstrutura / 5;
    }
}
