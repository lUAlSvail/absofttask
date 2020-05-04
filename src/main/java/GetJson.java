
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class GetJson {
    private WebDriver driver;

    public GetJson(WebDriver driver) {
        this.driver = driver;
    }
    private By json = By.xpath("//pre");

    public String getFox() {
        driver.get("https://randomfox.ca/floof/");
        JSONObject jsonObj = new JSONObject(driver.findElement(json).getText());
        String image = (String) jsonObj.get("image");
        return image;
    }
    public String getDog() {
        driver.get("https://random.dog/woof.json");
        JSONObject jsonObj = new JSONObject(driver.findElement(json).getText());
        String image = (String) jsonObj.get("url");
        return image ;
    }
    public String getCat() {
        driver.get("https://aws.random.cat/meow");
        JSONObject jsonObj = new JSONObject(driver.findElement(json).getText());
        String image = (String) jsonObj.get("file");
        return image;
    }
}
