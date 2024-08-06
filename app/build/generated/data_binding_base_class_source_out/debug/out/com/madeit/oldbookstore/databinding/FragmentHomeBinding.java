// Generated by view binder compiler. Do not edit!
package com.madeit.oldbookstore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.madeit.oldbookstore.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHomeBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final RecyclerView freeRecyclerView;

  @NonNull
  public final TextView interHome;

  @NonNull
  public final TextView matricHome;

  @NonNull
  public final TextView otherHome;

  @NonNull
  public final RecyclerView paidRecyclerView;

  @NonNull
  public final CircularProgressIndicator progressCircular;

  @NonNull
  public final TextView schoolHome;

  @NonNull
  public final EditText searchBookTitle;

  @NonNull
  public final AutoCompleteTextView searchLocation;

  private FragmentHomeBinding(@NonNull RelativeLayout rootView,
      @NonNull RecyclerView freeRecyclerView, @NonNull TextView interHome,
      @NonNull TextView matricHome, @NonNull TextView otherHome,
      @NonNull RecyclerView paidRecyclerView, @NonNull CircularProgressIndicator progressCircular,
      @NonNull TextView schoolHome, @NonNull EditText searchBookTitle,
      @NonNull AutoCompleteTextView searchLocation) {
    this.rootView = rootView;
    this.freeRecyclerView = freeRecyclerView;
    this.interHome = interHome;
    this.matricHome = matricHome;
    this.otherHome = otherHome;
    this.paidRecyclerView = paidRecyclerView;
    this.progressCircular = progressCircular;
    this.schoolHome = schoolHome;
    this.searchBookTitle = searchBookTitle;
    this.searchLocation = searchLocation;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.free_recycler_view;
      RecyclerView freeRecyclerView = ViewBindings.findChildViewById(rootView, id);
      if (freeRecyclerView == null) {
        break missingId;
      }

      id = R.id.inter_home;
      TextView interHome = ViewBindings.findChildViewById(rootView, id);
      if (interHome == null) {
        break missingId;
      }

      id = R.id.matric_home;
      TextView matricHome = ViewBindings.findChildViewById(rootView, id);
      if (matricHome == null) {
        break missingId;
      }

      id = R.id.other_home;
      TextView otherHome = ViewBindings.findChildViewById(rootView, id);
      if (otherHome == null) {
        break missingId;
      }

      id = R.id.paid_recycler_view;
      RecyclerView paidRecyclerView = ViewBindings.findChildViewById(rootView, id);
      if (paidRecyclerView == null) {
        break missingId;
      }

      id = R.id.progress_circular;
      CircularProgressIndicator progressCircular = ViewBindings.findChildViewById(rootView, id);
      if (progressCircular == null) {
        break missingId;
      }

      id = R.id.school_home;
      TextView schoolHome = ViewBindings.findChildViewById(rootView, id);
      if (schoolHome == null) {
        break missingId;
      }

      id = R.id.search_book_title;
      EditText searchBookTitle = ViewBindings.findChildViewById(rootView, id);
      if (searchBookTitle == null) {
        break missingId;
      }

      id = R.id.search_location;
      AutoCompleteTextView searchLocation = ViewBindings.findChildViewById(rootView, id);
      if (searchLocation == null) {
        break missingId;
      }

      return new FragmentHomeBinding((RelativeLayout) rootView, freeRecyclerView, interHome,
          matricHome, otherHome, paidRecyclerView, progressCircular, schoolHome, searchBookTitle,
          searchLocation);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
