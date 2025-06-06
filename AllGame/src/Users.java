public class Users {
    private String id;
    private String pw;
    private String nickname;

    public Users(String id, String pw, String nickname) {
        this.id = id;
        this.pw = pw;
        this.nickname = nickname;
    }

    public String getId() { return id; }
    public String getPw() { return pw; }
    public String getNickname() { return nickname; }
}
