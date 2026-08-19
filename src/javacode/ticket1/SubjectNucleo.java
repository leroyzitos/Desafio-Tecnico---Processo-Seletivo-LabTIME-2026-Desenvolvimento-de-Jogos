package javacode.ticket1;

/**
 * Define o contrato do sujeito do padrão de projeto Observer.
 *
 * <p>É responsável por estabelecer as operações necessárias para registrar
 * e remover observadores, bem como notificá-los sobre mudanças relevantes
 * no estado do sujeito.</p>
 */
public interface SubjectNucleo {

    /**
     * Registra um observador na lista de observadores do sujeito.
     *
     * @param observador objeto observador a ser registrado
     */
    void registrarObservador(ObserverNucleo observador);

    /**
     * Remove um observador da lista de observadores do sujeito.
     *
     * @param observador objeto observador a ser removido
     */
    void removerObservador(ObserverNucleo observador);

    /**
     * Notifica os observadores sobre uma mudança no estado crítico do sujeito.
     *
     * @param estadoCritico indica se o sujeito está em estado crítico ou não
     */
    void notificarObservadores(boolean estadoCritico);
}