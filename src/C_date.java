import java.util.Date;
import java.util.Scanner;

//Выберите метод (0 для выхода):
//1)Определить день недели;
//2)Число дней в месяце (+ проверка на високосность);
//3)
public class C_date {
    private Date inp_date = new Date();
    public static void d_week_d_num () {

    }
    public static void day_count () {

    }
    public static int d_functions () {
        int m_return = 1, mode = 0;
        System.out.println("Практическая работа №1. Выберите входные данные:\n1) Текущая дата;\n2) Ввод с клавиатуры;");
        Scanner mode_inp = new Scanner(System.in);
        mode = mode_inp.nextInt();
        switch (mode - 1){
            case 0:
                break;
            case 1:
                break;
            default:
                break;
        }
        mode_inp.close();
        return m_return;
    }
}
