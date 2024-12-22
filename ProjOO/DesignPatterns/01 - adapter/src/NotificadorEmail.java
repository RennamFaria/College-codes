public class NotificadorEmail implements INotificador {
    @Override
    public void enviar(String mensagem, String destinatario) {
        // Lógica para enviar e-mail usando a biblioteca de e-mail existente
        System.out.println("Enviando e-mail para " + destinatario + ": " + mensagem);
    }
}