import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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
    private By receiverField = By.xpath("//textarea[@name=\"to\"]");
    private By emailTextField = By.xpath("//div[@aria-label=\"Message Body\"]");
    private By sendButton = By.xpath("//div[text()[contains(.,\"Send\")]][@role=\"button\"]");

    public SendMessage sendKeys(By xpath,String keys){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
        driver.findElement(xpath).sendKeys(keys);
        return this;
    }
    public SendMessage sendMessage(String email,String password,String generatedEmail,String emailText) {

        WebDriverWait wait = new WebDriverWait(driver,15);
        sendKeys(emailField,email);
        driver.findElement(confirmEmail).click();

        sendKeys(passwordField,password);
        driver.findElement(confirmPassword).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(createMessage));
        driver.findElement(createMessage).click();

        sendKeys(receiverField,generatedEmail);

        sendKeys(emailTextField,emailText);

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
