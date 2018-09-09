package me.immathan.xring.utils

import org.apache.commons.lang3.builder.HashCodeBuilder



class HashCodeHelper {

    companion object {

        fun getHashCode(value: String): Int {
            return HashCodeBuilder(17, 31)
                    .append(value)
                    .toHashCode()
        }

        fun getHashCode(value: String, vararg values: Int) : Int {
            val builder = HashCodeBuilder(17, 31)
            builder.append(value)

            for(intValue in values) {
                builder.append(intValue)
            }
            return builder.toHashCode()
        }

    }
}