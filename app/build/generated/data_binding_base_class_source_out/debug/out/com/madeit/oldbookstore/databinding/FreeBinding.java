// Generated by view binder compiler. Do not edit!
package com.madeit.oldbookstore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.madeit.oldbookstore.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FreeBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView bookTitleFree;

  @NonNull
  public final CardView freeCardView;

  @NonNull
  public final ImageView imageFree;

  private FreeBinding(@NonNull CardView rootView, @NonNull TextView bookTitleFree,
      @NonNull CardView freeCardView, @NonNull ImageView imageFree) {
    this.rootView = rootView;
    this.bookTitleFree = bookTitleFree;
    this.freeCardView = freeCardView;
    this.imageFree = imageFree;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static FreeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FreeBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.free, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FreeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.book_title_free;
      TextView bookTitleFree = ViewBindings.findChildViewById(rootView, id);
      if (bookTitleFree == null) {
        break missingId;
      }

      CardView freeCardView = (CardView) rootView;

      id = R.id.image_free;
      ImageView imageFree = ViewBindings.findChildViewById(rootView, id);
      if (imageFree == null) {
        break missingId;
      }

      return new FreeBinding((CardView) rootView, bookTitleFree, freeCardView, imageFree);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
