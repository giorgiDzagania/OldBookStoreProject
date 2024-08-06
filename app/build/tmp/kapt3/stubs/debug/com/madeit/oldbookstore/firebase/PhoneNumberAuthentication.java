package com.madeit.oldbookstore.firebase;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/madeit/oldbookstore/firebase/PhoneNumberAuthentication;", "", "()V", "Companion", "app_debug"})
public final class PhoneNumberAuthentication {
    private static com.google.firebase.auth.FirebaseAuth mAuth1;
    private static com.google.firebase.auth.FirebaseAuth mAuth;
    private static com.google.firebase.database.DatabaseReference database;
    private static com.google.firebase.database.DatabaseReference databaseReference;
    @org.jetbrains.annotations.Nullable()
    private static java.lang.String verificationId;
    @org.jetbrains.annotations.Nullable()
    private static com.google.firebase.auth.PhoneAuthCredential credential;
    @org.jetbrains.annotations.Nullable()
    private static java.lang.String number;
    @org.jetbrains.annotations.Nullable()
    private static java.lang.String code;
    @org.jetbrains.annotations.Nullable()
    private static android.app.Activity activity;
    @org.jetbrains.annotations.Nullable()
    private static com.madeit.oldbookstore.model.ModelUsersData modelUsersData;
    private static android.widget.EditText otpText1;
    private static android.widget.EditText otpText2;
    private static android.widget.EditText otpText3;
    private static android.widget.EditText otpText4;
    private static android.widget.EditText otpText5;
    private static android.widget.EditText otpText6;
    @org.jetbrains.annotations.NotNull()
    private static final com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.madeit.oldbookstore.firebase.PhoneNumberAuthentication.Companion Companion = null;
    
    public PhoneNumberAuthentication() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J>\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006J\u0016\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010\'\u001a\u00020\u0006J\u000e\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u0004J\u000e\u0010*\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u0006J\u0016\u0010+\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010,\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/madeit/oldbookstore/firebase/PhoneNumberAuthentication$Companion;", "", "()V", "activity", "Landroid/app/Activity;", "code", "", "credential", "Lcom/google/firebase/auth/PhoneAuthCredential;", "database", "Lcom/google/firebase/database/DatabaseReference;", "databaseReference", "mAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "mAuth1", "mCallBack", "Lcom/google/firebase/auth/PhoneAuthProvider$OnVerificationStateChangedCallbacks;", "modelUsersData", "Lcom/madeit/oldbookstore/model/ModelUsersData;", "number", "otpText1", "Landroid/widget/EditText;", "otpText2", "otpText3", "otpText4", "otpText5", "otpText6", "verificationId", "AddToFirebase", "", "phoneNumber", "name", "email", "city", "point", "userID", "imageUri", "formatE164Number", "countryCode", "phNum", "initialize", "activityParam", "sendVerificationCode", "signInWithCredential", "verifyCode", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void initialize(@org.jetbrains.annotations.NotNull()
        android.app.Activity activityParam) {
        }
        
        public final void verifyCode(@org.jetbrains.annotations.NotNull()
        java.lang.String code) {
        }
        
        public final void signInWithCredential(@org.jetbrains.annotations.NotNull()
        com.google.firebase.auth.PhoneAuthCredential credential, @org.jetbrains.annotations.NotNull()
        android.app.Activity activity) {
        }
        
        public final void sendVerificationCode(@org.jetbrains.annotations.NotNull()
        java.lang.String number) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String formatE164Number(@org.jetbrains.annotations.NotNull()
        java.lang.String countryCode, @org.jetbrains.annotations.NotNull()
        java.lang.String phNum) {
            return null;
        }
        
        public final void AddToFirebase(@org.jetbrains.annotations.NotNull()
        java.lang.String phoneNumber, @org.jetbrains.annotations.NotNull()
        java.lang.String name, @org.jetbrains.annotations.NotNull()
        java.lang.String email, @org.jetbrains.annotations.NotNull()
        java.lang.String city, @org.jetbrains.annotations.NotNull()
        java.lang.String point, @org.jetbrains.annotations.NotNull()
        java.lang.String userID, @org.jetbrains.annotations.NotNull()
        java.lang.String imageUri) {
        }
    }
}