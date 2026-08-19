package javacode.ticket2;

/**
 * Representa o estado correspondente à função de operador dos escudos
 * e sistemas defensivos da nave.
 *
 * <p>Implementa {@link StateFuncao} e define o comportamento de trabalho
 * específico de um tripulante responsável pelos sistemas de defesa da nave.</p>
 */
public class OperadorDeEscudos implements StateFuncao{

    /** Nome da função representada por este estado. */
    private static final String nomeFuncao = "Operador(a) dos sistemas de escudos e defesas da nave";

    /**
     * Executa o comportamento de trabalho do operador dos escudos.
     *
     * <p>O tripulante opera e realiza a manutenção dos sistemas de escudos
     * e demais sistemas defensivos da nave.</p>
     */
    @Override
    public void trabalhar() {
        System.out.println("Operando e mantendo os sistemas de escudos e defesas da nave...");
    }

    /**
     * Retorna o nome da função de operador dos escudos e sistemas defensivos.
     *
     * @return nome da função
     */
    @Override
    public String getNomeFuncao() {
        return nomeFuncao;
    }
}