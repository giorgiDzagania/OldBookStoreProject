package com.madeit.oldbookstore.databinding;
import com.madeit.oldbookstore.R;
import com.madeit.oldbookstore.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityLoginBindingImpl extends ActivityLoginBinding implements com.madeit.oldbookstore.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.appBarLayout, 11);
        sViewsWithIds.put(R.id.toolbar, 12);
        sViewsWithIds.put(R.id.resend_text, 13);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener otp1androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewmodel.userOtp_1.getValue()
            //         is viewmodel.userOtp_1.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = com.madeit.oldbookstore.viewModel.BindingAdapters.getText(otp1);
            // localize variables for thread safety
            // viewmodel != null
            boolean viewmodelJavaLangObjectNull = false;
            // viewmodel.userOtp_1.getValue()
            java.lang.String viewmodelUserOtp1GetValue = null;
            // viewmodel.userOtp_1
            androidx.lifecycle.MutableLiveData<java.lang.String> viewmodelUserOtp1 = null;
            // viewmodel.userOtp_1 != null
            boolean viewmodelUserOtp1JavaLangObjectNull = false;
            // viewmodel
            com.madeit.oldbookstore.viewModel.LoginViewModel viewmodel = mViewmodel;



            viewmodelJavaLangObjectNull = (viewmodel) != (null);
            if (viewmodelJavaLangObjectNull) {


                viewmodelUserOtp1 = viewmodel.getUserOtp_1();

                viewmodelUserOtp1JavaLangObjectNull = (viewmodelUserOtp1) != (null);
                if (viewmodelUserOtp1JavaLangObjectNull) {




                    viewmodelUserOtp1.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener otp2androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewmodel.userOtp_2.getValue()
            //         is viewmodel.userOtp_2.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = com.madeit.oldbookstore.viewModel.BindingAdapters.getText(otp2);
            // localize variables for thread safety
            // viewmodel != null
            boolean viewmodelJavaLangObjectNull = false;
            // viewmodel.userOtp_2
            androidx.lifecycle.MutableLiveData<java.lang.String> viewmodelUserOtp2 = null;
            // viewmodel.userOtp_2 != null
            boolean viewmodelUserOtp2JavaLangObjectNull = false;
            // viewmodel.userOtp_2.getValue()
            java.lang.String viewmodelUserOtp2GetValue = null;
            // viewmodel
            com.madeit.oldbookstore.viewModel.LoginViewModel viewmodel = mViewmodel;



            viewmodelJavaLangObjectNull = (viewmodel) != (null);
            if (viewmodelJavaLangObjectNull) {


                viewmodelUserOtp2 = viewmodel.getUserOtp_2();

                viewmodelUserOtp2JavaLangObjectNull = (viewmodelUserOtp2) != (null);
                if (viewmodelUserOtp2JavaLangObjectNull) {




                    viewmodelUserOtp2.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener otp3androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewmodel.userOtp_3.getValue()
            //         is viewmodel.userOtp_3.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = com.madeit.oldbookstore.viewModel.BindingAdapters.getText(otp3);
            // localize variables for thread safety
            // viewmodel.userOtp_3 != null
            boolean viewmodelUserOtp3JavaLangObjectNull = false;
            // viewmodel.userOtp_3.getValue()
            java.lang.String viewmodelUserOtp3GetValue = null;
            // viewmodel != null
            boolean viewmodelJavaLangObjectNull = false;
            // viewmodel.userOtp_3
            androidx.lifecycle.MutableLiveData<java.lang.String> viewmodelUserOtp3 = null;
            // viewmodel
            com.madeit.oldbookstore.viewModel.LoginViewModel viewmodel = mViewmodel;



            viewmodelJavaLangObjectNull = (viewmodel) != (null);
            if (viewmodelJavaLangObjectNull) {


                viewmodelUserOtp3 = viewmodel.getUserOtp_3();

                viewmodelUserOtp3JavaLangObjectNull = (viewmodelUserOtp3) != (null);
                if (viewmodelUserOtp3JavaLangObjectNull) {




                    viewmodelUserOtp3.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener otp4androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewmodel.userOtp_4.getValue()
            //         is viewmodel.userOtp_4.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = com.madeit.oldbookstore.viewModel.BindingAdapters.getText(otp4);
            // localize variables for thread safety
            // viewmodel.userOtp_4 != null
            boolean viewmodelUserOtp4JavaLangObjectNull = false;
            // viewmodel != null
            boolean viewmodelJavaLangObjectNull = false;
            // viewmodel.userOtp_4
            androidx.lifecycle.MutableLiveData<java.lang.String> viewmodelUserOtp4 = null;
            // viewmodel.userOtp_4.getValue()
            java.lang.String viewmodelUserOtp4GetValue = null;
            // viewmodel
            com.madeit.oldbookstore.viewModel.LoginViewModel viewmodel = mViewmodel;



            viewmodelJavaLangObjectNull = (viewmodel) != (null);
            if (viewmodelJavaLangObjectNull) {


                viewmodelUserOtp4 = viewmodel.getUserOtp_4();

                viewmodelUserOtp4JavaLangObjectNull = (viewmodelUserOtp4) != (null);
                if (viewmodelUserOtp4JavaLangObjectNull) {




                    viewmodelUserOtp4.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener otp5androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewmodel.userOtp_5.getValue()
            //         is viewmodel.userOtp_5.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = com.madeit.oldbookstore.viewModel.BindingAdapters.getText(otp5);
            // localize variables for thread safety
            // viewmodel.userOtp_5.getValue()
            java.lang.String viewmodelUserOtp5GetValue = null;
            // viewmodel.userOtp_5
            androidx.lifecycle.MutableLiveData<java.lang.String> viewmodelUserOtp5 = null;
            // viewmodel != null
            boolean viewmodelJavaLangObjectNull = false;
            // viewmodel
            com.madeit.oldbookstore.viewModel.LoginViewModel viewmodel = mViewmodel;
            // viewmodel.userOtp_5 != null
            boolean viewmodelUserOtp5JavaLangObjectNull = false;



            viewmodelJavaLangObjectNull = (viewmodel) != (null);
            if (viewmodelJavaLangObjectNull) {


                viewmodelUserOtp5 = viewmodel.getUserOtp_5();

                viewmodelUserOtp5JavaLangObjectNull = (viewmodelUserOtp5) != (null);
                if (viewmodelUserOtp5JavaLangObjectNull) {




                    viewmodelUserOtp5.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener otp6androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewmodel.userOtp_6.getValue()
            //         is viewmodel.userOtp_6.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = com.madeit.oldbookstore.viewModel.BindingAdapters.getText(otp6);
            // localize variables for thread safety
            // viewmodel != null
            boolean viewmodelJavaLangObjectNull = false;
            // viewmodel.userOtp_6
            androidx.lifecycle.MutableLiveData<java.lang.String> viewmodelUserOtp6 = null;
            // viewmodel.userOtp_6.getValue()
            java.lang.String viewmodelUserOtp6GetValue = null;
            // viewmodel.userOtp_6 != null
            boolean viewmodelUserOtp6JavaLangObjectNull = false;
            // viewmodel
            com.madeit.oldbookstore.viewModel.LoginViewModel viewmodel = mViewmodel;



            viewmodelJavaLangObjectNull = (viewmodel) != (null);
            if (viewmodelJavaLangObjectNull) {


                viewmodelUserOtp6 = viewmodel.getUserOtp_6();

                viewmodelUserOtp6JavaLangObjectNull = (viewmodelUserOtp6) != (null);
                if (viewmodelUserOtp6JavaLangObjectNull) {




                    viewmodelUserOtp6.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener phoneNumberandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewmodel.userPhoneNumber.getValue()
            //         is viewmodel.userPhoneNumber.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = com.madeit.oldbookstore.viewModel.BindingAdapters.getText(phoneNumber);
            // localize variables for thread safety
            // viewmodel != null
            boolean viewmodelJavaLangObjectNull = false;
            // viewmodel.userPhoneNumber
            androidx.lifecycle.MutableLiveData<java.lang.String> viewmodelUserPhoneNumber = null;
            // viewmodel.userPhoneNumber.getValue()
            java.lang.String viewmodelUserPhoneNumberGetValue = null;
            // viewmodel
            com.madeit.oldbookstore.viewModel.LoginViewModel viewmodel = mViewmodel;
            // viewmodel.userPhoneNumber != null
            boolean viewmodelUserPhoneNumberJavaLangObjectNull = false;



            viewmodelJavaLangObjectNull = (viewmodel) != (null);
            if (viewmodelJavaLangObjectNull) {


                viewmodelUserPhoneNumber = viewmodel.getUserPhoneNumber();

                viewmodelUserPhoneNumberJavaLangObjectNull = (viewmodelUserPhoneNumber) != (null);
                if (viewmodelUserPhoneNumberJavaLangObjectNull) {




                    viewmodelUserPhoneNumber.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityLoginBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private ActivityLoginBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 10
            , (com.google.android.material.appbar.AppBarLayout) bindings[11]
            , (android.widget.ImageButton) bindings[1]
            , (android.widget.EditText) bindings[4]
            , (android.widget.EditText) bindings[5]
            , (android.widget.EditText) bindings[6]
            , (android.widget.EditText) bindings[7]
            , (android.widget.EditText) bindings[8]
            , (android.widget.EditText) bindings[9]
            , (android.widget.EditText) bindings[2]
            , (android.widget.TextView) bindings[13]
            , (android.widget.Button) bindings[3]
            , (android.widget.Button) bindings[10]
            , (androidx.appcompat.widget.Toolbar) bindings[12]
            );
        this.imageButtonBack.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.otp1.setTag(null);
        this.otp2.setTag(null);
        this.otp3.setTag(null);
        this.otp4.setTag(null);
        this.otp5.setTag(null);
        this.otp6.setTag(null);
        this.phoneNumber.setTag(null);
        this.sendOtp.setTag(null);
        this.submitLogin.setTag(null);
        setRootTag(root);
        // listeners
        mCallback2 = new com.madeit.oldbookstore.generated.callback.OnClickListener(this, 2);
        mCallback1 = new com.madeit.oldbookstore.generated.callback.OnClickListener(this, 1);
        mCallback3 = new com.madeit.oldbookstore.generated.callback.OnClickListener(this, 3);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x800L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewmodel == variableId) {
            setViewmodel((com.madeit.oldbookstore.viewModel.LoginViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewmodel(@Nullable com.madeit.oldbookstore.viewModel.LoginViewModel Viewmodel) {
        this.mViewmodel = Viewmodel;
        synchronized(this) {
            mDirtyFlags |= 0x400L;
        }
        notifyPropertyChanged(BR.viewmodel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewmodelUserOtp5((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeViewmodelUserOtp1((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeViewmodelUserOtp3((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeViewmodelToastMessage((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
            case 4 :
                return onChangeViewmodelUserPhoneNumber((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 5 :
                return onChangeViewmodelBackMessage((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
            case 6 :
                return onChangeViewmodelOtpMessage((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
            case 7 :
                return onChangeViewmodelUserOtp4((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 8 :
                return onChangeViewmodelUserOtp6((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 9 :
                return onChangeViewmodelUserOtp2((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewmodelUserOtp5(androidx.lifecycle.MutableLiveData<java.lang.String> ViewmodelUserOtp5, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewmodelUserOtp1(androidx.lifecycle.MutableLiveData<java.lang.String> ViewmodelUserOtp1, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewmodelUserOtp3(androidx.lifecycle.MutableLiveData<java.lang.String> ViewmodelUserOtp3, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewmodelToastMessage(androidx.lifecycle.LiveData<java.lang.String> ViewmodelToastMessage, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewmodelUserPhoneNumber(androidx.lifecycle.MutableLiveData<java.lang.String> ViewmodelUserPhoneNumber, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewmodelBackMessage(androidx.lifecycle.LiveData<java.lang.String> ViewmodelBackMessage, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewmodelOtpMessage(androidx.lifecycle.LiveData<java.lang.String> ViewmodelOtpMessage, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x40L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewmodelUserOtp4(androidx.lifecycle.MutableLiveData<java.lang.String> ViewmodelUserOtp4, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x80L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewmodelUserOtp6(androidx.lifecycle.MutableLiveData<java.lang.String> ViewmodelUserOtp6, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x100L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewmodelUserOtp2(androidx.lifecycle.MutableLiveData<java.lang.String> ViewmodelUserOtp2, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x200L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String viewmodelToastMessageGetValue = null;
        java.lang.String viewmodelBackMessageGetValue = null;
        java.lang.String viewmodelUserOtp3GetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewmodelUserOtp5 = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewmodelUserOtp1 = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewmodelUserOtp3 = null;
        java.lang.String viewmodelUserOtp2GetValue = null;
        java.lang.String viewmodelUserOtp5GetValue = null;
        androidx.lifecycle.LiveData<java.lang.String> viewmodelToastMessage = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewmodelUserPhoneNumber = null;
        java.lang.String viewmodelOtpMessageGetValue = null;
        java.lang.String viewmodelUserPhoneNumberGetValue = null;
        androidx.lifecycle.LiveData<java.lang.String> viewmodelBackMessage = null;
        java.lang.String viewmodelUserOtp1GetValue = null;
        java.lang.String viewmodelUserOtp4GetValue = null;
        java.lang.String viewmodelUserOtp6GetValue = null;
        androidx.lifecycle.LiveData<java.lang.String> viewmodelOtpMessage = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewmodelUserOtp4 = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewmodelUserOtp6 = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewmodelUserOtp2 = null;
        com.madeit.oldbookstore.viewModel.LoginViewModel viewmodel = mViewmodel;

        if ((dirtyFlags & 0xfffL) != 0) {


            if ((dirtyFlags & 0xc01L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.userOtp_5
                        viewmodelUserOtp5 = viewmodel.getUserOtp_5();
                    }
                    updateLiveDataRegistration(0, viewmodelUserOtp5);


                    if (viewmodelUserOtp5 != null) {
                        // read viewmodel.userOtp_5.getValue()
                        viewmodelUserOtp5GetValue = viewmodelUserOtp5.getValue();
                    }
            }
            if ((dirtyFlags & 0xc02L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.userOtp_1
                        viewmodelUserOtp1 = viewmodel.getUserOtp_1();
                    }
                    updateLiveDataRegistration(1, viewmodelUserOtp1);


                    if (viewmodelUserOtp1 != null) {
                        // read viewmodel.userOtp_1.getValue()
                        viewmodelUserOtp1GetValue = viewmodelUserOtp1.getValue();
                    }
            }
            if ((dirtyFlags & 0xc04L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.userOtp_3
                        viewmodelUserOtp3 = viewmodel.getUserOtp_3();
                    }
                    updateLiveDataRegistration(2, viewmodelUserOtp3);


                    if (viewmodelUserOtp3 != null) {
                        // read viewmodel.userOtp_3.getValue()
                        viewmodelUserOtp3GetValue = viewmodelUserOtp3.getValue();
                    }
            }
            if ((dirtyFlags & 0xc08L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.toastMessage
                        viewmodelToastMessage = viewmodel.getToastMessage();
                    }
                    updateLiveDataRegistration(3, viewmodelToastMessage);


                    if (viewmodelToastMessage != null) {
                        // read viewmodel.toastMessage.getValue()
                        viewmodelToastMessageGetValue = viewmodelToastMessage.getValue();
                    }
            }
            if ((dirtyFlags & 0xc10L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.userPhoneNumber
                        viewmodelUserPhoneNumber = viewmodel.getUserPhoneNumber();
                    }
                    updateLiveDataRegistration(4, viewmodelUserPhoneNumber);


                    if (viewmodelUserPhoneNumber != null) {
                        // read viewmodel.userPhoneNumber.getValue()
                        viewmodelUserPhoneNumberGetValue = viewmodelUserPhoneNumber.getValue();
                    }
            }
            if ((dirtyFlags & 0xc20L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.backMessage
                        viewmodelBackMessage = viewmodel.getBackMessage();
                    }
                    updateLiveDataRegistration(5, viewmodelBackMessage);


                    if (viewmodelBackMessage != null) {
                        // read viewmodel.backMessage.getValue()
                        viewmodelBackMessageGetValue = viewmodelBackMessage.getValue();
                    }
            }
            if ((dirtyFlags & 0xc40L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.otpMessage
                        viewmodelOtpMessage = viewmodel.getOtpMessage();
                    }
                    updateLiveDataRegistration(6, viewmodelOtpMessage);


                    if (viewmodelOtpMessage != null) {
                        // read viewmodel.otpMessage.getValue()
                        viewmodelOtpMessageGetValue = viewmodelOtpMessage.getValue();
                    }
            }
            if ((dirtyFlags & 0xc80L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.userOtp_4
                        viewmodelUserOtp4 = viewmodel.getUserOtp_4();
                    }
                    updateLiveDataRegistration(7, viewmodelUserOtp4);


                    if (viewmodelUserOtp4 != null) {
                        // read viewmodel.userOtp_4.getValue()
                        viewmodelUserOtp4GetValue = viewmodelUserOtp4.getValue();
                    }
            }
            if ((dirtyFlags & 0xd00L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.userOtp_6
                        viewmodelUserOtp6 = viewmodel.getUserOtp_6();
                    }
                    updateLiveDataRegistration(8, viewmodelUserOtp6);


                    if (viewmodelUserOtp6 != null) {
                        // read viewmodel.userOtp_6.getValue()
                        viewmodelUserOtp6GetValue = viewmodelUserOtp6.getValue();
                    }
            }
            if ((dirtyFlags & 0xe00L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.userOtp_2
                        viewmodelUserOtp2 = viewmodel.getUserOtp_2();
                    }
                    updateLiveDataRegistration(9, viewmodelUserOtp2);


                    if (viewmodelUserOtp2 != null) {
                        // read viewmodel.userOtp_2.getValue()
                        viewmodelUserOtp2GetValue = viewmodelUserOtp2.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x800L) != 0) {
            // api target 1

            this.imageButtonBack.setOnClickListener(mCallback1);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.otp1, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, otp1androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.otp2, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, otp2androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.otp3, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, otp3androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.otp4, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, otp4androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.otp5, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, otp5androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.otp6, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, otp6androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.phoneNumber, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, phoneNumberandroidTextAttrChanged);
            this.sendOtp.setOnClickListener(mCallback2);
            this.submitLogin.setOnClickListener(mCallback3);
        }
        if ((dirtyFlags & 0xc20L) != 0) {
            // api target 1

            com.madeit.oldbookstore.activity.LoginActivity.bindBackMessage(this.imageButtonBack, viewmodelBackMessageGetValue);
        }
        if ((dirtyFlags & 0xc02L) != 0) {
            // api target 1

            com.madeit.oldbookstore.viewModel.BindingAdapters.setText(this.otp1, viewmodelUserOtp1GetValue);
        }
        if ((dirtyFlags & 0xe00L) != 0) {
            // api target 1

            com.madeit.oldbookstore.viewModel.BindingAdapters.setText(this.otp2, viewmodelUserOtp2GetValue);
        }
        if ((dirtyFlags & 0xc04L) != 0) {
            // api target 1

            com.madeit.oldbookstore.viewModel.BindingAdapters.setText(this.otp3, viewmodelUserOtp3GetValue);
        }
        if ((dirtyFlags & 0xc80L) != 0) {
            // api target 1

            com.madeit.oldbookstore.viewModel.BindingAdapters.setText(this.otp4, viewmodelUserOtp4GetValue);
        }
        if ((dirtyFlags & 0xc01L) != 0) {
            // api target 1

            com.madeit.oldbookstore.viewModel.BindingAdapters.setText(this.otp5, viewmodelUserOtp5GetValue);
        }
        if ((dirtyFlags & 0xd00L) != 0) {
            // api target 1

            com.madeit.oldbookstore.viewModel.BindingAdapters.setText(this.otp6, viewmodelUserOtp6GetValue);
        }
        if ((dirtyFlags & 0xc10L) != 0) {
            // api target 1

            com.madeit.oldbookstore.viewModel.BindingAdapters.setText(this.phoneNumber, viewmodelUserPhoneNumberGetValue);
        }
        if ((dirtyFlags & 0xc40L) != 0) {
            // api target 1

            com.madeit.oldbookstore.activity.LoginActivity.bindOtpMessage(this.sendOtp, viewmodelOtpMessageGetValue);
        }
        if ((dirtyFlags & 0xc08L) != 0) {
            // api target 1

            com.madeit.oldbookstore.activity.LoginActivity.bindToastMessage(this.submitLogin, viewmodelToastMessageGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // viewmodel != null
                boolean viewmodelJavaLangObjectNull = false;
                // viewmodel
                com.madeit.oldbookstore.viewModel.LoginViewModel viewmodel = mViewmodel;



                viewmodelJavaLangObjectNull = (viewmodel) != (null);
                if (viewmodelJavaLangObjectNull) {


                    viewmodel.onSendOTPButtonClicked();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // viewmodel != null
                boolean viewmodelJavaLangObjectNull = false;
                // viewmodel
                com.madeit.oldbookstore.viewModel.LoginViewModel viewmodel = mViewmodel;



                viewmodelJavaLangObjectNull = (viewmodel) != (null);
                if (viewmodelJavaLangObjectNull) {


                    viewmodel.onBackButtonClicked();
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // viewmodel != null
                boolean viewmodelJavaLangObjectNull = false;
                // viewmodel
                com.madeit.oldbookstore.viewModel.LoginViewModel viewmodel = mViewmodel;



                viewmodelJavaLangObjectNull = (viewmodel) != (null);
                if (viewmodelJavaLangObjectNull) {


                    viewmodel.onSubmitButtonClicked();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewmodel.userOtp_5
        flag 1 (0x2L): viewmodel.userOtp_1
        flag 2 (0x3L): viewmodel.userOtp_3
        flag 3 (0x4L): viewmodel.toastMessage
        flag 4 (0x5L): viewmodel.userPhoneNumber
        flag 5 (0x6L): viewmodel.backMessage
        flag 6 (0x7L): viewmodel.otpMessage
        flag 7 (0x8L): viewmodel.userOtp_4
        flag 8 (0x9L): viewmodel.userOtp_6
        flag 9 (0xaL): viewmodel.userOtp_2
        flag 10 (0xbL): viewmodel
        flag 11 (0xcL): null
    flag mapping end*/
    //end
}