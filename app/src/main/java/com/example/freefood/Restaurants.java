package com.example.freefood;

import static com.example.freefood.entity.Type.RESTAURANT;

import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.freefood.dao.UserDAO;
import com.example.freefood.database.AppDataBase;
import com.example.freefood.entity.Type;
import com.example.freefood.entity.User;

import java.util.ArrayList;
import java.util.List;


public class Restaurants extends Fragment {
    AppDataBase db;
    RecyclerView rv;
    List<User> users;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        /*users=new ArrayList();
        users.add(new User());
        rv= rv.findViewById(R.id.recyclerview);
        rv.setAdapter(new ListAdapter(users,this));
        rv.setLayoutManager(new LinearLayoutManager(this));*/

        View v = inflater.inflate(R.layout.fragment_restaurants, container, false);
        rv= v.findViewById(R.id.recyclerview);
        users=new ArrayList();
        //users.add(new User("safa","safa","20504143","safa","test1","tunis",RESTAURANT));
        //users.add(new User("ameni","ameni","23635245","ameni","test2","ariana",RESTAURANT));
        //loadData(users);
        db = Room.databaseBuilder(v.getContext().getApplicationContext(),
                AppDataBase.class, "room_test_db").allowMainThreadQueries().build();
        users=db.userDao().getAllRestaurants();
        ListAdapter adapter = new ListAdapter(v.getContext(),users);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(v.getContext()));

        return v;

    }
    /*private void loadData( List<User> u2) {
        UserDAO userDao = db.userDao();
        List<User> userl = userDao.getAllRestaurants();
        for (User user : userl) {
            //if (user.getType().equals("RESTAURANT") ) {
                u2.add(user);
            }
        }*/

    }
