package com.bondex.ysl.mytest.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.bondex.ysl.mytest.BR;

/**
 * date: 2018/11/13
 * Author: ysl
 * description:
 */
public class User extends BaseObservable {

    public String firstName;
    public String lastName;


    public User() {

    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? "" : firstName;
        notifyPropertyChanged(BR.firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName == null ? "" : lastName;

        notifyPropertyChanged(BR.lastName);
    }

    @Bindable
    public String getFirstName() {
        return firstName == null ? "" : firstName;
    }

    @Bindable
    public String getLastName() {
        return lastName == null ? "" : lastName;
    }


}

