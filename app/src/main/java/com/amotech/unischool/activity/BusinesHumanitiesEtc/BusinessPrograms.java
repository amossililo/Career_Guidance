package com.amotech.unischool.activity.BusinesHumanitiesEtc;

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
import com.amotech.unischool.databinding.ItemProgramsBinding;
import com.amotech.unischool.model.FacultyData;
import com.amotech.unischool.utils.extensions.AppExtensionsKt;

import java.util.ArrayList;

public class BusinessPrograms  extends AppBaseActivity {
    private final BaseRecyclerAdapter<FacultyData, ItemProgramsBinding> adapter = getAdapter();

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_stem_sub_category);

        setContentView(R.layout.activity_select_stem_sub_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Business Programs");
        ;
        setToolbar(toolbar);
        RecyclerView recyclerView = findViewById(R.id.facultyRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        AppExtensionsKt.rvItemAnimation(recyclerView);
        adapter.addItems(ProgramsList());
        context = BusinessPrograms.this;


    }

    private ArrayList<FacultyData> ProgramsList() {
        ArrayList<FacultyData> programsList = new ArrayList<>();

        programsList.add(new FacultyData(getString(R.string.ACCOUNTANCY), getString(R.string.accountancy_additional_info)
                , "https://i.im.ge/2022/09/29/13uOj1.accountancy.jpg", getString(R.string.ACCOUNTANCYHtml)));
        programsList.add(new FacultyData(getString(R.string.PURCHASINGANDSUPPLY), getString(R.string.purchasing_and_supply_additional_info)
                , "https://i.im.ge/2022/09/29/13u5TJ.purchasing-and-supply.jpg", getString(R.string.PURCHASINGANDSUPPLYHtml)));
        programsList.add(new FacultyData(getString(R.string.HUMANRESOURCEMANAGEMENT), getString(R.string.human_resouces_additional_info)
                , "https://i.im.ge/2022/09/29/13uHbr.human-resource-management.png", getString(R.string.HUMANRESOURCEMANAGEMENTHtml)));
        programsList.add(new FacultyData(getString(R.string.BANKINGANDFINANCE), getString(R.string.banking_and_finance_additional_info)
                , "https://i.im.ge/2022/09/29/13uJa0.banking-and-finance.jpg", getString(R.string.BANKINGANDFINANCEHtml)));
        programsList.add(new FacultyData(getString(R.string.PUBLICPROCUREMENT), getString(R.string.public_procurement_additional_info)
                , "https://i.im.ge/2022/09/29/13F21K.Public-procurement.jpg", getString(R.string.PUBLICPROCUREMENTHtml)));
        programsList.add(new FacultyData(getString(R.string.PRODUCTIONANDOPERATIONSMANAGEMENT), getString(R.string.production_operation_additional_info)
                , "https://i.im.ge/2022/09/29/13FNer.production-and-operations-managment.jpg", getString(R.string.PRODUCTIONANDOPERATIONSMANAGEMENTHtml)));
        programsList.add(new FacultyData(getString(R.string.TRANSPORTANDLOGISTICSMANAGEMENT), getString(R.string.transport_and_logistics_additional_info)
                , "https://i.im.ge/2022/09/29/13Fx6L.transport-and-logistics.jpg", getString(R.string.TRANSPORTANDLOGISTICSMANAGEMENTHtml)));
        programsList.add(new FacultyData(getString(R.string.MARKETING), getString(R.string.marketing_additional_info)
                , "https://i.im.ge/2022/09/29/13FZCz.marketing.jpg", getString(R.string.MARKETINGHtml)));
        programsList.add(new FacultyData(getString(R.string.BUSINESSADMINISTRATIONANDMANAGEMENT), getString(R.string.business_admin_additional_info)
                , "https://i.im.ge/2022/09/29/13FJgh.business-admininistration.jpg", getString(R.string.BUSINESSADMINISTRATIONANDMANAGEMENTHtml)));
        programsList.add(new FacultyData(getString(R.string.BUSINESSOPERATIONSSUPPORTANDASSISTANTSERVICES), getString(R.string.business_operations_additional_info)
                , "https://i.im.ge/2022/09/29/13FGED.business-operatins.jpg", getString(R.string.BUSINESSOPERATIONSSUPPORTANDASSISTANTSERVICESHtml)));
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
        Intent intent = new Intent(BusinessPrograms.this, displayProgramInfoActivity.class);
        context.startActivity(intent);
    }


}