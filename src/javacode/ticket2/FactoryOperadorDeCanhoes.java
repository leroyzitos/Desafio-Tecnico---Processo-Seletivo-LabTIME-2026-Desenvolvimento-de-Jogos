package javacode.ticket2;

/**
 * Fábrica concreta responsável pela criação do estado de função de operador
 * dos canhões e armas da nave.
 *
 * <p>Implementa o método de fábrica definido por
 * {@link FactoryStateFuncao} e produz instâncias de
 * {@link OperadorDeCanhoes}.</p>
 */
public class FactoryOperadorDeCanhoes extends FactoryStateFuncao{

    /**
     * Cria uma nova instância do estado de operador dos canhões.
     *
     * @return novo estado {@link OperadorDeCanhoes}
     */
    @Override
    public StateFuncao criarStateFuncao() {
        return new OperadorDeCanhoes();
    }
}