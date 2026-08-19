package javacode.ticket2;

/**
 * Fábrica concreta responsável pela criação do estado de função de cientista.
 *
 * <p>Implementa o método de fábrica definido por
 * {@link FactoryStateFuncao} e produz instâncias de {@link Cientista}.</p>
 */
public class FactoryCientista extends FactoryStateFuncao{

    /**
     * Cria uma nova instância do estado de cientista.
     *
     * @return novo estado {@link Cientista}
     */
    @Override
    public StateFuncao criarStateFuncao() {
        return new Cientista();
    }
}