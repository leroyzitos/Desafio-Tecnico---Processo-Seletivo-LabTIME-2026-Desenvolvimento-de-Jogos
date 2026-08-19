package javacode.ticket2;

/**
 * Fábrica concreta responsável pela criação do estado de função de operador
 * dos escudos e sistemas defensivos da nave.
 *
 * <p>Implementa o método de fábrica definido por
 * {@link FactoryStateFuncao} e produz instâncias de
 * {@link OperadorDeEscudos}.</p>
 */
public class FactoryOperadorDeEscudos extends FactoryStateFuncao{

    /**
     * Cria uma nova instância do estado de operador dos escudos.
     *
     * @return novo estado {@link OperadorDeEscudos}
     */
    @Override
    public StateFuncao criarStateFuncao() {
        return new OperadorDeEscudos();
    }
}