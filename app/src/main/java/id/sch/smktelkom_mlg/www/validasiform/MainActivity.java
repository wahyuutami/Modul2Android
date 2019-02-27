package id.sch.smktelkom_mlg.www.validasiform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnok;
    EditText editnama, edittahun, editalamat;
    TextView txthasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnok=(Button)findViewById(R.id.btnok);
        editnama=(EditText)findViewById(R.id.editnama);
        editalamat=(EditText)findViewById(R.id.editalamat);
        edittahun=(EditText)findViewById(R.id.edittahun);
        txthasil=(TextView)findViewById(R.id.txthasil);

        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProcess();
            }
            private void doProcess() {
                if (isValid()){
                    String nama = editnama.getText().toString();
                    int tahun = Integer.parseInt(edittahun.getText().toString());
                    String alamat = editalamat.getText().toString();
                    txthasil.setText("Nama Anda" +nama + "\n"+ "Lahir pada"+tahun+ "\n" +"Alamat Anda"+alamat);
            } }

            private boolean isValid() {
                boolean valid = true;
                String nama = editnama.getText().toString();
                String tahun = edittahun.getText().toString();
                String alamat = editalamat.getText().toString();
                if (nama.isEmpty()){
                    editnama.setError("Nama Belum Diisi");
                    valid = false;
                }  else if (nama.length()<3){
                    editnama.setError("Karakter Nama kurang dari 3 karakter");
                    valid = false;
                } else {
                    editnama.setError(null);
                }  if (tahun.isEmpty()){
                    edittahun.setError("Tahun Belum Diisi");
                    valid = false;
                }  else if (tahun.length()<4){
                    edittahun.setError("Format tahun yyy");
                    valid = false;
                } else {
                    edittahun.setError(null);
                }  if (alamat.isEmpty()){
                    editalamat.setError("Alamat Belum Diisi");
                    valid = false;
                }  else if (alamat.length()<4){
                    editalamat.setError("Karakter kurang dari 4");
                    valid = false;
                } else{
                    editalamat.setError(null);
                }  return valid;
            } }); }
}
