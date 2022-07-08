package woori.project.newchallenge;

public class MyBoard {
    public String title;
    public String contents;
    public String challenge_item;
    public int like_number;

    public MyBoard(){
    }
    public MyBoard(String title, String contents, String challenge_item){
        this.title=title;
        this.contents=contents;
        this.challenge_item=challenge_item;
        this.like_number=0;
    }
    public String getChallenge_item() {
        return challenge_item;
    }
    public String getContents() {
        return contents;
    }
    public String getTitle() {
        return title;
    }
    public int getLike_number() {
        return like_number;
    }
}
