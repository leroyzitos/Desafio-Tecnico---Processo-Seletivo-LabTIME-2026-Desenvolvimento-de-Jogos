package javacode.nave;

import javacode.ticket1.*;
import javacode.ticket2.*;
import javacode.ticket3.*;

import java.util.ArrayList;

/**
 * Classe representando a nave e seus principais sistemas relacionados.
 *
 * <p>É responsável por instanciar e conectar os diversos componentes
 * que fazem parte do sistema da nave.</p>
 * */
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

    private ArrayList<Tripulante> tripulacao;

    private Armamento armas;

    /**
     * Construtor de {@code Nave}, que cria uma nova nave e inicializa seus sistemas
     *
     * <p>De acordo com o padrão de projeto Observer, durante a inicialização,
     * os sistemas de escudos, painéis e iluminação da nave são registrados como
     * observadores do núcleo de energia dela.</p>
     * */
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

    public String getNome() {
        return nome;
    }

    public String getNomeArmamento() {
        return armas.getNome();
    }

    public String statusNucleo() {
        return nucleo.toString();
    }

    public String statusEscudos() {
        return escudos.toString();
    }

    public String statusPaineis() {
        return paineis.toString();
    }

    public String statusLuzes() {
        return luzes.toString();
    }

    public String statusTripulacao() {
        String resultado = "\n\nTripulação:\n";

        for (Tripulante tripulante : tripulacao){
            resultado += tripulante + "\n\n";
        }

        return resultado;
    }

    public String statusArmamento() {
        return armas.toString();
    }

    public void reduzirEnergia(int valor) {
        nucleo.reduzirEnergia(valor);
    }

    public void aumentarEnergia(int valor) {
        nucleo.aumentarEnergia(valor);
    }

    public void registrarTripulante(String nome, char sexo, int idade, int opcaoFuncao) {
        Tripulante tripulante = new Tripulante(nome, sexo, idade, opcaoFuncao);

        tripulacao.add(tripulante);

        System.out.println("Tripulante adicionado com sucesso.");
    }

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

    public void atirar() {
        armas.atirar();
    }

    public void mudarArma(int opcao) {
        armas.mudarArma(opcao);
    }

    public void adicionarModificador(int opcao) {
        armas.adicionarModificador(opcao);
    }

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