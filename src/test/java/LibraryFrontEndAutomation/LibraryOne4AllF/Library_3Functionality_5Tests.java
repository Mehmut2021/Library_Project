package LibraryFrontEndAutomation.LibraryOne4AllF;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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

        driver.findElement(By.name("full_name")).sendKeys("Zeck Dar");

        driver.findElement(By.name("password")).sendKeys("ZDD" + i);

        driver.findElement(By.name("email")).sendKeys("ZDDD" + i + "@gmail.com");

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

        if (verifyName.equals("Zeck Dar") && verifyEmail.equals("ZDDD" + i + "@gmail.com")) {
            System.out.println("New user added successfully and verified !");
        } else {
            System.out.println("New user was not found, verification failed !!");
        }


        i++;
    }

    @Test
    public void TestNewBook() throws InterruptedException {

        driver.get("http://library2.cybertekschool.com/login.html");
        //enter email and password:
        WebElement LogInBox = driver.findElement(By.id("inputEmail"));
        LogInBox.sendKeys("librarian14@library");

        WebElement PassBox = driver.findElement(By.id("inputPassword"));
        PassBox.sendKeys("Sdet2022*");

        WebElement SignInBtn = driver.findElement(By.tagName("button"));
        SignInBtn.submit();
        System.out.println("LoggedIn");


        WebElement Books = driver.findElement(By.xpath("//span[.='Books']"));
        System.out.println("Books.getText() = " + Books.getText());
        Books.click();

        WebElement addBook = driver.findElement(By.xpath("//section[@id=\"books\"]//span/a"));
        addBook.click();

        WebElement Name = driver.findElement(By.name("name"));
        Name.sendKeys("History in the making");


        WebElement ISBN = driver.findElement(By.name("isbn"));
        ISBN.sendKeys("222111000");

        WebElement Year = driver.findElement(By.name("year"));
        Year.sendKeys("2022");

        WebElement author = driver.findElement(By.xpath("//input[@name='author']"));
        author.sendKeys("Alax Mohan");

        WebElement Category = driver.findElement(By.id("book_group_id"));

        Select selectBook = new Select(Category);
        selectBook.selectByVisibleText("Essay");
        //selectBook.selectByIndex();
        //selectBook.selectByValue("18");

        WebElement description = driver.findElement(By.xpath("//textarea"));
        description.sendKeys("History of 21st century");


        WebElement saveChangesBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        saveChangesBtn.submit();

        Thread.sleep(2000);
        WebElement search = driver.findElement(By.tagName("input")); //className==form-control input-sm input-small input-inline
        search.sendKeys("Alax");

        Thread.sleep(5000);
        WebElement verified = driver.findElement(By.xpath("//tr[1]//td[.='Alax Mohan']"));
        Assertions.assertEquals("Alax Mohan", verified.getText());
        System.out.println("New Book author: verified.getText() = " + verified.getText());
        System.out.println("new book verified");

        Thread.sleep(3000);



    }
}

