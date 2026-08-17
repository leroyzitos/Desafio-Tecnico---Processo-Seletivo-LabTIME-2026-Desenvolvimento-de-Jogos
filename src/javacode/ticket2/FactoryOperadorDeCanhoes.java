package javacode.ticket2;

public class FactoryOperadorDeCanhoes extends FactoryStateFuncao{

    @Override
    public StateFuncao criarStateFuncao() {
        return new OperadorDeCanhoes();
    }
}