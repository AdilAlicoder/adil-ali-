package com.example.past_year_paper;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;

public class uploadimage extends AppCompatActivity {
    private Button btnChoose, btnUpload;
    private ImageView imageView;
    private Uri filePath;
    private final int PICK_IMAGE_REQUEST = 71;
    FirebaseStorage storage;
    String board,book,classes,son,objsub;
    DatabaseReference databaseReference;
    StorageReference storageReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadimage);
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        btnChoose = (Button) findViewById(R.id.btnChoose);
        btnUpload = (Button) findViewById(R.id.btnUpload);
        imageView = (ImageView) findViewById(R.id.imgView);
        Intent intent=getIntent();
        book=intent.getStringExtra("board");
        board=intent.getStringExtra("book");
        classes=intent.getStringExtra("class");
        son=intent.getStringExtra("son");
        objsub=intent.getStringExtra("obj");
        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
            }
        });

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
            }
        });
    }
    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void uploadImage() {

        if(filePath != null)
        {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            final StorageReference ref = storageReference.child("images/"+ UUID.randomUUID().toString());
            ref.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Uploaded", Toast.LENGTH_SHORT).show();
                            ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    databaseReference=FirebaseDatabase.getInstance().getReference().child(board).child(classes).child(book).child(son).child(objsub);
                                    String uid=uri.toString();
                                    databaseReference.setValue(uid);
                                }
                            });
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                    .getTotalByteCount());
                            progressDialog.setMessage("Uploaded "+(int)progress+"%");
                        }
                    });
        }
    }
}