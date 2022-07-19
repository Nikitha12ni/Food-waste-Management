package com.example.mobileapplication;

public class user {
    String tof,add,mno;
    public user()
    {

    }
public user(String tof,String add,String mno)
{
    this.tof=tof;
    this.add=add;
    this.mno=mno;
}

    public String getTof() {
        return tof;
    }

    public void setTof(String tof) {
        this.tof = tof;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getMno() {
        return mno;
    }

    public void setMno(String mno) {
        this.mno = mno;
    }
}
