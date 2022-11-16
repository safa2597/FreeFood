package com.example.freefood;

import static com.example.freefood.entity.Type.RESTAURANT;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.freefood.database.AppDataBase;
import com.example.freefood.entity.User;

import java.util.ArrayList;
import java.util.List;


public class Associations extends Fragment {

    AppDataBase db;
    RecyclerView rv;
    List<User> users;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_restaurants, container, false);
        rv= v.findViewById(R.id.recyclerview);
        users=new ArrayList();
        users.add(new User("ameni","ameni","23635245","ameni","test2","ariana",RESTAURANT));
        users.add(new User("safa","safa","20504143","safa","test1","tunis",RESTAURANT));
        db = Room.databaseBuilder(v.getContext().getApplicationContext(),
                AppDataBase.class, "room_test_db").allowMainThreadQueries().build();
        System.out.println(db.userDao().getAllAssociations());
        ListAdapterAs adapter = new ListAdapterAs(v.getContext(),users);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(v.getContext()));

        return v;

    }
}