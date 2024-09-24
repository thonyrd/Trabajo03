package cl.isisur.basedatosfirebase2022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cl.isisur.basedatosfirebase2022.Clases.Libro;
import cl.isisur.basedatosfirebase2022.Clases.Usuario;


public class MainActivity extends AppCompatActivity {
    private List<Libro> ListLibro = new ArrayList<Libro>();
    private List<String> ListLibroNombre = new ArrayList();
    ArrayAdapter<Libro> arrayAdapterLibro;
    ArrayAdapter<String> arrayAdapterString;


    private List<Usuario> ListUsuario= new ArrayList<Usuario>();



    EditText eTNombre,eTEmail;
    Button bTBoton;


    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        eTNombre=findViewById(R.id.eTNombre);
        eTEmail= findViewById(R.id.etCorreo);

        bTBoton=findViewById(R.id.bTAgregar);

        Intent intent= new Intent(this, MainActivity2.class);

        inicializarFireBase();


        bTBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario Usuario = new Usuario();
                //libro.setIdAutor("11111");
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(UUID.randomUUID().toString());
                usuario.setNombre(eTNombre.getText().toString());
                usuario.setEmail(eTEmail.getText().toString());


                databaseReference.child("Usuario").child(usuario.getIdUsuario()).setValue(usuario);

                startActivity(intent);

            }
        });


    }



    private void inicializarFireBase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase =FirebaseDatabase.getInstance();
        databaseReference =firebaseDatabase.getReference();
    }
}