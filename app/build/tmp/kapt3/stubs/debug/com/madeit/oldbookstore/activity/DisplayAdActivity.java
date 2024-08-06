package com.madeit.oldbookstore.activity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J@\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u0004H\u0002J\u0018\u0010:\u001a\u0002032\u0006\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u0004H\u0002J@\u0010=\u001a\u0002032\u0006\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u0004H\u0002J\u0010\u0010>\u001a\u0002032\u0006\u0010?\u001a\u00020\u0004H\u0002J\u0010\u0010@\u001a\u0002032\u0006\u0010A\u001a\u00020\u0004H\u0002J\u0012\u0010B\u001a\u0002032\b\u0010C\u001a\u0004\u0018\u00010DH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006E"}, d2 = {"Lcom/madeit/oldbookstore/activity/DisplayAdActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "TAG", "", "book_title", "btn_chat", "Landroid/widget/Button;", "btn_dial", "btn_report", "btn_submit", "category", "databaseReference", "Lcom/google/firebase/database/DatabaseReference;", "description", "edt_feeback", "Landroid/widget/EditText;", "executorService", "Ljava/util/concurrent/ExecutorService;", "imageUriBack", "imageUriFront", "imageUriMain", "imageViewBack", "Landroid/widget/ImageView;", "imageViewFront", "imageViewMain", "location", "mRef_Messages", "mRef_Reports", "modelUsersData", "Lcom/madeit/oldbookstore/model/ModelUsersData;", "neg", "", "pos", "price", "profile_pic", "textClassifier", "Lorg/tensorflow/lite/task/text/nlclassifier/NLClassifier;", "txt_book_title", "Landroid/widget/TextView;", "txt_category", "txt_city", "txt_description", "txt_email", "txt_feedback", "txt_location", "txt_name", "txt_phoneNumber", "txt_price", "userID", "addToFirebase", "", "phoneNumber", "name", "email", "city", "point", "imageUri", "addToMessages", "id", "message", "addToReportList", "classify", "text", "downloadModel", "modelName", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class DisplayAdActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.google.firebase.database.DatabaseReference databaseReference;
    private com.google.firebase.database.DatabaseReference mRef_Reports;
    private com.google.firebase.database.DatabaseReference mRef_Messages;
    private com.madeit.oldbookstore.model.ModelUsersData modelUsersData;
    private double neg = 0.0;
    private double pos = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "TextClassificationDemo";
    private java.util.concurrent.ExecutorService executorService;
    private org.tensorflow.lite.task.text.nlclassifier.NLClassifier textClassifier;
    private java.lang.String price;
    private java.lang.String imageUriMain;
    private java.lang.String imageUriFront;
    private java.lang.String imageUriBack;
    private java.lang.String book_title;
    private java.lang.String location;
    private java.lang.String category;
    private java.lang.String userID;
    private java.lang.String description;
    private android.widget.ImageView imageViewMain;
    private android.widget.ImageView imageViewFront;
    private android.widget.ImageView imageViewBack;
    private android.widget.TextView txt_price;
    private android.widget.TextView txt_book_title;
    private android.widget.TextView txt_description;
    private android.widget.TextView txt_location;
    private android.widget.TextView txt_category;
    private android.widget.TextView txt_city;
    private android.widget.TextView txt_email;
    private android.widget.TextView txt_name;
    private android.widget.TextView txt_phoneNumber;
    private android.widget.Button btn_chat;
    private android.widget.Button btn_report;
    private android.widget.ImageView profile_pic;
    private android.widget.Button btn_dial;
    private android.widget.EditText edt_feeback;
    private android.widget.Button btn_submit;
    private android.widget.TextView txt_feedback;
    
    public DisplayAdActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void addToFirebase(java.lang.String phoneNumber, java.lang.String name, java.lang.String email, java.lang.String city, java.lang.String point, java.lang.String userID, java.lang.String imageUri) {
    }
    
    private final void addToReportList(java.lang.String phoneNumber, java.lang.String name, java.lang.String email, java.lang.String city, java.lang.String point, java.lang.String userID, java.lang.String imageUri) {
    }
    
    private final void addToMessages(java.lang.String id, java.lang.String message) {
    }
    
    private final void classify(java.lang.String text) {
    }
    
    private final void downloadModel(java.lang.String modelName) {
    }
}