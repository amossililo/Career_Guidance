package com.career.guidance.activity.STEM;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.career.guidance.AppBaseActivity;
import com.career.guidance.R;
import com.career.guidance.base.BaseRecyclerAdapter;
import com.career.guidance.databinding.StemItemBinding;
import com.career.guidance.model.Programs;
import com.career.guidance.model.StemData;
import com.career.guidance.utils.extensions.AppExtensionsKt;

import java.util.ArrayList;
import java.util.List;

public class EngineeringPrograms  extends AppBaseActivity {
    private final BaseRecyclerAdapter<StemData, StemItemBinding> adapter = getAdapter();

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_stem_sub_category);

        setContentView(R.layout.activity_select_stem_sub_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Engineering Programs");;
        setToolbar(toolbar);
        RecyclerView recyclerView = findViewById(R.id.facultyRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        AppExtensionsKt.rvItemAnimation(recyclerView);
        adapter.addItems(ProgramsList());
        context=EngineeringPrograms.this;




/*
        List<Programs> programList = new ArrayList<>();
        programList.add(new Programs(1, R.drawable.loading_icon,getString(R.string.CivilEngineering),getString(R.string.civilEngHtml)));
        programList.add(new Programs(1, R.drawable.loading_icon,getString(R.string.MechanicalEngineering),getString(R.string.MechanicalEngHtml)));
        programList.add(new Programs(1, R.drawable.loading_icon,getString(R.string.AeronauticalEngineering),getString(R.string.AeronauticalEngHtml)));
        programList.add(new Programs(1, R.drawable.loading_icon,getString(R.string.ElectricalAndElectronicsEngineering),getString(R.string.ElectricalAndElectronicsEngHtml)));
        programList.add(new Programs(1, R.drawable.loading_icon,getString(R.string.GeomaticsEngineering),getString(R.string.GeomaticsEngHtml)));
        programList.add(new Programs(1, R.drawable.loading_icon,getString(R.string.TelecommunicationsEngineering),getString(R.string.TelecommunicationsEngHtml)));
        programList.add(new Programs(1, R.drawable.loading_icon,getString(R.string.RailwayEngineering),getString(R.string.RailwayEngHtml)));
        programList.add(new Programs(1, R.drawable.loading_icon,getString(R.string.MechatronicsEngineering),getString(R.string.MechatronicsEngHtml)));
        programList.add(new Programs(1, R.drawable.loading_icon,getString(R.string.ElectromechanicalEngineering),getString(R.string.ElectromechanicalEngHtml)));
        programList.add(new Programs(1, R.drawable.loading_icon,getString(R.string.ArchitecturalEngineering),getString(R.string.ArchitecturalEngHtml)));

*/

    }

    private ArrayList<StemData> ProgramsList() {
        ArrayList<StemData> programsList = new ArrayList<>();

        programsList.add(new StemData(getString(R.string.CivilEngineering), getString(R.string.additional_info)
                , R.drawable.placeholder, getString(R.string.CivilEngineering)));

        programsList.add(new StemData(getString(R.string.MechanicalEngineering), getString(R.string.additional_info)
                , R.drawable.placeholder,  getString(R.string.MechanicalEngineering)));
        programsList.add(new StemData(getString(R.string.AeronauticalEngineering), getString(R.string.additional_info)
                , R.drawable.placeholder, getString(R.string.AeronauticalEngineering)));
        programsList.add(new StemData(getString(R.string.ElectricalAndElectronicsEngineering), getString(R.string.additional_info)
                , R.drawable.placeholder, getString(R.string.ElectricalAndElectronicsEngineering)));
        programsList.add(new StemData(getString(R.string.GeomaticsEngineering), getString(R.string.additional_info)
                , R.drawable.placeholder, getString(R.string.GeomaticsEngineering)));
        programsList.add(new StemData(getString(R.string.TelecommunicationsEngineering), getString(R.string.additional_info)
                , R.drawable.placeholder, getString(R.string.TelecommunicationsEngineering)));
        programsList.add(new StemData(getString(R.string.RailwayEngineering), getString(R.string.additional_info)
                , R.drawable.placeholder, getString(R.string.RailwayEngineering)));
        programsList.add(new StemData(getString(R.string.MechatronicsEngineering), getString(R.string.additional_info)
                , R.drawable.placeholder, getString(R.string.MechatronicsEngineering)));
        programsList.add(new StemData(getString(R.string.ElectromechanicalEngineering), getString(R.string.additional_info)
                , R.drawable.placeholder, getString(R.string.ElectromechanicalEngineering)));
        programsList.add(new StemData(getString(R.string.ChemicalEngineering), getString(R.string.additional_info)
                , R.drawable.placeholder, getString(R.string.ChemicalEngineering)));
        programsList.add(new StemData(getString(R.string.MiningEngineering), getString(R.string.additional_info)
                , R.drawable.placeholder, getString(R.string.MiningEngineering)));
        programsList.add(new StemData(getString(R.string.GeotechnicalandGeoEnvironmentalEngineering), getString(R.string.additional_info)
                , R.drawable.placeholder, getString(R.string.GeotechnicalandGeoEnvironmentalEngineering)));
        programsList.add(new StemData(getString(R.string.MetallurgicalEngineering), getString(R.string.additional_info)
                , R.drawable.placeholder, getString(R.string.MetallurgicalEngineering)));
        programsList.add(new StemData(getString(R.string.EnvironmentalEngineering), getString(R.string.additional_info)
                , R.drawable.placeholder, getString(R.string.EnvironmentalEngineering)));
        programsList.add(new StemData(getString(R.string.GeologyGeologicalEngineering), getString(R.string.additional_info)
                , R.drawable.placeholder, getString(R.string.GeomaticsEngineering)));
        return programsList;
    }

    private BaseRecyclerAdapter<StemData, StemItemBinding> getAdapter() {

        return new BaseRecyclerAdapter<StemData, StemItemBinding>() {
            @Override
            public int getLayoutResId() {
                return R.layout.stem_item;
            }

            @Override
            public void onBindData(StemData model, int position, StemItemBinding dataBinding) {

                dataBinding.stemName.setText(model.getStemName());
                dataBinding.stemInfo.setText(model.getStemInfo());
            }

            @Override
            public void onItemClick(@NonNull View view, StemData model, int position, StemItemBinding dataBinding) {
// implement click
                /*
// we will not use a switch statement because i cant fetch strings for switch cases, if will be used instead
                switch (model.getPage()){
                    case getString(R.string.stem_engineering_programs):
                        Intent intent=new Intent(SelectStemSubCategoryActivity.this, EngineeringPrograms.class);
                        context.startActivity(intent);
                        break;
                    case "d":

                        break;

                }
                */
                String selectedBtnPage=model.getPage();
                if (selectedBtnPage.equals(getString(R.string.stem_engineering_programs))){
                    Intent intent=new Intent(EngineeringPrograms.this, EngineeringPrograms.class);
                    context.startActivity(intent);
                }
                else if(selectedBtnPage.equals(getString(R.string.stem_ict_programs))){

                }else if(selectedBtnPage.equals(getString(R.string.stem_science_and_math_programs))){

                }else if(selectedBtnPage.equals(getString(R.string.stem_engineering_technology_programs))){

                }else if(selectedBtnPage.equals(getString(R.string.stem_university_that_offer))){

                }
            }

            @Override
            public void onItemLongClick(@NonNull View view, StemData model, int position) {

            }
        };
    }


}