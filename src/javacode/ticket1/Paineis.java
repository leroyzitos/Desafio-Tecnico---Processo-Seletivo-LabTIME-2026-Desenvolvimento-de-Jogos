package javacode.ticket1;

public class Paineis implements ObserverNucleo{

    private String exibicao;

    public Paineis() {
        exibicao = "Mensagens variadas e sistema padrão da nave.";
    }

    @Override
    public void atualizar(boolean estadoCritico) {

        if (estadoCritico) {
            exibicao = "Alertas e sistema de emergência da nave.";
        } else {
            exibicao = "Mensagens variadas e sistema padrão da nave.";
        }

    }

    public String getExibicao() {
        return exibicao;
    }

    @Override
    public String toString() {
        return "Conteúdo exibido: " + exibicao;
    }
}