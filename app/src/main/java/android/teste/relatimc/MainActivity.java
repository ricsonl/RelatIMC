package android.teste.relatimc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("LifeCycle", getClass().getName() + ".onCreate()");
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("ResourceAsColor")
    public void submit(View v){
        Intent it = new Intent(getBaseContext(), SummaryActivity.class);

        EditText nameEdit = findViewById(R.id.nameEdit);
        EditText ageEdit = findViewById(R.id.ageEdit);
        EditText weightEdit = findViewById(R.id.weightEdit);
        EditText heightEdit = findViewById(R.id.heightEdit);

        if(!nameEdit.getText().toString().equals("")
                && !ageEdit.getText().toString().equals("")
                && !weightEdit.getText().toString().equals("")
                && !heightEdit.getText().toString().equals("")){

            Bundle params = new Bundle();

            params.putString("name", nameEdit.getText().toString());
            params.putString("age", ageEdit.getText().toString());
            params.putString("weight", weightEdit.getText().toString());
            params.putString("height", heightEdit.getText().toString());

            float weight = Float.parseFloat(weightEdit.getText().toString());
            float height = Float.parseFloat(heightEdit.getText().toString());
            float imc = imc(weight, height);

            params.putString("imc", Float.toString(imc));
            params.putString("classif", classif(imc));

            it.putExtras(params);
            startActivity(it);
            return;
        }
        Toast toast = Toast.makeText(v.getContext(), "Preencha todos os campos!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.getView().setBackgroundColor(getResources().getColor(R.color.colorWarning));
        toast.show();
    }

    static private float imc(float w, float h){
        return (float) (Math.round(w/(h*h) * 10.0) / 10.0);
    }

    static private String classif(float imc){
        if(imc >= 40)
            return "Obesidade Grau III";
        else if(imc >= 35)
            return "Obesidade Grau II";
        else if(imc >= 30)
            return "Obesidade Grau I";
        else if(imc >= 25)
            return "Sobrepeso";
        else if(imc >= 18.5)
            return "Saudável";
        return "Abaixo do Peso";
    }

    protected void onStart() {
        super.onStart();
        Log.i("LifeCycle", getClass().getName() + ".onStart()");
    }
    protected void onRestart() {
        super.onRestart();
        Log.i("LifeCycle", getClass().getName() + ".onRestart()");
    }
    protected void onResume() {
        super.onResume();
        Log.i("LifeCycle", getClass().getName() + ".onResume()");
    }
    protected void onPause() {
        super.onPause();
        Log.i("LifeCycle", getClass().getName() + ".onPause()");
    }
    protected void onStop() {
        super.onStop();
        Log.i("LifeCycle", getClass().getName() + ".onStop()");
    }
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LifeCycle", getClass().getName() + ".onDestroy()");
    }

}