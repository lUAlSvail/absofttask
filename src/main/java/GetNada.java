import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class GetNada {

    private WebDriver driver;

    public GetNada(WebDriver driver) {
        this.driver = driver;
    }

    private By generatedEmail = By.xpath("//h1//span[@class=\"address what_to_copy\"]");
    private String email = "//div[text()[contains(.,\"%s\")]]";
    private By textOfMessage = By.xpath("//div[@dir=\"ltr\"]");
    private By screenCat = By.xpath("//body/div[@dir=\"ltr\"]//a[@target=\"_blank\"]");
    private By screenDog = By.xpath("//body/div[@dir=\"ltr\"]//a[@target=\"_blank\"]/following-sibling::div[1]");
    private By screenFox = By.xpath("//body/div[@dir=\"ltr\"]//a[@target=\"_blank\"]/following-sibling::div[2]/a");
    public  String rememberEmail() {
        driver.get("https://getnada.com/");
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(generatedEmail));
        String Email = driver.findElement(generatedEmail).getText();
        return Email;
    }
    public String getText(String emailOfSender){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath((String.format(email, emailOfSender)))));
        driver.findElement(By.xpath(String.format(email, emailOfSender))).click();
        driver.switchTo().frame("idIframe");
        wait.until(ExpectedConditions.presenceOfElementLocated(textOfMessage));
        String Email = driver.findElement(textOfMessage).getText();

        driver.findElement(screenCat).click();
        driver.findElement(screenDog).click();
        driver.findElement(screenFox).click();

        Set<String> tab_handles = driver.getWindowHandles();
        int number_of_tabs = tab_handles.size();
        int new_tab_index = number_of_tabs-1;
        System.out.println(new_tab_index);
        driver.switchTo().window(tab_handles.toArray()[new_tab_index].toString());
        File screenshotCat = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        driver.switchTo().window(tab_handles.toArray()[new_tab_index-1].toString());
        File screenshotDog = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        driver.switchTo().window(tab_handles.toArray()[new_tab_index-2].toString());
        File screenshotFox = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshotCat,new File(Configuration.CAT));
            FileUtils.copyFile(screenshotDog,new File(Configuration.DOG));
            FileUtils.copyFile(screenshotFox,new File(Configuration.FOX));
        } catch (IOException e) {
            e.printStackTrace();
        }


        return Email;
    }



}
