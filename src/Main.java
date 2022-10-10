import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        // Обьект который конвентирует арабские цифры в римские и обратно.
        Convert con = new Convert();//Работает не корректно!
        // Знаки операций.
        String[] sings = {"+" , "-" , "/" , "*"};
        //Знаки операций типа char.
        String[] regexSings = {"\\+" , "-" , "/" , "\\*"};

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите выражение");
        String example = scan.nextLine();

        //Индекс знака.
        int indexSing = 100;//невозможно присвоить чисту значение null. присвоил не возможное значение.
        for (var i = 0; i < sings.length;i++)
        {
            if (example.contains(sings[i]))
            {
                indexSing = i;
                break;
            }
        }
        //Если нет знака. выбрасываем исключение.
        if (indexSing <= 100)
        {
            System.out.println("Отсуцтвует операнд.");
            return;
        }

        //Деление сроки по символу.
        String[] data = example.split(regexSings[indexSing]);//Не принимает знак сложения и умножения:/

        //Проверка цифр на формат.
        //TODO: Нужно дописать класс конверт!
        if (1 == 1)
        {

        }

    }
}