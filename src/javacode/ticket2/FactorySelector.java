package javacode.ticket2;

public class FactorySelector {

    public static FactoryStateFuncao selecionarFactory(int opcao) {

        switch (opcao){
            case 1:
                return new FactoryCapitao();

            case 2:
                return new FactoryCientista();

            case 3:
                return new FactoryMedico();

            case 4:
                return new FactoryMecanicoDoMotor();

            case 5:
                return new FactoryOperadorDeCanhoes();

            case 6:
                return new FactoryOperadorDeEscudos();

            default:
                throw new IllegalArgumentException("Opção inválida de função.");
        }
    }
}