package java.ticket2;

public class FactoryCapitao extends FactoryStateFuncao{

    @Override
    public StateFuncao criarStateFuncao() {
        return new Capitao();
    }
}