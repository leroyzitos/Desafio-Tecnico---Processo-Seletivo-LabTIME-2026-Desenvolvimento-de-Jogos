package javacode.ticket2;

/**
 * Representa o estado correspondente à função de operador dos canhões
 * e armas da nave.
 *
 * <p>Implementa {@link StateFuncao} e define o comportamento de trabalho
 * específico de um tripulante responsável pela operação dos sistemas
 * ofensivos da nave.</p>
 */
public class OperadorDeCanhoes implements StateFuncao{

    /** Nome da função representada por este estado. */
    private static final String nomeFuncao = "Operador(a) dos canhões e armas da nave";

    /**
     * Executa o comportamento de trabalho do operador dos canhões.
     *
     * <p>O tripulante opera os diversos canhões e armas da nave.</p>
     */
    @Override
    public void trabalhar() {
        System.out.println("Operando os diversos canhões e armas da nave...");
    }

    /**
     * Retorna o nome da função de operador dos canhões e armas.
     *
     * @return nome da função
     */
    @Override
    public String getNomeFuncao() {
        return nomeFuncao;
    }
}