package javacode.ticket1;

/**
 * Classe representando o sistema de escudos da nave
 *
 * <p>Implementa a interface {@link ObserverNucleo}.</p>
 *
 * <p>É responsável por guardar o estado do foco dos
 * escudos e alterá-los conforme as notificações de {@link Nucleo}.</p>
 * */
public class Escudos implements ObserverNucleo {

    /** Foco atual dos escudos da nave. */
    private String focoAtual;

    /**
     * Construtor de {@code Escudos}, que cria o sistema de escudos e inicializa seu foco como o padrão */
    public Escudos() {
        focoAtual = "Nenhum.";
    }

    @Override
    public void atualizar(boolean estadoCritico) {

        if (estadoCritico) {
            focoAtual = "Núcleo.";
        } else {
            focoAtual = "Nenhum.";
        }

    }

    public String getFocoAtual() {
        return focoAtual;
    }

    @Override
    public String toString() {
        return "Foco atual: " + focoAtual;
    }
}