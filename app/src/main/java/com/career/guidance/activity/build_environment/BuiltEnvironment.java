package com.career.guidance.activity.build_environment;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.career.guidance.AppBaseActivity;
import com.career.guidance.R;
import com.career.guidance.activity.STEM.EngineeringPrograms;
import com.career.guidance.activity.displayProgramInfoActivity;
import com.career.guidance.base.BaseRecyclerAdapter;
import com.career.guidance.databinding.ItemProgramsBinding;
import com.career.guidance.databinding.StemItemBinding;
import com.career.guidance.model.FacultyData;
import com.career.guidance.model.StemData;
import com.career.guidance.utils.extensions.AppExtensionsKt;

import java.util.ArrayList;

public class BuiltEnvironment extends AppBaseActivity {
    private final BaseRecyclerAdapter<FacultyData, ItemProgramsBinding> adapter = getAdapter();
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_stem_sub_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Built Environment Programs");
        ;
        setToolbar(toolbar);
        RecyclerView recyclerView = findViewById(R.id.facultyRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        AppExtensionsKt.rvItemAnimation(recyclerView);
        adapter.addItems(stemData());

        context = BuiltEnvironment.this;
    }

    private ArrayList<FacultyData> stemData() {
        ArrayList<FacultyData> stemDataArrayList = new ArrayList<>();
        // add sub categories


        stemDataArrayList.add(new FacultyData(getString(R.string.built_architecture), getString(R.string.architecture_additional_info)
                , "", getString(R.string.ARCHITECTURE)));


        stemDataArrayList.add(new FacultyData(getString(R.string.built_construction_management), getString(R.string.construction_managementadditional_info)
                , "", getString(R.string.CONSTRUCTIONMANAGEMENTANDECONOMICS)));

        stemDataArrayList.add(new FacultyData(getString(R.string.built_real_estate), getString(R.string.real_estate_additional_info)
                , "", getString(R.string.REALESTATE)));

        stemDataArrayList.add(new FacultyData(getString(R.string.built_regional_land_and_urban_planning), getString(R.string.regional_planning_additional_info)
                , "", getString(R.string.REGIONALANDURBANPLANNING)));


        return stemDataArrayList;
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


        SharedPreferences sharedPreferences = context.getSharedPreferences("MySharedPref", MODE_PRIVATE);
// Creating an Editor object to edit(write to the file)
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
// Storing the key and its value as the data fetched from edittext
        myEdit.putString("selectedProgram", model.getFacultyName());
        myEdit.putString("nameOfHtmlFile", model.getPage());
        myEdit.apply();
        Intent intent = new Intent(BuiltEnvironment.this, displayProgramInfoActivity.class);
        context.startActivity(intent);
    }
}