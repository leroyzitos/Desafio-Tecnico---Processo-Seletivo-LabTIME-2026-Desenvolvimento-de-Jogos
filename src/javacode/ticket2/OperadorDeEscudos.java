package javacode.ticket2;

public class OperadorDeEscudos implements StateFuncao{

    private static final String nomeFuncao = "Operador(a) dos sistemas de escudos e defesas da nave";

    @Override
    public void trabalhar() {
        System.out.println("Operando e mantendo os sistemas de escudos e defesas da nave...");
    }

    @Override
    public String getNomeFuncao() {
        return nomeFuncao;
    }
}