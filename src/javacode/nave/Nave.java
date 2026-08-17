package javacode.nave;

import javacode.ticket1.Escudos;
import javacode.ticket1.Luzes;
import javacode.ticket1.Nucleo;
import javacode.ticket1.Paineis;
import javacode.ticket2.Tripulante;

import javacode.ticket1.*;
import javacode.ticket2.*;
//import java.ticket3.*;

import java.util.ArrayList;

/**
 * Classe representando a nave e seus principais sistemas relacionados.
 *
 * <p>É responsável por instanciar e conectar os diversos componentes
 * que fazem parte do sistema da nave.</p>
 * */
public class Nave {

    private String nome;

    /** Núcleo de energia da nave, central para seu funcionamento. */
    private Nucleo nucleo;

    /** Sistema de escudos da nave. */
    private Escudos escudos;

    /** Sistema de painéis da nave. */
    private Paineis paineis;

    /** Sistema de iluminação das salas da nave. */
    private Luzes luzes;

    ArrayList<Tripulante> tripulacao;

    //Armamento armamento;

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
    }

    public void registrarTripulante(Tripulante tripulante) { tripulacao.add(tripulante); }

    public void removerTripulante(Tripulante tripulante) { tripulacao.remove(tripulante); }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        String resultado = "=== NAVE " + nome.toUpperCase() + " ==="
                + "\nNúcleo: " + nucleo
                + "\nEscudos: " + escudos
                + "\nPainéis: " + paineis
                + "\nLuzes: " + luzes;

        resultado += "\n\nTripulação:\n";

        for (Tripulante tripulante : tripulacao){
            resultado += tripulante + "\n\n";
        }

        return resultado;
    }
}