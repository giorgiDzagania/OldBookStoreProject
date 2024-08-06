package com.madeit.oldbookstore.firebase;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001$B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J \u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0006\u0010!\u001a\u00020\u0018J\u0006\u0010\"\u001a\u00020\u0018J\u0006\u0010#\u001a\u00020\u0018R\u000e\u0010\u000b\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006%"}, d2 = {"Lcom/madeit/oldbookstore/firebase/GoogleAuthentication;", "", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "authStateListener", "Lcom/google/firebase/auth/FirebaseAuth$AuthStateListener;", "activity", "Landroid/app/Activity;", "mSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "(Lcom/google/firebase/auth/FirebaseAuth;Lcom/google/firebase/auth/FirebaseAuth$AuthStateListener;Landroid/app/Activity;Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;)V", "TAG", "", "blockedDatabaseReference", "Lcom/google/firebase/database/DatabaseReference;", "blockeduserList", "Ljava/util/ArrayList;", "Lcom/madeit/oldbookstore/model/ModelUsersData;", "database", "databaseReference", "idToken", "getMSignInClient", "()Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "firebaseAuthWithGoogle", "", "credential", "Lcom/google/firebase/auth/AuthCredential;", "handleSignInResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onStart", "onStop", "signInWithGoogle", "Companion", "app_debug"})
public final class GoogleAuthentication {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.auth.FirebaseAuth firebaseAuth = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.auth.FirebaseAuth.AuthStateListener authStateListener = null;
    @org.jetbrains.annotations.NotNull()
    private final android.app.Activity activity = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.android.gms.auth.api.signin.GoogleSignInClient mSignInClient = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "GoogleAuthentication";
    @org.jetbrains.annotations.Nullable()
    private java.lang.String idToken;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.database.DatabaseReference database = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.database.DatabaseReference databaseReference = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.database.DatabaseReference blockedDatabaseReference = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.madeit.oldbookstore.model.ModelUsersData> blockeduserList = null;
    private static final int RC_SIGN_IN = 9001;
    @org.jetbrains.annotations.NotNull()
    public static final com.madeit.oldbookstore.firebase.GoogleAuthentication.Companion Companion = null;
    
    public GoogleAuthentication(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth firebaseAuth, @org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth.AuthStateListener authStateListener, @org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    com.google.android.gms.auth.api.signin.GoogleSignInClient mSignInClient) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.auth.api.signin.GoogleSignInClient getMSignInClient() {
        return null;
    }
    
    public final void signInWithGoogle() {
    }
    
    public final void handleSignInResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void firebaseAuthWithGoogle(com.google.firebase.auth.AuthCredential credential) {
    }
    
    public final void onStart() {
    }
    
    public final void onStop() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/madeit/oldbookstore/firebase/GoogleAuthentication$Companion;", "", "()V", "RC_SIGN_IN", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}