//import java.util.ArrayList

/**
 * Classe representando a nave e seus principais sistemas relacionados.
 *
 * <p>É responsável por instanciar e conectar os diversos componentes
 * que fazem parte do sistema da nave.</p>
 * */
public class Nave {

    /** Núcleo de energia da nave, central para seu funcionamento. */
    private Nucleo nucleo;

    /** Sistema de escudos da nave. */
    private Escudos escudos;

    /** Sistema de painéis da nave. */
    private Paineis paineis;

    /** Sistema de iluminação das salas da nave. */
    private Luzes luzes;
    //ArrayList<Tripulante> tripulacao;
    //Armamento armamento;

    /**
     * Construtor de {@code Nave}, que cria uma nova nave e inicializa seus sistemas
     *
     * <p>De acordo com o padrão de projeto Observer, durante a inicialização,
     * os sistemas de escudos, painéis e iluminação da nave são registrados como
     * observadores do núcleo de energia dela.</p>
     * */
    public Nave() {
        nucleo = new Nucleo();
        escudos = new Escudos();
        paineis = new Paineis();
        luzes = new Luzes();

        nucleo.registrarObservador(escudos);
        nucleo.registrarObservador(paineis);
        nucleo.registrarObservador(luzes);
    }
}