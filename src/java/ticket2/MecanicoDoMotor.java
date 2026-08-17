package java.ticket2;

public class MecanicoDoMotor implements StateFuncao{

    @Override
    public void trabalhar() {
        System.out.println("Checando e mantendo o motor da nave...");
    }
}