package com.example.roomdbiontest2;

/*UserProfile의 데이터를 넣고, 빼고, 조회할 엑세스 오브젝트를 만들어줌
* Dao :  데이터를 엑스스할 객체*/

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserProfileDao {
    @Insert
    void insert(UserProfile userProfile);

    @Update
    void update(UserProfile userProfile);

    @Delete
    void delete(UserProfile userProfile);

    //UserProfile 목록을 얻어오는 것이 필요
    @Query("SELECT * FROM UserProfile")
    List<UserProfile> getAll();
}
