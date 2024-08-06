package com.madeit.oldbookstore.activity.ui.ads;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001/B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010%\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J&\u0010&\u001a\u0004\u0018\u00010\"2\u0006\u0010\'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020 H\u0016J\b\u0010.\u001a\u00020 H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/madeit/oldbookstore/activity/ui/ads/AdsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/madeit/oldbookstore/ItemClickListener;", "()V", "binding", "Lcom/madeit/oldbookstore/databinding/FragmentAdsBinding;", "databaseReferenceDonations", "Lcom/google/firebase/database/DatabaseReference;", "databaseReferencePaid", "donationsAdapter", "Lcom/madeit/oldbookstore/activity/adapter/DonationsAdapter;", "donationsItemsList", "Ljava/util/ArrayList;", "Lcom/madeit/oldbookstore/model/ModelDonations;", "freeItemsList", "Lcom/madeit/oldbookstore/model/ModelFree;", "freeRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mActivity", "Landroid/app/Activity;", "mContext", "Landroid/content/Context;", "paidAdapter", "Lcom/madeit/oldbookstore/activity/adapter/PaidAdapter;", "paidItemsList", "Lcom/madeit/oldbookstore/model/ModelPaid;", "paidRecyclerView", "priceItemsList", "Lcom/madeit/oldbookstore/model/ModelPrice;", "progressCircular", "Lcom/google/android/material/progressindicator/CircularProgressIndicator;", "onClickFree", "", "view", "Landroid/view/View;", "position", "", "onClickPaid", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "setupDatabaseReferences", "Companion", "app_debug"})
public final class AdsFragment extends androidx.fragment.app.Fragment implements com.madeit.oldbookstore.ItemClickListener {
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String category = "";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "MainActivity";
    private com.google.android.material.progressindicator.CircularProgressIndicator progressCircular;
    private androidx.recyclerview.widget.RecyclerView paidRecyclerView;
    private com.google.firebase.database.DatabaseReference databaseReferencePaid;
    private android.content.Context mContext;
    private android.app.Activity mActivity;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.madeit.oldbookstore.model.ModelPaid> paidItemsList = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.madeit.oldbookstore.model.ModelPrice> priceItemsList = null;
    @org.jetbrains.annotations.Nullable()
    private com.madeit.oldbookstore.activity.adapter.PaidAdapter paidAdapter;
    private androidx.recyclerview.widget.RecyclerView freeRecyclerView;
    private com.google.firebase.database.DatabaseReference databaseReferenceDonations;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.madeit.oldbookstore.model.ModelDonations> donationsItemsList = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.madeit.oldbookstore.model.ModelFree> freeItemsList = null;
    @org.jetbrains.annotations.Nullable()
    private com.madeit.oldbookstore.activity.adapter.DonationsAdapter donationsAdapter;
    @org.jetbrains.annotations.Nullable()
    private com.madeit.oldbookstore.databinding.FragmentAdsBinding binding;
    @org.jetbrains.annotations.NotNull()
    public static final com.madeit.oldbookstore.activity.ui.ads.AdsFragment.Companion Companion = null;
    
    public AdsFragment() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void setupDatabaseReferences() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @java.lang.Override()
    public void onClickPaid(@org.jetbrains.annotations.NotNull()
    android.view.View view, int position) {
    }
    
    @java.lang.Override()
    public void onClickFree(@org.jetbrains.annotations.NotNull()
    android.view.View view, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/madeit/oldbookstore/activity/ui/ads/AdsFragment$Companion;", "", "()V", "TAG", "", "category", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}