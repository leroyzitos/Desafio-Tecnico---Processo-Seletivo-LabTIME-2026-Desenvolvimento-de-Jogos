package javacode.ticket2;

/**
 * Classe abstrata responsável por definir o método de fábrica utilizado
 * para a criação dos estados de função dos tripulantes.
 *
 * <p>As subclasses concretas de {@code FactoryStateFuncao} implementam o
 * método {@link #criarStateFuncao()} para determinar qual implementação
 * concreta de {@link StateFuncao} deverá ser criada.</p>
 */
public abstract class FactoryStateFuncao {

    /**
     * Cria um estado concreto de função para um tripulante.
     *
     * @return estado de função criado
     */
    public abstract StateFuncao criarStateFuncao();
}