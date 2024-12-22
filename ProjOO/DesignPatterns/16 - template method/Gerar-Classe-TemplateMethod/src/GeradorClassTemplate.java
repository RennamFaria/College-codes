abstract class GeradorClassTemplate {
    protected String nome;
    protected String menssagem;

    public GeradorClassTemplate(String nome, String menssagem) {
        this.nome = nome;
        this.menssagem = menssagem;
    }

    public void constroiClass() {
        System.out.println(buildStart() + buildBody() + buildEnd());

        saveCode();
    }

    protected abstract String buildStart();
    protected abstract String buildBody();
    protected abstract String buildEnd();

    protected abstract void saveCode();
}
