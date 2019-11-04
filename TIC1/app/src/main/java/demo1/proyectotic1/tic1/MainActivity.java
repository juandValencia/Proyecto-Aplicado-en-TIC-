package demo1.proyectotic1.tic1;

import android.app.Application;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

    public class MainActivity extends ListActivity {

    private MyAdapter mAdapter=null;

    public class Node{
        public String mTitle;
        public String mDescripcion;
        public Integer mImagenResourse;
        public String mEstado;
        public  String packed;

    }

    private static ArrayList<Node> mArray=new ArrayList<Node>();
    private    String[] Aplicaciones ,Aplicaciones2,AppPaquete ,AppPaquete2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //setContentView(R.layout.activity_main);
        List<PackageInfo> packagelist=getPackageManager().getInstalledPackages(0);

        Aplicaciones = new  String[packagelist.size()];
        AppPaquete=new String[packagelist.size()];

        for (int i=0;i<packagelist.size();i++){
            PackageInfo packageInfo=packagelist.get(i);
            if((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM)==0){

                 AppPaquete[i]=packageInfo.packageName;
                String appName=packageInfo.applicationInfo.loadLabel(getPackageManager()).toString();
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

            setData();
            mAdapter =new MyAdapter(this);
            setListAdapter(mAdapter);

    }

        protected void onListItemClick(ListView l ,View v ,int position,long id){
            //Toast.makeText(this,mArray.get(position).mTitle,Toast.LENGTH_LONG).show();

            if(mArray.get(position).mEstado.equals("ABRIR")||mArray.get(position).mEstado.equals("abrir")){
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage( mArray.get(position).packed);
                startActivity(launchIntent);
            }
            if(mArray.get(position).mEstado.equals("INSTALAR")||mArray.get(position).mEstado.equals("instalar")){
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://play.google.com/store/apps/details?id=" +mArray.get(position).packed)));
            }

        }

        protected  void onClick(){}

        public String ActulizarEstado(String nombreApp){
            String retorno="instalar";
            for(int i=0;i<Aplicaciones2.length-1;i++){
                if(Aplicaciones2[i].equals(nombreApp))retorno="abrir";
            }
            return  retorno;
        }

        public  void aculizarNode(Node node){
        String title=node.mTitle;
        node.mEstado="instalar";
            for(int i=0;i<Aplicaciones2.length-1;i++){
                if(Aplicaciones2[i].equals(title)){
                    node.mEstado="abrir";
                    node.packed=AppPaquete2[i];
                }

            }


        }

    private  void setData(){

        mArray.clear();
         Node mynode=new Node();

         mynode.mTitle=this.getResources().getString(R.string.App_Correo);
         mynode.mDescripcion=this.getResources().getString(R.string.App_Correod);
         mynode.mImagenResourse=R.drawable.correo;
         aculizarNode(mynode);
         mArray.add(mynode);

         Node mynode2=new Node();
         mynode2.mTitle=this.getResources().getString(R.string.App_Notas);
         mynode2.mDescripcion=this.getResources().getString(R.string.App_Notasd);
         mynode2.mImagenResourse=R.drawable.notas;
         aculizarNode(mynode2);
         mArray.add(mynode2);

         Node mynode3=new Node();
         mynode3.mTitle=this.getResources().getString(R.string.App_mensaj);
         mynode3.mDescripcion=this.getResources().getString(R.string.App_mensajd);
         mynode3.mImagenResourse=R.drawable.whatsapp;
         aculizarNode(mynode3);
         mArray.add(mynode3);

         Node mynode4=new Node();
         mynode4.mTitle=this.getResources().getString(R.string.App_gps);
         mynode4.mDescripcion=this.getResources().getString(R.string.App_gpsd);
         mynode4.packed=this.getResources().getString(R.string.App_gpsp);
         mynode4.mImagenResourse=R.drawable.maps;
         aculizarNode(mynode4);
         mArray.add(mynode4);

         Node mynode5=new Node();
         mynode5.mTitle=this.getResources().getString(R.string.App_remota);
         mynode5.mDescripcion=this.getResources().getString(R.string.App_remotad);
         mynode5.packed=this.getResources().getString(R.string.App_remotap);
         mynode5.mImagenResourse=R.drawable.teamviewer;
         aculizarNode(mynode5);
         mArray.add(mynode5);

         Node mynode6 =new Node();
         mynode6.mTitle=this.getResources().getString(R.string.App_voz);
         mynode6.mDescripcion=this.getResources().getString(R.string.App_vozd);
         mynode6.packed=this.getResources().getString(R.string.App_vozp);
         mynode6.mImagenResourse=R.drawable.voz;
         aculizarNode(mynode6);
         mArray.add(mynode6);

         Node mynode7=new Node();
         mynode7.mTitle=this.getResources().getString(R.string.App_texto);
         mynode7.mDescripcion=this.getResources().getString(R.string.App_textod);
         mynode7.packed=this.getResources().getString(R.string.App_textop);
         mynode7.mImagenResourse=R.drawable.word;
         aculizarNode(mynode7);
         mArray.add(mynode7);



    }
        public  static  class MyAdapter extends BaseAdapter {

            public Context mContext;
            public  MyAdapter(Context c){
                mContext=c;
            }

            @Override
            public int getCount() {
                return mArray.size();
            }

            @Override
            public Object getItem(int position) {
                return mArray.get(position);
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view =null;
                if(convertView==null){
                    //make up a new view
                    LayoutInflater inflater =(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    view =inflater.inflate(R.layout.activity_main,null);
                }
                else{
                    //Use convertView if it is avaliable
                    view=convertView;
                }
                ImageView img = (ImageView) view.findViewById(R.id.image);
                img.setImageDrawable(mContext.getDrawable(mArray.get(position).mImagenResourse));

                TextView tTitle =(TextView) view.findViewById(R.id.title);
                tTitle.setText(mArray.get(position).mTitle);

                TextView Tdescription =(TextView) view.findViewById(R.id.description);
                Tdescription.setText(mArray.get(position).mDescripcion);

                final Button button =(Button) view.findViewById(R.id.buttonlindo);
                button.setText(mArray.get(position).mEstado);
                button.setClickable(false);
                button.setFocusable(false);



                return view;
            }
        }




}
/*
private static class CustomCursorAdapter extends CursorAdapter {
        protected ListView mListView; protected static class RowViewHolder {
            public TextView mTitle; public TextView mText; }
            public CustomCursorAdapter(Activity activity) {
            super();
            mListView = activity.getListView(); }
            @Override public void bindView(View view, Context context, Cursor cursor) {
            }
             @Override public View newView(Context context, Cursor cursor, ViewGroup parent) {
            View view = View.inflate(context, R.layout.row_layout, null);
            RowViewHolder holder = new RowViewHolder();
            holder.mTitle = (TextView) view.findViewById(R.id.Title);
            holder.mText = (TextView) view.findViewById(R.id.Text);
            holder.mTitle.setOnClickListener(mOnTitleClickListener);
            holder.mText.setOnClickListener(mOnTextClickListener);
            view.setTag(holder); return view;
        } private OnClickListener mOnTitleClickListener = new OnClickListener() {
            @Override public void onClick(View v) {
                final int position = mListView.getPositionForView((View) v.getParent());
                Log.v(TAG, "Title clicked, row %d", position);
            } };
        private OnClickListener mOnTextClickListener = new OnClickListener() {
            @Override public void onClick(View v) {
                final int position = mListView.getPositionForView((View) v.getParent());
                Log.v(TAG, "Text clicked, row %d", position); } }; }
    }
    }


    ---------------------------------------------------------------
      button.setOnClickListener(new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(button.getText().equals("ABRIR")||button.getText().equals("abrir")){
                            Toast.makeText(mContext,button.getText().toString(),Toast.LENGTH_LONG).show();

                            notifyDataSetChanged();
                        }
                        else if(button.getText().equals("INSTALAR")||button.getText().equals("instalar")){
                            Toast.makeText(mContext,button.getText().toString(),Toast.LENGTH_LONG).show();
                            notifyDataSetChanged();
                        }

                    }
                });
*/