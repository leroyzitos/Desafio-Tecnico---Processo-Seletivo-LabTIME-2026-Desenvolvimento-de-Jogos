package javacode.ticket2;

/**
 * Responsável por selecionar a fábrica concreta correspondente à opção
 * de função fornecida pelo usuário.
 *
 * <p>A classe atua como mecanismo de seleção entre as diferentes fábricas
 * concretas de {@link StateFuncao}, permitindo que a criação do estado de
 * função permaneça separada da classe {@link Tripulante}.</p>
 */
public class FactorySelector {

    /**
     * Seleciona a fábrica de função correspondente à opção informada.
     *
     * @param opcao opção numérica correspondente à função desejada
     * @return fábrica concreta responsável por criar o estado de função
     * @throws IllegalArgumentException caso a opção informada não corresponda
     * a uma função válida
     */
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