package com.android.unischool.activity.MedicineHealthEtc;

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

public class MedicineHealthAndVetProgramsActivity extends AppBaseActivity {
    private final BaseRecyclerAdapter<FacultyData, ItemProgramsBinding> adapter = getAdapter();

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_select_stem_sub_category);

        setContentView(R.layout.activity_select_stem_sub_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Medical Programs");
        ;
        setToolbar(toolbar);
        RecyclerView recyclerView = findViewById(R.id.facultyRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        AppExtensionsKt.rvItemAnimation(recyclerView);
        adapter.addItems(ProgramsList());
        context = MedicineHealthAndVetProgramsActivity.this;


    }

    private ArrayList<FacultyData> ProgramsList() {
        ArrayList<FacultyData> programsList = new ArrayList<>();

        programsList.add(new FacultyData(getString(R.string.MEDICINEANDSURGERY), getString(R.string.medicine_and_surgery_additional_info)
                , "https://i.im.ge/2022/10/01/1g88Br.surgery.png", getString(R.string.MEDICINEANDSURGERYHtml)));
        programsList.add(new FacultyData(getString(R.string.VETERINARYMEDICINEANDALLIEDPROFESSIONS), getString(R.string.veterinary_additional_info)
                , "https://i.im.ge/2022/10/01/1gKFGa.vetetnary-medicine.jpg", getString(R.string.VETERINARYMEDICINEANDALLIEDPROFESSIONSHtml)));
        programsList.add(new FacultyData(getString(R.string.DENTALSURGERY), getString(R.string.dental_surgery_additional_info)
                , "https://i.im.ge/2022/10/01/1gRQ1F.dental.jpg", getString(R.string.DENTALSURGERYHtml)));
        programsList.add(new FacultyData(getString(R.string.PHARMACY), getString(R.string.pharmacy_additional_info)
                , "https://i.im.ge/2022/10/01/1gRswq.pharmacy.jpg", getString(R.string.PHARMACYHtml)));
        programsList.add(new FacultyData(getString(R.string.CLINICALMEDICINE), getString(R.string.clinical_medicine_additional_info)
                , "https://i.im.ge/2022/09/29/1xARi9.SeekPng-com-thermometer-png-246169.png", getString(R.string.CLINICALMEDICINEHtml)));
        programsList.add(new FacultyData(getString(R.string.PUBLICHEALTH), getString(R.string.public_health_additional_info)
                , "https://i.im.ge/2022/10/01/1gRLbf.public-heath.png", getString(R.string.PUBLICHEALTHHtml)));
        programsList.add(new FacultyData(getString(R.string.ENVIRONMENTALHEALTH), getString(R.string.environmental_health_additional_info)
                , "https://i.im.ge/2022/10/01/1gRwKL.environmental-health.jpg", getString(R.string.ENVIRONMENTALHEALTHHtml)));
        programsList.add(new FacultyData(getString(R.string.NURSING), getString(R.string.nursing_additional_info)
                , "https://i.im.ge/2022/10/01/1gRlXX.nursing.jpg", getString(R.string.NURSINGHtml)));


        programsList.add(new FacultyData(getString(R.string.PHYSIOTHERAPY), getString(R.string.physiotherapy_additional_info)
                , "https://i.im.ge/2022/10/01/1gRC7y.physiotherapy.jpg", getString(R.string.PHYSIOTHERAPYHtml)));
        programsList.add(new FacultyData(getString(R.string.OCCUPATIONALTHERAPY), getString(R.string.occupational_therapy_additional_info)
                , "https://i.im.ge/2022/10/01/1gRECS.occupational-therapy.jpg", getString(R.string.OCCUPATIONALTHERAPYHtml)));
        programsList.add(new FacultyData(getString(R.string.BIOMEDICALSCIENCE), getString(R.string.bio_medical_additional_info)
                , "https://i.im.ge/2022/10/01/1gRY26.biomedical-science.jpg", getString(R.string.BIOMEDICALSCIENCEHtml)));
        programsList.add(new FacultyData(getString(R.string.HEALTHINFORMATICS), getString(R.string.health_informatics_additional_info)
                , "https://i.im.ge/2022/10/01/1gRWc8.heakth-informatics.jpg", getString(R.string.HEALTHINFORMATICSHtml)));

        programsList.add(new FacultyData(getString(R.string.BIOLOGYANDBIOLOGICALSCIENCES), getString(R.string.biological_sciences_additional_info)
                , "https://i.im.ge/2022/10/02/1WbYMa.biological-science-s.jpg", getString(R.string.BIOLOGYANDBIOLOGICALSCIENCESHtml)));
        programsList.add(new FacultyData(getString(R.string.GENETICS), getString(R.string.geneticsstem_additional_info)
                , "https://i.im.ge/2022/10/02/1Wg7mC.genetics.jpg", getString(R.string.GENETICSHtml)));
        programsList.add(new FacultyData(getString(R.string.ALLIEDHEALTHANDMEDICALASSISTINGSERVICES), getString(R.string.allied_health_additional_info)
                , "https://i.im.ge/2022/10/02/1Wgv2D.mediacl-assisting.jpg", getString(R.string.ALLIEDHEALTHANDMEDICALASSISTINGSERVICESHtml)));
        programsList.add(new FacultyData(getString(R.string.MENTALANDSOCIALHEALTHSERVICESANDALLIEDPROFESSIONS), getString(R.string.additional_info)
                , "https://i.im.ge/2022/10/02/1Wgw10.mental-health.jpg", getString(R.string.MENTALANDSOCIALHEALTHSERVICESANDALLIEDPROFESSIONSHtml)));
        programsList.add(new FacultyData(getString(R.string.ALLIEDHEALTHDIAGNOSTICINTERVENTIONANDTREATMENTPROFESSIONS), getString(R.string.additional_info)
                , "https://i.im.ge/2022/10/02/1WRMu6.allied-health-diagnostic.jpg", getString(R.string.ALLIEDHEALTHDIAGNOSTICINTERVENTIONANDTREATMENTPROFESSIONSHtml)));
        programsList.add(new FacultyData(getString(R.string.ALTERNATIVEANDCOMPLEMENTARYMEDICALSUPPORTSERVICES), getString(R.string.additional_info)
                , "https://i.im.ge/2022/10/02/1WRQ9F.alternative-and-complimentary-medical-support-services.jpg", getString(R.string.ALTERNATIVEANDCOMPLEMENTARYMEDICALSUPPORTSERVICESHtml)));
        programsList.add(new FacultyData(getString(R.string.CLINICALMEDICALLABORATORYSCIENCERESEARCHANDALLIEDPROFESSIONS), getString(R.string.additional_info)
                , "https://i.im.ge/2022/10/02/1WRlLX.clinical-Medical-laborator.jpg", getString(R.string.CLINICALMEDICALLABORATORYSCIENCERESEARCHANDALLIEDPROFESSIONSHtml)));
        programsList.add(new FacultyData(getString(R.string.COMMUNICATIONDISORDERSSCIENCESANDSERVICES), getString(R.string.additional_info)
                , "https://i.im.ge/2022/10/02/1WRrx8.communication-disorders.jpg", getString(R.string.COMMUNICATIONDISORDERSSCIENCESANDSERVICESHtml)));
        programsList.add(new FacultyData(getString(R.string.DENTALSUPPORTSERVICESANDALLIEDPROFESSIONS), getString(R.string.additional_info)
                , "https://i.im.ge/2022/10/02/1WROqM.dental-support-services.jpg", getString(R.string.DENTALSUPPORTSERVICESANDALLIEDPROFESSIONSHtml)));
        programsList.add(new FacultyData(getString(R.string.DIETETICSANDCLINICALNUTRITIONSERVICES), getString(R.string.additional_info)
                , "https://i.im.ge/2022/10/02/1WR2kD.dietetics-and-cliniical-nutritioin.jpg", getString(R.string.DIETETICSANDCLINICALNUTRITIONSERVICESHtml)));
        programsList.add(new FacultyData(getString(R.string.HEALTHANDMEDICALADMINISTRATIVESERVICES), getString(R.string.additional_info)
                , "https://i.im.ge/2022/10/02/1WR7Qp.health-administration.jpg", getString(R.string.HEALTHANDMEDICALADMINISTRATIVESERVICESHtml)));

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
        Intent intent = new Intent(MedicineHealthAndVetProgramsActivity.this, displayProgramInfoActivity.class);
        context.startActivity(intent);
    }

}