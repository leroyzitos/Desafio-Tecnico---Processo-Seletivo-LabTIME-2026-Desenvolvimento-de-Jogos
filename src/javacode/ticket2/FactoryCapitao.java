package javacode.ticket2;

/**
 * Fábrica concreta responsável pela criação do estado de função de capitão.
 *
 * <p>Implementa o método de fábrica definido por
 * {@link FactoryStateFuncao} e produz instâncias de {@link Capitao}.</p>
 */
public class FactoryCapitao extends FactoryStateFuncao{

    /**
     * Cria uma nova instância do estado de capitão.
     *
     * @return novo estado {@link Capitao}
     */
    @Override
    public StateFuncao criarStateFuncao() {
        return new Capitao();
    }
}