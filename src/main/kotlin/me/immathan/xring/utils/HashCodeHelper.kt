package me.immathan.xring.utils

import org.apache.commons.lang3.builder.HashCodeBuilder



class HashCodeHelper {

    companion object {

        fun getHashCode(value: String): Int {
            return HashCodeBuilder(17, 31)
                    .append(value)
                    .toHashCode()
        }

    }
}