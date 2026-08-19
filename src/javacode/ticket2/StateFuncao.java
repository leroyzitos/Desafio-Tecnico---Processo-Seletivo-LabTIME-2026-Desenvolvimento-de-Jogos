package javacode.ticket2;

/**
 * Define o contrato dos estados de função que podem ser assumidos por um
 * tripulante.
 *
 * <p>Cada implementação representa uma função específica da tripulação e
 * define o comportamento executado quando o tripulante recebe o comando
 * para trabalhar.</p>
 */
public interface StateFuncao {

    /**
     * Executa o comportamento de trabalho correspondente ao estado atual.
     */
    void trabalhar();

    /**
     * Retorna o nome da função representada pelo estado.
     *
     * @return nome da função
     */
    String getNomeFuncao();
}