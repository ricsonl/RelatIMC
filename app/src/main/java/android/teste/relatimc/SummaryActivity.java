package android.teste.relatimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("LifeCycle", getClass().getName() + ".onCreate()");
        setContentView(R.layout.activity_summary);

        Intent it = getIntent();
        Bundle params = it.getExtras();

        TextView nameTxt = findViewById(R.id.nameOut);
        TextView ageTxt = findViewById(R.id.ageOut);
        TextView weightTxt = findViewById(R.id.weightOut);
        TextView heightTxt = findViewById(R.id.heightOut);
        TextView imcTxt = findViewById(R.id.imcOut);
        TextView classifTxt = findViewById(R.id.classifOut);

        nameTxt.setText(params.getString("name"));
        ageTxt.setText(params.getString("age") + " anos");
        weightTxt.setText(params.getString("weight") + " Kg");
        heightTxt.setText(params.getString("height") + " m");
        imcTxt.setText(Html.fromHtml( params.getString("imc") + " Kg/m<sup><small>2</small></sup>"));
        classifTxt.setText(params.getString("classif"));
    }

    public void recalc(View v){
        Intent it = new Intent(getBaseContext(), MainActivity.class);
        it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(it);
        finish();
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
