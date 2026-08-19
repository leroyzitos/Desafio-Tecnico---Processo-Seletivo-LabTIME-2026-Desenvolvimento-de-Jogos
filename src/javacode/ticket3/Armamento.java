package javacode.ticket3;

/**
 * Representa o sistema de armamento da nave.
 *
 * <p>É responsável por manter a arma atualmente equipada, permitir a troca
 * da arma-base, adicionar modificadores de forma cumulativa por meio do
 * padrão de projeto {@link DecoratorModificadores} e executar os disparos.</p>
 *
 * <p>O sistema trabalha com a abstração {@link Arma}, permitindo que tanto
 * armas-base quanto armas envolvidas por modificadores sejam tratadas de
 * maneira uniforme.</p>
 */
public class Armamento {

    /** Arma atualmente equipada no sistema de armamento. */
    private Arma arma;

    /**
     * Construtor de {@code Armamento}.
     *
     * <p>Inicializa o sistema com uma instância de {@link CanhoesPerfurantes}
     * como arma-base.</p>
     */
    public Armamento() {
        arma = new CanhoesPerfurantes();
    }

    /**
     * Retorna a arma atualmente equipada.
     *
     * @return arma atualmente equipada
     */
    public Arma getArma() {
        return arma;
    }

    /**
     * Retorna o nome da arma atualmente equipada.
     *
     * @return nome da arma atualmente equipada
     */
    public String getNome() {
        return arma.getNome();
    }

    /**
     * Altera a arma atualmente equipada de acordo com a opção informada.
     *
     * <p>A troca da arma-base substitui a configuração atual do armamento,
     * removendo quaisquer modificadores que estivessem acoplados à arma
     * anteriormente.</p>
     *
     * @param opcao opção correspondente à arma desejada
     * @throws IllegalArgumentException caso a opção informada não corresponda
     * a uma arma válida
     */
    public void mudarArma(int opcao) {

        switch (opcao){
            case 1:
                arma = new CanhoesPerfurantes();
                break;

            case 2:
                arma = new EnxameDeMisseis();
                break;

            case 3:
                arma = new LaserContinuo();
                break;

            case 4:
                arma = new RaioDisruptor();
                break;

            default:
                throw new IllegalArgumentException("Opção de arma inválida.");
        }
    }

    /**
     * Adiciona um modificador à arma atualmente equipada.
     *
     * <p>O novo modificador é aplicado sobre a configuração atual da arma,
     * permitindo que múltiplos modificadores sejam empilhados de maneira
     * dinâmica.</p>
     *
     * @param opcao opção correspondente ao modificador desejado
     * @throws IllegalArgumentException caso a opção informada não corresponda
     * a um modificador válido
     */
    public void adicionarModificador(int opcao) {

        switch (opcao){
            case 1:
                arma = new DisruptorDeEscudos(arma);
                break;

            case 2:
                arma = new PerfuracaoDeBlindagem(arma);
                break;

            case 3:
                arma = new ImpactoExplosivo(arma);
                break;

            case 4:
                arma = new DanoDeFogo(arma);
                break;

            case 5:
                arma = new DanoDeAcido(arma);
                break;

            default:
                throw new IllegalArgumentException("Opção de modificador inválida.");
        }
    }

    /**
     * Executa um disparo utilizando a arma atualmente equipada e seus
     * modificadores acumulados.
     *
     * <p>O método obtém os valores atuais de dano imediato, dano por segundo
     * e alcance por meio da abstração {@link Arma}, calcula os valores totais
     * correspondentes e apresenta o resultado do disparo no terminal.</p>
     */
    public void atirar() {

        int danoEscudos = arma.getDanoEscudos();
        int danoBlindagem = arma.getDanoBlindagem();
        int danoEstrutura = arma.getDanoEstrutura();

        int danoTotal = danoEscudos + danoBlindagem + danoEstrutura;

        int dpsEscudos = arma.getDpsEscudos();
        int dpsBlindagem = arma.getDpsBlindagem();
        int dpsEstrutura = arma.getDpsEstrutura();

        int dpsTotal = dpsEscudos + dpsBlindagem + dpsEstrutura;

        int alcanceMin = arma.getAlcanceMin();
        int alcanceMax = arma.getAlcanceMax();

        System.out.println("\n========================================");
        System.out.println("            !DISPARO EFETUADO!");
        System.out.println("========================================\n");

        System.out.println("Arma selecionada: " + arma.getNome());

        System.out.println("\nDano imediato:");
        System.out.println("\tEscudos:    " + danoEscudos);
        System.out.println("\tBlindagem:  " + danoBlindagem);
        System.out.println("\tEstrutura:  " + danoEstrutura);
        System.out.println("\t--------------------");
        System.out.println("\tTotal:      " + danoTotal);

        System.out.println("\nDano por segundo:");
        System.out.println("\tEscudos:    " + dpsEscudos);
        System.out.println("\tBlindagem:  " + dpsBlindagem);
        System.out.println("\tEstrutura:  " + dpsEstrutura);
        System.out.println("\t--------------------");
        System.out.println("\tTotal:      " + dpsTotal);

        System.out.println("\nAlcance:");
        System.out.println("\tMínimo:     " + alcanceMin);
        System.out.println("\tMáximo:     " + alcanceMax);
        System.out.println("\t--------------------");
        System.out.println("\tIntervalo:  De " + alcanceMin + " a " + alcanceMax);

        System.out.println("\n========================================\n");
    }

    /**
     * Retorna uma representação textual do estado atual do sistema de
     * armamento.
     *
     * <p>A representação apresenta a arma equipada, os valores atuais de
     * dano imediato, dano por segundo e o alcance, considerando também os
     * modificadores atualmente aplicados.</p>
     *
     * @return representação textual do estado atual do armamento
     */
    @Override
    public String toString() {

        int danoEscudos = arma.getDanoEscudos();
        int danoBlindagem = arma.getDanoBlindagem();
        int danoEstrutura = arma.getDanoEstrutura();

        int dpsEscudos = arma.getDpsEscudos();
        int dpsBlindagem = arma.getDpsBlindagem();
        int dpsEstrutura = arma.getDpsEstrutura();

        int danoTotal = danoEscudos + danoBlindagem + danoEstrutura;
        int dpsTotal = dpsEscudos + dpsBlindagem + dpsEstrutura;

        return "Arma equipada: " + arma.getNome()

                + "\n\nDano imediato:"
                + "\n\tEscudos:    " + danoEscudos
                + "\n\tBlindagem:  " + danoBlindagem
                + "\n\tEstrutura:  " + danoEstrutura
                + "\n\t--------------------"
                + "\n\tTotal:      " + danoTotal

                + "\n\nDano por segundo:"
                + "\n\tEscudos:    " + dpsEscudos
                + "\n\tBlindagem:  " + dpsBlindagem
                + "\n\tEstrutura:  " + dpsEstrutura
                + "\n\t--------------------"
                + "\n\tTotal:      " + dpsTotal

                + "\n\nAlcance:"
                + "\n\tMínimo:     " + arma.getAlcanceMin()
                + "\n\tMáximo:     " + arma.getAlcanceMax()
                + "\n\t--------------------"
                + "\n\tIntervalo:  De " + arma.getAlcanceMin()
                + " a " + arma.getAlcanceMax() + "\n";
    }
}