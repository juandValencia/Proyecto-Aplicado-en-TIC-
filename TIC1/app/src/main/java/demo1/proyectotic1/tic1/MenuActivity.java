package demo1.proyectotic1.tic1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {


    public class Node{
        public String mTitle;
        public String mDescripcion;
        public Integer mImagenResourse;
        public String mEstado;
        public  String packed;

    }

    private static ArrayList<MenuActivity.Node> mArray=new ArrayList<MenuActivity.Node>();
    private    String[] Aplicaciones ,Aplicaciones2,AppPaquete ,AppPaquete2;
    private String[] apps = {"Outlook","Notas de Keep","WhatsApp","Maps","TeamViewer","Grabadora de Voz","Word"};
    Button btnSalir,btnAppsxUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        List<PackageInfo> packagelist=getPackageManager().getInstalledPackages(0);

        Aplicaciones = new  String[packagelist.size()];
        AppPaquete = new String[packagelist.size()];

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        final AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);;
        dialogo1.setTitle("Cerrar Sesión");
        dialogo1.setMessage("¿Desea cerrar sesión?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                salir();
            }
        });
        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                finish();
            }
        });

        btnSalir = (Button)findViewById(R.id.btnSalir);
        btnAppsxUsuario = (Button)findViewById(R.id.btnAppsxUsuario);
        btnAppsxUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getApplicationContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogo1.show();
            }
        });

        for (int i=0;i<packagelist.size();i++){
            PackageInfo packageInfo=packagelist.get(i);
            if((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM)==0){
                AppPaquete[i] = packageInfo.packageName;
                String appName = packageInfo.applicationInfo.loadLabel(getPackageManager()).toString();
                Aplicaciones[i]=appName;
            }
        }
        Integer flag=0;
        for(int i=0;i<Aplicaciones.length;i++){
            if(Aplicaciones[i]==null)flag++;
        }
        Aplicaciones2=new String[Aplicaciones.length-flag];
        AppPaquete2=new String[Aplicaciones.length-flag];
        Integer j=0;
        for (int i=0;i<=flag;i++){
            if(Aplicaciones[i]!=null){
                Aplicaciones2[j]=Aplicaciones[i];
                AppPaquete2[j]=AppPaquete[i];
                j++;
            }

        }

    }

    private void salir(){
        SQLServerConnection con = new SQLServerConnection();
        Connection cn1 = con.conexion();
        Connection cn2 = con.conexion();
        Statement pst1,pst2;
        ResultSet rs1,rs2 = null;
        try{
            pst1 = cn1.createStatement();
            pst2 = cn2.createStatement();
            int idusuario = getIntent().getIntExtra("IdUsuario",1);
            int contador = 0,idaplicacion;
            rs1 = pst1.executeQuery("SELECT * FROM AppsxUsuario WHERE IdUsuario = "+idusuario);
            while(rs1.next()){
                System.out.println(rs1.getInt(0)+" "+rs1.getInt(1));
                pst1.executeUpdate("DELETE FROM AppsxUsuario WHERE IdUsuario = "+idusuario+" AND IdAplicacion = "+rs1.getInt(0));
            }
            for (int i = 0;i<Aplicaciones2.length;i++){
                for (int j = 0;j<apps.length;j++){
                    if(Aplicaciones2[i].equals(apps[j])){
                        rs2 = pst2.executeQuery("SELECT IdAplicacion FROM AppsrRecomend WHERE Nombre = '"+apps[j]+"'");
                        if(rs2.next()) pst2.executeUpdate("INSERT INTO AppsxUsuario (IdAplicacion,IdUsuario,Nombre) VALUES ("+rs2.getInt("IdAplicacion")+","+idusuario+",'"+apps[j]+"')");
                    }
                }
            }
            if(rs2!=null) rs2.close();
            rs1.close();
            pst1.close();
            pst2.close();
            cn1.close();
            cn2.close();
            Toast.makeText(this,"Cierre de sesión exitoso",Toast.LENGTH_LONG).show();
            Intent intent = new Intent (getApplicationContext(), Main.class);
            startActivityForResult(intent, 0);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
