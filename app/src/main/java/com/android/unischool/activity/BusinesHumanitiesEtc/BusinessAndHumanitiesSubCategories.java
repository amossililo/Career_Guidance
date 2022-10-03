package com.android.unischool.activity.BusinesHumanitiesEtc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.unischool.AppBaseActivity;
import com.android.unischool.R;
import com.android.unischool.base.BaseRecyclerAdapter;
import com.android.unischool.databinding.StemItemBinding;
import com.android.unischool.model.StemData;
import com.android.unischool.utils.extensions.AppExtensionsKt;

import java.util.ArrayList;

public class BusinessAndHumanitiesSubCategories extends AppBaseActivity {
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

        context= BusinessAndHumanitiesSubCategories.this;
    }

    private ArrayList<StemData> stemData() {
        ArrayList<StemData> stemDataArrayList = new ArrayList<>();

        stemDataArrayList.add(new StemData(getString(R.string.BUSINESSPROGRAMS), getString(R.string.business_programs_additional_info)
                , R.drawable.placeholder, getString(R.string.BUSINESSPROGRAMS)));
        stemDataArrayList.add(new StemData(getString(R.string.HUMANITYPROGRAMS), getString(R.string.humanity_programs_additional_info)
                , R.drawable.placeholder, getString(R.string.HUMANITYPROGRAMS)));
        stemDataArrayList.add(new StemData(getString(R.string.EDUCATIONPROGRAMS), getString(R.string.education_programs_additional_info)
                , R.drawable.placeholder, getString(R.string.EDUCATIONPROGRAMS)));

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


                String selectedBtnPage=model.getPage();
                if (selectedBtnPage.equals(getString(R.string.BUSINESSPROGRAMS))){
                    Intent intent=new Intent(BusinessAndHumanitiesSubCategories.this,BusinessPrograms.class);
                    context.startActivity(intent);
                }
                else if(selectedBtnPage.equals(getString(R.string.HUMANITYPROGRAMS))){
                    Intent intent=new Intent(BusinessAndHumanitiesSubCategories.this, HumanityPrograms.class);
                    context.startActivity(intent);
                }else if(selectedBtnPage.equals(getString(R.string.EDUCATIONPROGRAMS))){
                    Intent intent=new Intent(BusinessAndHumanitiesSubCategories.this, EducationPrograms.class);
                    context.startActivity(intent);
                }
            }

            @Override
            public void onItemLongClick(@NonNull View view, StemData model, int position) {

            }
        };
    }

}
