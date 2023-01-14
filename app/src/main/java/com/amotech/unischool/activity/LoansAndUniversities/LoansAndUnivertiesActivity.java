package com.amotech.unischool.activity.LoansAndUniversities;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.amotech.unischool.AppBaseActivity;
import com.amotech.unischool.R;

import com.amotech.unischool.activity.STEM.EngineeringPrograms;
import com.amotech.unischool.activity.STEM.SelectStemSubCategoryActivity;
import com.amotech.unischool.activity.TevetaInstituions.TevetaSubCategories;
import com.amotech.unischool.activity.displayProgramInfoActivity;
import com.amotech.unischool.base.BaseRecyclerAdapter;
import com.amotech.unischool.databinding.ItemProgramsBinding;
import com.amotech.unischool.databinding.StemItemBinding;
import com.amotech.unischool.model.FacultyData;
import com.amotech.unischool.utils.extensions.AppExtensionsKt;

import java.util.ArrayList;

public class LoansAndUnivertiesActivity extends AppBaseActivity {
    private final BaseRecyclerAdapter<FacultyData, ItemProgramsBinding> adapter = getAdapter();

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_stem_sub_category);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Loans/Universities");
        ;
        setToolbar(toolbar);
        RecyclerView recyclerView = findViewById(R.id.facultyRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        AppExtensionsKt.rvItemAnimation(recyclerView);
        adapter.addItems(ProgramsList());
        context = LoansAndUnivertiesActivity.this;


    }

    private ArrayList<FacultyData> ProgramsList() {
        ArrayList<FacultyData> programsList = new ArrayList<>();

        programsList.add(new FacultyData(getString(R.string.STUDENTLOANSFORLOCALUNIVERSITIES), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/30/1cj3Sz.loacal-universities.jpg", getString(R.string.STUDENTLOANSFORLOCALUNIVERSITIESHtml)));
        programsList.add(new FacultyData(getString(R.string.ABROADSCHOLARSHIPS), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/30/1c9i1F.abroad.webp", getString(R.string.ABROADSCHOLARSHIPSHtml)));
        programsList.add(new FacultyData(getString(R.string.CDFBOARDINGSECONDARYSCHOOLBUSARIES), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/30/1cjrc8.secondary-school.jpg", getString(R.string.CDFBOARDINGSECONDARYSCHOOLBUSARIESHtml)));
        programsList.add(new FacultyData(getString(R.string.CDFSkillsDevelopmentBursaries), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/30/1cjODM.skills-dev.jpg", getString(R.string.CDFSkillsDevelopmentBursariesHtml)));
        programsList.add(new FacultyData(getString(R.string.Universities), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/29/1x38PM.SeekPng-com-graduation-hat-png-46121.png", getString(R.string.UniversitiesHtml)));
        programsList.add(new FacultyData(getString(R.string.TevetaInstitutions), getString(R.string.additional_info)
                , "https://i.im.ge/2023/01/08/sQC3iy.teveta.jpg", getString(R.string.TevetaInstitutionsHtml)));

        return programsList;
    }

    private BaseRecyclerAdapter<FacultyData, ItemProgramsBinding> getAdapter() {

        return new BaseRecyclerAdapter<FacultyData, ItemProgramsBinding>() {
            @Override
            public int getLayoutResId() {
                return R.layout.item_programs;
            }

            @Override
            public void onBindData(FacultyData model, int position, ItemProgramsBinding dataBinding) {

                dataBinding.tvFacultyName.setText(model.getFacultyName());
                dataBinding.tvProductRate.setText(model.getFacultyInfo());

                AppExtensionsKt.loadImageFromUri(dataBinding.ivFaculty, model.getFacultyImage());
            }

            @Override
            public void onItemClick(@NonNull View view, FacultyData model, int position, ItemProgramsBinding dataBinding) {

                opendisplayProgramInfoActivity(model);

            }

            @Override
            public void onItemLongClick(@NonNull View view, FacultyData model, int position) {

            }
        };
    }

    public void opendisplayProgramInfoActivity(FacultyData model) {

        if (model.getFacultyName().equals(getString(R.string.TevetaInstitutions))){
            Intent intent=new Intent(LoansAndUnivertiesActivity.this, TevetaSubCategories.class);
            context.startActivity(intent);
            return;
        }

        SharedPreferences sharedPreferences = context.getSharedPreferences("MySharedPref", MODE_PRIVATE);
// Creating an Editor object to edit(write to the file)
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
// Storing the key and its value as the data fetched from edittext
        myEdit.putString("selectedProgram", model.getFacultyName());
        myEdit.putString("nameOfHtmlFile", model.getPage());
        myEdit.commit();
        Intent intent = new Intent(LoansAndUnivertiesActivity.this, displayProgramInfoActivity.class);
        context.startActivity(intent);
    }


}