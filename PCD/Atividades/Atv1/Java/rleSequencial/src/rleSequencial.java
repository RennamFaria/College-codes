package PCD.Atividades.Atv1.Java.rleSequencial.src;
public class rleSequencial {
    public static String compressRle(String input){
        String output = "";
        char aux = input.charAt(0);
        String joinAux;
        int count = 1;

        for(int i = 1; i < input.length(); i++){
            if(input.charAt(i) == aux){         //if the next is the same char, count+1
                count++;
            }
            else{                   //else, save the count of chars and add in the output string
                joinAux = String.valueOf(aux)+String.valueOf(count);
                output = output.concat(joinAux);
                aux = input.charAt(i);
                count = 1;
            }
        }
        return output;
    }

      public static void main(String[] args){
        String input = "aaabbccccddddeeeeeffaaaaaaa";
        String output;
        long elapsedTime;

        long startTime = System.nanoTime();
        output = compressRle(input);
        long endTime = System.nanoTime();
        elapsedTime = endTime - startTime;


        System.out.println("String comprimida: " + output);
        System.out.println("Tempo de execução (sequencial): " + (double) elapsedTime / 1_000_000_000);

    }
}