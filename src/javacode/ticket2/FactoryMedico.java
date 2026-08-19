package javacode.ticket2;

/**
 * Fábrica concreta responsável pela criação do estado de função de médico.
 *
 * <p>Implementa o método de fábrica definido por
 * {@link FactoryStateFuncao} e produz instâncias de {@link Medico}.</p>
 */
public class FactoryMedico extends FactoryStateFuncao{

    /**
     * Cria uma nova instância do estado de médico.
     *
     * @return novo estado {@link Medico}
     */
    @Override
    public StateFuncao criarStateFuncao() {
        return new Medico();
    }
}