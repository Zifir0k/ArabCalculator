import java.util.TreeMap;
//Я понял что тут нужно использовать Enum и сделать через него дерево. Но через Интерфейс:/ Увы я в нём не разобрался
//На C# я тоже пропустил его мимо ушей и так и не понял его основной смысл(Надеюсь можно использовать интерфейсы)

//Объясню почему решил использовать TreeMap, а не LinkedHashMap. Программа получается короткой и можно забить на производительность
//А так же цифры легче сортировать по размеру чем по добавлению.
public class Convert
{
    //Вроде работает так же как Enum. Правда я не понимаю как сделать это через Enum.
    //Форумы привели меня к этому интерфейсу.(пока писал коменты среда предложила скачать штучку, исправляющую мои ошибки на русском:/)

    TreeMap<Character, Integer> rKey = new TreeMap<>();
    TreeMap<Integer, String> aKey = new TreeMap<>();
    public Convert()
    {
        rKey.put('I',1);
        rKey.put('V',5);
        rKey.put('X',10);
        rKey.put('L',50);
        rKey.put('C',100);
        rKey.put('D',500);
        rKey.put('M',1000);

        aKey.put(1,"I");
        aKey.put(4, "IV");
        aKey.put(5, "V");
        aKey.put(9, "IX");
        aKey.put(10, "X");
        aKey.put(40, "XL");
        aKey.put(50, "L");
        aKey.put(90, "XC");
        aKey.put(100, "C");
        aKey.put(400, "CD");
        aKey.put(500, "D");
        aKey.put(900, "CM");
        aKey.put(1000, "M");
    }

    public boolean IsRim(String num)
    {
        return rKey.containsKey(num.charAt(0));
    }

    public String intRim (int num)//Не знаю как сделать подсказку. Чтоб при наведении мышки на метод показывалось что он делает!
    {
        String rim = "";
        int aKeyNum;
        try {
            do {
                //Цикл перебирает похожие числа скаладывая их в строку римский цифр вычитая значение из арабских.
                aKeyNum = aKey.floorKey(num);
                rim = rim + aKey.get(aKeyNum);
                num = num - aKeyNum;
            } while (num != 0);
        }catch (Exception ex)
        {
            throw new RuntimeException("В риме не было отрицательных чисел.");//Или были, я тогда ещё не родился.
        }
        return rim;
    }

    public int rimToArab(String str)
    {
        int end = str.length() - 1;
        char[] array = str.toCharArray();
        int arab;
        int result = rKey.get(array[end]);

        for (var i = end - 1; i >= 0; i--)
        {
            arab = rKey.get(array[i]);

            if (arab < rKey.get(array[i + 1]))
            {
                result = result - arab;
            }else
            {
                result = result + arab;
            }
        }
        return result;
    }
}
