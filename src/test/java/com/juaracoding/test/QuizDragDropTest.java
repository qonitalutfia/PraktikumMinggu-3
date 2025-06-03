package com.juaracoding.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

// import java.time.Duration;

public class QuizDragDropTest extends BaseTest{

    WebDriver driver;

    @BeforeClass
    @Parameters({ "url" })
    public void init(String url) {
        driver = DriverSingleton.createOrGetDriver();
        driver.get(url);
    }

    private void dragable(String idDrag, String idDrop) {
        WebElement draggable = driver.findElement(By.id(idDrag));
        WebElement drop = driver.findElement(By.id(idDrop));
        Actions builder = new Actions(driver);
        builder.dragAndDrop(draggable, drop).perform();

    }

    @Test
    public void ujian3Test() throws InterruptedException {

        String[][] keyElements = {
                {"box1", "box101"},
                {"box2", "box102"},
                {"box3", "box103"},
                {"box4", "box104"},
                {"box5", "box105"},
                {"box6", "box106"},
                {"box7", "box107"},
        };

        ScreenshotHelper.takeScreenshot("ujianpraktikminggu-3_before.png", driver);

        for (int row = 0; row < keyElements.length; row++) {
            dragable(keyElements[row][0], keyElements[row][1]);
            Thread.sleep(2000);
        }

        ScreenshotHelper.takeScreenshot("ujianpraktikminggu-3_after.png", driver);

        for (String[] pair : keyElements) {
            dragable(pair[0], "dropContent"); // "dropContent" = ID div kiri
            Thread.sleep(1000);
        }

        ScreenshotHelper.takeScreenshot("ujianpraktikminggu-3_back.png", driver);
    }

}
