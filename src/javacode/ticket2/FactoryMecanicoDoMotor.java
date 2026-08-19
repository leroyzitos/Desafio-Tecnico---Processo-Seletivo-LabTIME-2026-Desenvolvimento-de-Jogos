package javacode.ticket2;

/**
 * Fábrica concreta responsável pela criação do estado de função de
 * mecânico do motor.
 *
 * <p>Implementa o método de fábrica definido por
 * {@link FactoryStateFuncao} e produz instâncias de
 * {@link MecanicoDoMotor}.</p>
 */
public class FactoryMecanicoDoMotor extends FactoryStateFuncao{

    /**
     * Cria uma nova instância do estado de mecânico do motor.
     *
     * @return novo estado {@link MecanicoDoMotor}
     */
    @Override
    public StateFuncao criarStateFuncao() {
        return new MecanicoDoMotor();
    }
}