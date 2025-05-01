package kr.kh.spring2.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {//실제로 사용할 메소드는 업로드파일 딜리트파일 뿐...

	
	/**
	 * 파일을 업로드하는 메소드
	 * @param uploadPath 업로드할 경로
	 * @param originalName 실제 파일명
	 * @param fileData	업로드할 파일의 실제데이터
	 * @return	업로드된 경로 및 UUID가 포함된 파일명
	 * @throws Exception
	 */	
    public static String uploadFile(String uploadPath, String originalName, byte[]
            fileData)throws Exception{
    	
    	// 두 회원이 같은 이름의 파일을 업로드해서 충돌 생기면x -> 파일에 uuid(유니버셜 유니크 아이덴티파이어,범용 고유 식별자)를 부여해서 이름 앞에 붙여줌.
    	// UUID는 16 옥텟(128비트)의 수이다. 표준형식에서 UUID는 32개의 십육진수로 표현되며 총 36개 문자(32개 문자와 4개의 하이픈)로 된 8-4-4-4-12라는 5개의 그룹을 하이픈으로 구분
        UUID uid = UUID.randomUUID();
        String savedName = uid.toString() +"_" + originalName;
        String savedPath = calcPath(uploadPath);	//uploadpath : 실제 파일 공간, savedpath : 날짜별 등으로 파일 따로 관리하기 위해
        											//날짜를 이용하여 폴더를 생성해서 관리 2025폴더->03폴더->26폴더 경로 리턴
        File target = new File(uploadPath + savedPath, savedName);
        //업로드할 파일 데이터를 이용하여 복사를 진행
        FileCopyUtils.copy(fileData, target);
        //날짜폴더와 업로드된 파일명이 있는 문자열을 가져옴	\\대신 / 로 변환
        String uploadFileName = getFileName(savedPath, savedName);
        return uploadFileName;
    }

    private static String calcPath(String uploadPath) {
    	//현재 시간을 캘린더 객체로 가져옴(date 말고 calendar 쓰는 이유는 년-월-일 추출하기가 쉬워서)
        Calendar cal = Calendar.getInstance();

        //년을 추출해서 앞에 구분자를 추가.	\\2025
        //File.seperator : 폴더와 폴더 사이를 구분하는 문자열.(윈도우에선 \인데 리눅스 같은데선 /라서 이걸로 운영체제 맞춰 가져와야함)
        String yearPath = File.separator+cal.get(Calendar.YEAR);
        //년과 월을 추출해서 앞에 구분자를 추가.	\\2025\\03
        String monthPath = yearPath + File.separator
            + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
        // \\2025\\03\\26 문자열
        String datePath = monthPath + File.separator
            + new DecimalFormat("00").format(cal.get(Calendar.DATE));
        
        makeDir(uploadPath, yearPath, monthPath, datePath);// 연 월 일로 폴더 생성

        return datePath;	//해당 폴더 위치 문자열로 반환

    }
    /**
     * uploadPath 안에 paths 폴더들이 없으면 생성하는 메소드
     * @param uploadPath	폴더들을 만들어줄 경로
     * @param paths			만들어줄 폴더명
     */
    private static void makeDir(String uploadPath, String... paths) {
    	//해당 일 폴더가 있으면 년,월,일 폴더 만들 필요 x ->체크(몇개올지 몰라서 가변매개변수로)
        if(new File(uploadPath + paths[paths.length-1]).exists())//해당 폴더가 존재하면
            return;//리턴
        for(String path : paths) {	//경로들마다 체크해서
            File dirPath = new File(uploadPath + path);		//있는지 확인
            if( !dirPath.exists())
                dirPath.mkdir();			//기존하는 mkdir 명령어를 활용한 메소드(폴더를 만드는 명령어)
        }
    }
    
    private static String getFileName(String path, String fileName)
            throws Exception{
    	// \\2025\\03\\26\\uuid_파일명.확장자
        String iconName = path + File.separator + fileName;
        // /2025/03/26/uuid_파일명.확장자 ->데이터베이스에는 이 경로로 
        return iconName.replace(File.separatorChar, '/');
    }
    
    public static void deleteFile(String uploadPath, String fi_name) {
        // /2025/03/26/uuid_파일명.확장자 -> \\2025\\03\\26\\uuid_파일명.확장자 로 변환
    	fi_name = fi_name.replace('/', File.separatorChar);
		File file = new File(uploadPath + fi_name);
		//해당 파일이 존재하면 파일을 삭제
		if(file.exists()) {
				file.delete();
		}
    }
	
    public static String uploadFileToFolder(String uploadPath, String folder, String originalName, byte[] fileData) throws Exception{ 	//위에서 uploadFile 복붙... 날짜별 말고 파일별로 관리
    	
        //UUID uid = UUID.randomUUID();
    	
    	if(!folder.startsWith("\\")) {
    		folder = "\\" + folder;
    	}
        String savedName = originalName;
        makeDir(uploadPath, folder);
        String savedPath = "/" + folder;

        //서버에서 업로드 경로와 날짜 경로를 이용하여 빈 파일을 생성
        File target = new File(uploadPath + savedPath, savedName);
        //업로드할 파일 데이터를 이용하여 복사를 진행
        FileCopyUtils.copy(fileData, target);
        //날짜폴더와 업로드된 파일명이 있는 문자열을 가져옴	\\대신 / 로 변환
        String uploadFileName = getFileName(savedPath, savedName);
        
        return uploadFileName;
    }
}