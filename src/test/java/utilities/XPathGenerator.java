package utilities;

import org.openqa.selenium.WebElement;

public class XPathGenerator {

    public static void printXpathFormulas(WebElement element) {
        String tag = element.getTagName();
        String id = element.getAttribute("id");
        String classAttr = element.getAttribute("class");
        String placeholder = element.getAttribute("placeholder");
        String name = element.getAttribute("name");
        String href = element.getAttribute("href");
        String src = element.getAttribute("src");
        String alt = element.getAttribute("alt");
        String title = element.getAttribute("title");
        String role = element.getAttribute("role");
        String ariaLabel = element.getAttribute("aria-label");
        String value = element.getAttribute("value");
        String type = element.getAttribute("type");
        String text = element.getText().trim();

        System.out.println("🔍 Element Bilgileri:");
        System.out.println("Tag: " + tag);
        System.out.println("Text: " + text);
        System.out.println("ID: " + id);
        System.out.println("Class: " + classAttr);
        System.out.println("Placeholder: " + placeholder);
        System.out.println("Name: " + name);
        System.out.println("Href: " + href);
        System.out.println("Src: " + src);
        System.out.println("Alt: " + alt);
        System.out.println("Title: " + title);
        System.out.println("Role: " + role);
        System.out.println("Aria-label: " + ariaLabel);
        System.out.println("Value: " + value);
        System.out.println("Type: " + type);

        System.out.println("\n📌 XPath Formülleri:");

        // Text tabanlı
        if (!text.isEmpty()) {
            System.out.println("//" + tag + "[text()='" + text + "']");
            System.out.println("//" + tag + "[contains(text(),'" + getFirstWord(text) + "')]");
            System.out.println("//*[normalize-space(text())='" + text + "']");
        }

        // Attribute tabanlı
        printAttributeXPath(tag, "id", id);
        printAttributeXPath(tag, "class", classAttr);
        printAttributeXPath(tag, "placeholder", placeholder);
        printAttributeXPath(tag, "name", name);
        printAttributeXPath(tag, "href", href);
        printAttributeXPath(tag, "src", src);
        printAttributeXPath(tag, "alt", alt);
        printAttributeXPath(tag, "title", title);
        printAttributeXPath(tag, "role", role);
        printAttributeXPath(tag, "aria-label", ariaLabel);
        printAttributeXPath(tag, "value", value);
        printAttributeXPath(tag, "type", type);

        // Kombinasyonlar
        if (id != null && classAttr != null) {
            System.out.println("//" + tag + "[@id='" + id + "' and contains(@class,'" + getFirstWord(classAttr) + "')]");
        }
        if (name != null && type != null) {
            System.out.println("//" + tag + "[@name='" + name + "' and @type='" + type + "']");
        }
        if (href != null && text != null) {
            System.out.println("//" + tag + "[@href='" + href + "' and contains(text(),'" + getFirstWord(text) + "')]");
        }

        // XPath axes (bağlamsal ilişkiler)
        System.out.println("\n🧭 XPath Aksları:");
        System.out.println("//" + tag + "/parent::*");
        System.out.println("//" + tag + "/ancestor::*");
        System.out.println("//" + tag + "/following-sibling::*");
        System.out.println("//" + tag + "/preceding-sibling::*");

        // Position tabanlı
        System.out.println("\n📐 Pozisyon Bazlı:");
        System.out.println("(//" + tag + ")[1]");
        System.out.println("(//" + tag + ")[last()]");

        // Dinamik ID ve class için starts-with / contains
        if (id != null && id.length() >= 3) {
            System.out.println("//*[starts-with(@id,'" + id.substring(0, 3) + "')]");
        }
        if (classAttr != null && classAttr.length() >= 3) {
            System.out.println("//*[contains(@class,'" + getFirstWord(classAttr) + "')]");
        }
    }

    private static void printAttributeXPath(String tag, String attrName, String attrValue) {
        if (attrValue != null && !attrValue.isEmpty()) {
            System.out.println("//" + tag + "[@" + attrName + "='" + attrValue + "']");
            System.out.println("//*[@" + attrName + "='" + attrValue + "']");
            System.out.println("//*[contains(@" + attrName + ",'" + getFirstWord(attrValue) + "')]");
        }
    }

    private static String getFirstWord(String text) {
        return text.split(" ")[0];
    }
}