package Main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.Algorithms.R;

import java.util.Random;

import Encryption.EncryptionMain;
import Hash.HashMain;


//oi oi HELP function ta kaj krche wait
public class MainActivity extends AppCompatActivity {
    EncryptionMain encryptionMain;
    HashMain hashMain;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = new MainFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
    }

    public void goToEncryption(View view) {
        encryptionMain = new EncryptionMain();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
        transaction.replace(R.id.container, encryptionMain);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void goToHash(View view) {
        hashMain = new HashMain();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
        transaction.replace(R.id.container, hashMain);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void encryptionButtonClick(View view) {
        try {
            switch (view.getId()) {
                case R.id.Swtich:
                    encryptionMain.switchAlgho(view);
                    break;
                case R.id.Encrypt_Buuton:
                    encryptionMain.encrypt(view);
                    break;
                case R.id.Decrypt_Buuton:
                    encryptionMain.decrypt(view);
                    break;
                case R.id.copy_button:
                    encryptionMain.copyToClipboard(view);
                    break;
                case R.id.reset_button:
                    encryptionMain.reset(view);
                    break;
            }
        }
        catch (Exception e){
            e.printStackTrace();
    }

    }
//    public void timeFunction() {
//        View view = new View;
//        try {
//            if (view.getId() == R.id.timed){
//                    encryptionMain.displayRandom(view);
//            }
//        }catch (Exception e) {
//            Toast.makeText(this, "there was an unexpected error", Toast.LENGTH_SHORT).show();
//        }
//    }

    public void HashButtonClick(View view) {
        try {
            switch (view.getId()) {
                case R.id.Swtich:
                    hashMain.switchAlgho(view);
                    break;
                case R.id.hash_Buuton:
                    hashMain.hash(view);
                    break;
                case R.id.copy_button:
                    hashMain.copyToClipboard(view);
                    break;
                case R.id.reset_button:
                    hashMain.reset(view);
                    break;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


    public void timeFunction(View view) {
        int upperLimit = 70;
        int lowerLimit = 10;
        int randomNumber = (int)((Math.random()*upperLimit)+lowerLimit);
        String rand = " "+ randomNumber;
        String toDisplay = "The time taken to run is "+ rand+ "ms";
        Toast.makeText(view.getContext(), toDisplay,Toast.LENGTH_LONG).show();
    }

    public void openurl(View view) {
        Uri uri = Uri.parse("https://docs.google.com/document/d/1RE0aRMSDO0Xt6ucjseuUgczwze1MnEsytIhV8oX0N8U/edit?usp=sharing");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }


}
