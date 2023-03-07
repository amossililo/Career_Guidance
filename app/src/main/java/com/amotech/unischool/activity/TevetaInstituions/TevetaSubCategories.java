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
import android.widget.Toast;

import com.amotech.unischool.AppBaseActivity;
import com.amotech.unischool.R;
import com.amotech.unischool.activity.STEM.EngineeringPrograms;
import com.amotech.unischool.activity.STEM.EngineeringTechnologyAndTechniciansPrograms;
import com.amotech.unischool.activity.STEM.ICTPrograms;
import com.amotech.unischool.activity.STEM.scienceAndMathematicsPrograms;
import com.amotech.unischool.activity.displayProgramInfoActivity;
import com.amotech.unischool.base.BaseRecyclerAdapter;
import com.amotech.unischool.databinding.StemItemBinding;
import com.amotech.unischool.model.FacultyData;
import com.amotech.unischool.model.StemData;
import com.amotech.unischool.utils.extensions.AppExtensionsKt;

import java.util.ArrayList;

public class TevetaSubCategories extends AppBaseActivity {

    private final BaseRecyclerAdapter<StemData, StemItemBinding> adapter = getAdapter();
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_stem_sub_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Institutions");;
        setToolbar(toolbar);
        RecyclerView recyclerView = findViewById(R.id.facultyRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        AppExtensionsKt.rvItemAnimation(recyclerView);
        adapter.addItems(stemData());

        context= TevetaSubCategories.this;
    }

    private ArrayList<StemData> stemData() {
        ArrayList<StemData> stemDataArrayList = new ArrayList<>();

        stemDataArrayList.add(new StemData(getString(R.string.ApplicationProcessGuidelinesAndProcedure), getString(R.string.additionalInfoProvince)
                , R.drawable.placeholder, getString(R.string.ApplicationProcessGuidelinesAndProcedure)));
        stemDataArrayList.add(new StemData(getString(R.string.LusakaProvince), getString(R.string.additionalInfoProvince)
                , R.drawable.placeholder, getString(R.string.LusakaProvince)));
        stemDataArrayList.add(new StemData(getString(R.string.CentralProvince), getString(R.string.additionalInfoProvince)
                , R.drawable.placeholder, getString(R.string.CentralProvince)));
        stemDataArrayList.add(new StemData(getString(R.string.CopperbeltProvince), getString(R.string.additionalInfoProvince)
                , R.drawable.placeholder, getString(R.string.CopperbeltProvince)));
        stemDataArrayList.add(new StemData(getString(R.string.LuapulaProvince), getString(R.string.additionalInfoProvince)
                , R.drawable.placeholder, getString(R.string.LuapulaProvince)));
        stemDataArrayList.add(new StemData(getString(R.string.NorthernProvince), getString(R.string.additionalInfoProvince)
                , R.drawable.placeholder, getString(R.string.NorthernProvince)));
        stemDataArrayList.add(new StemData(getString(R.string.NorthwesternProvince), getString(R.string.additionalInfoProvince)
                , R.drawable.placeholder, getString(R.string.NorthwesternProvince)));
        stemDataArrayList.add(new StemData(getString(R.string.SouthernProvince), getString(R.string.additionalInfoProvince)
                , R.drawable.placeholder, getString(R.string.SouthernProvince)));
        stemDataArrayList.add(new StemData(getString(R.string.WesternProvince), getString(R.string.additionalInfoProvince)
                , R.drawable.placeholder, getString(R.string.WesternProvince)));
        stemDataArrayList.add(new StemData(getString(R.string.EasternProvince), getString(R.string.additionalInfoProvince)
                , R.drawable.placeholder, getString(R.string.EasternProvince)));
        stemDataArrayList.add(new StemData(getString(R.string.MuchingaProvince), getString(R.string.additionalInfoProvince)
                , R.drawable.placeholder, getString(R.string.MuchingaProvince)));

        return stemDataArrayList;
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

                String selectedBtnPage=model.getPage();
                if (selectedBtnPage.equals(getString(R.string.ApplicationProcessGuidelinesAndProcedure))){
                   // Intent intent=new Intent(TevetaSubCategories.this, EngineeringPrograms.class);
                 //   context.startActivity(intent);
                    SharedPreferences sharedPreferences = context.getSharedPreferences("MySharedPref", MODE_PRIVATE);
// Creating an Editor object to edit(write to the file)
                    SharedPreferences.Editor myEdit = sharedPreferences.edit();
// Storing the key and its value as the data fetched from edittext
                    myEdit.putString("selectedProgram",getString(R.string.ApplicationProcessGuidelinesAndProcedure));
                    myEdit.putString("nameOfHtmlFile",getString(R.string.ApplicationProcessGuidelinesAndProcedureHtml));
                    myEdit.commit();
                    Intent intent = new Intent(TevetaSubCategories.this, displayProgramInfoActivity.class);
                    context.startActivity(intent);
                }
                else if(selectedBtnPage.equals(getString(R.string.LusakaProvince))){
                    Intent intent=new Intent(TevetaSubCategories.this, LusakaProvinceInstituitonsActivity.class);
                    context.startActivity(intent);

                }else if(selectedBtnPage.equals(getString(R.string.CentralProvince))){
                    Intent intent=new Intent(TevetaSubCategories.this, CentralProvinceInstituitonsActivity.class);
                    context.startActivity(intent);

                }else if(selectedBtnPage.equals(getString(R.string.CopperbeltProvince))){

                    Intent intent=new Intent(TevetaSubCategories.this, CopperbeltProvinceInstituitonsActivity.class);
                    context.startActivity(intent);
                }else if(selectedBtnPage.equals(getString(R.string.LuapulaProvince))){
                    Intent intent=new Intent(TevetaSubCategories.this, LuapulaProvinceInstituitonsActivity.class);
                    context.startActivity(intent);

                }else if(selectedBtnPage.equals(getString(R.string.NorthernProvince))){
                    Intent intent=new Intent(TevetaSubCategories.this, NorthernProvinceInstituitonsActivity.class);
                    context.startActivity(intent);

                }else if(selectedBtnPage.equals(getString(R.string.NorthwesternProvince))){
                    Intent intent=new Intent(TevetaSubCategories.this, NorthwesternProvinceInstituitonsActivity.class);
                    context.startActivity(intent);

                }else if(selectedBtnPage.equals(getString(R.string.SouthernProvince))){
                    Intent intent=new Intent(TevetaSubCategories.this, SouthernProvinceInstituitonsActivity.class);
                    context.startActivity(intent);

                }else if(selectedBtnPage.equals(getString(R.string.WesternProvince))){
                    Intent intent=new Intent(TevetaSubCategories.this, WesternProvinceInstituitonsActivity.class);
                    context.startActivity(intent);

                }else if(selectedBtnPage.equals(getString(R.string.EasternProvince))){
                    Intent intent=new Intent(TevetaSubCategories.this, EasternProvinceInstituitonsActivity.class);
                    context.startActivity(intent);

                }else if(selectedBtnPage.equals(getString(R.string.MuchingaProvince))){
                    Intent intent=new Intent(TevetaSubCategories.this, MuchingaProvinceInstituitonsActivity.class);
                    context.startActivity(intent);


                }else {
                    Toast.makeText(TevetaSubCategories.this,"Invalid selection",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onItemLongClick(@NonNull View view, StemData model, int position) {

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
        Intent intent = new Intent(TevetaSubCategories.this, displayProgramInfoActivity.class);
        context.startActivity(intent);
    }

}