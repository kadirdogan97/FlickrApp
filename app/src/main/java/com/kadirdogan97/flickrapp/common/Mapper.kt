package com.kadirdogan97.flickrapp.common

interface Mapper<R, D> {
    fun mapFrom(type: R): D
}