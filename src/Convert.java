import java.util.TreeMap;
//Я понял что тут нужно использовать Enum и сделать через него дерево. Но через Интерфейс:/ Увы я в нём не разобрался
//На C# я тоже пропустил его мимо ушей и так и не понял его основной смысл(Надеюсь можно использовать интерфейсы)

//Обьясню почему решил использовать TreeMap, а не LinkedHashMap. Программа получается короткой и можно забить на производительность
//А так же цифры легче сортировать по размеру чем по добавлению.
public class Convert
{
    //Вроде работает так же как Enum. Правда я не понимаю как сделать это через Enum.
    //Форумы привели меня к этому интерфейсу.(пока писал коменты среда предложила скачать штучку исправляющую мои ошибки на руском:/)

    TreeMap<Character, Integer> rKey = new TreeMap<>();
    TreeMap<Integer, String> aKey = new TreeMap<>();
    public Convert()
    {
        rKey.put('I',1);
        rKey.put('V',5);
        rKey.put('X',10);

        aKey.put(1,"I");
        aKey.put(4, "IV");
        aKey.put(5, "V");
        aKey.put(9, "IX");
        aKey.put(10, "X");
    }

    public boolean IsRim(String num)
    {
        return rKey.containsKey(num.charAt(0));
    }

    public String intRim (int num)//Не знаю как сделать подсказку. чтоб при наведении мышки на метод показывалось что он делает!
    {
        String rim = "";
        int aKeyNum;
        do
        {
            //Цикл перебирает похожие числа скаладывая их в строку римский цифр вычитая их значение из арабских.
            aKeyNum = aKey.floorKey(num);
            rim = rim + aKey.get(aKeyNum);
            num = num -aKeyNum;
        }while (num != 0);
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
