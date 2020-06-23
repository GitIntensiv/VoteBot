package dictionary;

public enum  BaseRequest {

    CREATE("CREATE TABLE REGISTRATION (username INT, PRIMARY KEY (username))"),
    GET("SELECT username FROM Registration where username = (?)"),
    GET_ALL("SELECT username FROM Registration"),
    INSERT("INSERT INTO REGISTRATION (username) values (?)"),
    DELETE("DROP table REGISTRATION");

    private String text;

    BaseRequest(String str) {
        this.text = str;
    }

    public String getText() {
        return text;
    }
}
