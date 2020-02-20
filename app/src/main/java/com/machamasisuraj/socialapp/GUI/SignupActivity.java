package com.machamasisuraj.socialapp.GUI;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import com.machamasisuraj.socialapp.AndroidPermisson.LinkPermisson;
import com.machamasisuraj.socialapp.ApiService.RetrofitCaller;
import com.machamasisuraj.socialapp.ApiService.UsersAPI;
import com.machamasisuraj.socialapp.BaseUrl.BaseUrl;
import com.machamasisuraj.socialapp.EnableStrictMode.StrictModeClass;
import com.machamasisuraj.socialapp.Model.Response.ImageResponse;
import com.machamasisuraj.socialapp.Model.Response.LoginAndSignUpResponse;
import com.machamasisuraj.socialapp.Model.User;
import com.machamasisuraj.socialapp.R;
import com.machamasisuraj.socialapp.Sensors.LightSensor;
import com.machamasisuraj.socialapp.Sensors.ProximitySensor;
import com.machamasisuraj.socialapp.Sensors.ShakeDetector;

import java.io.File;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    private CircleImageView imgProfile;
    private EditText etFirstName, etLastName, etSignUpUsername, etSignUpPassword, etConfirmPassword;
    private Button btnSignup;
    private RadioButton male,female;
    String imagePath;
    private String imageName = "";

    static int PReqCode = 1 ;
    static int REQUESCODE = 1 ;

    private ShakeDetector mShakeDetector;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //sensor init
        SensorInit();
        setContentView(R.layout.activity_signup);

        imgProfile = findViewById(R.id.imgProfile);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etSignUpUsername = findViewById(R.id.etSignUpUsername);
        etSignUpPassword = findViewById(R.id.etSignUpPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnSignup = findViewById(R.id.btnSignup);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);
        male.setChecked(true);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector(new ShakeDetector.OnShakeListener() {
            @Override
            public void onShake() {
                etFirstName.setText("");
                etLastName.setText("");
                etSignUpUsername.setText("");
                etSignUpPassword.setText("");
                etConfirmPassword .setText("");
                imgProfile.setImageResource(R.drawable.ic_launcher_background);
            }
        });
        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BrowseImage();
            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etSignUpPassword.getText().toString().equals(etConfirmPassword.getText().toString())) {
                    if(Validation()) {
                        try {
                            saveImageOnly();
                        }catch (Exception ex){
                            Toast.makeText(SignupActivity.this, "No Image Selected, You can set Image later too.", Toast.LENGTH_SHORT).show();
                        }

                        signUp();
                    }
                } else {
                    Toast.makeText(SignupActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                    etSignUpPassword.requestFocus();
                    return;
                }

            }
        });
    }

    public boolean Validation(){
        //  pickupaddress,travellerCount,adult,childCounts;
        if(TextUtils.isEmpty(etFirstName.getText().toString())){
            etFirstName.setError("Can't be Empty!");
            etFirstName.requestFocus();
            //  Toast.makeText(TripDetailActvity.this, "Input Cant be Empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(TextUtils.isEmpty(etLastName.getText().toString())){
            etLastName.setError("Can't be Empty!");
            etLastName.requestFocus();
            //  Toast.makeText(TripDetailActvity.this, "Input Cant be Empty", Toast.LENGTH_SHORT).show();
            return false;

        } else if(TextUtils.isEmpty(etSignUpUsername.getText().toString())){
            etSignUpUsername.setError("Can't be Empty!");
            etSignUpUsername.requestFocus();
           // Toast.makeText(TripDetailActvity.this, "Input Cant be Empty", Toast.LENGTH_SHORT).show();
            return false;

        }
        else if(TextUtils.isEmpty(etConfirmPassword.getText().toString())){
            etConfirmPassword.setError("Can't be Empty!");
            etConfirmPassword.requestFocus();
            // Toast.makeText(TripDetailActvity.this, "Input Cant be Empty", Toast.LENGTH_SHORT).show();
            return false;

        }
        else if(TextUtils.isEmpty(etSignUpPassword.getText().toString())){
            etSignUpPassword.setError("Can't be Empty!");
            etSignUpPassword.requestFocus();
            // Toast.makeText(TripDetailActvity.this, "Input Cant be Empty", Toast.LENGTH_SHORT).show();
            return false;

        }
        else{
            return true;
        }


    }

    private void BrowseImage() {
        LinkPermisson linkPermisson= new LinkPermisson(this);
        try {
            linkPermisson.requestPermissionForReadExtertalStorage();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (data == null) {
                Toast.makeText(this, "Please select an image ", Toast.LENGTH_SHORT).show();
            }
        }
        Uri uri = data.getData();
        imgProfile.setImageURI(uri);
        imagePath = getRealPathFromUri(uri);
    }

    private String getRealPathFromUri(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        CursorLoader loader = new CursorLoader(getApplicationContext(),
                uri, projection, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int colIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(colIndex);
        cursor.close();
        return result;
    }

    private void saveImageOnly() {
        File file = new File(imagePath);
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("imageFile",
                file.getName(), requestBody);

        UsersAPI usersAPI = RetrofitCaller.getInstance().create(UsersAPI.class);
        Call<ImageResponse> responseBodyCall = usersAPI.uploadImage(body, BaseUrl.token);

        StrictModeClass.StrictMode();
        //Synchronous methid
        try {
            Response<ImageResponse> imageResponseResponse = responseBodyCall.execute();
            imageName = imageResponseResponse.body().getFilename();
            Toast.makeText(this, "Image inserted" + imageName, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "Error" + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void signUp() {



        String fname = etFirstName.getText().toString();
        String lname = etLastName.getText().toString();
        String username = etSignUpUsername.getText().toString();
        String password = etSignUpPassword.getText().toString();
        String gender = male.isChecked() ? "male":"female";

        User users = new User(fname, lname, username, password, imageName,gender);

        UsersAPI usersAPI = RetrofitCaller.getInstance().create(UsersAPI.class);
        Call<LoginAndSignUpResponse> signUpCall = usersAPI.registerUser(users);

        signUpCall.enqueue(new Callback<LoginAndSignUpResponse>() {
            @Override
            public void onResponse(Call<LoginAndSignUpResponse> call, Response<LoginAndSignUpResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(SignupActivity.this, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(SignupActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SignupActivity.this,LoginActivity.class));
            }

            @Override
            public void onFailure(Call<LoginAndSignUpResponse> call, Throwable t) {
                Toast.makeText(SignupActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    protected void onPause() {
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }

    @Override    protected void onResume() {

        mSensorManager.registerListener(mShakeDetector, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
        super.onResume();

    }
    public void SensorInit() {

        LightSensor lightSensor= new LightSensor(this);
        lightSensor.getLightInstance();
        ProximitySensor proximitySensor= new ProximitySensor(this);
        proximitySensor.ProximitySensor();

    }
}
