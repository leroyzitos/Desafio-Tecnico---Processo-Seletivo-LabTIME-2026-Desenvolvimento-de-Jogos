package javacode.ticket1;

/**
 * Representa o sistema de painéis de navegação da nave.
 *
 * <p>Implementa a interface {@link ObserverNucleo} e reage às notificações
 * realizadas pelo {@link Nucleo} sobre alterações em seu estado crítico.</p>
 *
 * <p>Quando o núcleo está em estado crítico, os painéis passam a exibir
 * mensagens de alerta e informações relacionadas ao sistema de emergência.
 * Quando o núcleo retorna ao funcionamento normal, a exibição padrão é
 * restaurada.</p>
 */
public class Paineis implements ObserverNucleo{

    /** Conteúdo atualmente exibido pelos painéis de navegação. */
    private String exibicao;

    /**
     * Construtor de {@code Paineis}.
     *
     * <p>Inicializa os painéis com suas mensagens e informações padrão.</p>
     */
    public Paineis() {
        exibicao = "Mensagens variadas e sistema padrão da nave.";
    }

    /**
     * Atualiza o conteúdo exibido pelos painéis de acordo com o estado
     * crítico do núcleo.
     *
     * <p>Em estado crítico, os painéis exibem alertas e informações do
     * sistema de emergência. Fora desse estado, a exibição padrão é
     * restaurada.</p>
     *
     * @param estadoCritico indica se o núcleo está em estado crítico ou não
     */
    @Override
    public void atualizar(boolean estadoCritico) {

        if (estadoCritico) {
            exibicao = "Alertas e sistema de emergência da nave.";
        } else {
            exibicao = "Mensagens variadas e sistema padrão da nave.";
        }

    }

    /**
     * Retorna uma representação textual do conteúdo atual dos painéis.
     *
     * @return texto contendo o conteúdo atualmente exibido
     */
    @Override
    public String toString() {
        return "Conteúdo exibido: " + exibicao;
    }
}