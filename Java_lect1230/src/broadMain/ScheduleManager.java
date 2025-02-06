package broadMain;

import java.util.ArrayList;
import java.util.List;

public class ScheduleManager {
    private List<Company> companies = new ArrayList<>();

    public void addCompany(String name) {
        if (companies.stream().anyMatch(c -> c.getCompanyName().equals(name))) {
            System.out.println("이미 존재하는 방송사입니다.");
            return;
        }
        companies.add(new Company(name));
        System.out.println(name + " 방송사가 추가되었습니다.");
    }

    public void removeCompany(String name) {
        companies.removeIf(c -> c.getCompanyName().equals(name));
        System.out.println(name + " 방송사가 삭제되었습니다.");
    }

    public void addTimeTable(String companyName, TimeTable timeTable) {
        companies.stream()
            .filter(c -> c.getCompanyName().equals(companyName))
            .findFirst()
            .ifPresentOrElse(
                c -> c.getList().add(timeTable),
                () -> System.out.println("해당 방송사를 찾을 수 없습니다.")
            );
    }

    public void printAllSchedules() {
      //  companies.forEach(Company::printAll);
    }

    public List<Company> getCompanies() {
        return companies;
    }
}
