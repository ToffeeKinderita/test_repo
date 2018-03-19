package pages;

public class UserInfoMd {
    private String firstName = "Alex";
    private String lastName = "AbcTest";
    private String spouse = "Sarah";
    private String prPhone = "1234567890";
    private String secPhone = "1234567899";
    private String prEmail = "test@gmail.com";
    private String secEmail = "test@gmail.com";
    private String prStreet = "PrStreet";
    private String prCity = "PrCity";
    private String prState = "PrState";
    private String prZip = "PrZip";
    private String prCountry = "PrCountry";
    private String secStreet = "SecStreet";
    private String secCity = "SecCity";
    private String secState = "SecState";
    private String secZip = "SecZip";
    private String secCountry="SecCountry";
    private String children="Mark";

    private String usrnameField = "admin";
    private String pswrdField = "123456789";

    public UserInfoMd(){

    }

    public UserInfoMd(String firstName, String lastName, String spouse, String prPhone, String secPhone, String prEmail, String secEmail, String prStreet,
                      String prCity, String prState, String prZip, String prCountry, String secStreet, String secCity, String secState, String secZip,
                      String secCountry, String children, String usrnameField, String pswrdField){
        this.firstName = firstName;
        this.lastName = lastName;
        this.spouse = spouse;
        this. prPhone = prPhone;
        this.secPhone = secPhone;
        this.prEmail = prEmail;
        this.secEmail = secEmail;
        this.prStreet = prStreet;
        this.prCity = prCity;
        this.prState = prState;
        this.prZip = prZip;
        this.prCountry=prCountry;
        this.secStreet = secStreet;
        this.secCity = secCity;
        this.secState = secState;
        this.secZip = secZip;
        this.secCountry = secCountry;
        this.children = children;
        this.usrnameField = usrnameField;
        this.pswrdField =pswrdField;

    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public String getPrPhone() {
        return prPhone;
    }

    public void setPrPhone(String prPhone) {
        this.prPhone = prPhone;
    }

    public String getSecPhone() {
        return secPhone;
    }

    public void setSecPhone(String secPhone) {
        this.secPhone = secPhone;
    }

    public String getPrEmail() {
        return prEmail;
    }

    public void setPrEmail(String prEmail) {
        this.prEmail = prEmail;
    }

    public String getSecEmail() {
        return secEmail;
    }

    public void setSecEmail(String secEmail) {
        this.secEmail = secEmail;
    }

    public String getPrStreet() {
        return prStreet;
    }

    public void setPrStreet(String prStreet) {
        this.prStreet = prStreet;
    }

    public String getPrCity() {
        return prCity;
    }

    public void setPrCity(String prCity) {
        this.prCity = prCity;
    }

    public String getPrState() {
        return prState;
    }

    public void setPrState(String prState) {
        this.prState = prState;
    }

    public String getPrZip() {
        return prZip;
    }

    public void setPrZip(String prZip) {
        this.prZip = prZip;
    }

    public String getPrCountry() {
        return prCountry;
    }

    public void setPrCountry(String prCountry) {
        this.prCountry = prCountry;
    }

    public String getSecStreet() {
        return secStreet;
    }

    public void setSecStreet(String secStreet) {
        this.secStreet = secStreet;
    }

    public String getSecCity() {
        return secCity;
    }

    public void setSecCity(String secCity) {
        this.secCity = secCity;
    }

    public String getSecState() {
        return secState;
    }

    public void setSecState(String secState) {
        this.secState = secState;
    }

    public String getSecZip() {
        return secZip;
    }

    public void setSecZip(String secZip) {
        this.secZip = secZip;
    }

    public String getSecCountry() {
        return secCountry;
    }

    public void setSecCountry(String secCountry) {
        this.secCountry = secCountry;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getUsrnameField() {
        return usrnameField;
    }

    public void setUsrnameField(String usrnameField) {
        this.usrnameField = usrnameField;
    }

    public String getPswrdField() {
        return pswrdField;
    }

    public void setPswrdField(String pswrdField) {
        this.pswrdField = pswrdField;
    }
}
