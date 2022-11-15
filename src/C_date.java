import java.util.Scanner;
import java.util.regex.Pattern;

//Выберите метод (0 для выхода):
//1)Определить день недели;
//2)Число дней в месяце (+ проверка на високосность);
//3)
// Выберите входные данные [введите 0 для возврата] :\n1) Текущая дата;\n2) Ввод с клавиатуры;"
public class C_date {
    public static int d_week_d_num (int inp_day, int inp_month, int inp_year) {
        int month_trans = inp_month + 10, year_trans = inp_year;
        if (month_trans > 12){
            month_trans -= 12;
        }
        if (month_trans == 11 || month_trans == 12){
            year_trans--;
        }
        int day_of_week =  ( inp_day + (int)(Math.floor((13 * month_trans-1)/5)) + year_trans +
                             (int)(Math.floor(year_trans / 4)) -  (int)(Math.floor(year_trans / 100)) +
                             (int)(Math.floor(year_trans/400)) ) % 7;
        System.out.print("\nДень недели: ");
        switch (day_of_week) {
            case 0 -> System.out.println("воскресенье.\n");
            case 1 -> System.out.println("понедельник.\n");
            case 2 -> System.out.println("вторник.\n");
            case 3 -> System.out.println("среда.\n");
            case 4 -> System.out.println("четверг.\n");
            case 5 -> System.out.println("пятница.\n");
            case 6 -> System.out.println("суббота.\n");
            default -> {System.out.println("ошибка расчета.\n");
                        return 212;}
        }
        return 211;
    }
    public static int day_count (int inp_month, boolean inp_leap_y) {
        int[] day_list = { 28, 29, 30, 31 };
        int curr_day_count = 0;

        switch (inp_month){
            case 2:
                if (!inp_leap_y) { curr_day_count = day_list[0]; }
                else            { curr_day_count = day_list[1]; }
                break;
            case 4, 6, 9, 11:
                curr_day_count = day_list[2];
                break;
            case 1, 3, 5, 7, 8, 10, 12:
                curr_day_count = day_list[3];
                break;
        }
        System.out.printf("\nОбщее количество дней в месяце: %d", curr_day_count);
        System.out.println("\n");
        return 221;
    }
    public static int date_format(int inp_day, int inp_month, int inp_year){
        int chsd_pattern = 0;
        String corr_year, corr_month, corr_day;
        System.out.println("Выберите шаблон из представленных далее[введите 0 для возврата к выбору функции]:\n1) YYYY-MM-DD;\n2) YY-MM-DD;\n");
        Scanner set_pattern = new Scanner(System.in);
        chsd_pattern = set_pattern.nextInt();
        if ((chsd_pattern - 1) == -1 ){
            System.out.println("Возврат...");
            return 331;
        } else if ((chsd_pattern - 1) == 0 || (chsd_pattern - 1) == 1) {
            corr_year = Integer.toString(inp_year);
            corr_month = Integer.toString(inp_month);
            corr_day = Integer.toString(inp_day);
            if (corr_month.length() == 1){ corr_month = "0" + corr_month;  }
            if (corr_day.length() == 1){ corr_day = "0" + corr_day;  }
            if ((chsd_pattern - 1) == 0) { while (corr_year.length() < 4){ corr_year = "0" + corr_year; } }
            else { if (corr_year.length() < 2) { corr_year = "0" + corr_year; }
                   else if (corr_year.length() > 2) { while (corr_year.length() != 2) { corr_year = corr_year.substring(1); } }}
            System.out.println("Результат: " + corr_year + "-" + corr_month + "-" + corr_day + "\n");
        }
        return 331;
    }
    public static int d_functions () {
        int m_return = 1, fm_return = 0, check_back = 99, day = 0, month = 0, year = 0, mode = 0;
        String inp_str_date;
        boolean check_str_dat = false, check_leap_y = false;
        Pattern inp_dat_pat = Pattern.compile("^\\d{2}\\W\\d{2}\\W\\d{4}$", Pattern.CASE_INSENSITIVE);
        System.out.println("\nПрактическая работа №1.");
        Scanner mode_inp = new Scanner(System.in);
        System.out.println("\n");
        while (fm_return == 0 || fm_return == 211 || fm_return == 221 || fm_return == 331) {
            System.out.println("Введите дату в начальном формате dd.mm.yyyy [введите 0 для возврата]: ");
            inp_str_date = mode_inp.next();
            check_back = Integer.parseInt(inp_str_date.substring(0,1));
            if (check_back == 0 && inp_str_date.length() == 1) {
                System.out.println("Возврат...");
                fm_return = 99;
                break;
            }
            check_str_dat = Pattern.matches(inp_dat_pat.pattern(), inp_str_date);
            if (check_str_dat && inp_str_date.charAt(2) == '.' && inp_str_date.charAt(5) == '.') {
                day = Integer.parseInt(inp_str_date.substring(0, 2));
                month = Integer.parseInt(inp_str_date.substring(3, 5));
                year = Integer.parseInt(inp_str_date.substring(6));
                if (((day > 0 && day < 32) && (month > 0 && month < 13) && (year > 0))) {
                    check_leap_y = year % 4 == 0 && (year % 400 == 0 || year % 100 != 0);
                    if (check_leap_y) { System.out.println("\nГод: високосный.\n");}
                    else              { System.out.println("\nГод: не-високосный.\n"); }
                    if (month == 2 && day == 29 && !check_leap_y){
                        System.out.println("Проверка: дата некорректна.\nСкорректируйте введенную дату!\n");
                        continue;
                    }

                    while (mode - 1 == -1 || mode - 1 == 0 || mode - 1 == 1 || mode - 1 == 2 ) {
                        System.out.println("Выберите функцию [введите 0 для возврата к вводу даты]:\n1) Определить день недели;\n2) Число дней в месяце;\n3) Форматирование выбранной даты;");
                        mode = mode_inp.nextInt();
                        if (mode - 1 == -1) { break; }
                        switch (mode - 1) {
                            case 0 -> fm_return = C_date.d_week_d_num(day, month, year);
                            case 1 -> fm_return = C_date.day_count(month, check_leap_y);
                            case 2 -> fm_return = C_date.date_format(day, month, year);
                            default -> System.out.println("Ошибка выбора функции! Попробуйте еще раз.");
                        }
                        if (fm_return == 212) {
                            System.out.println("Ошибка в функции расчета дня недели!");
                            break;
                        }
                    }
                } else {
                    System.out.println("Ошибка введенной даты! Попробуйте еще раз.");
                }
            } else {
                System.out.println("Ошибка формата введенной даты! Попробуйте еще раз.");
            }
        }
        return m_return;
    }

}
