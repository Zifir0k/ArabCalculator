import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Convert con = new Convert();//Он тут не нужен пока что.

        Scanner scan = new Scanner(System.in);// Это нужно оставить тут!
        System.out.println("Введите выражение");
        String example = scan.nextLine();

        Calc calculator = new Calc();

        String result = calculator.calc(example);

        System.out.println(result);

    }
}