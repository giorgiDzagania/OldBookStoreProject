// Generated by data binding compiler. Do not edit!
package com.madeit.oldbookstore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.madeit.oldbookstore.R;
import com.madeit.oldbookstore.viewModel.LoginViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityLoginBinding extends ViewDataBinding {
  @NonNull
  public final AppBarLayout appBarLayout;

  @NonNull
  public final ImageButton imageButtonBack;

  @NonNull
  public final EditText otp1;

  @NonNull
  public final EditText otp2;

  @NonNull
  public final EditText otp3;

  @NonNull
  public final EditText otp4;

  @NonNull
  public final EditText otp5;

  @NonNull
  public final EditText otp6;

  @NonNull
  public final EditText phoneNumber;

  @NonNull
  public final TextView resendText;

  @NonNull
  public final Button sendOtp;

  @NonNull
  public final Button submitLogin;

  @NonNull
  public final Toolbar toolbar;

  @Bindable
  protected LoginViewModel mViewmodel;

  protected ActivityLoginBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppBarLayout appBarLayout, ImageButton imageButtonBack, EditText otp1, EditText otp2,
      EditText otp3, EditText otp4, EditText otp5, EditText otp6, EditText phoneNumber,
      TextView resendText, Button sendOtp, Button submitLogin, Toolbar toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appBarLayout = appBarLayout;
    this.imageButtonBack = imageButtonBack;
    this.otp1 = otp1;
    this.otp2 = otp2;
    this.otp3 = otp3;
    this.otp4 = otp4;
    this.otp5 = otp5;
    this.otp6 = otp6;
    this.phoneNumber = phoneNumber;
    this.resendText = resendText;
    this.sendOtp = sendOtp;
    this.submitLogin = submitLogin;
    this.toolbar = toolbar;
  }

  public abstract void setViewmodel(@Nullable LoginViewModel viewmodel);

  @Nullable
  public LoginViewModel getViewmodel() {
    return mViewmodel;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_login, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityLoginBinding>inflateInternal(inflater, R.layout.activity_login, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_login, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityLoginBinding>inflateInternal(inflater, R.layout.activity_login, null, false, component);
  }

  public static ActivityLoginBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityLoginBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityLoginBinding)bind(component, view, R.layout.activity_login);
  }
}
