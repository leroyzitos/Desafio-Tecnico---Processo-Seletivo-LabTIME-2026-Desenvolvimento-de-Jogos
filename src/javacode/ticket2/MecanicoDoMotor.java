package javacode.ticket2;

/**
 * Representa o estado correspondente à função de mecânico do motor.
 *
 * <p>Implementa {@link StateFuncao} e define o comportamento de trabalho
 * específico de um tripulante responsável pela manutenção do motor da nave.</p>
 */
public class MecanicoDoMotor implements StateFuncao{

    /** Nome da função representada por este estado. */
    private static final String nomeFuncao = "Mecânico(a) do motor";

    /**
     * Executa o comportamento de trabalho do mecânico do motor.
     *
     * <p>O mecânico verifica e realiza a manutenção do motor da nave.</p>
     */
    @Override
    public void trabalhar() {
        System.out.println("Checando e mantendo o motor da nave...");
    }

    /**
     * Retorna o nome da função de mecânico do motor.
     *
     * @return nome da função
     */
    @Override
    public String getNomeFuncao() {
        return nomeFuncao;
    }
}