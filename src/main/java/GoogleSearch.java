import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.lang.model.element.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class GoogleSearch {
    public static void main(String[] args) throws TransformerException {
//type, clear, read
        System.setProperty("webdriver.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");

        WebDriver driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start--");


        driver.get("https://www.google.com");
        driver.getWindowHandle();
        String wordToSearch = "coding";
        WebElement element = driver.findElement(By.name("quit"));
        element.sendKeys(wordToSearch);
        element.submit();
        Element linkToSite = document.createElement("link");
        Element url = document.createElement("url");
        Element pageName = document.createElement("pageName");
        Element wordCount = document.createElement("wordCount");
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File("C:\\Users\\admin\\IdeaProjects\\Testing2PetrovAlexandru\\search.xml"));
        transformer.transform(source, result);


    }
}

