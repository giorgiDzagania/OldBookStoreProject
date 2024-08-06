package com.madeit.oldbookstore.activity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/madeit/oldbookstore/activity/LoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "database", "Lcom/google/firebase/database/DatabaseReference;", "usersDetails", "Lcom/madeit/oldbookstore/model/ModelUsersData;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_debug"})
public final class LoginActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.google.firebase.database.DatabaseReference database;
    private com.madeit.oldbookstore.model.ModelUsersData usersDetails;
    @org.jetbrains.annotations.Nullable()
    private static android.app.Activity activity;
    @org.jetbrains.annotations.NotNull()
    public static final com.madeit.oldbookstore.activity.LoginActivity.Companion Companion = null;
    
    public LoginActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"backMessage"})
    @kotlin.jvm.JvmStatic()
    public static final void bindBackMessage(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"otpMessage"})
    @kotlin.jvm.JvmStatic()
    public static final void bindOtpMessage(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"toastMessage"})
    @kotlin.jvm.JvmStatic()
    public static final void bindToastMessage(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\u001a\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\u001a\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lcom/madeit/oldbookstore/activity/LoginActivity$Companion;", "", "()V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "bindBackMessage", "", "view", "Landroid/view/View;", "message", "", "bindOtpMessage", "bindToastMessage", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.app.Activity getActivity() {
            return null;
        }
        
        public final void setActivity(@org.jetbrains.annotations.Nullable()
        android.app.Activity p0) {
        }
        
        @androidx.databinding.BindingAdapter(value = {"toastMessage"})
        @kotlin.jvm.JvmStatic()
        public final void bindToastMessage(@org.jetbrains.annotations.NotNull()
        android.view.View view, @org.jetbrains.annotations.Nullable()
        java.lang.String message) {
        }
        
        @androidx.databinding.BindingAdapter(value = {"otpMessage"})
        @kotlin.jvm.JvmStatic()
        public final void bindOtpMessage(@org.jetbrains.annotations.NotNull()
        android.view.View view, @org.jetbrains.annotations.Nullable()
        java.lang.String message) {
        }
        
        @androidx.databinding.BindingAdapter(value = {"backMessage"})
        @kotlin.jvm.JvmStatic()
        public final void bindBackMessage(@org.jetbrains.annotations.NotNull()
        android.view.View view, @org.jetbrains.annotations.Nullable()
        java.lang.String message) {
        }
    }
}