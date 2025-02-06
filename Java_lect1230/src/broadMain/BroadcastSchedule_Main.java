package broadMain;

import java.util.List;

public class BroadcastSchedule_Main {
    private static final ScheduleManager scheduleManager = new ScheduleManager();

    public static void main(String[] args) {
        loadData();
        runMainMenu();
        saveData();
    }

    private static void loadData() {
        scheduleManager.getCompanies().addAll((List<Company>) FileHandler.load("companies.dat"));
    }

    private static void saveData() {
        FileHandler.save("companies.dat", scheduleManager.getCompanies());
    }

    private static void runMainMenu() {
        String menu;
        do {
            ConsoleUI.printMenu("로그인", "로그인 없이 편성표 조회", "회원가입", "세이브 후 종료");
            menu = ConsoleUI.getInput("메뉴 입력: ");

            switch (menu) {
                case "1":
                    login();
                    break;
                case "2":
                    scheduleManager.printAllSchedules();
                    break;
                case "3":
                    signUp();
                    break;
                case "4":
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        } while (true);
    }

    private static void login() {
        String id = ConsoleUI.getInput("아이디 입력: ");
        System.out.println(id + "님이 로그인하셨습니다.");
        // 로그인 로직 추가 가능
    }

    private static void signUp() {
        String id = ConsoleUI.getInput("새 아이디 입력: ");
        System.out.println(id + "님이 회원가입하셨습니다.");
        // 회원가입 로직 추가 가능
    }
}
