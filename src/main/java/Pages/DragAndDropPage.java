package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public class DragAndDropPage extends BasePage {

    @FindBy(xpath = "//div[@id='columns']/div")
    List<WebElement> columns;

    Actions actions = new Actions(driver);

    public DragAndDropPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ArrayList<Character> getOrderOfColumns() {

        ArrayList<Character> columnIdList = new ArrayList<>();
        for (WebElement column : columns) {
            columnIdList.add(column.findElement(By.tagName("header")).getText().toLowerCase().charAt(0));
        }
        return columnIdList;
    }

    public String checkOrderOfColumns() {
        int a, b;

        a = getOrderOfColumns().getFirst();
        b = getOrderOfColumns().getLast();

        if (a < b) {
            return "asc";
        } else if (a > b) {
            return "desc";
        } else return "error calculating order";
    }

    public void dragColumns(String col1, String col2) {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Not going to lie, ChatGPT was useful for this case.
        String script =
                "function simulateDragDrop(source, destination) { " +
                        "    var event = new DataTransfer(); " +
                        "    source.dispatchEvent(new DragEvent('dragstart', { dataTransfer: event })); " +
                        "    destination.dispatchEvent(new DragEvent('dragenter', { dataTransfer: event })); " +
                        "    destination.dispatchEvent(new DragEvent('dragover', { dataTransfer: event })); " +
                        "    destination.dispatchEvent(new DragEvent('drop', { dataTransfer: event })); " +
                        "    source.dispatchEvent(new DragEvent('dragend', { dataTransfer: event })); " +
                        "} " +
                        "simulateDragDrop(arguments[0], arguments[1]);";
        WebElement column1 = null, column2 = null;

        for (WebElement element : columns) {
            WebElement header = element.findElement(By.tagName("header"));
            String letter = header.getText().trim();

            if (letter.equalsIgnoreCase("A")) {
                column1 = element;
            } else if (letter.equalsIgnoreCase("B")) {
                column2 = element;
            } else {
                throw new IllegalStateException("Unexpected column header: " + letter);
            }
        }

        assert column1 != null;
        assert column2 != null;
        if (col1.equalsIgnoreCase("A") && col2.equalsIgnoreCase("B")) {
            js.executeScript(script, column1, column2);
        } else if (col1.equalsIgnoreCase("b") && col2.equalsIgnoreCase("a")) {
            js.executeScript(script, column1, column2);
        } else throw new IllegalStateException("Incorrect drag and drop setup");

        ((RemoteWebDriver) driver).resetInputState();
    }

}
