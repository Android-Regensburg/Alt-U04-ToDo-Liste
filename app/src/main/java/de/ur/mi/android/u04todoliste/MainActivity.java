package de.ur.mi.android.u04todoliste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Diese Anwendung erlaubt NutzerInnen über ein Eingabefeld und einen Button Aufgaben für eine ToDo-
 * Liste zu erstellen.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Instanzvariablen für Referenzen auf Eingabefelder
     */
    private EditText etTaskInput;
    private ImageButton btnAdd;
    private ListView listView;

    /**
     * Instanzvariablen für die Verwendung von Listen in Kombination mit dem ListView
     */
    private ArrayAdapter<String> adapter;
    private ArrayList<String> todoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        setupViewsAndListener();
    }

    private void initUI() {
        etTaskInput = findViewById(R.id.et_task);
        btnAdd = findViewById(R.id.btn_add);
        listView = findViewById(R.id.todo_listView);
    }

    private void setupViewsAndListener() {
        setupList();
        setButtonClickListener();
    }

    /**
     * Der Adapter wird initialisiert und mit dem ListView verbunden. Mit einem itemLongClickListener
     * kann erkannt werden wann ein Listeneintrag lange geklickt wird.
     */
    private void setupList() {
        /*Ein ArrayAdapter braucht als Parameter einen Context (Diese Activity), ein Layout für die
          Listeneinträge (Wir verwenden hier ein vorgefertigtes aus der Android-Library) und eine Liste
          (hier ArrayList) für die Einträge.
         */
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, todoList);

        //Der Adapter wird dem ListView zugewiesen
        listView.setAdapter(adapter);

        /*Dem ListView wird ein onItemLongClickListener angehängt, der erkennt wenn ein Eintrag lange
          geklickt wird
         */
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //Der lang geklickte Eintrag wird aus der Liste entfernt
                todoList.remove(position);

                //Der Adapter wird über diese Änderung benachrichtigt
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void setButtonClickListener() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Der Inhalt des Eingabefeldes wird ausgelesen und in einer String-Variable gespeichert
                String newTask = etTaskInput.getText().toString();

                checkAndAddNewTask(newTask);

            }
        });
    }

    /**
     * Überprüft ob der String einen neuen Eintrag enthält und speichert diesen wenn "ok" in die Liste
     * @param newTask neuer Listeneintrag
     */
    private void checkAndAddNewTask(String newTask) {

        //Überprüft ob der neue Listeneintrag leer ist.
        if (!newTask.isEmpty()) {
            //Eintrag wird der Liste hinzugefügt
            todoList.add(newTask);

            //Adapter wird benachrichtigt
            adapter.notifyDataSetChanged();

            //Eingabefeld wird geleert.
            etTaskInput.setText("");
        }
    }
}
