package com.amotech.unischool.activity.STEM;

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
import com.amotech.unischool.activity.displayProgramInfoActivity;
import com.amotech.unischool.base.BaseRecyclerAdapter;
import com.amotech.unischool.databinding.LayoutBinding;
import com.amotech.unischool.databinding.StemItemBinding;
import com.amotech.unischool.model.FacultyData;
import com.amotech.unischool.utils.extensions.AppExtensionsKt;

import java.util.ArrayList;

public class ICTPrograms  extends AppBaseActivity {
    private final BaseRecyclerAdapter<FacultyData, LayoutBinding> adapter = getAdapter();

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_stem_sub_category);

        setContentView(R.layout.activity_select_stem_sub_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("ICT Programs");;
        setToolbar(toolbar);
        RecyclerView recyclerView = findViewById(R.id.facultyRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        AppExtensionsKt.rvItemAnimation(recyclerView);
        adapter.addItems(ProgramsList());
        context=ICTPrograms.this;


    }

    private ArrayList<FacultyData> ProgramsList() {
        ArrayList<FacultyData> programsList = new ArrayList<>();

        programsList.add(new FacultyData(getString(R.string.ComputerScience), getString(R.string.cs_additional_info)
                , "https://i.im.ge/2022/09/30/1blY0a.computer-scienc-e.png", getString(R.string.computerScienceHtml)));

        programsList.add(new FacultyData(getString(R.string.ComputerEngineering), getString(R.string.computer_eng_additional_info)
                , "https://i.im.ge/2022/09/30/1brqfL.computer-eng.jpg",  getString(R.string.computerEngHtml)));

        return programsList;
    }

    private BaseRecyclerAdapter<FacultyData, LayoutBinding> getAdapter() {

        return new BaseRecyclerAdapter<FacultyData, LayoutBinding>() {
            @Override
            public int getLayoutResId() {
                return R.layout.layout;
            }

            @Override
            public void onBindData(FacultyData model, int position, LayoutBinding dataBinding) {

                dataBinding.tvFacultyName.setText(model.getFacultyName());
                dataBinding.tvProductRate.setText(model.getFacultyInfo());
                AppExtensionsKt.loadImageFromUri(dataBinding.ivFaculty, model.getFacultyImage());
            }

            @Override
            public void onItemClick(@NonNull View view, FacultyData model, int position,LayoutBinding dataBinding) {

// implement click
                opendisplayProgramInfoActivity(model);

            }

            @Override
            public void onItemLongClick(@NonNull View view, FacultyData model, int position) {

            }
        };
    }

    public void opendisplayProgramInfoActivity(FacultyData model) {


        SharedPreferences sharedPreferences = context.getSharedPreferences("MySharedPref", MODE_PRIVATE);
// Creating an Editor object to edit(write to the file)
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
// Storing the key and its value as the data fetched from edittext
        myEdit.putString("selectedProgram", model.getFacultyName());
        myEdit.putString("nameOfHtmlFile", model.getPage());
        myEdit.commit();
        Intent intent = new Intent(ICTPrograms.this, displayProgramInfoActivity.class);
        context.startActivity(intent);
    }

}