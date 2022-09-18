package com.career.guidance.activity.STEM;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.career.guidance.R;
import com.career.guidance.base.BaseRecyclerAdapter;
import com.career.guidance.databinding.StemItemBinding;
import com.career.guidance.model.StemData;
import com.career.guidance.utils.extensions.AppExtensionsKt;

import java.util.ArrayList;

public class SelectStemSubCategoryActivity extends AppCompatActivity {
    private final BaseRecyclerAdapter<StemData, StemItemBinding> adapter = getAdapter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        RecyclerView recyclerView = findViewById(R.id.facultyRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        AppExtensionsKt.rvItemAnimation(recyclerView);
        adapter.addItems(stemData());
    }

    private ArrayList<StemData> stemData() {
        ArrayList<StemData> stemDataArrayList = new ArrayList<>();
        stemDataArrayList.add(new StemData(getString(R.string.stem_engineering_programs), getString(R.string.additional_info)
                , R.drawable.placeholder, getString(R.string.stem_engineering_programs)));
        stemDataArrayList.add(new StemData(getString(R.string.stem_ict_programs), getString(R.string.additional_info)
                , R.drawable.placeholder, getString(R.string.stem_ict_programs)));
        stemDataArrayList.add(new StemData(getString(R.string.stem_science_and_math_programs), getString(R.string.additional_info)
                , R.drawable.placeholder, getString(R.string.stem_science_and_math_programs)));
        stemDataArrayList.add(new StemData(getString(R.string.stem_engineering_technology_programs), getString(R.string.additional_info)
                , R.drawable.placeholder, getString(R.string.stem_engineering_technology_programs)));
        stemDataArrayList.add(new StemData(getString(R.string.stem_university_that_offer), getString(R.string.additional_info)
                , R.drawable.placeholder, getString(R.string.stem_university_that_offer)));
        stemDataArrayList.add(new StemData(getString(R.string.stem_billionaires_club), getString(R.string.additional_info)
                , R.drawable.placeholder, getString(R.string.stem_billionaires_club)));
        return stemDataArrayList;
    }

    private BaseRecyclerAdapter<StemData, StemItemBinding> getAdapter() {

        return new BaseRecyclerAdapter<StemData, StemItemBinding>() {
            @Override
            public int getLayoutResId() {
                return R.layout.stem_item;
            }

            @Override
            public void onBindData(StemData model, int position, StemItemBinding dataBinding) {


            }

            @Override
            public void onItemClick(@NonNull View view, StemData model, int position, StemItemBinding dataBinding) {
// implement click
                switch (model.getPage()){
                    case "":
                        break;
                    case "d":

                        break;

                }
            }

            @Override
            public void onItemLongClick(@NonNull View view, StemData model, int position) {

            }
        };
    }

}