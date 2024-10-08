public class Multiplicacao implements Operacao {
    private int operacaoUm;
    private int operacaoDois;

    public Multiplicacao(int operacaoUm, int operacaoDois){
        this.operacaoUm = operacaoUm;
        this.operacaoDois = operacaoDois;
    }

    public int getOperacaoUm(){
        return this.operacaoUm;
    }

    public int getOperacaoDois(){
        return this.operacaoDois;
    }

    @Override
    public void aceita(VisitorOperacao visitorOp){
        visitorOp.visitMultiplicacao(this);
    }
}
