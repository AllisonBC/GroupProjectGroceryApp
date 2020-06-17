package com.example.groupproject_groceryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    //    Fragment recipesFragment = new RecipesFragment();
//    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        Button recipesBtn = findViewById(R.id.recipesBtn);
        recipesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToRecipes(v);
            }
        });
    }
//                  transaction.replace(R.id.recipes_frag_container, recipesFragment).commit();
//              if (findViewById(R.id.recipes_frag_container) != null) {
//                  if (savedInstanceState != null) {
//                      return;
//                  }
//                  RecipesFragment recipesFragment = new RecipesFragment();
//                  getSupportFragmentManager().beginTransaction()
//                          .add(R.id.recipes_frag_container, recipesFragment).commit();



    public void goToRecipes(View v){
        RecipesFragment recipesFragment = new RecipesFragment();
        FragmentManager transaction = getSupportFragmentManager();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.recipes_frag_container, recipesFragment).commit();

    }



//    //LayoutInflater inflater, ViewGroup container,
//    //                Bundle savedInstanceState
//    public void addRecipeFragment(Context context, Bundle savedInstanceState) {
//        Fragment recipesFragment = new RecipesFragment();
//        recipesFragment.onAttach(context);
//        recipesFragment.onCreate(savedInstanceState);
//    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }
}
