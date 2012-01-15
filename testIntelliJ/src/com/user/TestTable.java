package com.user;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: seric <nevilonster@gmail.com>
 * Date: 11.01.12
 * Time: 16:53
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "test_table")
public class TestTable implements Serializable{
    private int id = 0;
    private String message = "";

    @Id
    @Column(name = "idtest_table")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString(){
        return "id:" + getId() + " message:" + getMessage();
    }
}
