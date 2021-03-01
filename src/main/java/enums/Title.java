package enums;

public enum Title {
    MR("Mr."), MRS("Mrs.");

    private String value;

    Title(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
