package your.tmi.dto.search;

public enum SearchType {
    NICKNAME("이름"), MONTH("월");

    private final String searchName;

    SearchType(String searchName) {
        this.searchName = searchName;
    }

    public String getSearchName() {
        return searchName;
    }

}
