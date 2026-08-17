package java.ticket2;

public class FactoryMedico extends FactoryStateFuncao{

    @Override
    public StateFuncao criarStateFuncao() {
        return new Medico();
    }
}