package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DBPages {

    public DBPages() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // < -- =========== ADMİN DASHBOARD PAGES ================= -- >

    // < -- === ADMİN SAYFASINA ULAŞMAK İÇİN GEREKLİ LOCATERS

    @FindBy(xpath = "(//a[@class='btn_add'])[1]")
    public WebElement signInButton ;

    // < -- === header  sıgnUp buttonu ile sıgnOutButtonu Lacaterları aynı
    @FindBy(xpath = "//*[@id=\"top_menu\"]/li[2]/a")  // 8
    public WebElement signUpButton ;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement mailBox ;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordBox ;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-cons m-t-10']")
    public WebElement loginPageSignInButton ;

    @FindBy(xpath = "//input[@id='checkbox1']")
    public WebElement rememberMeButton ;

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/en/password/reset']")
    public WebElement forgotPasswordButton ;

    // < -- === KOD İÇİNDE FAZLALIK OLMASIN DİYE === -- >
    // < -- === FARKLI ATTİRİBUTE LERLE XPATH TEKRAR ALINDI === -- >


    @FindBy(xpath = "(//a[@class='btn_add'])[1]")
    public WebElement accountButton ;

    // < -- === header  sıgnUp buttonu ile sıgnOutButtonu Lacaterları aynı
    @FindBy(xpath = "//*[@id=\"top_menu\"]/li[2]/a")   // 8
    public WebElement signOutButton ;

    // < - === ADMİN PAGE DASHBOARD LOCATER
    @FindBy(xpath = "//div[@class='sidebar-header']")
    public WebElement dashBoard ;

    // < -- === ROLES BUTTON

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Roles']")
    public WebElement dbRolesButton;

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Roles']")
    public WebElement subRolesButton;

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Roles/create']")
    public WebElement createRolesButtons;

    // < -- === USERS BUTTONS

    @FindBy(xpath = "//span[text()='Users']")
    public WebElement dbUsersButton; //1

    @FindBy(xpath = "//*[@href='https://qa.loyalfriendcare.com/Dashboard/Users']")
    public WebElement subUsersButton; //2
    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Users/create']")
    public WebElement createUsersButton; //3

    // < -- === DEPARTMENTS BUTTONS
    // < -- === KULLANIMDA HEADER BUTTONS İLE ÇAKIŞIP ÇAKIŞMADIĞI KONTROL EDİLECEK

    @FindBy(xpath = "//span[@class='title']")  // ***
    public WebElement departmentsButton; //4  // BUTTON İSMİ HEADER DA KULLANILIYOR

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Categories']")
    public WebElement subDepartmentsButtons; //5

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Categories/create']")
    public WebElement createDepartmentsButton; //6

    // < -- === DOCTORS BUTTONS
    @FindBy(xpath = "//span[text()='Doctors']") // ***
    public WebElement doctorsButton; //7 // BUTTON İSMİ HEADER DA KULLANILIYOR

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Clients']")
    public WebElement subDoctorsButton; //8

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Clients/create']")
    public WebElement createDoctorsButton; //9

    // < -- === PATH ADSENS BUTTONS

    @FindBy(xpath = "//span[text()='Pets adsense']")
    public WebElement petsAdsenseButton; //10

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/AdSense']")
    public WebElement subPetAdsenseButton; //11

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/AdSense/create']")
    public WebElement createPetAdSenseButton; //12

    // < -- === MEDİCİNES BUTTONS

    @FindBy(xpath = "//span[text()='Medicines']") //***
    public WebElement medicinesButton; //13 // BUTTON İSMİ HEADER DA KULLANILIYOR

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Instagrams']")
    public WebElement subMedicinesButton; //14

    @FindBy(xpath = "//a[@href='https://qa.loyalfriendcare.com/Dashboard/Instagrams/create']")
    public WebElement createMedicinesButtons; //15

    // < -- === TİCKET BUTTONS

    @FindBy(xpath = "//span[text()='Tickets']")
    public WebElement ticketsButton; //16

    // < -- === VACCİNATİONS BUTTONS

    @FindBy(xpath = "//span[text()='Vaccinations']") // ***
    public WebElement vaccinationsButton; //17 // BUTTON İSMİ HEADER DA KULLANILIYOR

    @FindBy(xpath = "//*[@class='btn btn-tag btn-success btn-tag-rounded']")
    public WebElement addVaccinationsButton ;

    @FindBy(xpath = "(//input[@id='Title_en'])")
    public WebElement petsTitleBox ;

    @FindBy(xpath = "//input[@id='body_en']")
    public WebElement petsContentBox ;

    @FindBy(xpath = "//input[@id='price']")
    public WebElement petPriceBox ;

    @FindBy(xpath = "//*[@class='btn btn-success btn-cons btn-animated from-left fa fa-save pull-right']")
    public WebElement saveButton ;

    @FindBy(xpath = "(//button[@class='btn btn-danger btn-cons btn-animated from-top fa  fa-remove'])[1]")
    public WebElement deleteVaccinationsButton ;




    // < -- ==============^^^================================ -- >
    // < -- === KOD BLOĞUNDA ÇOK FAZLA PAGES EKLEMEMEK İÇİM === -- >
    // < -- === BURADAKİ LOCATERS LFCPages İLE AYNI === --->
    // < -- === ADMİN SAYFASINA GİRİŞ VE ÇIKIŞ LOCATERS === -- >

    // < -- === ADMİN PAGES HEADER PROFİL BUTTONLARI

    // < -- ===adminPage  Header profileButton
    @FindBy(xpath = "//div[@class='dropdown pull-right d-lg-block d-none']")
    public WebElement profileButton ;

    // < -- === adminPage Header profil dropDownMenü
    @FindBy(xpath = "(//a[@class='dropdown-item'])[1]")
    public WebElement settingsButton;

    // < -- === adminPage Header profil dropDownMenü
    @FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
    public WebElement editProfileButton ;

    // < -- === adminPage Header profil dropDownMenü
    @FindBy(xpath = "//*[@class='pull-left']")
    public WebElement logOutButton;

    // < - === ADMİN_PAGE --> HEADER_PROFİLE --> EDİT_PROFİLE --> NEXT_PAGE
    @FindBy(xpath = "//div[@class='error-container text-center']")
    public WebElement errorContainerWebelement  ;

    // < -- === ADMİN_PAGE -->ADSENSE --> LOCATE === -->

    @FindBy(xpath = "//span[@title='Home']")
    public WebElement addForumLocationButtons ; //

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement addForumFieldBox; //input[@class='select2-search__field']

    @FindBy(xpath = "//input[@placeholder='ex: This Title Pets']")
    public WebElement addForumPetTitle ; //

    @FindBy(xpath = "//input[@placeholder='ex:  Your Display Name']")
    public WebElement addForumDisplayName ;

    @FindBy(xpath = "//*[@class='switchery switchery-default']")
    public WebElement addForumRadioButton ;

    @FindBy(xpath = "(//span[@class='select2-selection__rendered'])[2]")
    public WebElement addForumTypeButton ;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement addForumTypeBox ;

    @FindBy(xpath = "//div[@id='headingTwo']")
    public WebElement addForumImageButton ;

    @FindBy(xpath = "(//button[@class='btn btn-primary btn-sm  btn-rounded m-r-10'])[2]")
    public WebElement addForumAdSenseButton ;



    @FindBy(xpath = "//input[@placeholder='ex:  Your Url Image']")
    public WebElement addForumImageUrlBox ;

    @FindBy(xpath = "//button[@class='btn btn-success btn-cons btn-animated from-left fa fa-save pull-right mb-30']")
    public WebElement addForumSaveButton ;

    @FindBy(xpath = "//div[@class='note-editable']")
    public WebElement addForumTextBox ;

    // < -- === adense delete Pages === -- >

    @FindBy(xpath = "(//button[@class='btn btn-danger btn-cons btn-animated from-top fa fa-remove'])[1]")
    public WebElement addSenseDeleteButton ;








    /*

    @FindBy(xpath = "")
    public WebElement             ;

     */






}
