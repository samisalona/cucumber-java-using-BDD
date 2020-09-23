package common;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ReadXML {

    public static String FirstName;
    public static String LastName;
    public static Integer GenderIdentity;
    public static Integer AssignedSex;
    public static Integer PartnerSex;
    public static Integer Age;
    public static String Ethnicity;
    public static String AddressLineOne;
    public static String TownCity;
    public static String County;
    public static String PostCode;
    public static String EmailAddress;
    public static String MobileNumber;
    public static String ContactPreference;
    public static String Password;
    public static String ConfirmPassword;
    public static String ResearchConsent;
    public static String Terms;

    public static void ReadXMLFile() {
        try {
            String filePath = "src/test/resources/AutomationTest.xml";
            File file = new File(filePath);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbf.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            FirstName = doc.getElementsByTagName("FirstName").item(0).getTextContent();

            LastName = doc.getElementsByTagName("LastName").item(0).getTextContent();

            GenderIdentity = Integer.valueOf(doc.getElementsByTagName("Gender").item(0).getTextContent());

            AssignedSex = Integer.valueOf(doc.getElementsByTagName("AssignedSex").item(0).getTextContent());

            PartnerSex = Integer.valueOf(doc.getElementsByTagName("PartnerSex").item(0).getTextContent());

            Age = Integer.valueOf(doc.getElementsByTagName("Age").item(0).getTextContent());

            Ethnicity = doc.getElementsByTagName("Ethnicity").item(0).getTextContent();

            AddressLineOne = doc.getElementsByTagName("Address1").item(0).getTextContent();

            TownCity = doc.getElementsByTagName("TownCity").item(0).getTextContent();

            County = doc.getElementsByTagName("County").item(0).getTextContent();

            PostCode = doc.getElementsByTagName("PostCode").item(0).getTextContent();

            EmailAddress = doc.getElementsByTagName("EmailAddress").item(0).getTextContent();

            MobileNumber = doc.getElementsByTagName("MobileNumber").item(0).getTextContent();

            ContactPreference = doc.getElementsByTagName("ContactPreference").item(0).getTextContent();

            Password = doc.getElementsByTagName("Password").item(0).getTextContent();

            ConfirmPassword = doc.getElementsByTagName("PasswordConfirm").item(0).getTextContent();

            ResearchConsent = doc.getElementsByTagName("ResearchConsent").item(0).getTextContent();

            Terms = doc.getElementsByTagName("Terms").item(0).getTextContent();
        }
        catch ( Exception e) {
            e.printStackTrace();
        }
    }

}
