import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

//Выберите метод (0 для выхода):
//1)Определить день недели;
//2)Число дней в месяце (+ проверка на високосность);
//3)
// Выберите входные данные [введите 0 для возврата] :\n1) Текущая дата;\n2) Ввод с клавиатуры;"
public class C_date {
    private static Date inp_date = new Date();
    private static Date get_inp_date() {
        return inp_date;
    }
    private static void set_inp_date(Date inp_date) {
        C_date.inp_date = inp_date;
    }
    public static void d_week_d_num () {

    }
    public static void day_count () {

    }
    public static void date_format(){

    }
    public static int d_functions () {
        int m_return = 1, fm_return = 0, mode = 0, day = 0, month = 0, year = 0;
//        char[] tmp_dat;
        String inp_str_dat;
        boolean check_str_dat = false;
        Pattern inp_dat_pat = Pattern.compile("^\\d{2}\\W\\d{2}\\W\\d{4}$", Pattern.CASE_INSENSITIVE);
        System.out.println("Практическая работа №1.");
        Scanner mode_inp = new Scanner(System.in);
        System.out.println();
        while (fm_return == 0) {
            System.out.println("Выберите входные данные [введите 0 для возврата] :\n1) Текущая дата;\n2) Ввод с клавиатуры;");
            mode = mode_inp.nextInt();
            switch (mode - 1) {
                case -1 -> {
                    System.out.println("Возврат...");
                    fm_return = 99;
                }
                case 1 -> {
                    System.out.println("Введите дату в начальном формате dd.mm.yyyy: ");
                    inp_str_dat = mode_inp.next();
                    check_str_dat = Pattern.matches(inp_dat_pat.pattern(), inp_str_dat);
                    if (check_str_dat && inp_str_dat.charAt(2) == '.' && inp_str_dat.charAt(5) == '.') {
                        day = Integer.parseInt(inp_str_dat.substring(0, 2));
                        month = Integer.parseInt(inp_str_dat.substring(3, 5));
                        year = Integer.parseInt(inp_str_dat.substring(6));
                        if (((day > 0 && day < 32) && (month > 0 && month < 13) && (year > 0))) {

                        } else {
                            System.out.println("Ошибка введенной даты!");
                        }
                    } else {
                        System.out.println("Ошибка формата введенной даты!");
                    }
                }
                default -> System.out.println("Ошибка ввода! Попробуйте еще.");
            }
        }
//        mode_inp.close();
        return m_return;
    }

}
