package com.example.relaxtime.Fragment;

import android.icu.util.ULocale;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.relaxtime.Domain.Category;
import com.example.relaxtime.Domain.Feature;
import com.example.relaxtime.R;
import com.example.relaxtime.adaptor.CategoryAdapter;
import com.example.relaxtime.adaptor.FeatureAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class HomeFragment extends Fragment {
    private FirebaseFirestore mStore;
    //category tab
    private List<Category> mCategorylist;
    private CategoryAdapter mCategoryAdapter;
    private RecyclerView mCatRecyclerView;
    //feature tab
    private List<Feature> mFeaturelist;
    private FeatureAdapter mFeatureAdapter;
    private RecyclerView mFeatureRecyclerView;

    public  HomeFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mStore = FirebaseFirestore.getInstance();
        mCatRecyclerView=view.findViewById(R.id.category_recycler);
        mFeatureRecyclerView =view.findViewById(R.id.feature_recycler);
        // For Category
        mCategorylist = new ArrayList<>();
        mCategoryAdapter =new CategoryAdapter(getContext(),mCategorylist);
        mCatRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        mCatRecyclerView.setAdapter(mFeatureAdapter);

        // For Feature
        mFeaturelist = new ArrayList<>();
        mFeatureAdapter =new FeatureAdapter(getContext(),mFeaturelist);
        mFeatureRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        mFeatureRecyclerView.setAdapter(mCategoryAdapter);

        mStore.collection("Category")
                .get()
                .addOnCompleteListener(   new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Category category = document.toObject(Category.class);
                                Log.e("URL::",category.getImg_url());
                                mCategorylist.add(category);
                                mCategoryAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Log.w("TAG", "Error getting documents.", task.getException());
                        }
                    }
                });
        mStore.collection("Feature")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Feature feature = document.toObject(Feature.class);
                                mFeaturelist.add(feature);
                                mCategoryAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Log.w("TAG", "Error getting documents.", task.getException());
                        }
                    }
                });
        return view;
    }
}