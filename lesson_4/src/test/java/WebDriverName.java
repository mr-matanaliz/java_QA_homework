public enum WebDriverName {
    CHROME ("chrome"),
    FIREFOX ("firefox");

    private String title;

    WebDriverName(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
