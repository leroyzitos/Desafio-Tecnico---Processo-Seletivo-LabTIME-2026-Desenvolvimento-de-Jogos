package javacode.ticket1;

import java.util.ArrayList;

public class Nucleo implements SubjectNucleo{

    private static final int NIVEL_MAXIMO = 100;
    private static final int NIVEL_CRITICO = 25;

    private int energia;
    private String estado;
    private ArrayList<ObserverNucleo> observadores;

    public Nucleo(){
        energia = NIVEL_MAXIMO;
        estado = "Funcionamento normal.";
        observadores = new ArrayList<>();
    }

    @Override
    public void registrarObservador(ObserverNucleo observador) { observadores.add(observador); }

    @Override
    public void removerObservador(ObserverNucleo observador) { observadores.remove(observador); }

    @Override
    public void notificarObservadores(boolean estadoCritico) {
        for (ObserverNucleo observador : observadores) {
            observador.atualizar(estadoCritico);
        }
    }

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

    public int getEnergia() {
        return energia;
    }

    @Override
    public String toString() {
        return "Energia: " + energia + " | Estado atual: " + estado;
    }
}