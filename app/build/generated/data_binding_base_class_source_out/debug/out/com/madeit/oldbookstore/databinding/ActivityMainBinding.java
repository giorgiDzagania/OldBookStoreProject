// Generated by view binder compiler. Do not edit!
package com.madeit.oldbookstore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.madeit.oldbookstore.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button adminButton;

  @NonNull
  public final Button googleButton;

  @NonNull
  public final Button phoneNumberButton;

  @NonNull
  public final CircularProgressIndicator progressCircularMain;

  private ActivityMainBinding(@NonNull RelativeLayout rootView, @NonNull Button adminButton,
      @NonNull Button googleButton, @NonNull Button phoneNumberButton,
      @NonNull CircularProgressIndicator progressCircularMain) {
    this.rootView = rootView;
    this.adminButton = adminButton;
    this.googleButton = googleButton;
    this.phoneNumberButton = phoneNumberButton;
    this.progressCircularMain = progressCircularMain;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.admin_button;
      Button adminButton = ViewBindings.findChildViewById(rootView, id);
      if (adminButton == null) {
        break missingId;
      }

      id = R.id.google_button;
      Button googleButton = ViewBindings.findChildViewById(rootView, id);
      if (googleButton == null) {
        break missingId;
      }

      id = R.id.phoneNumber_button;
      Button phoneNumberButton = ViewBindings.findChildViewById(rootView, id);
      if (phoneNumberButton == null) {
        break missingId;
      }

      id = R.id.progress_circular_main;
      CircularProgressIndicator progressCircularMain = ViewBindings.findChildViewById(rootView, id);
      if (progressCircularMain == null) {
        break missingId;
      }

      return new ActivityMainBinding((RelativeLayout) rootView, adminButton, googleButton,
          phoneNumberButton, progressCircularMain);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
