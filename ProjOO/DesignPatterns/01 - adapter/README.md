Uma aplicação de gerenciamento de projetos precisa enviar notificações para seus usuários. Inicialmente, a aplicação foi projetada para enviar notificações apenas por e-mail, utilizando uma biblioteca de terceiros específica para essa finalidade. Com o tempo, a necessidade de enviar notificações através de outros meios como SMS e notificações push em dispositivos móveis tornou-se evidente. Contudo, cada um desses meios utiliza uma biblioteca de terceiros diferente, com interfaces distintas para o envio de mensagens.


Objetivo:
Integrar o suporte a SMS e notificações push na aplicação de gerenciamento de projetos, garantindo que a expansão das funcionalidades de notificação seja feita com o mínimo de alterações no código existente. Para isso, você deverá utilizar o Padrão de Projeto Adapter.


Requisitos:
1. **Interface Comum de Notificação**: Definir uma interface comum `INotificador` que declare o método `enviar(mensagem, destinatario)`. Esta interface será a base para o envio de notificações dentro da aplicação.

2. **Implementação de Email**: Criar uma classe `NotificadorEmail` que implemente `INotificador`, utilizando a biblioteca de e-mail existente para enviar as notificações.

3. **Adaptação para SMS e Push**: Suponha que as bibliotecas de SMS e Push têm métodos `enviarSMS(numero, mensagem)` e `enviarPush(idDispositivo, mensagem)`, respectivamente, que são incompatíveis com a interface `INotificador`. Você deve criar adaptadores `AdaptadorSMS` e `AdaptadorPush` que permitam o uso dessas bibliotecas através da interface `INotificador`.

4. **Demonstração**: Implementar uma classe `Main` que demonstre a utilização das classes de notificação para enviar diferentes tipos de mensagens (e-mail, SMS, push) para diversos destinatários.
