package javacode.ticket2;

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

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public char getSexo() {
        return sexo;
    }

    public int getIdade() {
        return idade;
    }

    public String getNomeFuncao() {
        return funcao.getNomeFuncao();
    }

    @Override
    public String toString() {
        return "Tripulante Nº " + codigo
                + "\nNome: " + nome
                + "\nSexo: " + sexo
                + "\nIdade: " + idade + " anos"
                + "\nFunção: " + funcao.getNomeFuncao();
    }
}