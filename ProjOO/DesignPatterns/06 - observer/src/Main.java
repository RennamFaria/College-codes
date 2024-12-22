import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    PCDData pcdNorte = new PCDData("PCDNorte", 26.2, 7.1, 0.97);
    PCDData pcdOeste = new PCDData("PCDOeste", 23.7, 8.0, 0.94);
    Instituicao instSP = new InstituicaoConcreto("Universidade SP");
    Instituicao instRJ = new InstituicaoConcreto("Insituto de Pesquisa RJ");
    Instituicao instMG = new InstituicaoConcreto("Empresa MG");
    
    pcdNorte.cadastrar(instSP);
    pcdNorte.cadastrar(instRJ);
    pcdOeste.cadastrar(instMG);

    System.out.println("Notificacao 1:");
    pcdNorte.addData(26.0, 7.1, 0.97);  //deve enviar notifica'cao para SP e RJ

    System.out.println("\nNotificacao 2:");
    pcdOeste.addData(23.7, 9.0, 0.94);  //deve enviar notificacao
  }
}
