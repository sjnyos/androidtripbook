package com.machamasisuraj.socialapp.GUI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.machamasisuraj.socialapp.BLL.UserBLL;
import com.machamasisuraj.socialapp.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    private CircleImageView imgProfile;
    private EditText etFirstName, etLastName, etSignUpUsername, etSignUpPassword, etConfirmPassword;
    private Button btnSignup;
    private RadioButton male,female;
    String imagePath;
    private String imageName = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        imgProfile = findViewById(R.id.imgProfile);
        etFirstName = findViewById(R.id.utFirstName);
        etLastName = findViewById(R.id.utLastName);
        etSignUpUsername = findViewById(R.id.utSignUpUsername);
        etSignUpPassword = findViewById(R.id.utSignUpPassword);
        etConfirmPassword = findViewById(R.id.utConfirmPassword);
        btnSignup = findViewById(R.id.ubtnSignup);
        male=findViewById(R.id.umale);
        female=findViewById(R.id.ufemale);
       // male.setChecked(true);
      //  populateData();
    }

    public void populateData(){

        UserBLL userBLL= new UserBLL();
        etFirstName.setText( userBLL.geTProfile().getFirstname().equals("")  || userBLL.geTProfile().getFirstname()==null? "":userBLL.geTProfile().getFirstname());
        etLastName.setText(userBLL.geTProfile().getLastname().equals("")  || userBLL.geTProfile().getLastname()==null?"":userBLL.geTProfile().getLastname());
        etSignUpUsername.setText(userBLL.geTProfile().getUsername().equals("")  || userBLL.geTProfile().getUsername()==null?"":userBLL.geTProfile().getUsername() );
        if (userBLL.geTProfile().getGender() == "male") {
            male.setChecked(true);
        } else {
            female.setChecked(true);
        }

    }
}
