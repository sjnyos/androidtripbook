package com.machamasisuraj.socialapp.UI;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.machamasisuraj.socialapp.BLL.ImageUploadBll;
import com.machamasisuraj.socialapp.BLL.ItemBll;
import com.machamasisuraj.socialapp.Model.Item;
import com.machamasisuraj.socialapp.R;
import com.machamasisuraj.socialapp.permissonsAndUri.LinkPermisson;
import com.machamasisuraj.socialapp.permissonsAndUri.StoragePath;

public class ItemCreateActivity extends AppCompatActivity {
private ImageView imageView;
private Button button,button2;
private EditText editText2,editText5,editText6,editText,editText3;
private String imagepath;
private String imageName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_create);
        imageView = findViewById(R.id.imageView2);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);

        editText=findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
        editText3=findViewById(R.id.editText3);
        editText5=findViewById(R.id.editText5);
        editText6=findViewById(R.id.editText6);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    BrowseImage();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UploadImage();
            }
        });


    }

    private void UploadImage(){
        ImageUploadBll imageUploadBll= new ImageUploadBll(imagepath,this);
       String getmageName= imageUploadBll.uploadFile();
       if(!getmageName.equals("Error")){
           SaveData(getmageName);
       }
    }


    private void SaveData(String setimageName){
        Item item = new Item(editText.getText().toString()
                , Integer.parseInt(editText3.getText().toString())
        ,editText6.getText().toString()
        ,editText2.getText().toString()
        ,setimageName
        ,editText5.getText().toString());

        ItemBll itemBll= new ItemBll();
        itemBll.insertItem(item);

    }

    private void BrowseImage() throws Exception {
      // checkPermissionForReadExtertalStorage();
        LinkPermisson linkPermisson= new LinkPermisson(this);
        linkPermisson.requestPermissionForReadExtertalStorage();

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
        imageView.setImageURI(uri);
        StoragePath storagePath= new StoragePath(this);
        imagepath = storagePath.getRealPathFromUri(uri);
    }




}
