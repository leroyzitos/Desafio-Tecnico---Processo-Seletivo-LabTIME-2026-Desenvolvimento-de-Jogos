package javacode.ticket1;

/**
 * Interface para as classes observadoras do padrão de projeto Observer.
 *
 * <p>Ela define o comportamento dos observadores diante das notificações
 * da classe sujeito.</p>
 * */
public interface ObserverNucleo {

    /**
     * Método responsável reagir às notificações realizadas pela classe sujeito.
     *
     * @param estadoCritico indica se o sujeito está em estado crítico ou não
     * */
    void atualizar (boolean estadoCritico);
}