package com.redoy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.redoy.recyclerviewselection.R;
import com.redoy.adapter.SwipeAdapter;
import com.redoy.model.Employee;

import java.util.ArrayList;
import java.util.Objects;

public class SwipeSelectionActivity extends AppCompatActivity {

    private android.support.v7.widget.RecyclerView recyclerView;
    private SwipeAdapter adapter;
    private ArrayList<Employee> employees = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_selection);
        this.recyclerView = findViewById(R.id.recyclerView);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Swipe");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        adapter = new SwipeAdapter(this, employees);
        recyclerView.setAdapter(adapter);

        createList();
    }

    private void createList() {
        employees = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Employee employee = new Employee();
            employee.setName("Employee " + (i + 1));
            employees.add(employee);
        }
        adapter.setEmployees(employees);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
