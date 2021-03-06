import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * La classe MyLambda implementa els mètodes necessaris per comprovar si un enter és parell, primer, i palíndrom,
 * implementats com funcions lambda a través de la functional interface CheckNumero.
 * El mètode principal checker retorna una llista d'objectes Numero amb aquestes tres propietats com a record.
 *
 * @author ErnestCV
 */

public class MyLambda {

    //Creem la functional interface necessària per definir els mètodes demanats amb lambdes
    @FunctionalInterface
    public interface CheckNumero{
        boolean check(int num);
    }

    //Comprovem si el nombre és parell
    CheckNumero isOdd = num -> (num > 0) && ((num % 2) == 0);

    //Comprovem si el nombre és primer, mirant que no sigui divisible per cap altre nombre (excloent ell mateix i l'1)
    CheckNumero isPrime = num -> (num > 0) && IntStream.rangeClosed(2, num / 2).noneMatch(i -> num % i == 0);

    /*
    Comprovem si el nombre és palíndrom, convertint-lo a String i comprovant de manera successiva
    que el primer i darrer dígits són iguals
    */
    CheckNumero isPalindrome = num -> {
        String str = String.valueOf(num);
        return num > 0 && IntStream.range(0, str.length() / 2)
                .allMatch(i -> str.charAt(i) == str.charAt(str.length() - i - 1));
    };

    /*
    Mètode principal, retorna una llista d'objectes Numero amb les propietats demanades.
    Si l'input és 0, mostra el missatge "NOT A POSSIBLE OPTION" i continua al següent valor.
    */
    public List<Numero> checker(int[] nums) {
        List<Numero> list = new ArrayList<>();
        Arrays.stream(nums).forEach(num -> {
            if (num == 0) {
                System.out.println("NOT A POSSIBLE OPTION");
            } else {
                list.add(numMaker(num));
            }
        });
        return list;
    }

    //Fem servir aquest Record per desar les propietats d'un nombre individual
    private record Numero(int num, boolean isOdd, boolean isPrime, boolean isPalindrome) {

        @Override
        public String toString() {
            return "{" +
                    "input:" + num +
                    ", isOdd:" + isOdd +
                    ", isPrime:" + isPrime +
                    ", isPalindrome:" + isPalindrome +
                    '}';
        }
    }

    //Aquest mètode construeix objectes Numero
    private Numero numMaker(int num) {
        return new Numero(num, isOdd.check(num), isPrime.check(num), isPalindrome.check(num));
    }
}
