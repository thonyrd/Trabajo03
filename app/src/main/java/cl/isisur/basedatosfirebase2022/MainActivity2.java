package cl.isisur.basedatosfirebase2022;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import cl.isisur.basedatosfirebase2022.Clases.Producto;

public class MainActivity2 extends AppCompatActivity {
    private List<Producto> ListProducto = new ArrayList<>();
    private List<String> ListProductoNombre = new ArrayList<>();
    ArrayAdapter<String> arrayAdapterString;

    ListView lvListadoProductos;
    Button bt;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        Intent intent= new Intent(this, MainActivity2.class);
        lvListadoProductos = findViewById(R.id.lvListado);
        bt= findViewById(R.id.btVolver);
        inicializarFireBase();
        listarDatos();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }


    private void listarDatos() {
        databaseReference.child("Producto").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ListProducto.clear();
                ListProductoNombre.clear(); // Limpiar la lista de nombres
                for (DataSnapshot objs : snapshot.getChildren()) {
                    Producto p = objs.getValue(Producto.class);
                    ListProducto.add(p);
                    ListProductoNombre.add(p.getNombre() + " " + p.getPrecio());
                }
                arrayAdapterString = new ArrayAdapter<>(MainActivity2.this, android.R.layout.simple_list_item_1, ListProductoNombre);
                lvListadoProductos.setAdapter(arrayAdapterString);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void inicializarFireBase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}