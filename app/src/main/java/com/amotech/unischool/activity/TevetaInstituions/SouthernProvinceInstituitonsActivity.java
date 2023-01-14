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
import com.amotech.unischool.activity.STEM.ICTPrograms;
import com.amotech.unischool.activity.displayProgramInfoActivity;
import com.amotech.unischool.base.BaseRecyclerAdapter;
import com.amotech.unischool.databinding.LayoutBinding;
import com.amotech.unischool.model.FacultyData;
import com.amotech.unischool.utils.extensions.AppExtensionsKt;

import java.util.ArrayList;

public class SouthernProvinceInstituitonsActivity extends AppBaseActivity {
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
        context= ICTPrograms.this;


    }

    private ArrayList<FacultyData> ProgramsList() {
        ArrayList<FacultyData> programsList = new ArrayList<>();

        programsList.add(new FacultyData(getString(R.string.ComputerScience), getString(R.string.cs_additional_info)
                , "https://i.im.ge/2022/09/30/1blY0a.computer-scienc-e.png", getString(R.string.computerScienceHtml)));

        programsList.add(new FacultyData(getString(R.string.ComputerEngineering), getString(R.string.computer_eng_additional_info)
                , "https://i.im.ge/2022/09/30/1brqfL.computer-eng.jpg",  getString(R.string.computerEngHtml)));

        programsList.add(new FacultyData(getString(R.string.CyberSecurity), getString(R.string.additional_info)
                , "https://i.im.ge/2023/01/08/sQ9sPS.CYBER-SEC-1.png",  getString(R.string.CyberSecurityHtml)));
        programsList.add(new FacultyData(getString(R.string.computerSystemsAnalysis), getString(R.string.additional_info)
                , "https://i.im.ge/2023/01/08/sQik4M.systems-analyst-1.jpg",  getString(R.string.computerSystemsAnalysisHtml)));
        programsList.add(new FacultyData(getString(R.string.Informatics), getString(R.string.additional_info)
                , "https://i.im.ge/2023/01/08/sQi4jq.informatics-1.jpg",  getString(R.string.informaticsHtml)));
        programsList.add(new FacultyData(getString(R.string.ComputerSystemsNetworkingAndTelecommunications), getString(R.string.additional_info)
                , "https://i.im.ge/2023/01/08/sQ0T4m.computer-networking-1.jpg",  getString(R.string.ComputerSystemsNetworkingAndTelecommunicationsHtml)));
        programsList.add(new FacultyData(getString(R.string.ComputerInformationManagementSystem), getString(R.string.additional_info)
                , "https://i.im.ge/2023/01/08/sQ0STG.computer-information-managemnt-systems-1.jpg",  getString(R.string.ComputerInformationManagementSystemHtml)));
        programsList.add(new FacultyData(getString(R.string.InformationTechnology), getString(R.string.additional_info)
                , "https://i.im.ge/2023/01/08/sQ0DyS.information-technology-1.jpg",  getString(R.string.InformationTechnologyHtml)));
        programsList.add(new FacultyData(getString(R.string.Robotics), getString(R.string.additional_info)
                , "https://i.im.ge/2023/01/08/sQ0iWK.robotics-1.jpg",  getString(R.string.RoboticsHtml)));
        programsList.add(new FacultyData(getString(R.string.InformationScience), getString(R.string.additional_info)
                , "https://i.im.ge/2023/01/08/sQ0xop.information-science-1.png",  getString(R.string.InformationScienceHtml)));
        programsList.add(new FacultyData(getString(R.string.ActurialScience), getString(R.string.additional_info)
                , "https://i.im.ge/2023/01/08/sQ0gam.ActuarialScience-1.jpg",  getString(R.string.ActurialScienceHtml)));
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
            public void onItemClick(@NonNull View view, FacultyData model, int position, LayoutBinding dataBinding) {

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