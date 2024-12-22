public class AdaptadorSMS implements INotificador {
    @Override
    public void enviar(String mensagem, String numero) {
        //bib_sms = new BibliotecaSMS();
        //bibsmms.enviarSms(numero, mensagem);
        System.out.println("Enviando SMS para " + numero + ": " + mensagem);
    }
}