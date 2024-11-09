package PCD.Atividades.Atv1.Java.rleParalelo.src;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class rleParallel {
    //one fork compress first half and the other compress the rest
    public static String splitTask(String input, ForkJoinPool pool) {
        int mid = input.length() / 2;
        String firstHalf = input.substring(0, mid);
        String secondHalf = input.substring(mid);

        CompressTask firstTask = new CompressTask(firstHalf);
        CompressTask secondTask = new CompressTask(secondHalf);

        firstTask.fork();

        String secondResult = secondTask.compute();
        String firstResult = firstTask.join();

        return firstResult + secondResult;
    }

    public static String compress(String input) {
        String output = "";
        char aux = input.charAt(0);
        String joinAux;
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == aux) {
                count++;
            } else {
                joinAux = String.valueOf(aux) + String.valueOf(count);
                output = output.concat(joinAux);
                aux = input.charAt(i);
                count = 1;
            }
        }
        //Fix last character sequence
        joinAux = String.valueOf(aux) + String.valueOf(count);
        output = output.concat(joinAux);

        return output;
    }

    public static void main(String[] args) {
        String input = "aaabbccccddddeeeeeffaaaaaaa";
        String output;
        long elapsedTime;

        ForkJoinPool commonPool = ForkJoinPool.commonPool();

        long startTime = System.nanoTime();

        try {
            output = splitTask(input, commonPool);
            long endTime = System.nanoTime();
            elapsedTime = endTime - startTime;

            System.out.println("Compressed string: " + output);
            System.out.println("Execution time (parallel): " + (double) elapsedTime / 1_000_000_000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static class CompressTask extends RecursiveTask<String> {
        private final String input;

        public CompressTask(String input) {
            this.input = input;
        }

        @Override
        protected String compute() {
            return compress(input);
        }
    }
}