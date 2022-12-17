package pseudoankit.droid.composenavigation

import android.os.Parcel
import android.os.Parcelable

data class DetailScreenPayload(
    val id: Int = 0,
    val name: String = "oops something went wrong while parsing"
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().orEmpty()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DetailScreenPayload> {
        override fun createFromParcel(parcel: Parcel): DetailScreenPayload {
            return DetailScreenPayload(parcel)
        }

        override fun newArray(size: Int): Array<DetailScreenPayload?> {
            return arrayOfNulls(size)
        }
    }

}