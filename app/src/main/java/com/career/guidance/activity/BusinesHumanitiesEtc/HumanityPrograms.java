package com.career.guidance.activity.BusinesHumanitiesEtc;

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

import com.career.guidance.AppBaseActivity;
import com.career.guidance.R;
import com.career.guidance.activity.displayProgramInfoActivity;
import com.career.guidance.base.BaseRecyclerAdapter;
import com.career.guidance.databinding.ItemProgramsBinding;
import com.career.guidance.model.FacultyData;
import com.career.guidance.utils.extensions.AppExtensionsKt;

import java.util.ArrayList;

public class HumanityPrograms extends AppBaseActivity {
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
        context = HumanityPrograms.this;


    }

    private ArrayList<FacultyData> ProgramsList() {
        ArrayList<FacultyData> programsList = new ArrayList<>();

        programsList.add(new FacultyData(getString(R.string.Law), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.LawHtml)));
        programsList.add(new FacultyData(getString(R.string.ECONOMICS), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.ECONOMICSHtml)));
        programsList.add(new FacultyData(getString(R.string.MASSCOMMUNICATION), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.MASSCOMMUNICATIONHtml)));
        programsList.add(new FacultyData(getString(R.string.SOCIALWORK), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.SOCIALWORKHtml)));
        programsList.add(new FacultyData(getString(R.string.PSYCHOLOGY), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.PSYCHOLOGYHtml)));
        programsList.add(new FacultyData(getString(R.string.STATISTICSANDDEMOGRAPHICStudies), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.STATISTICSANDDEMOGRAPHICStudiesHtml)));
        programsList.add(new FacultyData(getString(R.string.POLITICALSCIENCE), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.POLITICALSCIENCEHtml)));
        programsList.add(new FacultyData(getString(R.string.COMMUNITYDEVELOPMENTSTUDIES), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.COMMUNITYDEVELOPMENTSTUDIESHtml)));
        programsList.add(new FacultyData(getString(R.string.PUBLICADMINISTRATION), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.PUBLICADMINISTRATIONHtml)));
        programsList.add(new FacultyData(getString(R.string.LIBERALARTSANDSCIENCESGENERALSTUDIESANDHUMANITIES), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.LIBERALARTSANDSCIENCESGENERALSTUDIESANDHUMANITIESHtml)));


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
        Intent intent = new Intent(HumanityPrograms.this, displayProgramInfoActivity.class);
        context.startActivity(intent);
    }


}