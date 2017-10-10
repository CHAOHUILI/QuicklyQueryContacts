package com.lihuichao.testquerycontacts;

import com.lihuichao.quicklyquerycontacts.Friend;

/**
 * Created by lihuichao on 2017/10/9.
 */

public class Entity extends Friend {

    private String nick;
    private String code;

    public Entity(){

    }
    public Entity(String name) {
        setName(name);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        setName(nick);
        this.nick = nick;
    }
}
