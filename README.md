 📱 Android App - Autenticação com Firebase (Jetpack Compose)

Aplicação Android desenvolvida em **Kotlin** com foco em autenticação de usuários, navegação entre telas e construção de interface moderna utilizando **Jetpack Compose**.

 🚀 Sobre o projeto

Este projeto foi desenvolvido com o objetivo de praticar o desenvolvimento Android moderno, utilizando **UI declarativa com Compose**, integração com **Firebase** e organização de navegação entre telas.

A aplicação simula um fluxo real de autenticação, com telas de login e cadastro, conectadas a serviços externos.

 ✨ Funcionalidades

- Cadastro de usuário
- Login com autenticação via Firebase
- Navegação entre telas com Navigation Compose
- Validação de campos de entrada
- Interface moderna com Jetpack Compose
- Campo de senha com controle de visibilidade
- Feedback visual para o usuário (erros e validações)

 🧱 Arquitetura e organização

O projeto foi estruturado com foco em organização e escalabilidade da camada de apresentação:

- **Screens (Telas)**  
  Responsáveis pela UI e interação com o usuário

- **Navigation**  
  Gerenciamento de rotas e fluxo entre telas

- **Components**  
  Componentes reutilizáveis para inputs e UI

- **Firebase Integration**  
  Autenticação e persistência de dados com Firestore

 🛠️ Tecnologias utilizadas

- Kotlin
- Jetpack Compose
- Navigation Compose
- Firebase Authentication
- Cloud Firestore
- Material Design 3
- Android Studio

 📸 Fluxo da aplicação

1. Usuário acessa tela de login  
2. Pode realizar login ou ir para cadastro  
3. Cadastro cria usuário no Firebase  
4. Login autentica e direciona para próxima tela  

 📚 Aprendizados

Com este projeto, foi possível evoluir em:

- Construção de interfaces modernas com Compose
- Gerenciamento de navegação entre telas
- Integração com serviços externos (Firebase)
- Criação de componentes reutilizáveis
- Validação de dados em formulários
- Organização de código Android

 🚧 Melhorias futuras

- Implementar arquitetura MVVM completa
- Adicionar ViewModel e StateFlow
- Melhorar tratamento de erros da autenticação
- Adicionar persistência local (Room)
- Criar testes automatizados
- Melhorar UX (loading, estados, feedback)

 ▶️ Como executar

1. Clone o repositório:

```bash
git clone https://github.com/Abelpozza/AnotherTest
