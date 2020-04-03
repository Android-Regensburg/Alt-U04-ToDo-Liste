package de.ur.mi.android.u04todoliste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etTaskInput;
    private ImageButton btnAdd;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> todoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setupViews();
    }

    /**
     * Findet alle benötigten Views über findViewById und speichert sie in den jeweiligen Instanzvariablen ab
     */
    private void findViews() {
        etTaskInput = findViewById(R.id.et_task);
        btnAdd = findViewById(R.id.btn_add);
        listView = findViewById(R.id.todo_listView);
    }

    /**
     * Initialisiert die Liste und erstellt den OnClickListener für den "Add" Knopf
     */
    private void setupViews() {
        todoList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, todoList);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                todoList.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Liest den Inhalt der TextView und trimmt alle vorangehenden und nachfolgenden Leerzeichen
                String newTask = etTaskInput.getText().toString().trim();

                //Falls der Inhalt nicht leer ist wird er zur Liste hinzugefügt und die TextView wird für die nächste Eingabe zurückgesetzt
                if (!newTask.isEmpty()) {
                    todoList.add(newTask);
                    adapter.notifyDataSetChanged();
                    etTaskInput.setText("");
                }
            }
        });
    }
}
