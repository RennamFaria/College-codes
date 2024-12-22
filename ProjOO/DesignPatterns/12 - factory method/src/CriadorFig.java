import java.util.HashMap;

public class CriadorFig {
  static HashMap<String, Figura> builders;

  public CriadorFig(){
    builders = new HashMap<String, Figura>();
  
    builders.put("Circulo", new Circulo());
    builders.put("Quadrado", new Quadrado());
    builders.put("TrEquilatero", new TrEquilatero());
  }

  public static Figura getFigura(String key){
    return (Figura) builders.get(key);
  }
}