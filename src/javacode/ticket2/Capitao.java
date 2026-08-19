package javacode.ticket2;

/**
 * Representa o estado correspondente à função de capitão da nave.
 *
 * <p>Implementa {@link StateFuncao} e define o comportamento de trabalho
 * específico de um tripulante que exerce a função de capitão.</p>
 */
public class Capitao implements StateFuncao{

    /** Nome da função representada por este estado. */
    private static final String nomeFuncao = "Capitão(ã) da nave";

    /**
     * Executa o comportamento de trabalho do capitão.
     *
     * <p>O capitão é responsável por pilotar a nave e comandar sua
     * tripulação.</p>
     */
    @Override
    public void trabalhar() {
        System.out.println("Pilotando a nave e comandando a sua tripulação...");
    }

    /**
     * Retorna o nome da função de capitão.
     *
     * @return nome da função
     */
    @Override
    public String getNomeFuncao() {
        return nomeFuncao;
    }
}