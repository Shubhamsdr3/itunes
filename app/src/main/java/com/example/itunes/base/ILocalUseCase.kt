package com.example.itunes.base

import kotlinx.coroutines.flow.Flow

interface ILocalUseCase<in I, out R : Any> {

    suspend operator fun invoke(input: I): Flow<R>
}