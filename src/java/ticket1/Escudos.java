
/**
 * Classe representando o sistema de escudos da nave
 *
 * <p>Implementa a interface {@link Observer}.</p>
 *
 * <p>É responsável por guardar o estado do foco dos
 * escudos e alterá-los conforme as notificações de {@link Nucleo}.</p>
 * */
public class Escudos implements Observer {

    /** Foco atual dos escudos da nave. */
    private String focoAtual;

    /**
     * Construtor de {@code Escudos}, que cria o sistema de escudos e inicializa seu foco como o padrão */
    public Escudos() {
        focoAtual = "Nenhum";
    }

    @Override
    public void atualizar(boolean estadoCritico) {

        if (estadoCritico) {
            focoAtual = "Nucleo";
        } else {
            focoAtual = "Nenhum";
        }

    }
}