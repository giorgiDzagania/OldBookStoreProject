package com.madeit.oldbookstore.activity.ui.dashbord;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/madeit/oldbookstore/activity/ui/dashbord/DashboardFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/google/android/material/bottomnavigation/BottomNavigationView$OnNavigationItemSelectedListener;", "()V", "adsFragment", "Lcom/madeit/oldbookstore/activity/ui/ads/AdsFragment;", "binding", "Lcom/madeit/oldbookstore/databinding/FragmentDashboardBinding;", "homeFragment", "Lcom/madeit/oldbookstore/activity/ui/home/HomeFragment;", "inboxFragment", "Lcom/madeit/oldbookstore/activity/ui/inbox/InboxFragment;", "profileFragment", "Lcom/madeit/oldbookstore/activity/ui/profile/ProfileFragment;", "sellFragment", "Lcom/madeit/oldbookstore/activity/ui/sell/SellFragment;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onNavigationItemSelected", "", "item", "Landroid/view/MenuItem;", "app_debug"})
public final class DashboardFragment extends androidx.fragment.app.Fragment implements com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener {
    @org.jetbrains.annotations.Nullable()
    private com.madeit.oldbookstore.databinding.FragmentDashboardBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final com.madeit.oldbookstore.activity.ui.home.HomeFragment homeFragment = null;
    @org.jetbrains.annotations.NotNull()
    private final com.madeit.oldbookstore.activity.ui.inbox.InboxFragment inboxFragment = null;
    @org.jetbrains.annotations.NotNull()
    private final com.madeit.oldbookstore.activity.ui.profile.ProfileFragment profileFragment = null;
    @org.jetbrains.annotations.NotNull()
    private final com.madeit.oldbookstore.activity.ui.sell.SellFragment sellFragment = null;
    @org.jetbrains.annotations.NotNull()
    private final com.madeit.oldbookstore.activity.ui.ads.AdsFragment adsFragment = null;
    
    public DashboardFragment() {
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
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @java.lang.Override()
    public boolean onNavigationItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
}