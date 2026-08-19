package javacode.ticket1;

/**
 * Representa o sistema de iluminação das salas da nave.
 *
 * <p>Implementa a interface {@link ObserverNucleo} e reage às notificações
 * realizadas pelo {@link Nucleo} sobre alterações em seu estado crítico.</p>
 *
 * <p>Durante uma situação crítica do núcleo, as luzes são desligadas.
 * Quando a situação é encerrada, elas retornam ao estado ligado.</p>
 */
public class Luzes implements ObserverNucleo{

    /** Estado atual das luzes da nave. */
    private String estado;

    /**
     * Construtor de {@code Luzes}.
     *
     * <p>Inicializa o sistema de iluminação com as luzes ligadas.</p>
     */
    public Luzes() {
        estado = "Ligadas.";
    }

    /**
     * Atualiza o estado das luzes de acordo com o estado crítico do núcleo.
     *
     * <p>As luzes são desligadas quando o núcleo entra em estado crítico
     * e ligadas novamente quando ele retorna ao funcionamento normal.</p>
     *
     * @param estadoCritico indica se o núcleo está em estado crítico ou não
     */
    @Override
    public void atualizar(boolean estadoCritico) {

        if (estadoCritico) {
            estado = "Desligadas.";
        } else {
            estado = "Ligadas.";
        }

    }

    /**
     * Retorna uma representação textual do estado atual das luzes.
     *
     * @return texto contendo o estado das luzes
     */
    @Override
    public String toString() {
        return "Estado: " + estado;
    }
}