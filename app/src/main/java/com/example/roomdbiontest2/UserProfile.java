package com.example.roomdbiontest2;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity //DB에서 테이블(같은형태의 데이터가 여러개 저장될 수 있는 공간)에 해당하는 개념
public class UserProfile {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public String phone;
    public String address;
}
