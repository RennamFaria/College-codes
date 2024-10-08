public class Imprime implements VisitorOperacao {
    private Calcula visitorCalc;

    public Imprime(Calcula visitorCalc) {
        this.visitorCalc = visitorCalc;
    }

    @Override
    public void visitAdicao(Adicao adicao){
        System.out.println(adicao.getOperacaoUm() + "+" + adicao.getOperacaoDois() + "=" + visitorCalc.getResultadoAd());
    }

    @Override
    public void visitMultiplicacao(Multiplicacao multiplicacao){
        System.out.println(multiplicacao.getOperacaoUm() + "*" + multiplicacao.getOperacaoDois() + "=" + visitorCalc.getResultadoMult());
    }
}
