package com.amotech.unischool.activity.TevetaInstituions;

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

import com.amotech.unischool.AppBaseActivity;
import com.amotech.unischool.R;
import com.amotech.unischool.activity.STEM.EngineeringPrograms;
import com.amotech.unischool.activity.displayProgramInfoActivity;
import com.amotech.unischool.base.BaseRecyclerAdapter;
import com.amotech.unischool.databinding.ItemProgramsBinding;
import com.amotech.unischool.model.FacultyData;
import com.amotech.unischool.utils.extensions.AppExtensionsKt;

import java.util.ArrayList;

public class TevetaInstitutions extends AppBaseActivity {
    private final BaseRecyclerAdapter<FacultyData, ItemProgramsBinding> adapter = getAdapter();

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_stem_sub_category);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Teveta");
        ;
        setToolbar(toolbar);
        RecyclerView recyclerView = findViewById(R.id.facultyRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        AppExtensionsKt.rvItemAnimation(recyclerView);
        adapter.addItems(ProgramsList());
        context = TevetaInstitutions.this;



/*
        Button crashButton = new Button(this);
        crashButton.setText("Test Crash");
        crashButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                throw new RuntimeException("Test Crash"); // Force a crash
            }
        });

        addContentView(crashButton, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        */
    }



    private ArrayList<FacultyData> ProgramsList() {
        ArrayList<FacultyData> programsList = new ArrayList<>();

        programsList.add(new FacultyData(getString(R.string.CivilEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/30/1comZx.civil-eng.jpg", getString(R.string.civilEngHtml)));

        programsList.add(new FacultyData(getString(R.string.MechanicalEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/22/1LeHk4.mechanical-engineering-icon.png", getString(R.string.mechanicalEngHtml)));
        programsList.add(new FacultyData(getString(R.string.AeronauticalEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/10/02/1WZ7vf.aeraunatical.jpg", getString(R.string.aeronauticalEngHtml)));
        programsList.add(new FacultyData(getString(R.string.ElectricalAndElectronicsEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/10/02/1WZLNr.electrical-eng.jpg", getString(R.string.electricalEngHtml)));
        programsList.add(new FacultyData(getString(R.string.GeomaticsEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/10/02/1WZir0.geomatics-eng.jpg", getString(R.string.geomaticsEngHtml)));
        programsList.add(new FacultyData(getString(R.string.TelecommunicationsEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/10/02/1WK4YK.telecommunication-eng.jpg", getString(R.string.telecommunicationEngHtml)));
        programsList.add(new FacultyData(getString(R.string.RailwayEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/10/02/1WVXmY.rzilways.jpg", getString(R.string.railwayEngHtml)));
        programsList.add(new FacultyData(getString(R.string.MechatronicsEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/10/02/1WVAcF.mechatronics.jpg", getString(R.string.mechatronicsEngHtml)));
        programsList.add(new FacultyData(getString(R.string.ElectromechanicalEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/10/02/1WVlZD.electro-mechanical.jpg", getString(R.string.electroEngHtml)));
        programsList.add(new FacultyData(getString(R.string.ChemicalEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/10/02/1WVFhC.CHEMICAL.jpg", getString(R.string.chemicalEngHtml)));
        programsList.add(new FacultyData(getString(R.string.MiningEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/29/1xZm6X.MINING-ENGINNERING.jpg", getString(R.string.mininEngHtml)));
        programsList.add(new FacultyData(getString(R.string.GeotechnicalandGeoEnvironmentalEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/10/02/1WVBlW.geotechy.jpg", getString(R.string.geotechnicalEngHtml)));
        programsList.add(new FacultyData(getString(R.string.MetallurgicalEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/10/02/1WVSaP.metallergy2.png", getString(R.string.metallurgicalEngHtml)));
        programsList.add(new FacultyData(getString(R.string.EnvironmentalEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/10/02/1WVWlD.GEO-ENVIRONMENTAL.jpg", getString(R.string.environmentalEngHtml)));
        programsList.add(new FacultyData(getString(R.string.GeologyGeologicalEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/29/1xzyyz.geology-2.jpg", getString(R.string.geomaticsEngHtml)));
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


        SharedPreferences sharedPreferences = context.getSharedPreferences("MySharedPref", MODE_PRIVATE);
// Creating an Editor object to edit(write to the file)
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
// Storing the key and its value as the data fetched from edittext
        myEdit.putString("selectedProgram", model.getFacultyName());
        myEdit.putString("nameOfHtmlFile", model.getPage());
        myEdit.commit();
        Intent intent = new Intent(context, displayProgramInfoActivity.class);
        context.startActivity(intent);
    }

}