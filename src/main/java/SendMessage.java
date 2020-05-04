import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class SendMessage {
    private WebDriver driver;

    public SendMessage(WebDriver driver) {
        this.driver = driver;
    }
    private By emailField = By.xpath("//input[@type=\"email\"]");
    private By confirmEmail = By.xpath("//div[@id=\"identifierNext\"]");
    private By passwordField = By.xpath("//input[@type=\"password\"][@name=\"password\"]");
    private By confirmPassword = By.xpath("//div[@id=\"passwordNext\"]");
    private By createMessage = By.xpath("//div[@gh=\"cm\"]");
    private By receiverField = By.xpath("//textarea[@id=\":9k\"]");
    private By emailTextField = By.xpath("//div[@id=\":a7\"]");
    private By sendButton = By.xpath("//div[@id=\":8s\"]");

    public SendMessage sendMessage(String email,String password,String generatedEmail,String emailText) {

        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.presenceOfElementLocated(emailField));
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(confirmEmail).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPassword).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(createMessage));
        driver.findElement(createMessage).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(receiverField));
        driver.findElement(receiverField).sendKeys(generatedEmail);

        wait.until(ExpectedConditions.presenceOfElementLocated(emailTextField));
        driver.findElement(emailTextField).sendKeys(emailText);

        wait.until(ExpectedConditions.presenceOfElementLocated(sendButton));
        driver.findElement(sendButton).click();






        return this;
    }
    public String messageText(String cat,String dog,String fox){
        String textMessage = cat+"   -  link for cat image\n" +dog +"   -  link for dog image\n"
                +fox+"   -  link for fox image";
        return textMessage;

    }

}
