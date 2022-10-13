import java.io.IOException;

public class Calc
{
    public static String calc(String _input)
    {
        //TODO: Сделать провероверку чисел на num <= 10 && num > 0!
        //TODO: Убрать все пробелы и проверить строку на длину в 3 символа!

        String input = _input.replaceAll("\\s+","");

        Convert con = new Convert();//Объект конвертации.

        // Знаки операций.
        String[] sings = {"+" , "-" , "/" , "*"};
        //Знаки операций типа char.
        String[] regexSings = {"\\+" , "-" , "/" , "\\*"};

        int indexSing = -10;//невозможно присвоить числу значение null. присвоил не возможное значение.
        for (var i = 0; i < sings.length;i++)
        {
            if (input.contains(sings[i]))
            {
                indexSing = i;
                break;
            }
        }
        //Если нет знака. выбрасываем исключение.
        //И если нет знака значит пользователь ввёл одну цифру или просто стоку.
        if (indexSing == -10)
        {
            return  "Отсуцтвует операнд. Это не может быть примером.";
        }

        String[] data = input.split(regexSings[indexSing]);

        //Проверка цифр на формат.
        if (con.IsRim(data[0]) == con.IsRim(data[1]))
        {
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

            if (data.length > 2)// проверка на количество чисел в примере.
            {
                return "Вы ввели более одного числа.";
            }

            if (a > 10 || b > 10)
            {
                return "числа не могут быть более 10.";
            }
            if (a < 1 || b < 1)
            {
                return "числа не могут быть меньше 1.";
            }

            int result;
            switch (sings[indexSing])
            {
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
                    return "err";// невозможная ошибка.Пусть будет на всякий.
            }

            if (isRoman)
            {
                return con.intRim(result);
            }else
            {
                return String.valueOf(result);
            }

        }else
        {
            // Разный формат.
            return "Разный формат чисел.";
        }

    }
}
