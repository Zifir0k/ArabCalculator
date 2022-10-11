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
        int indexSing = -10;//невозможно присвоить чисту значение null. присвоил не возможное значение.
        for (var i = 0; i < sings.length;i++)
        {
            if (example.contains(sings[i]))
            {
                indexSing = i;
                break;
            }
        }
        //Если нет знака. выбрасываем исключение.
        if (indexSing == -10)
        {
            System.out.println("Отсуцтвует операнд.");
            return;
        }

        //Деление сроки по символу.
        String[] data = example.split(regexSings[indexSing]);//Не принимает знак сложения и умножения:/

        //Проверка цифр на формат.
        if (con.IsRim(data[0]) == con.IsRim(data[1])) {
            int a, b;
            //Определяем, римские ли это числа.
            boolean isRoman = con.IsRim(data[0]);
            if (isRoman) {
                a = con.rimToArab(data[0]);
                b = con.rimToArab(data[1]);
            } else {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }
            int result;
            switch (sings[indexSing]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    result = a / b;
                    break;
                default:
                    System.out.println("Err");
                    return;
            }
            if (isRoman)
            {
                System.out.println(con.intRim(result));
            }else
            {
                System.out.println(result);
            }

        }else
        {
            System.out.println("Разный формат");
        }

    }
}