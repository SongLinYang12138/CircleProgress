package com.bondex.ysl.mykotlin.test

/**
 * date: 2018/11/13
 * Author: ysl
 * description:
 */

class ImplBaseClick(name: String, rouseceId: Int,title:String) : BaseClick(name, rouseceId) {


    constructor(name: String,reouseceId:Int,title: String,string: String) : this(name,reouseceId,title) {

    }

}