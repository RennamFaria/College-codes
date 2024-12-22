public class AdaptadorPush implements INotificador {
    @Override
    public void enviar(String mensagem, String idDispositivo) {
        //bib_push = new BibliotecaPush();
        //bibpush.enviarPush(idDispositivo, mensagem);
        System.out.println("Enviando notificação push para dispositivo " + idDispositivo + ": " + mensagem);
    }
}