public class Luzes implements Observer{

    private String estado;

    public Luzes() {
        estado = "Ligadas";
    }

    @Override
    public void atualizar(boolean estadoCritico) {

        if (estadoCritico) {
            estado = "Desligadas";
        } else {
            estado = "Ligadas";
        }

    }
}