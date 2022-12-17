package pseudoankit.droid.composenavigation

import android.os.Parcelable
import com.squareup.moshi.Moshi

object JsonParser {

    val moshiInstance by lazy(LazyThreadSafetyMode.NONE) {
        Moshi.Builder().build()
    }

    inline fun <reified T : Parcelable> T.encodeToString(): String {
        return moshiInstance.adapter(T::class.java).toJson(this).orEmpty()
    }

    inline fun <reified T : Parcelable> String.decodeFromString(): T? {
        return moshiInstance.adapter(T::class.java).fromJson(this)
    }
}