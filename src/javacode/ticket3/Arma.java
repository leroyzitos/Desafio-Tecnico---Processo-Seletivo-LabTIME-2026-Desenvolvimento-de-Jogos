package javacode.ticket3;

/**
 * Define a abstração comum para as armas utilizadas pelo sistema.
 *
 * <p>A interface é utilizada tanto pelas armas-base, representadas pelas
 * subclasses de {@link StateArma}, quanto pelos modificadores do padrão
 * {@link DecoratorModificadores}. Isso permite que ambos sejam tratados
 * uniformemente e que os modificadores sejam encadeados dinamicamente.</p>
 */
public interface Arma {

    /**
     * Retorna o nome da arma.
     *
     * @return nome da arma
     */
    public String getNome();

    /**
     * Retorna o dano causado aos escudos.
     *
     * @return dano aos escudos
     */
    public int getDanoEscudos();

    /**
     * Retorna o dano causado à blindagem.
     *
     * @return dano à blindagem
     */
    public int getDanoBlindagem();

    /**
     * Retorna o dano causado à estrutura.
     *
     * @return dano à estrutura
     */
    public int getDanoEstrutura();

    /**
     * Retorna o alcance mínimo da arma.
     *
     * @return alcance mínimo
     */
    public int getAlcanceMin();

    /**
     * Retorna o alcance máximo da arma.
     *
     * @return alcance máximo
     */
    public int getAlcanceMax();

    /**
     * Retorna o dano por segundo causado aos escudos.
     *
     * @return dano por segundo aos escudos
     */
    public int getDpsEscudos();

    /**
     * Retorna o dano por segundo causado à blindagem.
     *
     * @return dano por segundo à blindagem
     */
    public int getDpsBlindagem();

    /**
     * Retorna o dano por segundo causado à estrutura.
     *
     * @return dano por segundo à estrutura
     */
    public int getDpsEstrutura();
}