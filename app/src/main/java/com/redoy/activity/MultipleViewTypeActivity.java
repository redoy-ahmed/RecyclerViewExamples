package com.redoy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.redoy.recyclerviewselection.R;
import com.redoy.adapter.MultipleTypeAdapter;
import com.redoy.model.MultiEmployee;

import java.util.ArrayList;
import java.util.Objects;

public class MultipleViewTypeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_view_type);
        initView();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Multiple view type");
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        createList();
    }

    private void createList() {
        ArrayList<MultiEmployee> employees = new ArrayList<>();

        MultiEmployee employee = new MultiEmployee();
        employee.setName("Robert");
        employee.setAddress("New York");
        employee.setPhone("+61234456");
        employees.add(employee);

        employee = new MultiEmployee();
        employee.setName("Tom");
        employee.setAddress("California");
        employee.setEmail("tom_frank@gmail.com");
        employees.add(employee);

        employee = new MultiEmployee();
        employee.setName("Smith");
        employee.setAddress("Philadelphia");
        employee.setEmail("smith_carrol@gmail.com");
        employees.add(employee);

        employee = new MultiEmployee();
        employee.setName("Ryan");
        employee.setAddress("Canada");
        employee.setPhone("+612001456");
        employees.add(employee);

        employee = new MultiEmployee();
        employee.setName("Mark");
        employee.setAddress("Boston");
        employee.setEmail("mark_walmerd@gmail.com");
        employees.add(employee);

        employee = new MultiEmployee();
        employee.setName("Adam");
        employee.setAddress("Brooklyn");
        employee.setPhone("+61211780");
        employees.add(employee);

        employee = new MultiEmployee();
        employee.setName("Kevin");
        employee.setAddress("New Jersey");
        employee.setPhone("+94221035");
        employees.add(employee);

        // set adapter
        MultipleTypeAdapter adapter = new MultipleTypeAdapter(this, employees);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}