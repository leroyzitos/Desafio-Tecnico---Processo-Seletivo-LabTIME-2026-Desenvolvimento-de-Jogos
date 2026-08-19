# Sistema Testador de Naves Espaciais - Desafio Técnico Processo Seletivo LabTIME 2026

Este projeto foi projetado e desenvolvido para atender às demandas apresentadas em três tickets do Desafio Técnico do Processo Seletivo LabTIME 2026.

Seu objetivo é analisar tecnicamente as requisições apresentadas em cada um dos tickets, bem como suas restrições arquiteturais e, á luz do catálogo de padrões de projeto disponibilizado, adotar os padrões que melhor resolvam os problemas apresentados e utilizar conhecimentos de Programação Orientada a Objetos para resolvê-los, sempre respeitando as restrições de cada caso.

## Mapeamento
Nesta parte, serão abordados os requisitos apresentados, suas restrições arquiteturais e os padrões de projeto adotados para cada um deles, juntamente com a justificativa para o seu uso.

### Ticket 1
- **Requisito:** Permitir que, caso o núcleo atinja um nível crítico de energia (através de comandos como "tomar_dano" ou"reduzir_energia"), os escudos mudem o foco de sua defesa, as luzes das salas se apaguem e os painéis de navegação exibam alertas automaticamente.
- **Restrição Arquitetural:** A classe do núcleo não poderia conhecer, referenciar ou chamar diretamente quaisquer das suas classes relacionadas. Além disso, a implementação deveria ser feita de modo que, caso requisitado que um outro componente relacionado também respondesse à crise, essa reação pudesse ser adicionada sem alterar o código da classe do núcleo.
- **Padrão de Projeto Utilizado:** *Observer*.
- **Justificativa:** Como o requisito detalha que os componentes escudos, luzes e painéis da nave devem reagir a um eventual estado de crise do núcleo sem que o núcleo em si tenha qualquer relação direta em código com elas, o padrão de projeto *Observer* foi escolhido para a solução por permitir justamente isso, através da implementação de um sujeito e seus observadores.

  O sujeito (no caso, `Nucleo`)tem consigo somente uma lista genérica de observadores (sistemas de `Escudos`, `Luzes` e `Paineis` de navegação da nave), sem saber detalhes deles nem quem eles são diretamente por código, e os notifica quando seu estado muda de alguma forma que deva alterar o comportamento dos seus observadores (como a crise de energia). Assim, quando ele atinge esse estado, ele notifica seus observadores, que por sua vez vão agir, de sua própria forma, em cima dessa notificação. Com isso, além do baixo acoplamento entre `Nucleo` e seus observadores, a adição de novos observadores, como destacado nas restrições arquiteturais, não alteraria absolutamente nenhuma linha de código dentro da classe `Nucleo`, satisfazendo todos os requisitos de implementação e funcionamento.

### Ticket 2
- **Requisito:** Permitir que os tripulantes possam alternar entre diferentes funções durante o gameplay, mantendo o mesmo objeto e fazendo com que a função atual determine o comportamento executado pelo comando "tripulante_trabalhar".
- **Restrição Arquitetural:** A classe principal do tripulante não poderia conter grandes blocos de condicionais para decidir qual lógica executar, e a troca de função não poderia ocorrer através da destruição e recriação do objeto do tripulante. Além disso, os comportamentos deveriam permanecer isolados, modulares e intercambiáveis em tempo de execução.
- **Padrões de Projeto Utilizados:** *State* e *Factory Method*.
- **Justificativa:** O padrão *State* foi utilizado para representar as diferentes funções que um tripulante pode exercer e permitir que seu comportamento seja alterado durante a execução sem que o objeto do tripulante precise ser destruído ou recriado. Cada função possui sua própria implementação de comportamento, e o tripulante mantém apenas uma referência para o estado correspondente à sua função atual. Dessa forma, ao receber o comando "trabalhar", o tripulante delega a execução ao estado atualmente atribuído, evitando que sua classe precise possuir grandes blocos de *if/else* ou *switch cases* para determinar qual lógica executar. A troca de função ocorre simplesmente pela substituição do estado atual por outro estado concreto, mantendo o mesmo objeto de tripulante.

  O *Factory Method* foi utilizado em conjunto com o *State* para encapsular a criação dos estados concretos de função. A opção escolhida pelo usuário para a função é utilizada para determinar qual fábrica concreta deve ser utilizada, e essa fábrica é responsável por criar o estado correspondente. Dessa forma, o `Tripulante` não precisa conhecer diretamente as classes concretas que representam cada função, enquanto o mecanismo de criação permanece separado da lógica comportamental. Assim, os dois padrões possuem responsabilidades distintas e complementares: o *Factory Method* é responsável pela criação do estado inicial, enquanto o *State* é responsável pela representação e alteração do comportamento do tripulante durante a execução.

### Ticket 3
- **Requisito:** Permitir que a nave utilize diferentes tipos de armas-base, possibilitando equipá-las e dispará-las por meio do console, além de permitir a aplicação de múltiplos modificadores cumulativos à mesma arma antes do disparo.
- **Restrição Arquitetural:** A classe da nave não poderia conhecer ou implementar diretamente a lógica específica de cada tipo de arma, devendo apenas emitir o comando genérico de disparo. Além disso, os modificadores deveriam poder ser combinados dinamicamente sem a necessidade de criar uma nova classe para cada combinação possível de efeitos.
- **Padrões de Projeto Utilizados:** *State* e *Decorator*.
- **Justificativa:** O padrão *State* foi utilizado para representar as diferentes armas-base disponíveis no sistema. Cada arma concreta possui seus próprios atributos e características, como danos aos escudos, blindagem e estrutura, alcance e demais valores relacionados ao seu funcionamento. O `Armamento` mantém a arma atualmente equipada por meio da abstração comum e, ao trocar a arma, passa a utilizar outro estado concreto. Dessa forma, a lógica e as características específicas de cada arma permanecem isoladas em suas próprias classes, sem que a `Nave` precise conhecer seus detalhes. A `Nave` pode, portanto, apenas emitir o comando genérico de "atirar", delegando a execução ao sistema de armamento.

  O padrão *Decorator* foi escolhido para implementar os modificadores de forma dinâmica e cumulativa. Cada modificador envolve a arma ou outro modificador já existente e acrescenta seus próprios efeitos aos valores e características do disparo, preservando o mesmo contrato da abstração de arma. Assim, diferentes modificadores podem ser empilhados em qualquer combinação durante a execução, sem necessidade de criar classes específicas para combinações como uma arma com fogo, perfuração e impacto explosivo simultaneamente. Cada modificador permanece responsável somente pelos efeitos que acrescenta, enquanto a estrutura de *Decorator* permite que esses efeitos sejam acumulados de maneira modular e extensível.

## Identificação dos Papéis no Código
Nesta parte, serão identificadas as principais classes e interfaces que representam os papéis dos padrões de projeto utilizados na implementação de cada ticket.

### Ticket 1 - Observer

- **`SubjectNucleo`**: interface que define os comportamentos necessários para o sujeito do padrão, sendo responsável pelo registro, remoção e notificação dos observadores.
- **`ObserverNucleo`**: interface que define o comportamento que deve ser implementado pelas classes observadoras diante das notificações realizadas pelo sujeito.
- **`Nucleo`**: sujeito concreto (*Subject*), responsável por manter a lista de observadores e notificá-los quando seu estado de energia atingir uma condição crítica de energia.
- **`Escudos`**: observador concreto (*Concrete Observer*) responsável por alterar o foco de defesa quando o núcleo entra ou sai de estado crítico.
- **`Luzes`**: observador concreto responsável por alterar o estado da iluminação das salas da nave de acordo com a notificação recebida.
- **`Paineis`**: observador concreto responsável por alterar as informações exibidas pelos painéis de navegação de acordo com o estado do núcleo.

### Ticket 2 - State

- **`StateFuncao`**: interface que define o comportamento que pode ser assumido por um tripulante de acordo com sua função atual.
- **`Tripulante`**: contexto (*Context*) do padrão *State*, responsável por manter uma referência para a função atualmente atribuída e delegar a execução do comando "trabalhar" ao estado correspondente.
- **Estados concretos de função**: classes que implementam `StateFuncao` e representam as funções que podem ser atribuídas aos tripulantes, como `Capitao`, `Cientista`, `MecanicoDoMotor`, `Medico`, `OperadorDeCanhoes` e `OperadorDeEscudos`. Cada uma contém a lógica específica de trabalho correspondente à sua função.

### Ticket 2 - Factory Method

- **`FactoryStateFuncao`**: classe abstrata responsável por definir o método de fábrica utilizado para a criação dos estados concretos de função.
- **Factories concretas de função**: classes como `FactoryCapitao`, `FactoryCientista`, `FactoryMedico`, `FactoryMecanicoDoMotor`, `FactoryOperadorDeCanhoes` e `FactoryOperadorDeEscudos`, responsáveis por implementar o método de fábrica e instanciar o `StateFuncao` correspondente.
- **`FactorySelector`**: componente responsável por relacionar a opção selecionada pelo usuário à fábrica concreta correspondente. Dessa forma, a opção fornecida pelo console pode ser convertida em uma fábrica capaz de criar o estado de função apropriado.
- **`Tripulante`**: utiliza a fábrica selecionada durante sua criação para obter o estado inicial correspondente à função escolhida, sem precisar instanciar diretamente as classes concretas de função.

### Ticket 3 - State

- **`Arma`**: interface que define os comportamentos e informações comuns às armas utilizadas pelo sistema, servindo como abstração compartilhada entre as armas-base e os modificadores.
- **`StateArma`**: classe abstrata que representa a estrutura dos estados concretos das armas-base e concentra os atributos e comportamentos comuns entre elas.
- **Armas concretas**: classes como `CanhoesPerfurantes`, `EnxameDeMisseis`, `LaserContinuo` e `RaioDisruptor`, que estendem `StateArma` e definem os atributos específicos de cada arma-base.
- **`Armamento`**: contexto do padrão *State* para o sistema de armas, responsável por manter a arma atualmente equipada e utilizá-la na execução do disparo. A troca da arma altera o estado atual do `Armamento` sem alterar a estrutura da nave.

### Ticket 3 - Decorator

- **`Arma`**: também funciona como componente comum do padrão *Decorator*, permitindo que tanto as armas-base quanto seus modificadores sejam tratados pela mesma abstração.
- **`DecoratorModificadores`**: decorador abstrato, responsável por manter uma referência para outro objeto `Arma` e delegar a ele os comportamentos que não são alterados, fornecendo a estrutura necessária para o empilhamento dos modificadores.
- **Decorators concretos**: classes como `DisruptorDeEscudos`, `PerfuracaoDeBlindagem`, `ImpactoExplosivo`, `DanoDeFogo` e `DanoDeAcido`, que estendem `DecoratorModificadores` e acrescentam seus próprios efeitos ao dano e/ou dano por segundo do componente decorado.
- **`Armamento`**: responsável por adicionar dinamicamente os modificadores à arma atualmente equipada e, posteriormente, utilizar o componente resultante para obter os valores finais do disparo. A composição dos modificadores ocorre em tempo de execução, permitindo combinações diferentes sem a criação de classes específicas para cada combinação possível.

## Instruções de Execução
Para executar o projeto, é necessário possuir o Java Development Kit (JDK) instalado na máquina.

### Clonando o repositório

Clone o repositório utilizando o Git:

```bash
git clone <https://github.com/leroyzitos/Desafio-Tecnico---Processo-Seletivo-LabTIME-2026-Desenvolvimento-de-Jogos.git>
````

Em seguida, entre na pasta do projeto:

```bash
cd <"Desafio-Tecnico---Processo-Seletivo-LabTIME-2026-Desenvolvimento-de-Jogos">
```

### Executando o projeto

Caso esteja utilizando uma IDE como o IntelliJ IDEA, basta abrir o projeto, localizar a classe `Main` e executar o método `main`.

Caso prefira executar pelo terminal, compile os arquivos `.java` e execute a classe principal:

```bash
javac -d out src/Main/Main.java src/javacode/nave/Nave.java src/javacode/ticket1/*.java src/javacode/ticket2/*.java src/javacode/ticket3/*.java
```

Depois, execute:

```bash
java -cp out Main.Main
```

Após a inicialização, o sistema apresentará uma tela de carregamento e, em seguida, permitirá a criação de uma nova nave.

A partir do menu principal da nave, o avaliador poderá acessar os sistemas correspondentes aos três tickets:

* **Núcleo e sistemas relacionados:** permite testar as variações de energia e observar as respostas automáticas dos sistemas relacionados ao núcleo.
* **Tripulação:** permite registrar, exibir, remover e alterar a função dos tripulantes, além de solicitar que um tripulante execute o comportamento correspondente à sua função atual.
* **Armamento:** permite trocar a arma-base equipada, adicionar modificadores cumulativos e efetuar disparos, exibindo os valores resultantes da combinação entre a arma e os modificadores aplicados.

### Exemplo de fluxo de demonstração

Um fluxo possível para demonstrar as funcionalidades implementadas é:

1. Iniciar o sistema e criar uma nova nave.
2. Acessar o menu de **Núcleo e sistemas relacionados** e realizar alterações na energia da nave, verificando as reações dos observadores quando o núcleo atinge uma condição crítica.
3. Acessar o menu de **Tripulação**, registrar um novo tripulante e atribuir uma função inicial.
4. Alterar a função do mesmo tripulante durante a execução e utilizar o comando de trabalho para verificar a mudança de comportamento.
5. Acessar o menu de **Armamento**, equipar uma arma-base e adicionar um ou mais modificadores.
6. Executar o comando de disparo e verificar os valores finais produzidos pela combinação entre a arma e os modificadores.

```
```
