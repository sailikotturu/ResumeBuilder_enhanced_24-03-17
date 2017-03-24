package com.example.sailik.resumebuilder_24_feb.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.sailik.resumebuilder_24_feb.models.Projects;
import com.example.sailik.resumebuilder_24_feb.R;
import com.example.sailik.resumebuilder_24_feb.database.DbHelper;

public class ProjectDialog extends AppCompatActivity {

    private EditText mPname;
    private EditText mPdesc;
    private EditText mPduration;
    private DbHelper dbObj;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_project_dialog);


        mPname = (EditText)findViewById(R.id.projectname_desc_editText);
        mPdesc = (EditText)findViewById(R.id.projectdesc_editText);
        mPduration = (EditText)findViewById(R.id.projectduration_editText);
        dbObj = new DbHelper(this);


        Intent getI = getIntent();
        email=getI.getStringExtra("email");

        Toolbar toolbar = (Toolbar) findViewById(R.id.mytoolbar_addproject);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null) {

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
            case R.id.tick:
                String name = mPname.getText().toString();
                String description = mPdesc.getText().toString();
                String duration = mPduration.getText().toString();
                Projects obj = new Projects();
                obj.setProjectName(name);
                obj.setDescription(description);
                obj.setProjectDuration(duration);
                dbObj.createProjectRow(obj,email);
                this.finish();
                break;

        }
        return super.onOptionsItemSelected(item);

    }
}
