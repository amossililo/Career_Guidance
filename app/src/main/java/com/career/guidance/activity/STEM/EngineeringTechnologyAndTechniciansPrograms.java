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

import com.career.guidance.AppBaseActivity;
import com.career.guidance.R;
import com.career.guidance.activity.displayProgramInfoActivity;
import com.career.guidance.base.BaseRecyclerAdapter;
import com.career.guidance.databinding.ItemProgramsBinding;
import com.career.guidance.model.FacultyData;
import com.career.guidance.utils.extensions.AppExtensionsKt;

import java.util.ArrayList;

public class EngineeringTechnologyAndTechniciansPrograms extends AppBaseActivity {
    private final BaseRecyclerAdapter<FacultyData, ItemProgramsBinding> adapter = getAdapter();

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_stem_sub_category);

        setContentView(R.layout.activity_select_stem_sub_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Eng Tech/Technicians");
        ;
        setToolbar(toolbar);
        RecyclerView recyclerView = findViewById(R.id.facultyRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        AppExtensionsKt.rvItemAnimation(recyclerView);
        adapter.addItems(ProgramsList());
        context = EngineeringTechnologyAndTechniciansPrograms.this;


    }

    private ArrayList<FacultyData> ProgramsList() {
        ArrayList<FacultyData> programsList = new ArrayList<>();


        programsList.add(new FacultyData(getString(R.string.ArchitecturalEngineeringTechnologyTechnician), getString(R.string.architecture_eng_tech_additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.ArchitecturalEngineeringTechnologyTechnicianHtml)));
        programsList.add(new FacultyData(getString(R.string.CivilEngineeringTechnologyTechnician), getString(R.string.civilEngHtml_tech_additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.CivilEngineeringTechnologyTechnicianHtml)));
        programsList.add(new FacultyData(getString(R.string.ConstructionEngineeringTechnologiesConstructionEngineeringTechnologyTechnician), getString(R.string.construction_enge_additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.ConstructionEngineeringTechnologiesConstructionEngineeringTechnologyTechnicianHtml)));
        programsList.add(new FacultyData(getString(R.string.DraftingDesignEngineeringTechnologiesTechnicians), getString(R.string.drafting_design_additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.DraftingDesignEngineeringTechnologiesTechniciansHtml)));
        programsList.add(new FacultyData(getString(R.string.IndustrialProductionTechnologiesTechniciansChemicalEngineering), getString(R.string.industrial_additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.IndustrialProductionTechnologiesTechniciansChemicalEngineeringHtml)));
        programsList.add(new FacultyData(getString(R.string.MechanicAndRepairTechnologiesTechniciansElectricalElectronicMaintenanceandRepairTechnology), getString(R.string.mechanic_and_repair_additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.MechanicAndRepairTechnologiesTechniciansElectricalElectronicMaintenanceandRepairTechnologyHtml)));
        programsList.add(new FacultyData(getString(R.string.VehicleMaintenanceandRepairTechnologies), getString(R.string.vehicle_maintenceadditional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.VehicleMaintenanceandRepairTechnologiesHtml)));
        programsList.add(new FacultyData(getString(R.string.PhysicalScienceTechnologiesTechniciansScienceTechnologiesTechniciansGeneral), getString(R.string.physical_science_additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.PhysicalScienceTechnologiesTechniciansScienceTechnologiesTechniciansGeneralHtml)));
        programsList.add(new FacultyData(getString(R.string.PrecisionProductionofBoilermakingBoilermaker), getString(R.string.precision_productions_dditional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.PrecisionProductionOfBoilerMakingBoilermakerHtml)));
        programsList.add(new FacultyData(getString(R.string.PrecisionMetalWorkingComputerNumericallyControlledCNCMachinistTechnologyCNCMachinist), getString(R.string.precision_metal_additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.PrecisionMetalWorkingComputerHtml)));
        programsList.add(new FacultyData(getString(R.string.MetalFabricator), getString(R.string.metal_fabricatior_additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.MetalFabricator)));
        programsList.add(new FacultyData(getString(R.string.PrecisionProductionTradesWoodworking), getString(R.string.precision_production_trades_additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.PrecisionProductionTradesWoodworkingHtml)));
        programsList.add(new FacultyData(getString(R.string.FireProtection), getString(R.string.fire_protection_additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.FireProtectionHtml)));
        programsList.add(new FacultyData(getString(R.string.TransportationAndMaterialsMoving), getString(R.string.transportation_and_materials_additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.TransportationAndMaterialsMovingHtml)));


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
        Intent intent = new Intent(EngineeringTechnologyAndTechniciansPrograms.this, displayProgramInfoActivity.class);
        context.startActivity(intent);
    }


}