package com.D121211084.mygames.binding

import android.app.Activity
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ActivityViewBindingDelegate<T : ViewBinding>(private val bindingClass: Class<T>) :
    ReadOnlyProperty<Activity, T> {
    /**
     * initiate variable for binding view
     */
    private var binding: T? = null

    @Suppress("UNCHECKED_CAST")
    override fun getValue(thisRef: Activity, property: KProperty<*>): T {
        binding?.let { return it }

        /**
         * inflate View class
         */
        val inflateMethod = bindingClass.getMethod("inflate", LayoutInflater::class.java)

        /**
         * Bind layout
         */
        val invokeLayout = inflateMethod.invoke(null, thisRef.layoutInflater) as T

        /**
         * Set the content view
         */
        thisRef.setContentView(invokeLayout.root)

        return invokeLayout.also { this.binding = it }
    }
}

inline fun <reified T : ViewBinding> Activity.viewBinding() = ActivityViewBindingDelegate(T::class.java)
