package javacode.ticket1;

/**
 * Representa o sistema de escudos da nave.
 *
 * <p>Implementa a interface {@link ObserverNucleo} e atua como observador
 * das notificações realizadas pelo {@link Nucleo}.</p>
 *
 * <p>É responsável por manter o foco atual de defesa dos escudos e alterá-lo
 * de acordo com o estado crítico informado pelo núcleo.</p>
 */
public class Escudos implements ObserverNucleo {

    /** Foco atual de defesa dos escudos da nave. */
    private String focoAtual;

    /**
     * Construtor de {@code Escudos}.
     *
     * <p>Inicializa o sistema de escudos com seu foco padrão de defesa.</p>
     */
    public Escudos() {
        focoAtual = "Nenhum.";
    }

    /**
     * Atualiza o foco de defesa dos escudos de acordo com o estado do núcleo.
     *
     * <p>Quando o núcleo está em estado crítico, os escudos passam a focar
     * sua defesa no núcleo. Caso contrário, retornam ao estado padrão.</p>
     *
     * @param estadoCritico indica se o núcleo está em estado crítico ou não
     */
    @Override
    public void atualizar(boolean estadoCritico) {

        if (estadoCritico) {
            focoAtual = "Núcleo.";
        } else {
            focoAtual = "Nenhum.";
        }

    }

    /**
     * Retorna uma representação textual do estado atual dos escudos.
     *
     * @return texto contendo o foco atual dos escudos
     */
    @Override
    public String toString() {
        return "Foco atual: " + focoAtual;
    }
}