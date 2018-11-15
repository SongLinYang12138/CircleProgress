package com.bondex.ysl.mytest.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.bondex.ysl.mytest.BR;


/**
 * date: 2018/11/13
 * Author: ysl
 * description:
 */
public class AdapterBean extends BaseObservable {

    public String str = "测试";

    public AdapterBean() {
    }

    public AdapterBean(String str) {
        this.str = str;
    }

    @Bindable
    public String getStr() {
        return str == null ? "" : str;
    }

    public void setStr(String str) {
        this.str = str == null ? "" : str;

        notifyPropertyChanged(BR.str);

    }

}
