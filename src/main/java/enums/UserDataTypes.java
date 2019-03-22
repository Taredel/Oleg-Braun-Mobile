package enums;

public enum UserDataTypes {
    HOME("Home"),
    WORK("Work"),
    MOBILE("Mobile"),
    OTHER("Other");

    public String label;

    @Override
    public String toString() {
        return "UserDataTypes{" +
                "label='" + label + '\'' +
                '}';
    }

    UserDataTypes(String label) {
        this.label = label;
    }
}
