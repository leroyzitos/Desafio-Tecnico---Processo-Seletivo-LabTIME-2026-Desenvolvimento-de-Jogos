package java.ticket2;

public class FactoryCientista extends FactoryStateFuncao{

    @Override
    public StateFuncao criarStateFuncao() {
        return new Cientista();
    }
}