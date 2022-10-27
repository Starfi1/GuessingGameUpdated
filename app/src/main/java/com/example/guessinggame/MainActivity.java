package com.example.guessinggame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SharedMemory;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCustomLogin,btnLogin;
    SharedPreferences sp;
    EditText etUserName,etPass;
    TextView welcomescreen;
    Dialog d;
    Integer maxrandom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnLogin=(Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        sp=getSharedPreferences("details1",0);




    }

    public void createLoginDialog()
    {


        d= new Dialog(this);
        d.setContentView(R.layout.login_dialog);
        d.setTitle("Login");
        d.setCancelable(true);
        etUserName=(EditText)d.findViewById(R.id.etUserName);
        etPass=(EditText)d.findViewById(R.id.etPassword);
        btnCustomLogin=(Button)d.findViewById(R.id.btnDialogLogin);
        btnCustomLogin.setOnClickListener(this);
        welcomescreen=(TextView)d.findViewById(R.id.hello_message);
     d.show();
        String strname=sp.getString("username",null);
        String strpass=sp.getString("pass",null);
        if(strname!=null&&strpass!=null){
            etUserName.setText(strname);
            etPass.setText(strpass);
            welcomescreen.setText("hello, "+strname);
        }
    }

public void onClick(View v)
{
    if(v==btnLogin)
    {
        createLoginDialog();
    }
    else if(v==btnCustomLogin)
    {
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("username",etUserName.getText().toString());
        editor.putString("pass",etPass.getText().toString());
        editor.commit();
        Toast.makeText(this,"username and password saved", Toast.LENGTH_LONG).show();
        d.dismiss();
    }
}



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item)
    {
        super.onOptionsItemSelected(item);
        int id=item.getItemId();
        if(id==R.id.item1){
            Intent intent = new Intent(MainActivity.this, FirstGame.class);
            intent.putExtra("maxrandom", 51);
            startActivity(intent);
        }
        if(id==R.id.item2){
            Intent intent = new Intent(MainActivity.this, FirstGame.class);
            intent.putExtra("maxrandom", 101);
            startActivity(intent);
        }
        if(id==R.id.item3){
            Intent intent = new Intent(MainActivity.this, FirstGame.class);
            intent.putExtra("maxrandom", 201);
            startActivity(intent);
        }
return true;
    }



    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}