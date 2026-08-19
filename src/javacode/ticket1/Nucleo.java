package javacode.ticket1;

import java.util.ArrayList;

/**
 * Representa o núcleo de energia da nave e seu estado de funcionamento.
 *
 * <p>O núcleo atua como sujeito do padrão de projeto {@link SubjectNucleo},
 * mantendo uma lista de observadores que devem ser notificados quando seu
 * estado de energia atingir uma condição que exija uma reação dos demais
 * sistemas da nave.</p>
 *
 * <p>Quando a energia atinge ou fica abaixo do nível crítico, os observadores
 * são notificados sobre o início do estado crítico. Quando a energia volta a
 * ficar acima desse nível, uma nova notificação informa o retorno ao
 * funcionamento normal.</p>
 */
public class Nucleo implements SubjectNucleo{

    /** Nível máximo de energia que o núcleo pode possuir. */
    private static final int NIVEL_MAXIMO = 100;

    /** Nível de energia a partir do qual o núcleo é considerado crítico. */
    private static final int NIVEL_CRITICO = 25;

    /** Quantidade atual de energia do núcleo. */
    private int energia;

    /** Estado atual de funcionamento do núcleo. */
    private String estado;

    /** Lista de observadores registrados para receber notificações do núcleo. */
    private ArrayList<ObserverNucleo> observadores;

    /**
     * Construtor de {@code Nucleo}.
     *
     * <p>Inicializa o núcleo com sua energia máxima, estado de funcionamento
     * normal e uma lista vazia de observadores.</p>
     */
    public Nucleo(){
        energia = NIVEL_MAXIMO;
        estado = "Funcionamento normal.";
        observadores = new ArrayList<>();
    }

    /**
     * Registra um observador para receber notificações sobre mudanças
     * relevantes no estado do núcleo.
     *
     * @param observador objeto observador a ser registrado
     */
    @Override
    public void registrarObservador(ObserverNucleo observador) { observadores.add(observador); }

    /**
     * Remove um observador anteriormente registrado no núcleo.
     *
     * @param observador objeto observador a ser removido
     */
    @Override
    public void removerObservador(ObserverNucleo observador) { observadores.remove(observador); }

    /**
     * Notifica todos os observadores registrados sobre uma alteração no
     * estado crítico do núcleo.
     *
     * @param estadoCritico indica se o núcleo está em estado crítico
     */
    @Override
    public void notificarObservadores(boolean estadoCritico) {
        for (ObserverNucleo observador : observadores) {
            observador.atualizar(estadoCritico);
        }
    }

    /**
     * Reduz a quantidade de energia do núcleo.
     *
     * <p>Caso a redução faça a energia atingir ou ficar abaixo do nível
     * crítico, os observadores são notificados sobre o início do estado
     * crítico do núcleo.</p>
     *
     * @param valor quantidade de energia a ser reduzida
     * @throws IllegalArgumentException caso o valor informado seja negativo
     */
    public void reduzirEnergia(int valor) {
        if (valor < 0){
            throw new IllegalArgumentException("A quantidade não pode ser negativa.");
        }

        boolean estadoAnteriorCritico = energia <= NIVEL_CRITICO;

        if (energia == 0){
            return;
        } else if (valor > energia){
            energia = 0;
        } else {
            energia -= valor;
        }

        if (!estadoAnteriorCritico && energia <= NIVEL_CRITICO) {
            notificarObservadores(true);
            estado = "NÚCLEO EM ESTADO CRÍTICO. SISTEMAS DE EMERGÊNCIA ACIONADOS.";
        }
    }

    /**
     * Aumenta a quantidade de energia do núcleo.
     *
     * <p>Caso a quantidade de energia faça o núcleo sair do estado crítico,
     * os observadores são notificados sobre o retorno ao funcionamento
     * normal.</p>
     *
     * @param valor quantidade de energia a ser adicionada
     * @throws IllegalArgumentException caso o valor informado seja negativo
     */
    public void aumentarEnergia(int valor) {
        if (valor < 0){
            throw new IllegalArgumentException("A quantidade não pode ser negativa.");
        }

        boolean estadoAnteriorCritico = energia <= NIVEL_CRITICO;

        if (energia == NIVEL_MAXIMO){
            return;
        } else if (valor > (NIVEL_MAXIMO - energia)){
            energia = NIVEL_MAXIMO;
        } else {
            energia += valor;
        }

        if (estadoAnteriorCritico && energia > NIVEL_CRITICO) {
            notificarObservadores(false);
            estado = "Funcionamento normal.";
        }
    }

    /**
     * Retorna uma representação textual do estado atual do núcleo.
     *
     * @return texto contendo a quantidade de energia e o estado atual
     */
    @Override
    public String toString() {
        return "Energia: " + energia + " | Estado atual: " + estado;
    }
}