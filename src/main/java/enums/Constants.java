package enums;

public enum Constants {
    SITE_URL("https://iana.org"),
    START_PAGE_TITLE("Contact Manager"),
    CONTACT_PAGE_TITLE("Add Contact"),
    SAVE_BUTTON("Save"),
    MAIN_PAGE_TITLE("Internet Assigned Numbers Authority"),
    DOMAIN_NAME("Domain Names"),
    HEADER_TEXT("The global coordination of the DNS Root, IP addressing, and other Internet protocol " +
            "resources is performed as the Internet Assigned Numbers Authority (IANA) functions. Learn more.");

    public String value;

    Constants(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Constants{" +
                "appType='" + value + '\'' +
                '}';
    }
}
