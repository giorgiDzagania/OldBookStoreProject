package com.madeit.oldbookstore.activity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/madeit/oldbookstore/activity/ReportedUsers;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "database", "Lcom/google/firebase/database/DatabaseReference;", "modelUsersDataArrayList", "Ljava/util/ArrayList;", "Lcom/madeit/oldbookstore/model/ModelUsersData;", "Lkotlin/collections/ArrayList;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "usersAdapter", "Lcom/madeit/oldbookstore/activity/adapter/UsersAdapter;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class ReportedUsers extends androidx.appcompat.app.AppCompatActivity {
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    @org.jetbrains.annotations.Nullable()
    private com.madeit.oldbookstore.activity.adapter.UsersAdapter usersAdapter;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.madeit.oldbookstore.model.ModelUsersData> modelUsersDataArrayList = null;
    private com.google.firebase.database.DatabaseReference database;
    
    public ReportedUsers() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
}