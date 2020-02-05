package com.machamasisuraj.socialapp.GUI;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.machamasisuraj.socialapp.BLL.BannerBll;
import com.machamasisuraj.socialapp.BLL.ImageUpload;
import com.machamasisuraj.socialapp.Model.BannerItem;
import com.machamasisuraj.socialapp.R;
import com.machamasisuraj.socialapp.AndroidPermisson.LinkPermisson;
import com.machamasisuraj.socialapp.AndroidPermisson.StoragePath;

import static android.app.Activity.RESULT_OK;

public class BannerActivity extends Fragment {
    private Context mContext;

    public BannerActivity( Context mContext) {
        this.mContext = mContext;
    }

    private ImageView bannerImage;
    private EditText bannerName,desc;
    private Button upload,save;
    private String imagepath="";
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      View view  = inflater.inflate(R.layout.activity_banner,container,false);
        bannerImage= view.findViewById(R.id.imageView2banner);
        bannerName=view.findViewById(R.id.editTextbanner);
        desc=view.findViewById(R.id.editTextdesc);
        upload=view.findViewById(R.id.uploadbutton2);
        save=view.findViewById(R.id.buttonsave);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    BrowseImage();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(mContext, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UploadImageAndSaveData();
            }
        });
        return view;


    }

    private void BrowseImage() throws Exception {
        // checkPermissionForReadExtertalStorage();
        LinkPermisson linkPermisson= new LinkPermisson(mContext);
        linkPermisson.requestPermissionForReadExtertalStorage();

        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 0);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (data == null) {
                Toast.makeText(mContext, "Please select an image ", Toast.LENGTH_SHORT).show();
            }
        }
        Uri uri = data.getData();
        bannerImage.setImageURI(uri);
        StoragePath storagePath= new StoragePath(mContext);
        imagepath = storagePath.getRealPathFromUri(uri);
    }

    private void UploadImageAndSaveData(){
        ImageUpload imageUpload = new ImageUpload(imagepath,mContext);
        String getmageName= imageUpload.uploadFile();
        if(!getmageName.equals("Error")){
            SaveData(getmageName);
        }
    }

    private void SaveData(String setimageName){
        BannerItem bannerItem= new BannerItem(bannerName.getText().toString(),setimageName,desc.getText().toString());
        BannerBll bannerBll= new BannerBll();
        if(bannerBll.InsertBanner(bannerItem)){
            Toast.makeText(mContext, "Data Inserted Successfuly", Toast.LENGTH_SHORT).show();
        }

    }

}
