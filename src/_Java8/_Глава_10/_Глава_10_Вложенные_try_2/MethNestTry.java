package _Java8._Глава_10._Глава_10_Вложенные_try_2;
public class MethNestTry {
    static void nesttry(int a) {
        try {
            /*
                вложенный try-блок
                Если используется один аргумент командной строки,  то
                следующий код будет генерировать исключение деления на нуль.
                 */
            if (a == 1)
                a = a / (a - a);  // деление на ноль
                /*
                Если используется два аргумента командной строки,
                то генерируется исключение выхода за границу массива.
                */
            if (a == 2) {
                int c[] = {1};
                c[42] = 99;
                    /*
                    генерировать исключение выхода за границу массива
                     */
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Индекс выходит за границу массива: " + e);
        }
    }
    public static void main(String[] args) {
        try {
            int a = args.length;
            /*
            Если нет аргументов командной строки,  следующий оператор будет
            генерировать исключение деления на нуль.
             */
            int b = 42 / a;
            System.out.println("a = " + a);
            nesttry(a);
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль: " + e);
        }
    }
}
