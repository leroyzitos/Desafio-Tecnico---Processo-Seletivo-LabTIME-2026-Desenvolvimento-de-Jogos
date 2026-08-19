package javacode.ticket2;

/**
 * Representa o estado correspondente à função de cientista da nave.
 *
 * <p>Implementa {@link StateFuncao} e define o comportamento de trabalho
 * específico de um tripulante que exerce a função de cientista.</p>
 */
public class Cientista implements StateFuncao{

    /** Nome da função representada por este estado. */
    private static final String nomeFuncao = "Cientista";

    /**
     * Executa o comportamento de trabalho do cientista.
     *
     * <p>O cientista realiza experimentos e registra novas descobertas.</p>
     */
    @Override
    public void trabalhar() {
        System.out.println("Fazendo experimentos e anotando novas descobertas...");
    }

    /**
     * Retorna o nome da função de cientista.
     *
     * @return nome da função
     */
    @Override
    public String getNomeFuncao() {
        return nomeFuncao;
    }
}