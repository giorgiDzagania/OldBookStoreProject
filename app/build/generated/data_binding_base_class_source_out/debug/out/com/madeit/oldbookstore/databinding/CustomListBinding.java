// Generated by view binder compiler. Do not edit!
package com.madeit.oldbookstore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.madeit.oldbookstore.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class CustomListBinding implements ViewBinding {
  @NonNull
  private final TextView rootView;

  @NonNull
  public final TextView text1;

  private CustomListBinding(@NonNull TextView rootView, @NonNull TextView text1) {
    this.rootView = rootView;
    this.text1 = text1;
  }

  @Override
  @NonNull
  public TextView getRoot() {
    return rootView;
  }

  @NonNull
  public static CustomListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CustomListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.custom_list, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CustomListBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    TextView text1 = (TextView) rootView;

    return new CustomListBinding((TextView) rootView, text1);
  }
}
