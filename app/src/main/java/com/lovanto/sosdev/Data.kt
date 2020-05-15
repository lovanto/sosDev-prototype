package com.lovanto.sosdev

import android.os.Parcel
import android.os.Parcelable

data class Data(
    var username: String? = "",
    var name: String? = "",
    var avatar: Int = 0,
    var company: String? = "",
    var location: String? = "",
    var repository: Int = 0,
    var followers: Int = 0,
    var following: Int = 0
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(username)
        parcel.writeString(name)
        parcel.writeInt(avatar)
        parcel.writeString(company)
        parcel.writeString(location)
        parcel.writeInt(repository)
        parcel.writeInt(followers)
        parcel.writeInt(following)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Data> {
        override fun createFromParcel(parcel: Parcel): Data {
            return Data(parcel)
        }

        override fun newArray(size: Int): Array<Data?> {
            return arrayOfNulls(size)
        }
    }
}