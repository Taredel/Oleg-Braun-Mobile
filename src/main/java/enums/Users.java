package enums;

public enum Users {
    JACK("Jack", "+7-777-777-77-77", "jack@jack.com");

    private String contactName;
    private String contactPhone;
    private String contactEmail;

    Users(String contactName, String contactPhone, String contactEmail) {
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    @Override
    public String toString() {
        return "Users{" +
                "contactName='" + contactName + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                '}';
    }
}


