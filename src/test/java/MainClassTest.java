import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MainClassTest {


    private WebDriver driver;
    private GetNada getNada;
    private GetJson getJson;
    private SendMessage sendMessage;
    private Http http;



    @Before
    public void PreparingToTheTest(){
        System.setProperty("webdriver.chrome.driver", Configuration.CHROME_DRIVER);
        driver = new ChromeDriver();
        getNada = new GetNada(driver);
        sendMessage = new SendMessage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void GetImageSelenium() {
        getJson = new GetJson(driver);

        //getting links with Selenium
        String cat = getJson.getCat();
        String dog = getJson.getDog();
        String fox = getJson.getFox();
        String receiverEmail = getNada.rememberEmail();

        //opening gmail and switching to this window
        String newTabOpener = "window.open(\"https://mail.google.com/\",'_blank');";
        ((JavascriptExecutor)driver).executeScript(newTabOpener);
        Set<String> tab_handles = driver.getWindowHandles();
        int number_of_tabs = tab_handles.size();
        int new_tab_index = number_of_tabs-1;
        driver.switchTo().window(tab_handles.toArray()[new_tab_index].toString());
        String textToSend = sendMessage.messageText(cat,dog,fox);
        sendMessage.sendMessage(Configuration.YOUR_EMAIL,Configuration.YOUR_PASSWORD,receiverEmail,textToSend);

        //Switching back to generate Email window
        driver.switchTo().window(tab_handles.toArray()[new_tab_index-1].toString());

        //getting text of received message
        String receivedText = getNada.getText(Configuration.YOUR_EMAIL);

        //comparing text receivedText to text we send from gmail
        Assert.assertEquals(receivedText,textToSend);
        driver.quit();
    }
    @Test
    public void GetImageHttp(){
        http = new Http();
        //getting links with http request
        String cat = http.getLink("https://aws.random.cat/meow","file");
        String dog = http.getLink("https://random.dog/woof.json","url");
        String fox = http.getLink("https://randomfox.ca/floof/","image");
        String receiverEmail = getNada.rememberEmail();

        //opening gmail and switching to this window
        String a = "window.open(\"https://mail.google.com/\",'_blank');";
        ((JavascriptExecutor)driver).executeScript(a);
        Set<String> tab_handles = driver.getWindowHandles();
        int number_of_tabs = tab_handles.size();
        int new_tab_index = number_of_tabs-1;
        driver.switchTo().window(tab_handles.toArray()[new_tab_index].toString());
        String textToSend = sendMessage.messageText(cat,dog,fox);
        sendMessage.sendMessage(Configuration.YOUR_EMAIL,Configuration.YOUR_PASSWORD,receiverEmail,textToSend);

        //Switching back to generate Email window
        driver.switchTo().window(tab_handles.toArray()[new_tab_index-1].toString());

        //getting text of received message
        String receivedText = getNada.getText(Configuration.YOUR_EMAIL);

        //comparing text receivedText to text we send from gmail
        Assert.assertEquals(receivedText,textToSend);
        driver.quit();

    }


}