package javacode.ticket2;

public class Capitao implements StateFuncao{

    private static final String nomeFuncao = "Capitão(ã) da nave";

    @Override
    public void trabalhar() {
        System.out.println("Pilotando a nave e comandando a sua tripulação...");
    }

    @Override
    public String getNomeFuncao() {
        return nomeFuncao;
    }
}