package woori.project.newchallenge;

public class ChallengeData {
    private int profile_image=0;
    private String profile_textview=null;
    private int content_image=0;
    private int favorite_imageview=0;
    private String explain_textview=null;

    public ChallengeData(int profile_image, String profile_textview,
                         int content_image, int favorite_imageview, String explain_textview)
    {
        this.profile_image = profile_image;
        this.profile_textview = profile_textview;
        this.content_image = content_image;
        this.favorite_imageview=favorite_imageview;
        this.explain_textview=explain_textview;
    }


    public int getContent_image() {
        return content_image;
    }

    public int getFavorite_imageview() {
        return favorite_imageview;
    }

    public int getProfile_image() {
        return profile_image;
    }

    public String getExplain_textview() {
        return explain_textview;
    }

    public String getProfile_textview() {
        return profile_textview;
    }

    public void setContent_image(int content_image) {
        this.content_image = content_image;
    }

    public void setExplain_textview(String explain_textview) {
        this.explain_textview = explain_textview;
    }

    public void setFavorite_imageview(int favorite_imageview) {
        this.favorite_imageview = favorite_imageview;
    }

    public void setProfile_image(int profile_image) {
        this.profile_image = profile_image;
    }

    public void setProfile_textview(String profile_textview) {
        this.profile_textview = profile_textview;
    }
}
