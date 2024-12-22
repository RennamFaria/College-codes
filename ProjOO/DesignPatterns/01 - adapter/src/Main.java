public class Main {
    public static void main(String[] args) {
        INotificador notificadorEmail = new NotificadorEmail();
        INotificador notificadorSMS = new AdaptadorSMS();
        INotificador notificadorPush = new AdaptadorPush();

        String mensagem = "Lembrete: Reunião às 15h!";
        String destinatarioEmail = "usuario@email.com";
        String numeroSMS = "+5511999999999";
        String idDispositivoPush = "123456";

        notificadorEmail.enviar(mensagem, destinatarioEmail);
        notificadorSMS.enviar(mensagem, numeroSMS);
        notificadorPush.enviar(mensagem, idDispositivoPush);
    }
}
