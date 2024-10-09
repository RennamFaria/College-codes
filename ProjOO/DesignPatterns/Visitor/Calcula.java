public class Calcula implements VisitorOperacao {
    private int resultadoAd;
    private int resultadoMult;

    @Override
    public void visitAdicao(Adicao adicao){
        this.resultadoAd = adicao.getOperacaoUm() + adicao.getOperacaoDois();
    }

    @Override
    public void visitMultiplicacao(Multiplicacao multiplicacao){
        this.resultadoMult = multiplicacao.getOperacaoUm() * multiplicacao.getOperacaoDois();
    }

    public int getResultadoAd() {
        return resultadoAd;
    }

    public int getResultadoMult() {
        return resultadoMult;
    }
}
