package com.android.unischool.activity.BusinesHumanitiesEtc;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.android.unischool.AppBaseActivity;
import com.android.unischool.R;
import com.android.unischool.activity.displayProgramInfoActivity;
import com.android.unischool.base.BaseRecyclerAdapter;
import com.android.unischool.databinding.ItemProgramsBinding;
import com.android.unischool.model.FacultyData;
import com.android.unischool.utils.extensions.AppExtensionsKt;

import java.util.ArrayList;

public class EducationPrograms extends AppBaseActivity {
    private final BaseRecyclerAdapter<FacultyData, ItemProgramsBinding> adapter = getAdapter();

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_stem_sub_category);

        setContentView(R.layout.activity_select_stem_sub_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Education Programs");
        ;
        setToolbar(toolbar);
        RecyclerView recyclerView = findViewById(R.id.facultyRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        AppExtensionsKt.rvItemAnimation(recyclerView);
        adapter.addItems(ProgramsList());
        context = EducationPrograms.this;
    }

    private ArrayList<FacultyData> ProgramsList() {
        ArrayList<FacultyData> programsList = new ArrayList<>();

        programsList.add(new FacultyData(getString(R.string.EDUCATIONALADMINISTRATIONANDSUPERVISION), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/30/1cItuf.educatioonal-administratioin.jpg", getString(R.string.EDUCATIONALADMINISTRATIONANDSUPERVISIONHtml)));
        programsList.add(new FacultyData(getString(R.string.EDUCATIONALASSESSMENTEVALUATIONANDRESEARCH), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/30/1cIYnc.educational-assessment-evaluation.jpg", getString(R.string.EDUCATIONALASSESSMENTEVALUATIONANDRESEARCHHtml)));
        programsList.add(new FacultyData(getString(R.string.EducationalInstructionalMediaDesign), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/30/1cUJr8.educational-instructional-media.png", getString(R.string.EducationalInstructionalMediaDesignHtml)));
        programsList.add(new FacultyData(getString(R.string.SPECIALEDUCATIONANDTEACHING), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/30/1cUn5h.specail-education.jpg", getString(R.string.SPECIALEDUCATIONANDTEACHINGHtml)));
        programsList.add(new FacultyData(getString(R.string.STUDENTCOUNSELINGANDPERSONNELSERVICES), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/30/1chQJC.student-counselling.jpg", getString(R.string.STUDENTCOUNSELINGANDPERSONNELSERVICESHtml)));
        programsList.add(new FacultyData(getString(R.string.TEACHEREDUCATIONANDPROFESSIONALDEVELOPMENTSPECIFICLEVELSANDMETHODS), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/30/1chh8J.teacher-education-and-profession.jpg", getString(R.string.TEACHEREDUCATIONANDPROFESSIONALDEVELOPMENTSPECIFICLEVELSANDMETHODSHtml)));
        programsList.add(new FacultyData(getString(R.string.TEACHEREDUCATIONANDPROFESSIONALDEVELOPMENTSPECIFICSUBJECTAREAS), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/30/1chYn4.teacher-education-specific-subject-areas.jpg", getString(R.string.TEACHEREDUCATIONANDPROFESSIONALDEVELOPMENTSPECIFICSUBJECTAREASHtml)));

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
        Intent intent = new Intent(EducationPrograms.this, displayProgramInfoActivity.class);
        context.startActivity(intent);
    }


}