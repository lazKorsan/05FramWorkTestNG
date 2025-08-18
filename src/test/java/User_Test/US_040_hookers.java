package User_Test;

import Pages.LFCPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import utilities.*;

public class US_040_hookers {
    LFCPages lfcPages = new LFCPages();
    //Bir yönetici olarak,
    // yeni bir aşı ekleyebilmeli ve
    // bu aşıyı mevcut aşılar listesine kaydedebilmeliyim.

    @Test
    public void hk1_(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        lfcPages.signInButton.click();
        lfcPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        lfcPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        lfcPages.loginPageSigInButton.click();

        lfcPages.accountButton.click();

        lfcPages.dashBoard.click();
        ReusableMethods.bekle(2);

        System.out.println("roles locaters");
        WebElement roles = Driver.getDriver().findElement(By.xpath("//span[text()='Roles']")) ;
        XPathGenerator.printXpathFormulas(roles);
        System.out.println("subRoles locaters");

        WebElement subRolesButton = Driver.getDriver().findElement(By.xpath("//a[@href='https://qa.loyalfriendcare.com/Dashboard/Roles']")) ;
        XPathGenerator.printXpathFormulas(subRolesButton);

        System.out.println("createRolesButton");
        WebElement createRolesButton = Driver.getDriver().findElement(By.xpath("//a[@href='https://qa.loyalfriendcare.com/Dashboard/Roles/create']")) ;
        XPathGenerator.printXpathFormulas(createRolesButton);
        System.out.println("<--============"+createRolesButton+"=========== -->");



        System.out.println("usersButton");
        WebElement usersButton = Driver.
                getDriver().
                findElement(By.xpath("//span[text()='Users']")) ;
        XPathGenerator.printXpathFormulas(usersButton);
        System.out.println("<--============"+usersButton+"=========== -->");

        System.out.println("0000000000subUsersButton00000000000000000");
        WebElement subUsersButton =
                Driver.getDriver().
                        findElement(By.xpath("/html/body/nav/div[2]/div[1]/ul/li[3]/ul/li[1]/a")) ;



        System.out.println("createUserButton");
        WebElement createUserButton = Driver.
                getDriver().
                findElement(By.xpath("//*[@href='https://qa.loyalfriendcare.com/Dashboard/Users/create']")) ;
        XPathGenerator.printXpathFormulas(createUserButton);
        System.out.println("<--============"+createUserButton+"=========== -->");
        // ROLES
        roles.click();
        subRolesButton.click();

        Driver.getDriver().navigate().back();

        lfcPages.dashBoard.click();
        roles.click();
        createUserButton.click();
        ReusableMethods.bekle(2);

        Driver.getDriver().navigate().back();
        lfcPages.dashBoard.click();
        usersButton.click();
        subUsersButton.click();
        ReusableMethods.bekle(2);
        Driver.getDriver().navigate().back();
        lfcPages.dashBoard.click();
        usersButton.click();
        createUserButton.click();
    }
    @Test
    public void dashboardlocaters(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        lfcPages.signInButton.click();
        lfcPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        lfcPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        lfcPages.loginPageSigInButton.click();

        lfcPages.accountButton.click();

        lfcPages.dashBoard.click();
        ReusableMethods.bekle(2);



        // < -- =========ROLESBUTTONS
        System.out.println("dbRolesButton");
        WebElement dbRolesButton =
                Driver.
                        getDriver().
                        findElement(By.xpath("//a[@href='https://qa.loyalfriendcare.com/Dashboard/Roles']")) ;

        System.out.println("subRolesButton");
        WebElement subRolesButton =
                Driver.
                        getDriver().
                        findElement(By.xpath("/html/body/nav/div[2]/div[1]/ul/li[2]/ul/li[1]/a")) ;

        System.out.println("createRolesButtons");
        WebElement createRolesButtons =
                Driver.
                        getDriver().
                        findElement(By.xpath("/html/body/nav/div[2]/div[1]/ul/li[2]/ul/li[2]/a"));


       // < -- USERSBUTTONS
        System.out.println("dbUsersButton");
        WebElement dbUsersButton = Driver
                .getDriver()
                .findElement(By.xpath("/html/body/nav/div[2]/div[1]/ul/li[3]/a/span[1]")) ;

        System.out.println("subUsersButton");
        WebElement subUsersButton = Driver
                .getDriver()
                .findElement(By.xpath("/html/body/nav/div[2]/div[1]/ul/li[3]/a/span[1]")) ;

        System.out.println("createUsersButton");
        WebElement createUsersButton =
                Driver
                        .getDriver()
                        .findElement(By.xpath("/html/body/nav/div[2]/div[1]/ul/li[3]/a/span[1]"));



        // <-- ==========BEDMANAGERSBUTTON
        System.out.println("dbBedManagers");
        WebElement dbBedManagers =
                Driver
                        .getDriver()
                        .findElement(By.xpath("/html/body/nav/div[2]/div[1]/ul/li[4]/a/span[1]")) ;

        System.out.println("subManagersButton");
        WebElement subBedManagersButton =
                Driver
                        .getDriver()
                        .findElement(By.xpath("/html/body/nav/div[2]/div[1]/ul/li[4]/ul/li[2]/a"));

        System.out.println("createBedManagersButton");
        WebElement createBedManagersButton =
                Driver.
        getDriver().
                        findElement(By.xpath("/html/body/nav/div[2]/div[1]/ul/li[4]/ul/li[2]/a"));


        // <--========= DEPARTMENTS BUTTONS
        System.out.println("dbDepartmentsButton");
        WebElement dbDepartmentsButton =
                Driver
                        .getDriver()
                        .findElement(By.xpath("/html/body/nav/div[2]/div[1]/ul/li[5]/a/span[1]"));

        System.out.println("subDepartmentsButtons");
        WebElement subDepartmentsButtons =
                Driver
                        .getDriver()
                        .findElement(By.xpath("/html/body/nav/div[2]/div[1]/ul/li[5]/ul/li[1]/a"));

        System.out.println("createDepartmentsButton");
        WebElement createDepartmentsButton =
                Driver
                        .getDriver()
                        .findElement(By.xpath("/html/body/nav/div[2]/div[1]/ul/li[5]/ul/li[2]/a")) ;
        // < -- === DOCTORS BUTTONS +
        System.out.println("dbDoctorsButton");
        WebElement dbDoctorsButton =
                Driver
                        .getDriver()
                        .findElement(By.xpath("/html/body/nav/div[2]/div[1]/ul/li[6]/a/span[1]")) ;

        System.out.println("-------------subDoctorsButton--------------");
        WebElement subDoctorsButton =
                Driver
                        .getDriver()
                        .findElement(By.xpath("/html/body/nav/div[2]/div[1]/ul/li[6]/ul/li[1]/a")) ;

        System.out.println("subDoctorsButton");

        WebElement createDoctorsButton =
        Driver
                .getDriver()
                .findElement(By.xpath("/html/body/nav/div[2]/div[1]/ul/li[6]/ul/li[2]/a"));


        // < -- MEDİCİNES BUTTONS
        System.out.println("MEDİSCİNES/html/body/nav/div[2]/div[1]/ul/li[7]/a/span[1]");
        WebElement dbMedicinesButton =
                Driver
                        .getDriver()
                        .findElement(By.xpath("/html/body/nav/div[2]/div[1]/ul/li[7]/a/span[1]")) ;

        System.out.println("submedicines/html/body/nav/div[2]/div[1]/ul/li[7]/ul/li[1]/a");
        WebElement subMedicinesButton =
                Driver
                        .getDriver()
                        .findElement(By.xpath("/html/body/nav/div[2]/div[1]/ul/li[7]/ul/li[1]/a")) ;

        System.out.println("createMedicinesButton/html/body/nav/div[2]/div[1]/ul/li[7]/ul/li[2]/a");
        WebElement createMedicinesButtons =Driver.getDriver().findElement(By.xpath("/html/body/nav/div[2]/div[1]/ul/li[7]/ul/li[2]/a"));
        // < -- PATH ADSENS BUTTONS
        System.out.println("pathAdsenseButtons/html/body/nav/div[2]/div[1]/ul/li[8]/a/span[1]");
        WebElement dbPetsAdsenseButton =Driver.getDriver().findElement(By.xpath("/html/body/nav/div[2]/div[1]/ul/li[8]/a/span[1]")) ;

        System.out.println("subPetAdsenseButton");
        WebElement subPetAdsenseButton =Driver.getDriver().findElement(By.xpath("/html/body/nav/div[2]/div[1]/ul/li[8]/ul/li[1]/a")) ;


        System.out.println("createPetAdSenseButton");

        WebElement createPetAdSenseButton =Driver.getDriver().findElement(By.xpath("/html/body/nav/div[2]/div[1]/ul/li[8]/ul/li[2]/a"));

        System.out.println("dbTicketsButton");
        WebElement dbTicketsButton =Driver.getDriver().findElement(By.xpath("/html/body/nav/div[2]/div[1]/ul/li[12]/a/span")) ;

        // < -- ====vaccination  BUTTONS

        System.out.println("dbVaccinationsButton");
        WebElement dbVaccinationsButton =Driver.getDriver().findElement(By.xpath("/html/body/nav/div[2]/div[1]/ul/li[13]/a/span")) ;

        TakeScreenShotsWithRedSquare.captureScreenshotWithRedBorder(dbRolesButton,"dbRolesButton");
        TakeScreenShotsWithRedSquare.captureScreenshotWithRedBorder(dbUsersButton,"dbUsersButton");
        TakeScreenShotsWithRedSquare.captureScreenshotWithRedBorder(dbBedManagers,"dbBedManagers");
        TakeScreenShotsWithRedSquare.captureScreenshotWithRedBorder(dbDepartmentsButton,"dbDepartmentsButton");
        TakeScreenShotsWithRedSquare.captureScreenshotWithRedBorder(dbDoctorsButton,"dbDoctorsButton");
        TakeScreenShotsWithRedSquare.captureScreenshotWithRedBorder(dbMedicinesButton,"dbMedicinesButton");
        TakeScreenShotsWithRedSquare.captureScreenshotWithRedBorder(dbRolesButton,"dbRolesButton");
        TakeScreenShotsWithRedSquare.captureScreenshotWithRedBorder(dbPetsAdsenseButton,"dbPetsAdsenseButton");
        TakeScreenShotsWithRedSquare.captureScreenshotWithRedBorder(dbTicketsButton,"dbTicketsButton");
        TakeScreenShotsWithRedSquare.captureScreenshotWithRedBorder(dbVaccinationsButton,"dbVaccinationsButton");


        MultiScreenShootsMethods.getWebelementWithRedBorder(
                Driver.getDriver(),
                "https://qa.loyalfriendcare.com/en/admin",
                dbRolesButton,
                dbUsersButton,
                dbBedManagers,
                dbDepartmentsButton,
                dbDoctorsButton,
                dbMedicinesButton,
                dbPetsAdsenseButton,
                dbTicketsButton,
                dbVaccinationsButton
        );

        dbRolesButton.click();
        XPathGenerator.printXpathFormulas(dbDoctorsButton);
        XPathGenerator.printXpathFormulas(subRolesButton);
        XPathGenerator.printXpathFormulas(createRolesButtons);

        MultiScreenShootsMethods.getWebelementWithRedBorder(
                Driver.getDriver(),
                "https://qa.loyalfriendcare.com/en/admin",
                dbRolesButton,
                subRolesButton,
                createRolesButtons
        );

        dbUsersButton.click();
        XPathGenerator.printXpathFormulas(dbUsersButton);
        XPathGenerator.printXpathFormulas(subUsersButton);
        XPathGenerator.printXpathFormulas(createUsersButton);

        MultiScreenShootsMethods.getWebelementWithRedBorder(
                Driver.getDriver(),
                "https://qa.loyalfriendcare.com/en/admin",
                dbUsersButton,
                subUsersButton,
                createUsersButton
        );

        dbBedManagers.click();
        XPathGenerator.printXpathFormulas(dbBedManagers);
        XPathGenerator.printXpathFormulas(subBedManagersButton);
        XPathGenerator.printXpathFormulas(createBedManagersButton);

        MultiScreenShootsMethods.getWebelementWithRedBorder(
                Driver.getDriver(),
                "https://qa.loyalfriendcare.com/en/admin",
                dbBedManagers,
                subBedManagersButton,
                createBedManagersButton
        );

        dbDepartmentsButton.click();
        XPathGenerator.printXpathFormulas(dbDepartmentsButton);
        XPathGenerator.printXpathFormulas(subDepartmentsButtons);
        XPathGenerator.printXpathFormulas(createDepartmentsButton);

        MultiScreenShootsMethods.getWebelementWithRedBorder(
                Driver.getDriver(),
                "https://qa.loyalfriendcare.com/en/admin",
                dbDepartmentsButton,
                subDepartmentsButtons,
                createDepartmentsButton
        );

        dbDoctorsButton.click();
        XPathGenerator.printXpathFormulas(dbDoctorsButton);
        XPathGenerator.printXpathFormulas(subDoctorsButton);
        XPathGenerator.printXpathFormulas(createDoctorsButton);

        MultiScreenShootsMethods.getWebelementWithRedBorder(
                Driver.getDriver(),
                "https://qa.loyalfriendcare.com/en/admin",
                dbDoctorsButton,
                subDoctorsButton,
                createDoctorsButton
        );

        dbMedicinesButton.click();
        XPathGenerator.printXpathFormulas(dbMedicinesButton);
        XPathGenerator.printXpathFormulas(subMedicinesButton);
        XPathGenerator.printXpathFormulas(createMedicinesButtons);

        MultiScreenShootsMethods.getWebelementWithRedBorder(
                Driver.getDriver(),
                "https://qa.loyalfriendcare.com/en/admin",
                dbMedicinesButton,
                subMedicinesButton,
                createMedicinesButtons
        );

        dbPetsAdsenseButton.click();
        XPathGenerator.printXpathFormulas(dbPetsAdsenseButton);
        XPathGenerator.printXpathFormulas(subPetAdsenseButton);
        XPathGenerator.printXpathFormulas(createPetAdSenseButton);

        MultiScreenShootsMethods.getWebelementWithRedBorder(
                Driver.getDriver(),
                "https://qa.loyalfriendcare.com/en/admin",
                dbPetsAdsenseButton,
                subPetAdsenseButton,
                createPetAdSenseButton
        );

        XPathGenerator.printXpathFormulas(dbTicketsButton);
        XPathGenerator.printXpathFormulas(dbVaccinationsButton);


    }
    @Test
    public void hk_03(){
        // < -- ==== ROLESBUTTONS

        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        lfcPages.signInButton.click();
        lfcPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        lfcPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        lfcPages.loginPageSigInButton.click();

        lfcPages.accountButton.click();

        lfcPages.dashBoard.click();
        ReusableMethods.bekle(2);
        //dbRolesButton,


        // < -- =========ROLESBUTTONS
        System.out.println("dbRolesButton");
        WebElement dbRolesButton =
                Driver.
                        getDriver().
                        findElement(By.xpath("//a[@href='https://qa.loyalfriendcare.com/Dashboard/Roles']")) ;
        XPathGenerator.printXpathFormulas(dbRolesButton);
        System.out.println("subRolesButton");
        WebElement subRolesButton =
                Driver.
                        getDriver().
                        findElement(By.xpath("//a[@href='https://qa.loyalfriendcare.com/Dashboard/Roles']")) ;
        XPathGenerator.printXpathFormulas(subRolesButton);
        System.out.println("createRolesButtons");
        WebElement createRolesButtons =
                Driver.
                        getDriver().
                        findElement(By.xpath("//a[@href='https://qa.loyalfriendcare.com/Dashboard/Roles/create']"));
        XPathGenerator.printXpathFormulas(createRolesButtons);






    }
    @Test
    public void hk_04(){
        //<-- === USERSBUTTONS

        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        lfcPages.signInButton.click();
        lfcPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        lfcPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        lfcPages.loginPageSigInButton.click();

        lfcPages.accountButton.click();

        lfcPages.dashBoard.click();
        ReusableMethods.bekle(2);

        // < -- USERSBUTTONS
        System.out.println("dbUsersButton");
        WebElement dbUsersButton = Driver
                .getDriver()
                .findElement(By.xpath("//span[text()='Users']")) ;
        XPathGenerator.printXpathFormulas(dbUsersButton);
        System.out.println("subUsersButton");
        WebElement subUsersButton = Driver
                .getDriver()
                .findElement(By.xpath("//*[@href='https://qa.loyalfriendcare.com/Dashboard/Users']")) ;
        XPathGenerator.printXpathFormulas(subUsersButton);
        System.out.println("createUsersButton");
        WebElement createUsersButton =
                Driver
                        .getDriver()
                        .findElement(By.xpath("//a[@href='https://qa.loyalfriendcare.com/Dashboard/Users/create']"));
        XPathGenerator.printXpathFormulas(createUsersButton);




    }

    @Test
    public void hk_05(){

        // < -- === DEPARTMENTS BUTTONS

        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        lfcPages.signInButton.click();
        lfcPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        lfcPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        lfcPages.loginPageSigInButton.click();

        lfcPages.accountButton.click();

        lfcPages.dashBoard.click();
        ReusableMethods.bekle(2);
        // <--========= DEPARTMENTS BUTTONS
        System.out.println("dbDepartmentsButton");
        WebElement dbDepartmentsButton =
                Driver
                        .getDriver()
                        .findElement(By.xpath("//span[@class='title']"));
       XPathGenerator.printXpathFormulas(dbDepartmentsButton);
        System.out.println("subDepartmentsButtons");
        WebElement subDepartmentsButtons =
                Driver
                        .getDriver()
                        .findElement(By.xpath("//a[@href='https://qa.loyalfriendcare.com/Dashboard/Categories']"));
        XPathGenerator.printXpathFormulas(subDepartmentsButtons);
        System.out.println("createDepartmentsButton");
        WebElement createDepartmentsButton =
                Driver
                        .getDriver()
                        .findElement(By.xpath("//a[@href='https://qa.loyalfriendcare.com/Dashboard/Categories/create']")) ;
        XPathGenerator.printXpathFormulas(createDepartmentsButton);





    }
    @Test
    public void hk_06(){

        // < -- === DOCTORS BUTTONS

        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        lfcPages.signInButton.click();
        lfcPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        lfcPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        lfcPages.loginPageSigInButton.click();

        lfcPages.accountButton.click();

        lfcPages.dashBoard.click();
        ReusableMethods.bekle(2);
        // < -- === DOCTORS BUTTONS
        System.out.println("dbDoctorsButton");
        WebElement dbDoctorsButton =
                Driver
                        .getDriver()
                        .findElement(By.xpath("//span[text()='Doctors']")) ;
        XPathGenerator.printXpathFormulas(dbDoctorsButton);
        System.out.println("-------------subDoctorsButton--------------");
        WebElement subDoctorsButton =
                Driver
                        .getDriver()
                        .findElement(By.xpath("//a[@href='https://qa.loyalfriendcare.com/Dashboard/Clients']")) ;
        XPathGenerator.printXpathFormulas(subDoctorsButton);
        System.out.println("subDoctorsButton");

        WebElement createDoctorsButton =
                Driver
                        .getDriver()
                        .findElement(By.xpath("//a[@href='https://qa.loyalfriendcare.com/Dashboard/Clients/create']"));
        XPathGenerator.printXpathFormulas(createDoctorsButton);



    }

    @Test
    public void hk_07(){
        // < -- === MEDİCİNES BUTTONS


        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        lfcPages.signInButton.click();
        lfcPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        lfcPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        lfcPages.loginPageSigInButton.click();

        lfcPages.accountButton.click();

        lfcPages.dashBoard.click();
        ReusableMethods.bekle(2);
        // < -- MEDİCİNES BUTTONS
        System.out.println("MEDİSCİNES");
        WebElement dbMedicinesButton =
                Driver
                        .getDriver()
                        .findElement(By.xpath("//span[text()='Medicines']")) ;
XPathGenerator.printXpathFormulas(dbMedicinesButton);
        System.out.println("submedicines");
        WebElement subMedicinesButton =
                Driver
                        .getDriver()
                        .findElement(By.xpath("//a[@href='https://qa.loyalfriendcare.com/Dashboard/Instagrams']")) ;
XPathGenerator.printXpathFormulas(subMedicinesButton);
        System.out.println("createMedicinesButton");
        WebElement createMedicinesButtons =Driver.getDriver().findElement(By.xpath("//a[@href='https://qa.loyalfriendcare.com/Dashboard/Instagrams/create']"));
        XPathGenerator.printXpathFormulas(createMedicinesButtons);




    }
    @Test
    public void hk_08(){
        // < -- === PETADSENSE BUTTONS
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        lfcPages.signInButton.click();
        lfcPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        lfcPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        lfcPages.loginPageSigInButton.click();

        lfcPages.accountButton.click();

        lfcPages.dashBoard.click();
        ReusableMethods.bekle(2);
        // < -- === PATH ADSENS BUTTONS
        System.out.println("pathAdsenseButtons");
        WebElement dbPetsAdsenseButton =Driver.getDriver().findElement(By.xpath("//span[text()='Pets adsense']")) ;
        XPathGenerator.printXpathFormulas(dbPetsAdsenseButton);
        System.out.println("subPetAdsenseButton");
        WebElement subPetAdsenseButton =Driver.getDriver().findElement(By.xpath("//a[@href='https://qa.loyalfriendcare.com/Dashboard/AdSense']")) ;
        XPathGenerator.printXpathFormulas(subPetAdsenseButton);

        System.out.println("createPetAdSenseButton");

        WebElement createPetAdSenseButton =Driver.getDriver().findElement(By.xpath("//a[@href='https://qa.loyalfriendcare.com/Dashboard/AdSense/create']"));
        XPathGenerator.printXpathFormulas(createPetAdSenseButton);
        System.out.println("dbTicketsButton");



    Driver.quitDriver();
    }

    @Test
    public void hk_09(){
        // < -- === TİCKET BUTTONS


        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        lfcPages.signInButton.click();
        lfcPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        lfcPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        lfcPages.loginPageSigInButton.click();

        lfcPages.accountButton.click();

        lfcPages.dashBoard.click();
        ReusableMethods.bekle(2);
         WebElement dbTicketsButton =Driver.getDriver().findElement(By.xpath("//span[text()='Tickets']")) ;

        XPathGenerator.printXpathFormulas(dbTicketsButton);
        Driver.quitDriver();


    }
    @Test
    public void hk_10(){
        // < -- === VACCİNATİONS BUTTONS

        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        lfcPages.signInButton.click();
        lfcPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        lfcPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        lfcPages.loginPageSigInButton.click();

        lfcPages.accountButton.click();

        lfcPages.dashBoard.click();
        ReusableMethods.bekle(2);

        // < -- === VACCİNATİONS BUTTONS

        System.out.println("dbVaccinationsButton");
        WebElement dbVaccinationsButton =Driver.getDriver().findElement(By.xpath("//span[text()='Vaccinations']")) ;
        XPathGenerator.printXpathFormulas(dbVaccinationsButton);



        Driver.quitDriver();
    }

    // < -- =========== ADMİN DASHBOARD PAGES ================= -- >

    // < -- === ROLES BUTTON

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Roles']")
    public WebElement dbRolesButton ;

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Roles']")
    public WebElement subRolesButton ;

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Roles/create']")
    public WebElement createRolesButtons ;

    // < -- === USERS BUTTONS

    @FindBy(xpath = "//span[text()='Users']")
    public WebElement dbUsersButton ;

    @FindBy(xpath = "//*[@href='https://qa.loyalfriendcare.com/Dashboard/Users']")
    public WebElement subUsersButton ;
    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Users/create']")
    public WebElement createUsersButton ;

    // < -- === DEPARTMENTS BUTTONS

    @FindBy(xpath = "//span[@class='title']")
    public WebElement dbDepartmentsButton ;

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Categories']")
    public WebElement subDepartmentsButtons ;

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Categories/create']")
    public WebElement createDepartmentsButton ;

    // < -- === DOCTORS BUTTONS
    @FindBy(xpath = "//span[text()='Doctors']")
    public WebElement dbDoctorsButton ;

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Clients']")
    public WebElement subDoctorsButton ;

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Clients/create']")
    public WebElement createDoctorsButton ;

    // < -- === PATH ADSENS BUTTONS

    @FindBy(xpath = "//span[text()='Pets adsense']")
    public WebElement dbPetsAdsenseButton ;

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/AdSense']")
    public WebElement subPetAdsenseButton ;

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/AdSense/create']")
    public WebElement createPetAdSenseButton ;

    // < -- === MEDİCİNES BUTTONS

    @FindBy(xpath = "//span[text()='Medicines']")
    public WebElement dbMedicinesButton ;

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Instagrams']")
    public WebElement subMedicinesButton ;

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Instagrams/create']")
    public WebElement createMedicinesButtons ;

    // < -- === TİCKET BUTTONS

    @FindBy(xpath = "//span[text()='Tickets']")
    public WebElement dbTicketsButton ;

    // < -- === VACCİNATİONS BUTTONS

    @FindBy(xpath = "//span[text()='Vaccinations']")
    public WebElement dbVaccinationsButton ;

    @Test
    public void hookers() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));


    }}