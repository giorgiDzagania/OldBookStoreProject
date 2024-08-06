package com.madeit.oldbookstore.activity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003JD\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010%\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0002J\"\u0010&\u001a\u00020 2\u0006\u0010\'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\u0012\u0010+\u001a\u00020 2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J.\u0010.\u001a\u00020 2\n\u0010/\u001a\u0006\u0012\u0002\b\u0003002\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u000205H\u0016J\u0014\u00106\u001a\u00020 2\n\u0010/\u001a\u0006\u0012\u0002\b\u000300H\u0016J\b\u00107\u001a\u00020 H\u0002J\b\u00108\u001a\u00020 H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082.\u00a2\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00069"}, d2 = {"Lcom/madeit/oldbookstore/activity/ProfileActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/widget/AdapterView$OnItemSelectedListener;", "()V", "PICK_IMAGE_REQUEST", "", "array", "", "", "[Ljava/lang/String;", "btnSubmit", "Landroid/widget/Button;", "database", "Lcom/google/firebase/database/DatabaseReference;", "edtEmail", "Landroid/widget/EditText;", "edtName", "edtPhoneNumber", "filePath", "Landroid/net/Uri;", "frameLayout", "Landroid/widget/FrameLayout;", "imageUri", "location", "point", "profile", "Landroid/widget/ImageView;", "spinner", "Landroid/widget/Spinner;", "storageReference", "Lcom/google/firebase/storage/StorageReference;", "addToFirebase", "", "phoneNumber", "name", "email", "city", "userID", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onItemSelected", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position", "id", "", "onNothingSelected", "selectImage", "uploadImage", "app_debug"})
public final class ProfileActivity extends androidx.appcompat.app.AppCompatActivity implements android.widget.AdapterView.OnItemSelectedListener {
    private android.widget.Spinner spinner;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String location;
    private java.lang.String[] array;
    private android.widget.EditText edtName;
    private android.widget.EditText edtPhoneNumber;
    private android.widget.EditText edtEmail;
    private android.widget.Button btnSubmit;
    private android.widget.FrameLayout frameLayout;
    private final int PICK_IMAGE_REQUEST = 22;
    @org.jetbrains.annotations.Nullable()
    private android.net.Uri filePath;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String imageUri;
    private android.widget.ImageView profile;
    private com.google.firebase.storage.StorageReference storageReference;
    private com.google.firebase.database.DatabaseReference database;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String point;
    
    public ProfileActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onItemSelected(@org.jetbrains.annotations.NotNull()
    android.widget.AdapterView<?> parent, @org.jetbrains.annotations.Nullable()
    android.view.View view, int position, long id) {
    }
    
    @java.lang.Override()
    public void onNothingSelected(@org.jetbrains.annotations.NotNull()
    android.widget.AdapterView<?> parent) {
    }
    
    private final void addToFirebase(java.lang.String phoneNumber, java.lang.String name, java.lang.String email, java.lang.String city, java.lang.String point, java.lang.String userID, java.lang.String imageUri) {
    }
    
    private final void uploadImage() {
    }
    
    private final void selectImage() {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
}