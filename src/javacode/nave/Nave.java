package javacode.nave;

import javacode.ticket1.*;
import javacode.ticket2.*;
import javacode.ticket3.*;

import java.util.ArrayList;

/**
 * Representa uma nave espacial e os principais sistemas que a compõem.
 *
 * <p>A classe {@code Nave} atua como ponto central de integração dos sistemas
 * implementados nos três tickets do projeto, mantendo referências para o
 * núcleo de energia, seus observadores, a tripulação e o sistema de
 * armamento.</p>
 *
 * <p>Também funciona como uma camada de acesso aos diferentes sistemas para a
 * classe principal da aplicação, permitindo que a interface de interação
 * utilize a nave sem precisar conhecer diretamente os detalhes internos dos
 * componentes de cada ticket.</p>
 */
public class Nave {

    private final String nome;

    /** Núcleo de energia da nave, central para seu funcionamento. */
    private Nucleo nucleo;

    /** Sistema de escudos da nave. */
    private Escudos escudos;

    /** Sistema de painéis da nave. */
    private Paineis paineis;

    /** Sistema de iluminação das salas da nave. */
    private Luzes luzes;

    /** Lista de tripulantes atualmente registrados na nave. */
    private ArrayList<Tripulante> tripulacao;

    /** Sistema de armamento e arma atualmente equipada na nave. */
    private Armamento armas;

    /**
     * Construtor de {@code Nave}.
     *
     * <p>Cria uma nova nave com o nome informado e inicializa seus sistemas
     * principais, sua tripulação e seu sistema de armamento.</p>
     *
     * <p>Como parte da implementação do padrão de projeto Observer, os
     * sistemas de escudos, painéis e iluminação são registrados como
     * observadores do núcleo durante a inicialização.</p>
     *
     * @param nome nome atribuído à nave
     */
    public Nave(String nome) {
        this.nome = nome;

        nucleo = new Nucleo();
        escudos = new Escudos();
        paineis = new Paineis();
        luzes = new Luzes();

        nucleo.registrarObservador(escudos);
        nucleo.registrarObservador(paineis);
        nucleo.registrarObservador(luzes);

        tripulacao = new ArrayList<>();

        armas = new Armamento();
    }

    /**
     * Retorna o nome da nave.
     *
     * @return nome da nave
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o nome da arma atualmente equipada.
     *
     * @return nome da arma equipada
     */
    public String getNomeArmamento() {
        return armas.getNome();
    }

    /**
     * Retorna uma representação textual do estado atual do núcleo.
     *
     * @return estado atual do núcleo
     */
    public String statusNucleo() {
        return nucleo.toString();
    }

    /**
     * Retorna uma representação textual do estado atual dos escudos.
     *
     * @return estado atual dos escudos
     */
    public String statusEscudos() {
        return escudos.toString();
    }

    /**
     * Retorna uma representação textual do estado atual dos painéis.
     *
     * @return estado atual dos painéis
     */
    public String statusPaineis() {
        return paineis.toString();
    }

    /**
     * Retorna uma representação textual do estado atual das luzes.
     *
     * @return estado atual das luzes
     */
    public String statusLuzes() {
        return luzes.toString();
    }

    /**
     * Retorna uma representação textual da tripulação atualmente registrada.
     *
     * <p>Cada tripulante é representado por meio de seu próprio
     * {@link Tripulante#toString()}.</p>
     *
     * @return informações dos tripulantes da nave
     */
    public String statusTripulacao() {
        String resultado = "\n\nTripulação:\n";

        for (Tripulante tripulante : tripulacao){
            resultado += tripulante + "\n\n";
        }

        return resultado;
    }

    /**
     * Retorna uma representação textual do estado atual do sistema de
     * armamento.
     *
     * @return estado atual do armamento
     */
    public String statusArmamento() {
        return armas.toString();
    }

    /**
     * Reduz a quantidade de energia do núcleo da nave.
     *
     * <p>A alteração pode provocar a mudança do núcleo para seu estado
     * crítico e, consequentemente, a notificação dos sistemas observadores.</p>
     *
     * @param valor quantidade de energia a ser reduzida
     */
    public void reduzirEnergia(int valor) {
        nucleo.reduzirEnergia(valor);
    }

    /**
     * Aumenta a quantidade de energia do núcleo da nave.
     *
     * <p>Caso o núcleo deixe seu estado crítico, seus observadores são
     * notificados para restaurarem seus estados correspondentes.</p>
     *
     * @param valor quantidade de energia a ser adicionada
     */
    public void aumentarEnergia(int valor) {
        nucleo.aumentarEnergia(valor);
    }

    /**
     * Cria e registra um novo tripulante na nave.
     *
     * <p>A função inicial do tripulante é determinada a partir da opção
     * fornecida, utilizando o mecanismo de criação implementado no
     * sistema de tripulação.</p>
     *
     * @param nome nome completo do tripulante
     * @param sexo sexo do tripulante
     * @param idade idade do tripulante
     * @param opcaoFuncao opção correspondente à função inicial
     */
    public void registrarTripulante(String nome, char sexo, int idade, int opcaoFuncao) {
        Tripulante tripulante = new Tripulante(nome, sexo, idade, opcaoFuncao);

        tripulacao.add(tripulante);

        System.out.println("Tripulante adicionado com sucesso.");
    }

    /**
     * Remove da nave o tripulante identificado pelo código informado.
     *
     * @param codigo código identificador do tripulante a ser removido
     */
    public void removerTripulante(String codigo) {

        Tripulante tripulanteEncontrado = null;

        for (Tripulante tripulante : tripulacao) {
            if (tripulante.getCodigo().equals(codigo)) {
                tripulanteEncontrado = tripulante;
                break;
            }
        }

        if (tripulanteEncontrado != null) {
            tripulacao.remove(tripulanteEncontrado);
            System.out.println(
                    "Tripulante de código " + codigo + " removido com sucesso."
            );
            return;
        }

        System.out.println("Tripulante não encontrado.");
    }

    /**
     * Altera a função do tripulante identificado pelo código informado.
     *
     * <p>A operação mantém o mesmo objeto {@code Tripulante} e apenas altera
     * seu estado de função.</p>
     *
     * @param codigo código identificador do tripulante
     * @param opcao opção correspondente à nova função
     */
    public void trocarFuncao(String codigo, int opcao) {

        for (Tripulante tripulante : tripulacao){
            if (tripulante.getCodigo().equals(codigo)){
                tripulante.trocarFuncao(opcao);
                System.out.println("Função do tripulante de código " + codigo + " alterada com sucesso.");
                return;
            }
        }

        System.out.println("Tripulante não encontrado.");
    }

    /**
     * Solicita que o tripulante identificado pelo código execute seu
     * comportamento de trabalho correspondente à função atual.
     *
     * @param codigo código identificador do tripulante
     */
    public void trabalhar(String codigo) {

        for (Tripulante tripulante : tripulacao){
            if (tripulante.getCodigo().equals(codigo)){
                System.out.println("Tripulante de código " + codigo + " trabalhando:");
                tripulante.trabalhar();
                return;
            }
        }

        System.out.println("Tripulante não encontrado.");
    }

    /**
     * Executa um disparo utilizando o armamento atualmente configurado.
     */
    public void atirar() {
        armas.atirar();
    }

    /**
     * Altera a arma atualmente equipada na nave.
     *
     * @param opcao opção correspondente à arma desejada
     */
    public void mudarArma(int opcao) {
        armas.mudarArma(opcao);
    }

    /**
     * Adiciona um modificador à arma atualmente equipada.
     *
     * <p>Os modificadores são aplicados de forma cumulativa por meio da
     * estrutura do padrão de projeto Decorator.</p>
     *
     * @param opcao opção correspondente ao modificador desejado
     */
    public void adicionarModificador(int opcao) {
        armas.adicionarModificador(opcao);
    }

    /**
     * Retorna uma representação textual da nave e de seus principais
     * sistemas.
     *
     * <p>A representação inclui o estado do núcleo, escudos, painéis,
     * iluminação, tripulação e armamento atualmente configurado.</p>
     *
     * @return representação textual da nave
     */
    @Override
    public String toString() {

        return "=== NAVE " + nome.toUpperCase() + " ==="
                + "\nNúcleo: " + nucleo
                + "\nEscudos: " + escudos
                + "\nPainéis: " + paineis
                + "\nLuzes: " + luzes
                + statusTripulacao()
                + "\nArmamento:\n"
                + armas;
    }
}