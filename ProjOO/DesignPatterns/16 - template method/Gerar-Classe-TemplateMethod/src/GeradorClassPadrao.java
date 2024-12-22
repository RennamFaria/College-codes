
class GeradorClassPadrao extends GeradorClassTemplate {

    public GeradorClassPadrao(String nome, String mensagem) {
        super(nome, mensagem);
    }

    @Override
    protected String buildStart() {
        return "public class " + nome + " {\n";
    }

    @Override
    protected String buildBody() {
        return "    public static void main(String[] args) {\n" +
                "        System.out.println(\"" + menssagem + "\");\n" +
                "    }\n";
    }

    @Override
    protected String buildEnd() {
        return "}";
    }

    @Override
    public void saveCode(){

    }
}