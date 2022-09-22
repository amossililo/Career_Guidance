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
import com.career.guidance.databinding.LayoutBinding;
import com.career.guidance.databinding.StemItemBinding;
import com.career.guidance.model.FacultyData;
import com.career.guidance.model.Programs;
import com.career.guidance.model.StemData;
import com.career.guidance.utils.extensions.AppExtensionsKt;

import java.util.ArrayList;
import java.util.List;

public class ICTPrograms  extends AppBaseActivity {
    private final BaseRecyclerAdapter<FacultyData, LayoutBinding> adapter = getAdapter();

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
        context=ICTPrograms.this;


    }

    private ArrayList<FacultyData> ProgramsList() {
        ArrayList<FacultyData> programsList = new ArrayList<>();

        programsList.add(new FacultyData(getString(R.string.ComputerScience), getString(R.string.additional_info)
                , getString(R.string.loading_icon_on_google_drive), getString(R.string.ComputerScience)));

        programsList.add(new FacultyData(getString(R.string.ComputerEngineering), getString(R.string.additional_info)
                , getString(R.string.loading_icon_on_google_drive),  getString(R.string.ComputerEngineering)));

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
            }

            @Override
            public void onItemClick(@NonNull View view, FacultyData model, int position,LayoutBinding dataBinding) {
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
                    Intent intent=new Intent(ICTPrograms.this, EngineeringPrograms.class);
                    context.startActivity(intent);
                }
                else if(selectedBtnPage.equals(getString(R.string.stem_ict_programs))){

                }else if(selectedBtnPage.equals(getString(R.string.stem_science_and_math_programs))){

                }else if(selectedBtnPage.equals(getString(R.string.stem_engineering_technology_programs))){

                }else if(selectedBtnPage.equals(getString(R.string.stem_university_that_offer))){

                }
            }

            @Override
            public void onItemLongClick(@NonNull View view, FacultyData model, int position) {

            }
        };
    }


}