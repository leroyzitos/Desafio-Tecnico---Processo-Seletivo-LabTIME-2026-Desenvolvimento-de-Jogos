package javacode.ticket2;

public class Medico implements StateFuncao{

    private static final String nomeFuncao = "Médico(a)";

    @Override
    public void trabalhar() {
        System.out.println("Cuidando da saúde e do bem-estar da tripulação da nave...");
    }

    @Override
    public String getNomeFuncao() {
        return nomeFuncao;
    }
}