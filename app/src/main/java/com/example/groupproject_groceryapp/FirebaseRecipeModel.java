package com.example.groupproject_groceryapp;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.function.Consumer;

public class FirebaseRecipeModel {
    private static final String TAG = FirebaseRecipeModel.class.getSimpleName();

    private DatabaseReference mDatabase;
    private HashMap<DatabaseReference, ValueEventListener> listeners;

    public FirebaseRecipeModel() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        listeners = new HashMap<>();
        Log.i(TAG, "FirebaseRecipeModel: instance");
    }

    public void getRecipes(Consumer<DataSnapshot> dataChangedCallback, Consumer<DatabaseError> dataErrorCallback) {
        DatabaseReference recipesRef = mDatabase.child("recipes");

        ValueEventListener recipesListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dataChangedCallback.accept(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                dataErrorCallback.accept(databaseError);
            }
        };

        recipesRef.addValueEventListener(recipesListener);
        listeners.put(recipesRef, recipesListener);
    }

    public void clear() {
        // Clear all the listeners onPause
        listeners.forEach(Query::removeEventListener);
    }
}
