# TestePremierSoft
Teste Android Premier Soft

O teste consiste em apresentar notícias vindas de uma api em uma listagem com preview breve de cada artigo (apenas com as informações principais), e que ao ser clicado apresente uma tela com o artigo completo e opção de salvar a imagem principal e compartilhar o artigo.

## API a ser consumida:

- [https://newsapi.org/](https://newsapi.org/)

## Requisitos:

- async requests usando RxJava ou Coroutines;
- função de pull to refresh na tela de artigos;
- opção de salvar a imagem do artigo (obs: salvar na pasta de downloads do sistema) e compartilhar com outros apps;
- utilizar minSdkVersion 21 & targetSdkVersion 30;

## Desejável:

- Suporte a light e dark mode (e opção de alternar dentro do app);
- Incluir pesquisa/filtros;
- Arquitetura MVVM;
- **Offline mode:**
    - Salvar e carregar as notícias usando o Room;
    - Salvar também a imagem de cada notícia para ser apresentada juntamente com ela;
    - Mostrar um placeholder quando nao houver notícias salvas no Room e não houver conexão;
