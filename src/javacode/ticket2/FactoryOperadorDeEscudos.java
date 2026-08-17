package javacode.ticket2;

public class FactoryOperadorDeEscudos extends FactoryStateFuncao{

    @Override
    public StateFuncao criarStateFuncao() {
        return new OperadorDeEscudos();
    }
}