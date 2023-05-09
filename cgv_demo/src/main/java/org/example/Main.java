package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // ChromeDriver 위치 설정
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        
        // ChromeDriver 객체 생성
        WebDriver driver = new ChromeDriver();

        // 웹 페이지 열기
        driver.get("http://section.cgv.co.kr/theater/timetable/Default.aspx?code=0013");

//        // issue_area 클래스를 가진 div 요소 찾기 con_slider_list > ul > li:last-child
//        WebElement issueArea = driver.findElement(By.className("con_slider_list"));
//
//        // issueArea 하위에 있는 a 태그 요소 찾기
//        WebElement aTag = issueArea.findElement(By.tagName("a"));

        // CSS 셀렉터를 사용하여 요소 찾기 li:last-child
        WebElement rptDayTag = driver.findElement(By.cssSelector("div.con_slider_list > ul > li:last-child"));
        String spanText = rptDayTag.findElement(By.tagName("span")).getText();

        System.out.println(rptDayTag.toString());
        WebElement aTag = null;

//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        WebElement aTag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.con_slider_list > ul > li:last-child > a")));

        System.out.println("앙용");
        try {
            // CSS 셀렉터를 사용하여 요소 찾기
            aTag = rptDayTag.findElement(By.tagName("a"));

        } catch (NoSuchElementException e) {
            System.out.println("a 태그를 찾을 수 없습니다.");
            e.printStackTrace();
        }
//        if (aTag != null) {
//            // a 태그 클릭 이벤트 발생 이렇게 사용 불가능! 요소가 숨겨져있어서~
//            aTag.click();
//        }
        System.out.println(aTag.getAttribute("href"));
//        try {
//            Thread.sleep(500);
//        }catch (Exception e){
//
//        }

        if (aTag != null) {
            // JavaScript 코드 실행
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", aTag);
        }

        // 영화 시간표 테이블 태그 가져오기
        WebElement timeTable = driver.findElement(By.cssSelector(".movie_time_table > tbody"));

        // 각 행의 정보 출력
        List<WebElement> movieRows = timeTable.findElements(By.tagName("tr"));
        try {
        for (WebElement movieRow : movieRows) {
            List<WebElement> movieData = movieRow.findElements(By.tagName("td"));
            for (WebElement data : movieData) {
//                List<WebElement> movieRows = timeTable.findElements(By.tagName("tr"));
                WebElement s = data.findElement(By.cssSelector(".movie_time_table > tbody"));
//                WebElement rptDayTag = driver.findElement(By.cssSelector("div.con_slider_list > ul > li:last-child"));
//                String spanText = rptDayTag.findElement(By.tagName("span")).getText();


//                aTag = rptDayTag.findElement(By.tagName("a")))
//                System.out.print(new String(data.getText().getBytes(StandardCharsets.UTF_8), "EUC-KR") + "\t");

                byte[] utf8Bytes = data.getText().getBytes(StandardCharsets.UTF_8);
//
//                System.out.println(utf8Bytes + "\t");

                String utf8Str = new String(utf8Bytes, StandardCharsets.UTF_8);
                System.out.print(utf8Str + "\t");

            }
            System.out.println();
        }
        }catch(Exception e){

        }
//        // 웹 드라이버 종료
//        driver.quit();
    }
}

