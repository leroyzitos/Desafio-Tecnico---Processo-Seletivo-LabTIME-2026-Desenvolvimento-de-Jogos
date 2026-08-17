package java.ticket2;

public class Tripulante {

    private static int proxCodigo = 1;
    private final String codigo;
    private StateFuncao funcao;
    private String nome;
    private char sexo;
    private int idade;

    public Tripulante(String nome, char sexo, int idade, int opcaoFuncao) {
        codigo = String.format("%03d", proxCodigo++);
        FactoryStateFuncao factory = FactorySelector.selecionarFactory(opcaoFuncao);

        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.funcao = factory.criarStateFuncao();
    }

    public void trocarFuncao(int opcaoFuncao) {
        FactoryStateFuncao factory = FactorySelector.selecionarFactory(opcaoFuncao);

        this.funcao = factory.criarStateFuncao();
    }

    public void trabalhar() {
        funcao.trabalhar();
    }
}