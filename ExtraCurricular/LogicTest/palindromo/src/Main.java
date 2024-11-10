import java.util.Scanner;

public class Main {
    // Walk in the string and check if its palindrom
    public static String searchMaxPalindrom (String text) {
        String textAux = "";
        int i = (text.length());        //step size = size of string
        int j = 0;

        // Walk in string from big steps to smaller searching isPalindrom
        for( ; i > 0; ){
            textAux = text.substring(j, i + j);
            // System.out.printf("j = %d || i = %d || textAux = %s\n", j, i, textAux);

            if(isPalindrom(textAux)){
                return textAux;         //if found the palindrom is already the biggest
            }
            else{
                // Enter if you reach the end of the string
                if((i + j) == (text.length())){
                    i--;        // step size -1
                    j = 0;      // start back in the start of the string
                }
                else{
                    j++;        // walk +1
                }
            }
        }

        return textAux;
    }

    // Check if the original and inverted string is the same
    public static Boolean isPalindrom (String text) {
        String textInvert = new StringBuffer(text).reverse().toString();    //invert the texts
        
        if(text.equals(textInvert))
            return true;
        else
            return false;
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String text = "", maxPal;
        long startTime, estimatedTime;
        boolean isValid = false;

        do {
            isValid = true;
            System.out.println("Digite um texto: ");
            text = input.nextLine();

            // Check length
            if (text.length() < 1 || text.length() > 1000) {
                System.out.println("Erro! O tamanho da sequência deve ser entre 1 e 1000 caracteres.");
                isValid = false;
            }

            // Check if it is characters
            if (!text.matches("[a-zA-Z0-9 .,_-]+")) {
                System.out.println("Erro! A sequência permiti somente números e letras.");
                System.out.println("Digite novamente");
                isValid = false;
            }

        } while (!isValid);
        

        // Start time program
        startTime = System.nanoTime();

        maxPal = searchMaxPalindrom(text);

        // End time program
        estimatedTime = (System.nanoTime() - startTime);
        // Convert to seconds
        double elapsedTimeSeconds = estimatedTime / 1_000_000_000.0;

        System.out.println();
        System.out.println("O maior Palíndromo é: " + maxPal);
        System.out.printf("O tempo de programa foi de: %d nanosegundos ou %.5f segundos\n", estimatedTime, elapsedTimeSeconds);
        
        input.close();
    }
}
