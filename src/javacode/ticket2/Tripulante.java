package javacode.ticket2;

/**
 * Representa um tripulante da nave e sua função atual dentro da tripulação.
 *
 * <p>Um tripulante mantém seus dados pessoais e uma referência para o estado
 * correspondente à sua função atual. O comportamento de trabalho é delegado
 * ao {@link StateFuncao} atualmente atribuído, permitindo a alteração da
 * função durante a execução sem a necessidade de recriar o objeto.</p>
 *
 * <p>A criação do estado inicial de função é realizada por meio do
 * {@link FactoryStateFuncao}, selecionado de acordo com a opção de função
 * recebida durante a construção do objeto.</p>
 */
public class Tripulante {

    /** Próximo valor a ser utilizado na geração do código do tripulante. */
    private static int proxCodigo = 1;

    /** Código identificador único do tripulante durante a execução do sistema. */
    private final String codigo;

    /** Estado que representa a função atualmente exercida pelo tripulante. */
    private StateFuncao funcao;

    /** Nome completo do tripulante. */
    private String nome;

    /** Sexo do tripulante, representado por um único caractere. */
    private char sexo;

    /** Idade do tripulante. */
    private int idade;

    /**
     * Construtor de {@code Tripulante}.
     *
     * <p>Gera automaticamente o código identificador do tripulante, armazena
     * seus dados pessoais e utiliza o {@link FactorySelector} para selecionar
     * a fábrica responsável pela criação de sua função inicial.</p>
     *
     * @param nome nome completo do tripulante
     * @param sexo sexo do tripulante
     * @param idade idade do tripulante
     * @param opcaoFuncao opção correspondente à função inicial do tripulante
     */
    public Tripulante(String nome, char sexo, int idade, int opcaoFuncao) {
        codigo = String.format("%03d", proxCodigo++);
        FactoryStateFuncao factory = FactorySelector.selecionarFactory(opcaoFuncao);

        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.funcao = factory.criarStateFuncao();
    }

    /**
     * Altera a função atualmente exercida pelo tripulante.
     *
     * <p>Uma nova função é criada por meio da fábrica correspondente à opção
     * informada e atribuída ao mesmo objeto {@code Tripulante}, permitindo a
     * mudança de comportamento durante a execução.</p>
     *
     * @param opcaoFuncao opção correspondente à nova função do tripulante
     */
    public void trocarFuncao(int opcaoFuncao) {
        FactoryStateFuncao factory = FactorySelector.selecionarFactory(opcaoFuncao);

        this.funcao = factory.criarStateFuncao();
    }

    /**
     * Executa o comportamento correspondente à função atual do tripulante.
     *
     * <p>A execução é delegada ao estado {@link StateFuncao} atualmente
     * associado ao tripulante.</p>
     */
    public void trabalhar() {
        funcao.trabalhar();
    }

    /**
     * Retorna o código identificador do tripulante.
     *
     * @return código do tripulante
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Retorna uma representação textual dos dados atuais do tripulante.
     *
     * @return texto contendo código, nome, sexo, idade e função do tripulante
     */
    @Override
    public String toString() {
        return "Tripulante Nº " + codigo
                + "\nNome: " + nome
                + "\nSexo: " + sexo
                + "\nIdade: " + idade + " anos"
                + "\nFunção: " + funcao.getNomeFuncao();
    }
}