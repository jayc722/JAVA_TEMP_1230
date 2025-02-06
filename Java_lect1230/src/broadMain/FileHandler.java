package broadMain;

import java.io.*;

public class FileHandler {
    public static void save(String fileName, Object obj) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(obj);
            System.out.println(fileName + " 저장 완료");
        } catch (IOException e) {
            System.out.println(fileName + " 저장 실패: " + e.getMessage());
        }
    }

    public static Object load(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println(fileName + " 파일이 존재하지 않습니다.");
        } catch (Exception e) {
            System.out.println(fileName + " 불러오기 실패: " + e.getMessage());
        }
        return null;
    }
}
