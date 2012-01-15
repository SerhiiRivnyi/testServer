package com.user;

/**
 * Created by IntelliJ IDEA.
 * User: seric <nevilonster@gmail.com>
 * Date: 11.01.12
 * Time: 14:05
 * To change this template use File | Settings | File Templates.
 */

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable{
    private int _id = 0;
    private int _coins = 0;
    private int _gold = 0;
    private int _exp = 0;
    private String _name = "";
    private String _avatar = "";

    //public User(){
        /*_id = id;
        _coins = coins;
        _gold = gold;
        _exp = exp;*/
    //}

    public void addCoins(int coins){
        _coins += coins;
    }

    public void addGold(int gold){
        _gold += gold;
    }

    public void addExp(int exp){
        _exp += exp;
    }

    public void setCoins(int _coins) {
        this._coins = _coins;
    }

    public void setExp(int _exp) {
        this._exp = _exp;
    }

    public void setGold(int _gold) {
        this._gold = _gold;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    @Column(name = "coins")
    public int getCoins() {
        return _coins;
    }

    @Column(name = "exp")
    public int getExp() {
        return _exp;
    }

    @Column(name = "gold")
    public int getGold() {
        return _gold;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return _id;
    }

    public void setAvatar(String _avatar) {
        this._avatar = _avatar;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    @Column(name = "avatar")
    public String getAvatar() {
        return _avatar;
    }

    @Column(name = "name")
    public String getName() {
        return _name;
    }

    @Override
    public String toString() {
        return "id:" + getId() + " name:" + getName() + " coins:" + getCoins() + " exp:" + getExp() + " avatar:" + getAvatar();
    }
}
