package xyz.sangcomz.jjamppong;

/**
 * Created by sangcomz on 05/11/2017.
 */

public class Contributor {
    String login;
    String html_url;
    String avatar_url;

    int contributions;

    @Override
    public String toString() {
        return login + " (" + contributions + ")";
    }
}
