package foo.bar;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        StringCalc calc = new StringCalc();
        System.out.println("Wprowadź string w celu dodania:\n");
        String numery = input.nextLine();
        int wynik = calc.add(numery);
        System.out.println("\nWynik dodawania to: "+wynik);

    }
}
