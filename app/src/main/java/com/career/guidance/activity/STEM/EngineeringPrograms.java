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
                , "https://lh4.googleusercontent.com/LiVEmRaxk08ntlhuhCOWcGUCgkzNs4f218ylO7IK9Kipbx-eZI0Le7qicpwUahkYwV4=w2400", getString(R.string.civilEngHtml)));

        programsList.add(new FacultyData(getString(R.string.MechanicalEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/22/1LeHk4.mechanical-engineering-icon.png", getString(R.string.mechanicalEngHtml)));
        programsList.add(new FacultyData(getString(R.string.AeronauticalEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/22/1LevFC.auronautical-engineering-icon.png", getString(R.string.AeronauticalEngineering)));
        programsList.add(new FacultyData(getString(R.string.ElectricalAndElectronicsEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/29/1xbnlW.electrical-eng.jpg", getString(R.string.electricalEngHtml)));
        programsList.add(new FacultyData(getString(R.string.GeomaticsEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/29/1xb400.geomatics-eng.jpg", getString(R.string.geomaticsEngHtml)));
        programsList.add(new FacultyData(getString(R.string.TelecommunicationsEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/29/1xbGec.telecommunication-eng.jpg", getString(R.string.telecommunicationEngHtml)));
        programsList.add(new FacultyData(getString(R.string.RailwayEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/29/1xZlXm.railway.jpg", getString(R.string.railwayEngHtml)));
        programsList.add(new FacultyData(getString(R.string.MechatronicsEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/29/1xZSpL.mechatronics.jpg", getString(R.string.mechatronicsEngHtml)));
        programsList.add(new FacultyData(getString(R.string.ElectromechanicalEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/29/1xZaKa.electro-mechanical.jpg", getString(R.string.electroEngHtml)));
        programsList.add(new FacultyData(getString(R.string.ChemicalEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/29/1xZj29.CHEMICAL.webp", getString(R.string.chemicalEngHtml)));
        programsList.add(new FacultyData(getString(R.string.MiningEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/29/1xZm6X.MINING-ENGINNERING.jpg", getString(R.string.mininEngHtml)));
        programsList.add(new FacultyData(getString(R.string.GeotechnicalandGeoEnvironmentalEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/29/1xZNlh.GEO-ENVIRONMENTAL.jpg", getString(R.string.geotechnicalEngHtml)));
        programsList.add(new FacultyData(getString(R.string.MetallurgicalEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/29/1xZY2p.metallergy.webp", getString(R.string.metallurgicalEngHtml)));
        programsList.add(new FacultyData(getString(R.string.EnvironmentalEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/29/1xZcV1.environmental-eng.jpg", getString(R.string.environmentalEngHtml)));
        programsList.add(new FacultyData(getString(R.string.GeologyGeologicalEngineering), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/29/1xK18M.geology.jpg", getString(R.string.geomaticsEngHtml)));
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
        Intent intent = new Intent(EngineeringPrograms.this, displayProgramInfoActivity.class);
        context.startActivity(intent);
    }


}