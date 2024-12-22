import java.util.Random;

public class Main {         //test
    public static void main(String[] args) {
        AlgarismFactory algarismFactory = new AlgarismFactory();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int algarism = random.nextInt(10);
                Algarism algarismObj = algarismFactory.getAlgarism(algarism);
                algarismObj.print();
            }
            System.out.println();
        }
    }
}