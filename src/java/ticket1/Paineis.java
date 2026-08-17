package java.ticket1;

public class Paineis implements ObserverNucleo{

    private String exibicao;

    public Paineis() {
        exibicao = "Mensagens variadas e sistema padrão da nave";
    }

    @Override
    public void atualizar(boolean estadoCritico) {

        if (estadoCritico) {
            exibicao = "Alertas e sistema de emergência da nave";
        } else {
            exibicao = "Mensagens variadas e sistema padrão da nave";
        }

    }
}