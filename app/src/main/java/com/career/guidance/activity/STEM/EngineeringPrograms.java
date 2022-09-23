package com.career.guidance.activity.STEM;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.career.guidance.AppBaseActivity;
import com.career.guidance.R;
import com.career.guidance.activity.displayProgramInfoActivity;
import com.career.guidance.base.BaseRecyclerAdapter;
import com.career.guidance.databinding.ItemProgramsBinding;
import com.career.guidance.databinding.LayoutBinding;
import com.career.guidance.model.Programs;
import com.career.guidance.model.FacultyData;
import com.career.guidance.utils.extensions.AppExtensionsKt;
import com.career.guidance.utils.extensions.ExtensionsKt;

import java.util.ArrayList;
import java.util.List;

public class EngineeringPrograms extends AppBaseActivity {
    private final BaseRecyclerAdapter<FacultyData, ItemProgramsBinding> adapter = getAdapter();

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_stem_sub_category);

        setContentView(R.layout.activity_select_stem_sub_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Engineering Programs");
        ;
        setToolbar(toolbar);
        RecyclerView recyclerView = findViewById(R.id.facultyRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        AppExtensionsKt.rvItemAnimation(recyclerView);
        adapter.addItems(ProgramsList());
        context = EngineeringPrograms.this;


    }

    private ArrayList<FacultyData> ProgramsList() {
        ArrayList<FacultyData> programsList = new ArrayList<>();

        programsList.add(new FacultyData(getString(R.string.CivilEngineering), getString(R.string.additional_info)
                , getString(R.string.loading_icon_on_google_drive), getString(R.string.civilEngHtml)));

        programsList.add(new FacultyData(getString(R.string.MechanicalEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/22/1LeHk4.mechanical-engineering-icon.png", getString(R.string.mechanicalEngHtml)));
        programsList.add(new FacultyData(getString(R.string.AeronauticalEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/22/1LevFC.auronautical-engineering-icon.png", getString(R.string.AeronauticalEngineering)));
        programsList.add(new FacultyData(getString(R.string.ElectricalAndElectronicsEngineering), getString(R.string.additional_info)
                , getString(R.string.loading_icon_on_google_drive), getString(R.string.ElectricalAndElectronicsEngineering)));
        programsList.add(new FacultyData(getString(R.string.GeomaticsEngineering), getString(R.string.additional_info)
                , getString(R.string.loading_icon_on_google_drive), getString(R.string.GeomaticsEngineering)));
        programsList.add(new FacultyData(getString(R.string.TelecommunicationsEngineering), getString(R.string.additional_info)
                , getString(R.string.loading_icon_on_google_drive), getString(R.string.TelecommunicationsEngineering)));
        programsList.add(new FacultyData(getString(R.string.RailwayEngineering), getString(R.string.additional_info)
                , getString(R.string.loading_icon_on_google_drive), getString(R.string.RailwayEngineering)));
        programsList.add(new FacultyData(getString(R.string.MechatronicsEngineering), getString(R.string.additional_info)
                , getString(R.string.loading_icon_on_google_drive), getString(R.string.MechatronicsEngineering)));
        programsList.add(new FacultyData(getString(R.string.ElectromechanicalEngineering), getString(R.string.additional_info)
                , getString(R.string.loading_icon_on_google_drive), getString(R.string.ElectromechanicalEngineering)));
        programsList.add(new FacultyData(getString(R.string.ChemicalEngineering), getString(R.string.additional_info)
                , getString(R.string.loading_icon_on_google_drive), getString(R.string.chemicalEngHtml)));
        programsList.add(new FacultyData(getString(R.string.MiningEngineering), getString(R.string.additional_info)
                , getString(R.string.loading_icon_on_google_drive), getString(R.string.MiningEngineering)));
        programsList.add(new FacultyData(getString(R.string.GeotechnicalandGeoEnvironmentalEngineering), getString(R.string.additional_info)
                , getString(R.string.loading_icon_on_google_drive), getString(R.string.GeotechnicalandGeoEnvironmentalEngineering)));
        programsList.add(new FacultyData(getString(R.string.MetallurgicalEngineering), getString(R.string.additional_info)
                , getString(R.string.loading_icon_on_google_drive), getString(R.string.MetallurgicalEngineering)));
        programsList.add(new FacultyData(getString(R.string.EnvironmentalEngineering), getString(R.string.additional_info)
                , getString(R.string.loading_icon_on_google_drive), getString(R.string.EnvironmentalEngineering)));
        programsList.add(new FacultyData(getString(R.string.GeologyGeologicalEngineering), getString(R.string.additional_info)
                , getString(R.string.loading_icon_on_google_drive), getString(R.string.GeomaticsEngineering)));
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
                /*
                String selectedBtnPage=model.getPage();
                if (selectedBtnPage.equals( getString(R.string.CivilEngineering))){
                    opendisplayProgramInfoActivity(model);
                }
                else if(selectedBtnPage.equals(getString(R.string.stem_ict_programs))){

                }else if(selectedBtnPage.equals(getString(R.string.stem_science_and_math_programs))){

                }else if(selectedBtnPage.equals(getString(R.string.stem_engineering_technology_programs))){

                }else if(selectedBtnPage.equals(getString(R.string.stem_university_that_offer))){

                }
                */
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
        Intent intent = new Intent(EngineeringPrograms.this, displayProgramInfoActivity.class);
        context.startActivity(intent);
    }


}