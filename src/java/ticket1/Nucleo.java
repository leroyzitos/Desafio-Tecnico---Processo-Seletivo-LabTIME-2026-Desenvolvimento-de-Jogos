import java.util.ArrayList;

public class Nucleo implements Subject{

    private static final int NIVEL_MAXIMO = 100;
    private static final int NIVEL_CRITICO = 25;

    private int energia;
    private ArrayList<Observer> observadores;

    public Nucleo(){
        energia = NIVEL_MAXIMO;
        observadores = new ArrayList<>();
    }

    @Override
    public void registrarObservador(Observer observador) {
        observadores.add(observador);
    }

    @Override
    public void removerObservador(Observer observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores(boolean estadoCritico) {
        for (Observer observador : observadores) {
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
        }
    }
}