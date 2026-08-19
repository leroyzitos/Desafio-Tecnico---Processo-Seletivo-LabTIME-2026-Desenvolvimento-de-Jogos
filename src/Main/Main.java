package Main;

import javacode.nave.Nave;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        exibirTelaInicial();

        if (!confirmarCriacaoNave()) {
            desligarSistema();
            return;
        }

        Nave nave = criarNave();

        menuNave(nave);

        scanner.close();
    }

    // TELA INICIAL

    private static void exibirTelaInicial() {

        limparTela();

        System.out.println("========================================");
        System.out.println("         INICIANDO SISTEMA...");
        System.out.println("========================================");

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static boolean confirmarCriacaoNave() {

        limparTela();

        System.out.println("========================================");
        System.out.println("      SISTEMA TESTADOR DE NAVES");
        System.out.println("========================================\n");

        System.out.println(
                "Bem-vindo(a) ao Sistema Testador de Naves Espaciais.\n\n"
                        + "Este sistema possui como propósito a verificação e teste "
                        + "das diversas funcionalidades de nossas naves espaciais.\n\n"
                        + "Deseja prosseguir e criar uma nova nave?\n\n"
                        + "\t1. Sim (Avançar e criar nova nave)"
                        + "\t\t0. Não (Desligar sistema)\n"
                        + "\n"
                        + "Resposta: "
        );

        int opcao = lerInteiro();

        while (opcao != 0 && opcao != 1) {

            System.out.println("\nOpção inválida.");
            System.out.print("Resposta: ");

            opcao = lerInteiro();
        }

        return opcao == 1;
    }

    // CRIAÇÃO DA NAVE

    private static Nave criarNave() {

        limparTela();

        System.out.println("========================================");
        System.out.println("             CRIAÇÃO DA NAVE");
        System.out.println("========================================\n");

        System.out.print("Insira o nome desejado para a nave: ");

        String nome = scanner.nextLine();

        Nave nave = new Nave(nome);

        System.out.println("\nNave criada com sucesso!");
        System.out.println("Nome atribuído: " + nave.getNome());

        pausar();

        return nave;
    }

    // MENU DA NAVE

    private static void menuNave(Nave nave) {

        int opcao;

        do {
            limparTela();

            System.out.println("========================================");
            System.out.println("          MENU DA NAVE: " + nave.getNome());
            System.out.println("========================================\n");

            System.out.println("1 - Núcleo e sistemas relacionados");
            System.out.println("2 - Tripulação");
            System.out.println("3 - Armamento");
            System.out.println("4 - Detalhes da nave");
            System.out.println("0 - Desligar sistema");

            System.out.print("\nResposta: ");

            opcao = lerInteiro();

            switch (opcao) {

                case 1:
                    menuNucleo(nave);
                    break;

                case 2:
                    menuTripulacao(nave);
                    break;

                case 3:
                    menuArmamento(nave);
                    break;

                case 4:
                    exibirDetalhesNave(nave);
                    break;

                case 0:
                    desligarSistema();
                    break;

                default:
                    System.out.println("\nOpção inválida.");
                    pausar();
            }

        } while (opcao != 0);
    }

    // TICKET 1 - NÚCLEO

    private static void menuNucleo(Nave nave) {

        String comando;

        do {
            limparTela();

            System.out.println("========================================");
            System.out.println("       NÚCLEO E SISTEMAS RELACIONADOS");
            System.out.println("========================================\n");

            System.out.println("Estado atual dos sistemas:\n");

            System.out.println("Núcleo:");
            System.out.println(nave.statusNucleo());

            System.out.println("\nEscudos:");
            System.out.println(nave.statusEscudos());

            System.out.println("\nPainéis:");
            System.out.println(nave.statusPaineis());

            System.out.println("\nLuzes:");
            System.out.println(nave.statusLuzes());

            System.out.println("\nComandos disponíveis:");
            System.out.println("\n\ttomar_dano");
            System.out.println("\treparar_nave");
            System.out.println("\treduzir_energia");
            System.out.println("\taumentar_energia");
            System.out.println("\n\t0 - Voltar");

            System.out.print("\nResposta: ");

            comando = scanner.nextLine();

            switch (comando.trim().toLowerCase()){
                case "tomar_dano":
                    tomarDano(nave);
                    break;

                case "reparar_nave":
                    repararNave(nave);
                    break;

                case "reduzir_energia":
                    reduzirEnergia(nave);
                    break;

                case "aumentar_energia":
                    aumentarEnergia(nave);
                    break;

                case "0":
                    break;

                default:
                    System.out.println("\nComando inválido");
                    pausar();
            }

        } while (!comando.equals("0"));
    }

    private static void tomarDano(Nave nave) {

        limparTela();

        System.out.println("========================================");
        System.out.println("               TOMAR DANO");
        System.out.println("========================================\n");

        System.out.print("Insira a quantidade de dano: ");

        int valor = lerInteiro();

        try {
            nave.reduzirEnergia(valor);

            System.out.println("\nDano aplicado com sucesso.");
            System.out.println("Energia e sistemas atualizados.");
        } catch (IllegalArgumentException e) {
            System.out.println("\nErro: " + e.getMessage());
        }

        pausar();
    }

    private static void repararNave(Nave nave) {

        limparTela();

        System.out.println("========================================");
        System.out.println("             REPARAR NAVE");
        System.out.println("========================================\n");

        System.out.print("Insira a quantidade de energia a recuperar: ");

        int valor = lerInteiro();

        try {
            nave.aumentarEnergia(valor);

            System.out.println("\nReparo realizado com sucesso.");
            System.out.println("Energia e sistemas atualizados.");
        } catch (IllegalArgumentException e) {
            System.out.println("\nErro: " + e.getMessage());
        }

        pausar();
    }

    private static void reduzirEnergia(Nave nave) {

        limparTela();

        System.out.println("========================================");
        System.out.println("            REDUZIR ENERGIA");
        System.out.println("========================================\n");

        System.out.print("Insira a quantidade a ser reduzida: ");

        int valor = lerInteiro();

        try {
            nave.reduzirEnergia(valor);

            System.out.println("\nEnergia reduzida com sucesso.");
        } catch (IllegalArgumentException e) {
            System.out.println("\nErro: " + e.getMessage());
        }

        pausar();
    }

    private static void aumentarEnergia(Nave nave) {

        limparTela();

        System.out.println("========================================");
        System.out.println("            AUMENTAR ENERGIA");
        System.out.println("========================================\n");

        System.out.print("Insira a quantidade a ser aumentada: ");

        int valor = lerInteiro();

        try {
            nave.aumentarEnergia(valor);

            System.out.println("\nEnergia aumentada com sucesso.");
        } catch (IllegalArgumentException e) {
            System.out.println("\nErro: " + e.getMessage());
        }

        pausar();
    }

    // TICKET 2 - TRIPULAÇÃO

    private static void menuTripulacao(Nave nave) {

        String comando;

        do {
            limparTela();

            System.out.println("========================================");
            System.out.println("               TRIPULAÇÃO");
            System.out.println("========================================\n");

            System.out.println(nave.statusTripulacao());

            System.out.println("\nOpções:");
            System.out.println("\n\tregistrar_tripulante");
            System.out.println("\tmodificar_tripulante_funcao");
            System.out.println("\tremover_tripulante");
            System.out.println("\texibir_tripulacao");
            System.out.println("\ttripulante_trabalhar");
            System.out.println("\n\t0 - Voltar");

            System.out.print("\nResposta: ");

            comando = scanner.nextLine();

            switch (comando.trim().toLowerCase()) {

                case "registrar_tripulante":
                    registrarTripulante(nave);
                    break;

                case "modificar_tripulante_funcao":
                    trocarFuncao(nave);
                    break;

                case "remover_tripulante":
                    removerTripulante(nave);
                    break;

                case "exibir_tripulacao":
                    exibirTripulacao(nave);
                    break;

                case "tripulante_trabalhar":
                    trabalhar(nave);
                    break;

                case "0":
                    break;

                default:
                    System.out.println("\nComando inválido.");
                    pausar();
            }

        } while (!comando.equals("0"));
    }

    private static void registrarTripulante(Nave nave) {

        limparTela();

        System.out.println("========================================");
        System.out.println("        REGISTRAR NOVO TRIPULANTE");
        System.out.println("========================================\n");

        System.out.print("Nome completo: ");
        String nome = scanner.nextLine();

        char sexo;

        while (true) {

            System.out.print("Sexo (M/F): ");

            String entrada = scanner.nextLine().trim().toUpperCase();

            if (entrada.equals("M") || entrada.equals("F")) {
                sexo = entrada.charAt(0);
                break;
            }

            System.out.println("\nSexo inválido. Digite M ou F.");
        }

        System.out.print("Idade: ");
        int idade = lerInteiro();

        System.out.println("\nFunções disponíveis:");
        System.out.println("\t1 - Capitão");
        System.out.println("\t2 - Cientista");
        System.out.println("\t3 - Médico");
        System.out.println("\t4 - Mecânico do motor");
        System.out.println("\t5 - Operador dos canhões");
        System.out.println("\t6 - Operador dos escudos");

        System.out.print("\nOpção de função: ");
        int opcaoFuncao = lerInteiro();

        try {
            nave.registrarTripulante(nome, sexo, idade, opcaoFuncao);

            System.out.println("\nTripulante registrado com sucesso.");
        } catch (IllegalArgumentException e) {
            System.out.println("\nErro: " + e.getMessage());
        }

        pausar();
    }

    private static void trocarFuncao(Nave nave) {

        limparTela();

        System.out.println("========================================");
        System.out.println("        MODIFICAR FUNÇÃO DO TRIPULANTE");
        System.out.println("========================================\n");

        System.out.print("Código do tripulante: ");
        String codigo = scanner.nextLine();

        System.out.println("\nFunções disponíveis:");
        System.out.println("\t1 - Capitão");
        System.out.println("\t2 - Cientista");
        System.out.println("\t3 - Médico");
        System.out.println("\t4 - Mecânico do motor");
        System.out.println("\t5 - Operador dos canhões");
        System.out.println("\t6 - Operador dos escudos");

        System.out.print("\nNova função: ");
        int opcaoFuncao = lerInteiro();

        try {
            nave.trocarFuncao(codigo, opcaoFuncao);

            System.out.println("\nOperação concluída.");
        } catch (IllegalArgumentException e) {
            System.out.println("\nErro: " + e.getMessage());
        }

        pausar();
    }

    private static void removerTripulante(Nave nave) {

        limparTela();

        System.out.println("========================================");
        System.out.println("          REMOVER TRIPULANTE");
        System.out.println("========================================\n");

        System.out.print("Código do tripulante a remover: ");

        String codigo = scanner.nextLine();

        nave.removerTripulante(codigo);

        pausar();
    }

    private static void exibirTripulacao(Nave nave) {

        limparTela();

        System.out.println("========================================");
        System.out.println("               TRIPULAÇÃO");
        System.out.println("========================================\n");

        System.out.println(nave.statusTripulacao());

        pausar();
    }

    private static void trabalhar(Nave nave) {

        limparTela();

        System.out.println("========================================");
        System.out.println("          TRABALHO DO TRIPULANTE");
        System.out.println("========================================\n");

        System.out.print("Código do tripulante: ");

        String codigo = scanner.nextLine();

        nave.trabalhar(codigo);

        pausar();
    }

    // TICKET 3 - ARMAMENTO

    private static void menuArmamento(Nave nave) {

        String comando;

        do {
            limparTela();

            System.out.println("========================================");
            System.out.println("               ARMAMENTO");
            System.out.println("========================================\n");

            System.out.println(nave.statusArmamento());

            System.out.println("\nOpções:");
            System.out.println("\n\tatirar");
            System.out.println("\ttrocar_armamento");
            System.out.println("\tadicionar_modificador");
            System.out.println("\texibir_detalhes");
            System.out.println("\n\t0 - Voltar");

            System.out.print("\nResposta: ");

            comando = scanner.nextLine();

            switch (comando.trim().toLowerCase()) {

                case "atirar":
                    atirar(nave);
                    break;

                case "trocar_armamento":
                    mudarArma(nave);
                    break;

                case "adicionar_modificador":
                    adicionarModificador(nave);
                    break;

                case "exibir_detalhes":
                    exibirDetalhesArmamento(nave);
                    break;

                case "0":
                    break;

                default:
                    System.out.println("\nComando inválido.");
                    pausar();
            }

        } while (!comando.equals("0"));
    }

    private static void atirar(Nave nave) {

        limparTela();

        nave.atirar();

        pausar();
    }

    private static void mudarArma(Nave nave) {

        limparTela();

        System.out.println("========================================");
        System.out.println("             TROCAR ARMAMENTO");
        System.out.println("========================================\n");

        System.out.println("Arma atualmente equipada: " + nave.getNomeArmamento());

        System.out.println("\nAo trocar de arma, os modificadores atuais serão removidos.");

        System.out.println("\nArmas disponíveis:");
        System.out.println("\t1 - Canhões Perfurantes");
        System.out.println("\t2 - Enxame de Mísseis");
        System.out.println("\t3 - Láser Contínuo");
        System.out.println("\t4 - Raio Disruptor");

        System.out.print("\nOpção da arma: ");

        int opcao = lerInteiro();

        try {

            limparTela();

            System.out.println("========================================");
            System.out.println("             TROCAR ARMAMENTO");
            System.out.println("========================================\n");

            System.out.println("Arma selecionada: ");

            switch (opcao) {
                case 1:
                    System.out.println("\tCanhões Perfurantes");
                    break;

                case 2:
                    System.out.println("\tEnxame de Mísseis");
                    break;

                case 3:
                    System.out.println("\tLáser Contínuo");
                    break;

                case 4:
                    System.out.println("\tRaio Disruptor");
                    break;

                default:
                    throw new IllegalArgumentException("Opção de arma inválida.");
            }

            System.out.println("\nDigite \"equipar_arma\" para confirmar.");
            System.out.println("Digite \"0\" para sair.");
            System.out.print("\nResposta: ");

            String comando = scanner.nextLine().trim().toLowerCase();

            if (comando.equals("equipar_arma")) {

                nave.mudarArma(opcao);

                System.out.println("\nArmamento alterado com sucesso.");

            } else if (!comando.equals("0")) {

                System.out.println("\nNenhuma alteração foi realizada.");
            }

        } catch (IllegalArgumentException e) {

            System.out.println("\nErro: " + e.getMessage());
        }

        pausar();
    }

    private static void adicionarModificador(Nave nave) {

        limparTela();

        System.out.println("========================================");
        System.out.println("       ADICIONAR MODIFICADOR");
        System.out.println("========================================\n");

        System.out.println("Modificadores disponíveis:");
        System.out.println("\t1 - Disruptor de Escudos");
        System.out.println("\t2 - Perfuração de Blindagem");
        System.out.println("\t3 - Impacto Explosivo");
        System.out.println("\t4 - Dano de Fogo");
        System.out.println("\t5 - Dano de Ácido");

        System.out.print("\nOpção do modificador: ");

        int opcao = lerInteiro();

        try {
            nave.adicionarModificador(opcao);

            System.out.println("\nModificador adicionado com sucesso.");
        } catch (IllegalArgumentException e) {
            System.out.println("\nErro: " + e.getMessage());
        }

        pausar();
    }

    private static void exibirDetalhesArmamento(Nave nave) {

        limparTela();

        System.out.println("========================================");
        System.out.println("               ARMAMENTO");
        System.out.println("========================================\n");

        System.out.println(nave.statusArmamento());

        pausar();
    }

    // DETALHES DA NAVE

    private static void exibirDetalhesNave(Nave nave) {

        limparTela();

        System.out.println("========================================");
        System.out.println("           DETALHES DA NAVE");
        System.out.println("========================================\n");

        System.out.println(nave);

        pausar();
    }

    // ENTRADA E UTILITÁRIOS

    private static int lerInteiro() {

        while (!scanner.hasNextInt()) {

            System.out.println("\nEntrada inválida. Digite somente números.");
            scanner.nextLine();

            System.out.print("Resposta: ");
        }

        int valor = scanner.nextInt();
        scanner.nextLine();

        return valor;
    }

    private static void pausar() {

        System.out.println("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }

    private static void limparTela() {

        try {
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {

                new ProcessBuilder("cmd", "/c", "cls")
                        .inheritIO()
                        .start()
                        .waitFor();

            } else {

                System.out.print("\033[H\033[2J");
                System.out.flush();
            }

        } catch (Exception e) {
            // Caso não seja possível limpar a tela, continua normalmente.
        }
    }

    private static void desligarSistema() {

        limparTela();

        System.out.println("========================================");
        System.out.println("        DESLIGANDO SISTEMA...");
        System.out.println("========================================");

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\nSistema desligado.");
    }
}