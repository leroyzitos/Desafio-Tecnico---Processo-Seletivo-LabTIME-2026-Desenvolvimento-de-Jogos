package javacode.ticket2;

public class Cientista implements StateFuncao{

    private static final String nomeFuncao = "Cientista";

    @Override
    public void trabalhar() {
        System.out.println("Fazendo experimentos e anotando novas descobertas...");
    }

    @Override
    public String getNomeFuncao() {
        return nomeFuncao;
    }
}