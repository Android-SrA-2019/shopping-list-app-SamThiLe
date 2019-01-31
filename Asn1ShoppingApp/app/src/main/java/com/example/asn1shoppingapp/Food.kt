package com.example.asn1shoppingapp



import android.os.Parcel
import android.os.Parcelable

class Food( val name : String, var quantity : Int) : Parcelable {
    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<Food> {
            override fun createFromParcel(parcel: Parcel) = Food(parcel)
            override fun newArray(size: Int) = arrayOfNulls<Food>(size)
        }
    }
    private constructor(parcel: Parcel) : this(
        name = parcel.readString(),
        quantity = parcel.readInt()

    )
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(quantity)
    }
    override fun describeContents() = 0
}


//Lazy Way
//@Parcelize
//class Food(
//    var name: String,
//    var quantity: Int
//) : Parcelable
