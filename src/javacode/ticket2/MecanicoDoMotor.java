package javacode.ticket2;

public class MecanicoDoMotor implements StateFuncao{

    private static final String nomeFuncao = "Mecânico(a) do motor";

    @Override
    public void trabalhar() {
        System.out.println("Checando e mantendo o motor da nave...");
    }

    @Override
    public String getNomeFuncao() {
        return nomeFuncao;
    }
}