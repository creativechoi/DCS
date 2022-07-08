package woori.project.newchallenge;

import java.util.Vector;

public class MyUser {
    //public String uid;
    public String name;
    public String email;
    public int point;
    public Vector<String> challenge_list;

    public MyUser(){

    }
    public MyUser(String name, String email){
      this.name=name;
      this.email=email;
      this.point=0;
      this.challenge_list = new Vector<String>();
    }

    public int getPoint() {
        return point;
    }

    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }
    public Vector<String> getChallenge_list() {
        return challenge_list;
    }
}
