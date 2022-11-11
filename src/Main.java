
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int m_return = 0;
        Scanner inp_scan = new Scanner(System.in);
        System.out.println("Некое приветствие?");
        int pract_num = 0;
        System.out.println();
        while (true) {
            if (m_return != 0){ break; }
            System.out.println("Выбор практической работы (номер) [введите 0 для выхода]:");
            pract_num = inp_scan.nextInt();
            switch (pract_num - 1) {
                case -1:
                    System.out.println("Выход...");
                    m_return = 99;
                    break;
                case 0:
                    m_return = C_date.d_functions();
                    break;
                default:
                    System.out.println("Ошибка ввода! Попробуйте еще.");
//                    inp_scan.next();
                    break;
            }
//    System.out.printf("Тест принятия кода практической: %d \n", pract_num);
//            inp_scan.close();
        }
    }
}
