package javacode.ticket2;

public class OperadorDeCanhoes implements StateFuncao{

    private static final String nomeFuncao = "Operador(a) dos canhões e armas da nave";

    @Override
    public void trabalhar() {
        System.out.println("Operando os diversos canhões e armas da nave...");
    }

    @Override
    public String getNomeFuncao() {
        return nomeFuncao;
    }
}