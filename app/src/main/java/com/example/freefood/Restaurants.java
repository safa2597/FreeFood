package com.example.freefood;

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
    ArrayList<String> u2,u3;
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
        u2=new ArrayList<String>();
        u3=new ArrayList<String>();
        u2.add("safa");
        u2.add("ameni");
        u3.add("test");
        u3.add("test 2");

        db = Room.databaseBuilder(v.getContext().getApplicationContext(),
                AppDataBase.class, "room_test_db").allowMainThreadQueries().build();
        ListAdapter adapter = new ListAdapter(v.getContext(),u2,u3);
        loadData(u2,u3);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(v.getContext()));

        return v;

    }
    private void loadData( ArrayList<String> un2,ArrayList<String> ud3) {
        UserDAO userDao = db.userDao();
        List<User> userl = userDao.getAll();
        for (User user : userl) {
            //if (user.getType().equals("RESTAURANT") ) {
                un2.add(user.getNom());
                ud3.add(user.getDescription());
            }
        }

    }
