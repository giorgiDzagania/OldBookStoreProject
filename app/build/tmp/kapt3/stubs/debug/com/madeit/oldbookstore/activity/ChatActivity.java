package com.madeit.oldbookstore.activity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/madeit/oldbookstore/activity/ChatActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/madeit/oldbookstore/activity/adapter/MessageAdapter;", "databaseReference", "Lcom/google/firebase/database/DatabaseReference;", "mbase", "message", "Landroid/widget/EditText;", "messages", "", "Lcom/madeit/oldbookstore/model/ModelMessage;", "modelUsersData", "Lcom/madeit/oldbookstore/model/ModelUsersData;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "sendMessage", "Landroid/widget/ImageView;", "addToMessages", "", "id", "", "fetchMessages", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class ChatActivity extends androidx.appcompat.app.AppCompatActivity {
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private com.madeit.oldbookstore.activity.adapter.MessageAdapter adapter;
    private com.google.firebase.database.DatabaseReference mbase;
    private com.google.firebase.database.DatabaseReference databaseReference;
    private android.widget.EditText message;
    private android.widget.ImageView sendMessage;
    private com.madeit.oldbookstore.model.ModelUsersData modelUsersData;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.madeit.oldbookstore.model.ModelMessage> messages = null;
    
    public ChatActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void fetchMessages(java.lang.String id) {
    }
    
    private final void addToMessages(java.lang.String id, java.lang.String message) {
    }
}