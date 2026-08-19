package javacode.ticket2;

/**
 * Representa o estado correspondente à função de médico da nave.
 *
 * <p>Implementa {@link StateFuncao} e define o comportamento de trabalho
 * específico de um tripulante responsável pela saúde da tripulação.</p>
 */
public class Medico implements StateFuncao{

    /** Nome da função representada por este estado. */
    private static final String nomeFuncao = "Médico(a)";

    /**
     * Executa o comportamento de trabalho do médico.
     *
     * <p>O médico cuida da saúde e do bem-estar da tripulação.</p>
     */
    @Override
    public void trabalhar() {
        System.out.println("Cuidando da saúde e do bem-estar da tripulação da nave...");
    }

    /**
     * Retorna o nome da função de médico.
     *
     * @return nome da função
     */
    @Override
    public String getNomeFuncao() {
        return nomeFuncao;
    }
}