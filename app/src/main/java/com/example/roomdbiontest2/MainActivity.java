package com.example.roomdbiontest2;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.roomdbiontest2.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    private UserProfileDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);

        db = Room.databaseBuilder(this, UserProfileDatabase.class,"userprofile")
                .allowMainThreadQueries()
                .build();

        
        activityMainBinding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUserProfile(v);
                fetchUserProfileList();
            }
        });
    }

    private void fetchUserProfileList(){
        List<UserProfile> userProfileList = db.getUserProfileDao().getAll();
        String userListText = "사용자 목록";
        for (UserProfile userProfile : userProfileList){
            userListText += "\n" + userProfile.id + ", "+ userProfile.name + ", "
                    + userProfile.phone + ", " + userProfile.address;
        }

        activityMainBinding.userList.setText(userListText);
    }

    //추가버튼을 눌렀을때 실행이 되어야함
    public void addUserProfile(View view){
        UserProfile userProfile = new UserProfile();
        userProfile.name = activityMainBinding.name.getText().toString();
        userProfile.phone = activityMainBinding.phone.getText().toString();
        userProfile.address = activityMainBinding.address.getText().toString();
        db.getUserProfileDao().insert(userProfile);
        fetchUserProfileList();
    }
}
