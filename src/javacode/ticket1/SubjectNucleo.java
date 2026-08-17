package javacode.ticket1;

/**
 * Interface para a classe sujeito do padrão de projeto Observer.
 *
 * <p>Ela define os métodos do sujeito para adição e remoção de
 * observadores e também notificação destes de mudanças relantes no sujeito.</p>
 * */
public interface SubjectNucleo {

    /**
     * Método responsável por registrar um observador na lista de observadores do sujeito.
     *
     * @param observador objeto observador a ser registrado
     * */
    void registrarObservador(ObserverNucleo observador);

    /**
     * Método responsável por remover um observador da lista de observadores do sujeito.
     *
     * @param observador objeto observador a ser removido
     * */
    void removerObservador(ObserverNucleo observador);

    /**
     * Método responsável por notificar os observadores de mudanças no sujeito quando necessário.
     *
     * @param estadoCritico indica se o sujeito está em estado crítico ou não
     * */
    void notificarObservadores(boolean estadoCritico);
}