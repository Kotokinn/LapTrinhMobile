package com.example.myapplication.chuong8.baitap;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.DatabaseHelper;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Chuong8_BaiTap1 extends AppCompatActivity {

    private EditText etId, etType, etName;
    private Button btnLoad, btnAdd, btnDelete, btnUpdate, btnClose;
    private ListView lvContacts;
    private DatabaseHelper dbHelper;


    //    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuong8_bai_tap1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();
        dbHelper = new DatabaseHelper(this);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadContacts();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addContact();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteContact();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateContact();
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        lvContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List<Contact> contacts = dbHelper.getAllContacts();
                Contact selectedContact = contacts.get(position);

                etId.setText(String.valueOf(selectedContact.getId()));
                etType.setText(selectedContact.getType());
                etName.setText(selectedContact.getName());
            }
        });

        // Load contacts when app starts
        loadContacts();
    }

    private void initViews() {
        etId = findViewById(R.id.etId);
        etType = findViewById(R.id.etType);
        etName = findViewById(R.id.etName);
        btnLoad = findViewById(R.id.btnLoad);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnClose = findViewById(R.id.btnClose);
        lvContacts = findViewById(R.id.lvContacts);

    }

    private void loadContacts() {
        List<Contact> contacts = dbHelper.getAllContacts();
        ContactAdapter aContact;

        aContact = new ContactAdapter(contacts, R.layout.contact_item, this);
        lvContacts.setAdapter(aContact);
    }

    private void addContact() {
        String type = etType.getText().toString().trim();
        String name = etName.getText().toString().trim();

        if (type.isEmpty() || name.isEmpty()) {
            Toast.makeText(this, "Please enter both type and name", Toast.LENGTH_SHORT).show();
            return;
        }

        Contact contact = new Contact(type, name);
        dbHelper.addContact(contact);
        clearInputs();
        loadContacts();
        Toast.makeText(this, "Contact added successfully", Toast.LENGTH_SHORT).show();
    }

    private void deleteContact() {
        String idStr = etId.getText().toString().trim();

        if (idStr.isEmpty()) {
            Toast.makeText(this, "Please enter ID to delete", Toast.LENGTH_SHORT).show();
            return;
        }

        int id = Integer.parseInt(idStr);
        dbHelper.deleteContact(id);
        clearInputs();
        loadContacts();
        Toast.makeText(this, "Contact deleted successfully", Toast.LENGTH_SHORT).show();
    }

    private void updateContact() {
        String idStr = etId.getText().toString().trim();
        String type = etType.getText().toString().trim();
        String name = etName.getText().toString().trim();

        if (idStr.isEmpty() || type.isEmpty() || name.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Contact contact = new Contact();
        contact.setId(Integer.parseInt(idStr));
        contact.setType(type);
        contact.setName(name);

        dbHelper.updateContact(contact);
        clearInputs();
        loadContacts();
        Toast.makeText(this, "Contact updated successfully", Toast.LENGTH_SHORT).show();
    }

    private void clearInputs() {
        etId.setText("");
        etType.setText("");
        etName.setText("");
    }

}