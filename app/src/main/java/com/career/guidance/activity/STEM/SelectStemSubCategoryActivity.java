package com.career.guidance.activity.STEM;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.career.guidance.AppBaseActivity;
import com.career.guidance.R;
import com.career.guidance.base.BaseRecyclerAdapter;
import com.career.guidance.databinding.StemItemBinding;
import com.career.guidance.model.StemData;
import com.career.guidance.utils.extensions.AppExtensionsKt;

import java.util.ArrayList;

public class SelectStemSubCategoryActivity extends AppBaseActivity {
    private final BaseRecyclerAdapter<StemData, StemItemBinding> adapter = getAdapter();
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_stem_sub_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("hello");;
        setToolbar(toolbar);
        RecyclerView recyclerView = findViewById(R.id.facultyRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        AppExtensionsKt.rvItemAnimation(recyclerView);
        adapter.addItems(stemData());

        context=SelectStemSubCategoryActivity.this;
    }

    private ArrayList<StemData> stemData() {
        ArrayList<StemData> stemDataArrayList = new ArrayList<>();

        stemDataArrayList.add(new StemData(getString(R.string.stem_engineering_programs), getString(R.string.additional_info)
                , R.drawable.placeholder, getString(R.string.stem_engineering_programs)));

        stemDataArrayList.add(new StemData(getString(R.string.stem_ict_programs), getString(R.string.additional_info)
                , R.drawable.placeholder,  getString(R.string.stem_ict_programs)));
        stemDataArrayList.add(new StemData(getString(R.string.stem_science_and_math_programs), getString(R.string.additional_info)
                , R.drawable.placeholder, getString(R.string.stem_science_and_math_programs)));
        stemDataArrayList.add(new StemData(getString(R.string.stem_engineering_technology_programs), getString(R.string.additional_info)
                , R.drawable.placeholder, getString(R.string.stem_engineering_technology_programs)));
        stemDataArrayList.add(new StemData(getString(R.string.stem_university_that_offer), getString(R.string.additional_info)
                , R.drawable.placeholder, getString(R.string.stem_university_that_offer)));
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

                dataBinding.stemName.setText(model.getStemName());
                dataBinding.stemInfo.setText(model.getStemInfo());

            }

            @Override
            public void onItemClick(@NonNull View view, StemData model, int position, StemItemBinding dataBinding) {
// implement click
                /*
// we will not use a switch statement because i cant fetch strings for switch cases, if will be used instead
                switch (model.getPage()){
                    case getString(R.string.stem_engineering_programs):
                        Intent intent=new Intent(SelectStemSubCategoryActivity.this, EngineeringPrograms.class);
                        context.startActivity(intent);
                        break;
                    case "d":

                        break;

                }
                */
                String selectedBtnPage=model.getPage();
                if (selectedBtnPage.equals(getString(R.string.stem_engineering_programs))){
                    Intent intent=new Intent(SelectStemSubCategoryActivity.this, EngineeringPrograms.class);
                    context.startActivity(intent);
                }
                else if(selectedBtnPage.equals(getString(R.string.stem_ict_programs))){
                    Intent intent=new Intent(SelectStemSubCategoryActivity.this, ICTPrograms.class);
                    context.startActivity(intent);

                }else if(selectedBtnPage.equals(getString(R.string.stem_science_and_math_programs))){

                }else if(selectedBtnPage.equals(getString(R.string.stem_engineering_technology_programs))){

                }else if(selectedBtnPage.equals(getString(R.string.stem_university_that_offer))){

                }
            }

            @Override
            public void onItemLongClick(@NonNull View view, StemData model, int position) {

            }
        };
    }

}