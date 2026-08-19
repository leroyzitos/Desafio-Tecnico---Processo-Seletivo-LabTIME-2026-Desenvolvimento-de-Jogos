package javacode.ticket3;

public class Armamento {

    private Arma arma;

    public Armamento() {
        arma = new CanhoesPerfurantes();
    }

    public Arma getArma() {
        return arma;
    }

    public String getNome() {
        return arma.getNome();
    }

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