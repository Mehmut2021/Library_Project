package LibraryFrontEndAutomation.LibraryOne4AllF;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Library_3Functionality_5Tests extends Driver {


    @Test
    public void LibraryLogInSuccessfully() {
        driver.get("http://library2.cybertekschool.com/login.html");
        //enter email and password:
        WebElement LogInBox = driver.findElement(By.id("inputEmail"));
        LogInBox.sendKeys("librarian14@library");

        WebElement PassBox = driver.findElement(By.id("inputPassword"));
        PassBox.sendKeys("Sdet2022*");

        WebElement SignInBtn = driver.findElement(By.tagName("button"));
        SignInBtn.submit();

        WebElement module1 = driver.findElement(By.xpath("//span[.='Dashboard']"));

        WebElement module2 = driver.findElement(By.xpath("//span[.='Users']"));

        WebElement module3 = driver.findElement(By.xpath("//span[.='Books']"));

        if (module1.getText().equals("Dashboard") && module2.getText().equals("Users") && module3.getText().equals("Books")){
            System.out.println("LogIn function Validated");
        }else {
            System.out.println("LogIn function not validated");
        }

        System.out.println("Test 1, Case 1 passes");

    }

    @Test
    public void StudentLogInSuccessfully() {
        driver.get("http://library2.cybertekschool.com/login.html");
        //enter email and password:
        WebElement LogInBox = driver.findElement(By.id("inputEmail"));
        LogInBox.sendKeys("student30@library");

        WebElement PassBox = driver.findElement(By.id("inputPassword"));
        PassBox.sendKeys("Sdet2022*");

        WebElement SignInBtn = driver.findElement(By.tagName("button"));
        SignInBtn.submit();

        WebElement module1 = driver.findElement(By.xpath("//span[.='Books']"));
        assertEquals("Books", module1.getText()); //why not printing assertion???

        WebElement module2 = driver.findElement(By.xpath("//span[.='Borrowing Books']"));

        if (module1.getText().equals("Books") && module2.getText().equals("Borrowing Books")){
            System.out.println("LogIn function Validated");
        }else {
            System.out.println("LogIn function not validated");
        }
        System.out.println("Test 1, Case 2 passes");
    }

    @Test
    public void LibraryLogInFail() throws InterruptedException {
        driver.get("http://library2.cybertekschool.com/login.html");

        WebElement LogInBox = driver.findElement(By.id("inputEmail"));
        LogInBox.sendKeys("maxwell@gmail.com");
        //LogInBox.sendKeys("librarian14@library");

        WebElement PassBox = driver.findElement(By.id("inputPassword"));
        PassBox.sendKeys("Maxwell111");
        //PassBox.sendKeys("Sdet2022*");

        WebElement SignInBtn = driver.findElement(By.tagName("button"));
        SignInBtn.submit();

        WebElement FailMessage = driver.findElement(By.xpath("//div[.='Sorry, Wrong Email or Password']"));

        System.out.println("Message after failure to login = " + FailMessage.getText());
        assertTrue(FailMessage.getText().equals("Sorry, Wrong Email or Password"));

        if (FailMessage.getText().equals("Sorry, Wrong Email or Password")){
            System.out.println("Error message validated");
        }else {
            System.out.println("not validated");
        }
        System.out.println("Test 1, Case 3 passes");
        Thread.sleep(5000);

    }

    @Test
    public void addNewUser() throws InterruptedException {
        int i = 1;
        driver.get("http://library2.cybertekschool.com/login.html");
        //enter email and password:
        driver.findElement(By.id("inputEmail")).sendKeys("librarian14@library");

        driver.findElement(By.id("inputPassword")).sendKeys("Sdet2022*");

        driver.findElement(By.tagName("button")).submit();
        driver.getTitle();

        driver.findElement(By.xpath("//span[.='Users']")).click(); //user module

        driver.findElement(By.xpath("//span//i[@class='fa fa-plus']")).click(); // add user button

        driver.findElement(By.name("full_name")).sendKeys("Dickzy Dar");

        driver.findElement(By.name("password")).sendKeys("DDD" + i);

        driver.findElement(By.name("email")).sendKeys("DDDD" + i + "@gmail.com");

        driver.findElement(By.xpath("//select[@id='user_group_id']")).click();//User Group

        driver.findElement(By.xpath("//select[@id= 'user_group_id']//option[@value='3']")).click();//Students

        //driver.findElement(By.xpath("//*[@id=\"user_group_id\"]/option[1]")).click();
        driver.findElement(By.xpath("//div[@class='col-6']//select[@id='status']")).click();//Status
        driver.findElement(By.xpath("//div[@class='col-6']//select[@id='status']/option[.='ACTIVE']")).click();//Active

        // WebElement StartDate = driver.findElement(By.xpath("//div//input[@name='start_date']"));
        // StartDate.sendKeys("2021-09-10");

        // WebElement EndDate = driver.findElement(By.xpath("//div//input[@name='end_date']"));
        //EndDate.sendKeys("2023-09-15");


        driver.findElement(By.id("address")).sendKeys("CyberTekSchool apartment 110, C1B3DF");

        driver.findElement(By.xpath("//form//button[@type='submit']")).submit();

        driver.findElement(By.xpath("//div[@id='tbl_users_filter']//input")).sendKeys("Dicky"); //search

        WebElement verifyName = driver.findElement(By.xpath("//tr[1]//td[3]")); //verify user name
        WebElement verifyEmail = driver.findElement(By.xpath("//tr[1]/td[4]"));//verify suer email

        if (verifyName.equals("Dickzy Dar") && verifyEmail.equals("DDDD" + i + "@gmail.com")) {
            System.out.println("New user added successfully and verified !");
        } else {
            System.out.println("New user was not found, verification failed !!");
        }


        i++;


    }
}

