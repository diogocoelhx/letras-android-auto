# 🚗 Letras para Android Auto

Um aplicativo nativo desenvolvido para Android Auto que busca e exibe as letras das músicas em tempo real diretamente na tela do veículo. O projeto explora o ecossistema automotivo do Google, priorizando uma interface limpa, responsiva e segura para o motorista.

## 🛠️ Tecnologias e Arquitetura
* **Kotlin:** Linguagem principal do projeto.
* **Android for Cars App Library:** Construção da interface automotiva utilizando `CarAppService`, `Screen` e `LongMessageTemplate`.
* **Coroutines:** Gerenciamento de processos em segundo plano para chamadas de rede sem bloquear a interface do usuário.
* **Thread Safety (Handler):** Sincronização segura entre as rotinas de busca na internet e a atualização visual no painel do carro.
* **API REST:** Consumo da API `lyrics.ovh` (através da classe `LyricsFetcher`) para a busca dinâmica de letras.
* **Manifest & Intents:** Configuração avançada de permissões e categorias automotivas (`androidx.car.app.category.POI` e `automotive_app_desc.xml`).

## ✨ Funcionalidades
* Captura do estado atual do player de mídia (ex: Spotify).
* Busca automatizada e assíncrona da letra correspondente.
* Exibição hierárquica otimizada para leitura rápida em visores de painel (Head Units).
