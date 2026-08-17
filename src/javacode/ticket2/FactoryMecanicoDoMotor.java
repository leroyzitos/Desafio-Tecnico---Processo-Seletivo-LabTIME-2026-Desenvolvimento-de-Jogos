package javacode.ticket2;

public class FactoryMecanicoDoMotor extends FactoryStateFuncao{

    @Override
    public StateFuncao criarStateFuncao() {
        return new MecanicoDoMotor();
    }
}