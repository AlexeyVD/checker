package com.avd.checker.domain.model

import android.os.Parcel
import android.os.Parcelable

class CheckerDto(
        val id: Long,
        val title: String,
        val timeDataTypeId: Int,
        val isChecked: Boolean
) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readByte() != 0.toByte())

    constructor(model: CheckerModel) : this(
            model.id,
            model.title,
            model.timeData.getType(),
            model.isChecked
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(title)
        parcel.writeInt(timeDataTypeId)
        parcel.writeByte(if (isChecked) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CheckerDto> {
        override fun createFromParcel(parcel: Parcel): CheckerDto {
            return CheckerDto(parcel)
        }

        override fun newArray(size: Int): Array<CheckerDto?> {
            return arrayOfNulls(size)
        }
    }
}