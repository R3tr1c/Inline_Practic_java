import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner inp_scan = new Scanner(System.in);
    System.out.print("Выбор практической работы (номер): ");
    int pract_num = inp_scan.nextInt();

    switch (pract_num - 1) {
        case 0:
            C_date.d_functions();
            break;
        default:

            break;
    }
//    System.out.printf("Тест принятия кода практической: %d \n", pract_num);
    inp_scan.close();
    }
}
