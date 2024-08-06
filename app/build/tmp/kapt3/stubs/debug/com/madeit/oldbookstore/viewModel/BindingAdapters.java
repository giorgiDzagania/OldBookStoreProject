package com.madeit.oldbookstore.viewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007\u00a8\u0006\r"}, d2 = {"Lcom/madeit/oldbookstore/viewModel/BindingAdapters;", "", "()V", "getText", "", "editText", "Landroid/widget/EditText;", "setText", "", "text", "setTextListener", "listener", "Landroidx/databinding/InverseBindingListener;", "app_debug"})
public final class BindingAdapters {
    @org.jetbrains.annotations.NotNull()
    public static final com.madeit.oldbookstore.viewModel.BindingAdapters INSTANCE = null;
    
    private BindingAdapters() {
        super();
    }
    
    @kotlin.jvm.JvmStatic()
    @androidx.databinding.BindingAdapter(value = {"android:text"})
    public static final void setText(@org.jetbrains.annotations.NotNull()
    android.widget.EditText editText, @org.jetbrains.annotations.Nullable()
    java.lang.String text) {
    }
    
    @kotlin.jvm.JvmStatic()
    @androidx.databinding.InverseBindingAdapter(attribute = "android:text", event = "android:textAttrChanged")
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getText(@org.jetbrains.annotations.NotNull()
    android.widget.EditText editText) {
        return null;
    }
    
    @kotlin.jvm.JvmStatic()
    @androidx.databinding.BindingAdapter(value = {"android:textAttrChanged"})
    public static final void setTextListener(@org.jetbrains.annotations.NotNull()
    android.widget.EditText editText, @org.jetbrains.annotations.Nullable()
    androidx.databinding.InverseBindingListener listener) {
    }
}