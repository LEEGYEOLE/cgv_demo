//package org.example;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class Main {
//
//    public static void main(String[] args) {
//        // ChromeDriver 위치 설정
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
//
//        // ChromeDriver 객체 생성
//        WebDriver driver = new ChromeDriver();
//
//        // 웹 페이지 열기
//        driver.get("http://section.cgv.co.kr/theater/timetable/Default.aspx?code=0013");
//
//
//        // CSS 셀렉터를 사용하여 요소 찾기
//        WebElement rptDayTag = driver.findElement(By.cssSelector("div.con_slider_list > ul > li:last-child"));
//        String spanText = rptDayTag.findElement(By.tagName("span")).getText();
//
//        System.out.println(rptDayTag.toString());
//        WebElement aTag = null;
//
//        try {
//            // CSS 셀렉터를 사용하여 요소 찾기
//            aTag = rptDayTag.findElement(By.tagName("a"));
//
//        } catch (NoSuchElementException e) {
//            System.out.println("a 태그를 찾을 수 없습니다.");
//            e.printStackTrace();
//        }
//        if (aTag != null) {
//            // a 태그 클릭 이벤트 발생
//            aTag.click();
//        }
//        System.out.println(aTag.getAttribute("id"));
//
//        // 영화 시간표 테이블 태그 가져오기
////        WebElement timeTable = driver.findElement(By.cssSelector(".movie_time_table > tbody"));
////        System.out.println(timeTable.toString());
//
////        // 웹 드라이버 종료
////        driver.quit();
//    }
//}
//
