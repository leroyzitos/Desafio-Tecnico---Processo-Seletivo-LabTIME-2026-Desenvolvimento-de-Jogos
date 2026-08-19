package javacode.ticket1;

/**
 * Define o contrato das classes observadoras do padrão de projeto Observer.
 *
 * <p>As classes que implementam esta interface devem definir como irão
 * reagir às notificações recebidas do sujeito.</p>
 */
public interface ObserverNucleo {

    /**
     * Reage a uma notificação realizada pelo sujeito.
     *
     * @param estadoCritico indica se o sujeito está em estado crítico ou não
     */
    void atualizar(boolean estadoCritico);
}