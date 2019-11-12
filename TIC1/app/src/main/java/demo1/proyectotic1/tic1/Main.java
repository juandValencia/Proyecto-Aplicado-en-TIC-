package demo1.proyectotic1.tic1;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class Main extends AppCompatActivity {
    EditText et1,et2;
    private Cursor fila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        et1= (EditText) findViewById(R.id.etusuario);
        et2= (EditText) findViewById(R.id.etcontrasena);
    }

    public void ingresar(View v){
        DBHelper admin=new DBHelper(this,"Empresa",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
        String usuario=et1.getText().toString();
        String contrasena=et2.getText().toString();
        fila=db.rawQuery("select usuario,contrasena,codigo from usuarios where usuario='"+usuario+"' and contrasena='"+contrasena+"'",null);

        if (fila.moveToFirst()){
            String usua=fila.getString(0);
            String pass=fila.getString(1);
            int code = fila.getInt(2);
            if (usuario.equals(usua)&&contrasena.equals(pass)){
                Intent ven=new Intent(this,MenuActivity.class);
                ven.putExtra("IdUsuario",code);
                startActivity(ven);
                et1.setText("");
                et2.setText("");
            }

        }



    }


    public void salir(View v){
        finish();
        //System.exit(0);
    }
}
