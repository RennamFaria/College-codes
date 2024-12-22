public class FabricaConcreta extends Fabrica {
    @Override
    public Ponto createPonto(int x, int y) {
        return new Ponto(x, y);
    }

    @Override
    public Circulo createCirculo(Ponto p1, float raio) {
        return new Circulo(p1, raio);
    }

    @Override
    public Retangulo createRetangulo(Ponto p1, Ponto p2) {
        return new Retangulo(p1, p2);
    }

    @Override
    public Triangulo createTriangulo(Ponto p1, Ponto p2, Ponto p3) {
        return new Triangulo(p1, p2, p3);
    }
}